package com.gusmelford.gusmelfordbooks_spring.services;

import com.gusmelford.gusmelfordbooks_spring.entities.Permission;
import com.gusmelford.gusmelfordbooks_spring.entities.Role;
import com.gusmelford.gusmelfordbooks_spring.entities.User;
import com.gusmelford.gusmelfordbooks_spring.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> userRes = userRepository.findByEmail(email);

        if(userRes.isEmpty()){
            throw new UsernameNotFoundException("Could not findUser with email: " + email);
        }

        User user = userRes.get();
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                getAuthorities(user));
    }

    private List<GrantedAuthority> getAuthorities(User user) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        Role role = user.getRole();
        authorities.add(new SimpleGrantedAuthority(role.getName()));

        for (Permission permission : role.getPermissions()) {
            authorities.add(new SimpleGrantedAuthority(permission.getName()));
        }

        return authorities;
    }
}

