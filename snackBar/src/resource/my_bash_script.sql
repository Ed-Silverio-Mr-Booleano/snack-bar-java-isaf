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
  tipo enum('Assado', 'Frito') default 'Frito',
  recheio varchar(50),
  pao enum('Integral', 'Mesa', 'Forma') default 'Mesa',
  molho varchar(50),
  cobertura varchar(50) );
  
  desc prato;
  
  /*Trazer todos os pratos que forem pizza*/
  
  SELECT id, nome, datavalidade, preco, qtd, molho, recheio, cobertura FROM prato;
  
  INSERT INTO prato (nome, datavalidade, preco, qtd, molho, recheio, cobertura) VALUES ('pizza','2023-06-18 a 2023-06-19', 500, 1, 'Tomate', 'Cebola e pimento', 'Molho da banda');
  
  SELECT user,authentication_string,plugin,host FROM mysql.user;
  
  /*Meu user 1d5442df56*/
  
  ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'password';
FLUSH PRIVILEGES;