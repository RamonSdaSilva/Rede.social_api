create table usuarios(

    id bigint not null auto_increment,
    nome varchar(100) not null,
    email varchar(100) not null unique,
    telefone varchar(20) not null,
    foto varchar(255),
    ativo tinyint,

    primary key (id)

);