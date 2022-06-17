package com.gusmelford.gusmelfordbooks_spring.services.interfaces;

import com.gusmelford.gusmelfordbooks_spring.entities.Role;

public interface RoleService {
    Role getCustomerRole();
    Role getAdminRole();
}
