

create table usuario (
                         id serial not null primary key,
                         login varchar(50) not null,
                         nome varchar(50) not null,
                         senha varchar(30) not null,
                         tipo varchar(30) not null,
                         totalvendas numeric(10,2) not null
);

create table venda (
                       id_item serial not null primary key,
                       quantidade int not null,
                       valortotal numeric(10,2) not null,
                       tipo_pagamento varchar(50) not null,
                       id_produto_fk int not null,
                       id_usuario_fk int not null,
                       foreign key (id_produto_fk) references produto(id),
                       foreign key (id_usuario_fk) references usuario(id)
);

