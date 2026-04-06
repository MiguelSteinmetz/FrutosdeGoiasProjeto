create table produtos(
                         id serial not null primary key,
                         nome varchar(50) not null,
                         preco numeric(10,2) not null,
                         estoque int not null
)


create table funcionario(
                            id serial not null primary key,
                            nome varchar(50) not null,
                            senha varchar(30) not null,
                            totalvendas numeric(10, 2)not null
)

create table venda(
                      id_venda serial not null primary key,
                      valortotal numeric(10,2) not null,
                      id_funcionario_fk int not null,
                      foreign key (id_funcionario_fk) references funcionario(id)
)

create table item_venda(
                           id_item serial not null primary key,
                           quantidade int not null,
                           id_produto_fk int not null,
                           foreign key (id_produto_fk) references produtos(id),
                           id_venda_fk int not null,
                           foreign key (id_venda_fk) references venda(id_venda)
)

create table pagamento(
                          id_pagamento serial not null primary key,
                          valor numeric(10,2) not null,
                          tipo_pag varchar(30) not null,
                          id_venda_fk int not null,
                          foreign key (id_venda_fk) references venda(id_venda)
)

