create database cadastro;
use cadastro;

create table login(
	id int not null auto_increment primary key,
    usuario varchar(20),
    senha int
);

alter table login
modify column senha varchar(20);
