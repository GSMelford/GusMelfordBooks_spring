package com.gusmelford.gusmelfordbooks_spring.services;

import com.gusmelford.gusmelfordbooks_spring.entities.Role;
import com.gusmelford.gusmelfordbooks_spring.repositories.RoleRepository;
import com.gusmelford.gusmelfordbooks_spring.services.interfaces.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Override
    public Role getCustomerRole() {
        return roleRepository.findByName("User").orElseThrow();
    }

    @Override
    public Role getAdminRole() {
        return roleRepository.findByName("Admin").orElseThrow();
    }
}
