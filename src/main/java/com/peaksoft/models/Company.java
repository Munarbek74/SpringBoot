package com.peaksoft.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.*;
import static jakarta.persistence.FetchType.LAZY;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "companies")
public class Company {

    @Id
    @SequenceGenerator(name = "company_seq", sequenceName = "company_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "company_seq")
    private Long id;


    @Column(length = 100000,name = "company_name", nullable=false )
    private String companyName;


    @Column(length = 100000,name = "located_country", nullable=false)
    private String locatedCountry;

    @OneToMany(cascade = {ALL}, fetch = LAZY, mappedBy = "company")
    private List<Course> courses;

    public void addCourses(Course course){

        if (courses==null){
            courses=new ArrayList<>();
        }
        courses.add(course);
    }



    @OneToMany(cascade = {MERGE, REMOVE, REFRESH, DETACH}, fetch = LAZY, mappedBy = "company")
    private List<Group> groups;

    public void addGroups(Group group){
        if (groups==null){
            groups=new ArrayList<>();
        }
        groups.add(group);
    }
    public Company(String companyName, String locatedCountry) {
        this.companyName = companyName;
        this.locatedCountry = locatedCountry;
    }

}
