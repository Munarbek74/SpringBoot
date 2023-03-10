package com.peaksoft.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.*;
import static jakarta.persistence.FetchType.EAGER;
import static jakarta.persistence.FetchType.LAZY;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "courses")
public class Course {

    @Id
    @SequenceGenerator(name = "course_seq", sequenceName = "course_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_seq")
    private Long id;

    @Column(name = "course_name",length = 100000)
    private String courseName;

    @Column(length = 100000,name = "duration")
    private String duration;

    @Column(length = 100000,name = "description")
    private String description;


    @ManyToOne(cascade = {PERSIST,MERGE,REFRESH,DETACH},fetch = EAGER)
    private Company company;


    @ManyToMany(cascade = {PERSIST,MERGE,REFRESH,DETACH},fetch = LAZY,mappedBy = "courses")
    private List<Group> groups;

    public void addGroups(Group group){
        if (groups==null){
            groups=new ArrayList<>();
        }
        groups.add(group);
    }


    @OneToMany (cascade = {MERGE,DETACH,REFRESH,REMOVE},fetch = LAZY, mappedBy = "courses")
    private List<Instructor> instructors;

    public void addInstructor(Instructor instructor){
        if (instructors==null){
            instructors=new ArrayList<>();
        }
        instructors.add(instructor);
    }

    @OneToMany(cascade = {MERGE, REFRESH, REMOVE, DETACH}, fetch = LAZY, mappedBy = "course")
    private List<Lesson> lessons;

    public void addLessons(Lesson lesson){
        if (lessons==null){
            lessons=new ArrayList<>();
        }
        lessons.add(lesson);
    }

    public Course(String courseName, String duration, String description) {
        this.courseName = courseName;
        this.duration = duration;
        this.description = description;
    }
}
