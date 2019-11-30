CREATE TABLE aplicacao.role
(
    id bigint auto_increment,
    name varchar(255) not null,
    constraint role_pk
        primary key (id)
);

INSERT INTO role (name) values('ADMIN');
INSERT INTO role (name) values('CLIENT');

CREATE TABLE user_role
(
    id bigint not null auto_increment,
    user_id bigint,
    role_id bigint,
    constraint user_role_pk
      primary key (id),
    constraint user_role_user_fk
      foreign key (user_id) references aplicacao.user (id),
    constraint user_role_role_fk
      foreign key (role_id) references aplicacao.role (id)
);

insert into user_role