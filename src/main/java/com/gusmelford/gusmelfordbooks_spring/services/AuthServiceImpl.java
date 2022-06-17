package com.gusmelford.gusmelfordbooks_spring.services;

import com.gusmelford.gusmelfordbooks_spring.entities.User;
import com.gusmelford.gusmelfordbooks_spring.mappers.UserMapper;
import com.gusmelford.gusmelfordbooks_spring.payload.request.JwtData;
import com.gusmelford.gusmelfordbooks_spring.payload.request.UserLoginCredentials;
import com.gusmelford.gusmelfordbooks_spring.payload.request.UserRegistrationData;
import com.gusmelford.gusmelfordbooks_spring.repositories.UserRepository;
import com.gusmelford.gusmelfordbooks_spring.security.JwtTokenManager;
import com.gusmelford.gusmelfordbooks_spring.services.interfaces.AuthService;
import com.gusmelford.gusmelfordbooks_spring.services.interfaces.RoleService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final JwtTokenManager jwtTokenManager;
    private final AuthenticationManager authManager;
    private final RoleService roleService;

    @Override
    public User register(UserRegistrationData registerRequest) {
        User user = userMapper.fromDto(registerRequest);
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setRole(roleService.getCustomerRole());
        return userRepository.save(user);
    }

    @Override
    public User registerAdmin(UserRegistrationData registerRequest) {
        User user = userMapper.fromDto(registerRequest);
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setRole(roleService.getAdminRole());
        return userRepository.save(user);
    }

    @Override
    public JwtData login(UserLoginCredentials userCredentials) {
        Authentication authenticate = authManager.authenticate(new UsernamePasswordAuthenticationToken(
                userCredentials.getEmail(),
                userCredentials.getPassword()
        ));

        SecurityContextHolder.getContext().setAuthentication(authenticate);
        JwtData jwtData = jwtTokenManager.generateToken(authenticate);

        User user = userRepository.findByEmail(userCredentials.getEmail()).orElseThrow();
        jwtData.setUserRole(user.getRole().getName());
        jwtData.setName(String.join(" ", user.getFirstName(), user.getMiddleName(), user.getLastName()));
        return jwtData;
    }

}
