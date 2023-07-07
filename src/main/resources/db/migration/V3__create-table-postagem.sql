create table postagem(

    id bigint not null auto_increment,
    titulo varchar(50),
    descricao varchar(200),
    post varchar(255) not null,
    video varchar(255),
    ativo tinyint,

    primary key (id)

);