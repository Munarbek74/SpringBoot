//package com.peaksoft.models;
//
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.*;
//
//import static jakarta.persistence.CascadeType.ALL;
//
//@Entity
//@Table(name = "users")
//@Setter
//@Getter
//@NoArgsConstructor
//public class User  implements UserDetails {
//    @Id
//    @SequenceGenerator(name = "user_seq", sequenceName = "user_seq", allocationSize = 1)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
//    private Long id;
//
//    private String email;
//
//    private String password;
//
//
//    public User(String email, String password) {
//        this.email = email;
//        this.password = password;
//    }
//
//
//    @ManyToMany(cascade = ALL, fetch = FetchType.EAGER, mappedBy = "userList")
//    private Set<Role> roles = new HashSet<>();
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        Set<Role> roles = getRoles();
//        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
//        for (Role role: roles) {
//            authorities.add(new SimpleGrantedAuthority(role.getName()));
//        }
//        return authorities;
//    }
//    @Override
//    public String getPassword() {
//       return password;
//
//    }
//
//    @Override
//    public String getUsername() {
//        return email;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return false;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return false;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return false;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return false;
//    }
//}
