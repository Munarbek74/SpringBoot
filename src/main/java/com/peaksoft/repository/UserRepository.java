//package com.peaksoft.repository;
//
//import com.peaksoft.models.Company;
//import com.peaksoft.models.User;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public interface UserRepository extends JpaRepository<User, Long> {
//
//    @Query("select u from User u where u.email = :email")
//    User getByEmailUser(@Param("email") String email);
//}