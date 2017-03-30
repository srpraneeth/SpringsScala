drop table users;
create table users(
	id bigint auto_increment not null,
	username varchar_ignorecase(50) not null primary key,
	password varchar_ignorecase(50) not null,
	enabled boolean not null
);

drop table authorities;
create table authorities (
	id bigint auto_increment not null,
	username varchar_ignorecase(50) not null,
	authority varchar_ignorecase(50) not null,
	constraint fk_authorities_users foreign key(username) references users(username)
);

insert into users (id, username, password,enabled) values (1, 'root', 'root', true), (2, 'user', 'user', true);
insert into authorities (id, username, authority) values (1, 'root', 'ROLE_user'), (2, 'root', 'ROLE_admin'), (3, 'user', 'ROLE_user');