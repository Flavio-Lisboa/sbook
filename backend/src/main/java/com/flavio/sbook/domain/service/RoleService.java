package com.flavio.sbook.domain.service;

import com.flavio.sbook.domain.enums.RoleName;
import com.flavio.sbook.domain.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public String getRoleID(RoleName roleName) {
         return roleRepository.findByRoleName(roleName).getId();
    }
}
