insert into produto (id,nome,valor) values (default,'feijão', 13);
insert into produto (id,nome,valor) values (default,'arroz', 23);
insert into produto (id,nome,valor) values (default,'Bolacha', 5);

insert into pessoa_fisica (id, nome,cpf) values (1, 'Paulo Gerson', '40028922');


insert into  venda (id,date,pessoa_id) values (default, '2023-03-11', 1);

insert into item_venda (id,qtd,produto_id,venda_id) values(default,2,1,1);

insert into estado (id, nome, uf) values (1, 'Goiás', 'GO');
insert into estado (id, nome, uf) values (2, 'Tocantins', 'TO');
insert into estado (id, nome, uf) values (3, 'Amazonas', 'AM');
insert into estado (id, nome, uf) values (4, 'Paraná', 'PR');

insert into cidade (id, nome, estado_id) values (1, 'Anápolis', 1);
insert into cidade (id, nome, estado_id) values (2, 'Palmas', 2);
insert into cidade (id, nome, estado_id) values (3, 'Manaus', 3);
insert into cidade (id, nome, estado_id) values (4, 'Curitiba', 4);








