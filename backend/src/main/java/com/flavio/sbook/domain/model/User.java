package com.flavio.sbook.domain.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode

public class User {

    private Long id;
    private String firstName;
    private String email;
    private String password;
}
