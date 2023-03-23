insert into produto (id,nome,valor) values (1,'feijão', 13);
insert into produto (id,nome,valor) values (2,'arroz', 23);

insert into  venda (id,date) values (1, '2023-03-11');

insert into item_venda (id,qtd,produto_id,venda_id) values(1,2,1,1);

insert into pessoa_fisica (id, nome,cpf) values (1, 'Paulo Gerson', '40028922')
insert into pessoa_juridica (id, nome,cnpj) values (1, 'Jessica Raquel', '084126728')