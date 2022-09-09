package com.flavio.sbook.domain.model;

import com.flavio.sbook.domain.enums.RoleName;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@Entity
public class Role implements GrantedAuthority, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private UUID id;

    @Enumerated(EnumType.STRING)
    @Column(name = "role_name")
    private RoleName roleName;

    @Override
    public String getAuthority() {
        return getRoleName().toString();
    }
}
