create table drink
(
    id serial not null primary key,
    name varchar(30) not null,
    type varchar(30) not null,
    price int not null,
    description varchar(80)
);