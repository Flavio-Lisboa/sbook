package com.flavio.sbook.domain.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class User {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @NotBlank
    @Size(max = 15)
    @Column(name = "user_name")
    private String firstName;

    @NotBlank
    @Email
    @Size(max = 50)
    @Column(name = "user_email")
    private String email;

    @NotBlank
    @Size(max = 100)
    @Column(name = "user_password")
    private String password;
}
