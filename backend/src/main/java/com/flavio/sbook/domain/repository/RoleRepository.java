package com.flavio.sbook.domain.repository;

import com.flavio.sbook.domain.enums.RoleName;
import com.flavio.sbook.domain.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, String> {

    Role findByRoleName(RoleName role);
}
