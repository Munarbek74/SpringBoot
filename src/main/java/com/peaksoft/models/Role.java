//package com.peaksoft.models;
//
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import java.util.List;
//
//@Entity
//@Table(name = "roles")
//@Getter
//@Setter
//@NoArgsConstructor
//public class Role {
//    @Id
//    @SequenceGenerator(name = "role_seq", sequenceName = "role_seq", allocationSize = 1)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_seq")
//    private Long id;
//
//    private String name;
//
//    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE,CascadeType.REFRESH}, fetch = FetchType.LAZY)
//    @JoinTable(name = "role_person",
//    joinColumns=@JoinColumn(name = "person_id"),
//            inverseJoinColumns = @JoinColumn(name = "role_id")
//    )
//    private List<User> userList;
//}
//
