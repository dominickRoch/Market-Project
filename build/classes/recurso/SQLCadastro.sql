create database cadastro;
use cadastro;

create table login(
	id int not null auto_increment primary key,
    usuario varchar(20),
    senha int
);

alter table login
modify column senha varchar(20);

create table mercado(
	id int not null auto_increment primary key,
    produto varchar(30),
    preco float,
    validade varchar(15),
    peso int,
    quantidade int,
)

alter table mercado
modify column validade date;

