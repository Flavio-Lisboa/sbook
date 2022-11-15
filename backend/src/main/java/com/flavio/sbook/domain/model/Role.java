package com.flavio.sbook.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flavio.sbook.domain.enums.RoleName;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
public class Role implements GrantedAuthority, Serializable {

    @JsonIgnore
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "role_id")
    private String id;

    @Enumerated(EnumType.STRING)
    @Column(name = "role_name")
    private RoleName roleName;

    @JsonIgnore
    @Override
    public String getAuthority() {
        return getRoleName().toString();
    }
}
