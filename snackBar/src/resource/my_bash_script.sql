create database snackbar;

use snackbar;

create table prato (
  id int primary key auto_increment,
  nome varchar(50) not null default 'Pizza',
  preco double,
  datavalidade varchar(50) ,
  qtd int not null default 1,
  peso double not null default 10,
  massa varchar(50) ,
  tipo enum('Assado', 'Frito'),
  recheio varchar(50),
  pao enum('Integral', 'Mesa', 'Forma'),
  molho varchar(50),
  cobertura varchar(50),
  status_ boolean default true
  );
  
  desc prato;
  
  /*Trazer todos os pratos que forem pizza*/
  
  SELECT id, nome, datavalidade, preco, qtd, molho, recheio, cobertura FROM prato;
  
  INSERT INTO prato (nome, datavalidade, preco, qtd, molho, recheio, cobertura) VALUES ('pizza','2023-06-18 a 2023-06-19', 500, 1, 'Tomate', 'Cebola e pimento', 'Molho da banda');
  
  SELECT user,authentication_string,plugin,host FROM mysql.user;
  
  /*Meu user 1d5442df56*/
  
  ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'password';
FLUSH PRIVILEGES;


/*Criar tabela pedido*/

/*
private int id;
    private int pratoid;
    private double taxaservico;
    private double precototal;
    private double troco;
    private double valorpago;
    private String otn;
    private String pagamento;
    private String cliente;
    private int qtd;

*/

create table pedido(
id int primary key auto_increment,
prato_id int not null,
taxaservico double,
precototal double,
troco double,
valorpago double,
otn varchar(50),
metodpgt enum('Cash', 'Mcx'),
cliente varchar(50),
qtdtotal int default 1,
status_ boolean default true
);

alter table pedido add constraint fk_prato_id foreign key (prato_id) references prato (id);

desc pedido;
select * from pedido;
truncate table pedido;

/*INSERT INTO pedidos (prato_id, taxaservico, troco, valorpago, precototal, otn, pagamento, cliente, qtd) VALUES (?,?,?,?,?,?,?,?,?)*/

SELECT * FROM  pedido AS o JOIN prato AS p ON o.prato_id = p.id
WHERE otn = '100';
