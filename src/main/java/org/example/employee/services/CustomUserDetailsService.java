package org.example.employee.services;


import org.example.employee.model.User;
import org.example.employee.repository.UserRepository;
import jakarta.persistence.JoinColumn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder encoder;
    //Department-> Enum
    //Employee -> managerId ,userId->
//    @ManyToOne
//    @JoinColumn(name="manager_id")
//    private Employee manager;
    //project-> manager+ team
    //support-ticket
    public User createUser(User user){
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println(username);
        return userRepository.findByUsername(username).orElseThrow(()->
                new UsernameNotFoundException("user not found"));
    }
}