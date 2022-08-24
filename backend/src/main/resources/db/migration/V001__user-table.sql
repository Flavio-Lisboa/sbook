create table user (
	user_id bigint not null auto_increment,
    user_name varchar(15) not null,
    user_email varchar(50) not null,
    user_password varchar(100) not null,

    primary key (user_id)
);