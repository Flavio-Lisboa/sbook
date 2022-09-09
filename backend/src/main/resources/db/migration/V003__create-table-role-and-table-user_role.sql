create table role(
    role_id binary(16) not null,
    role_name varchar(10) not null,

    primary key(role_id)
);

create table user_role(
    user_id binary(16) not null,
    role_id binary(16) not null,

    constraint pk_user_role primary key(user_id, role_id),
    constraint fk_user_role foreign key(user_id) references user(user_id),
    constraint fk_role_user foreign key(role_id) references role(role_id)
);