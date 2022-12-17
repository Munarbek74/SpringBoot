//package com.peaksoft.service;
//
//import com.peaksoft.models.User;
//import com.peaksoft.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//public class UserDetailService implements UserDetailsService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userRepository.getByEmailUser(username);
//        if (user == null) {
//            throw new UsernameNotFoundException("User name not found exception");
//        }
//        return user;
//    }
//}
