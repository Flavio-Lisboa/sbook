ALTER TABLE user_role DROP FOREIGN KEY fk_user_role;
ALTER TABLE user_role DROP FOREIGN KEY fk_role_user;

ALTER TABLE user MODIFY user_id varchar(36);
ALTER TABLE role MODIFY role_id varchar(36);
ALTER TABLE user_role MODIFY user_id varchar(36);
ALTER TABLE user_role MODIFY role_id varchar(36);

ALTER TABLE user_role ADD CONSTRAINT fk_user_role FOREIGN KEY(user_id) REFERENCES user(user_id);
ALTER TABLE user_role ADD CONSTRAINT fk_role_user FOREIGN KEY(role_id) REFERENCES role(role_id);