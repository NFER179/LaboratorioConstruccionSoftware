/* source C:/Documents and Settings/hola/Escritorio/Proyectos/Workspace/Wild_Pizzeria/sql/laboratorio.sql; */
drop database if exists PizzeriaWild;

create database PizzeriaWild;

use PizzeriaWild;

/*create table usuario(dni integer(8),
					nombre char(30),
					apellido char(30),
					primary key(dni));
					
insert into usuario values('12345678','a','b'),
('87654321','c','d'),
('13572468','e','f'),
('24681357','g','h');
create table enter(pass char(12));*/
/*
create table cliente(id_cliente integer, nombres char(50), apellido char(30), direccion char(50),tel char(20),
					primary key (id_cliente));
					
/* Para poder seleccionar diferentes productos y diferentes variedades de gustos. */					
/*create table producto(product_id char(4), descripcion char(100) unique,
					primary key (product_id));
					
create table sabor_producto(product_id char(4), sabor char(100), precio integer,
					primary key(product_id, sabor),
					foreign key (product_id) references producto(product_id));
					
create table pedido(num_pedido integer, id_cliente integer, producto char(4), sabor char(250), fecha_hora datetime, cantidad integer, observaciones long, Estado enum('Pendiente','Armado','Viaje','Cancelado','Facturado'), delivery char(1),
					primary key (num_pedido, id_cliente, producto, sabor),
					foreign key (id_cliente) references cliente(id_cliente),
					foreign key (producto, sabor) references sabor_producto(product_id, sabor));
					
/*create table personal_delivery(id_empleado integer, nombre char(30), apellido char(30), tel char(12), direccion char(30),
							primary key(id_empleado));

create table pedido_repartidor(id_repartidor integer, num_pedido integer unique,
								primary key (id_repartidor, num_pedido),
								foreign key id_repartidor references personal_delivery(id_empleado),
								foreign key num_pedido references pedido(num_pedido));*/
								
/*-------------------------------------------------------------------------------------------------------------------------------------------------------------
/* Estructura V.1.02. */
create table cliente(id_cliente integer, nombres char(50), apellido char(30), direccion char(50),tel char(20),
					primary key (id_cliente));
					
/* Para poder seleccionar diferentes productos y diferentes variedades de gustos. */					
create table producto(product_id char(4), descripcion char(100) unique,
					primary key (product_id));
					
create table sabor_producto(product_id char(4), sabor char(100), precio integer,
					primary key(product_id, sabor),
					foreign key (product_id) references producto(product_id));
					
create table pedido(num_pedido integer, cliente char(80), direccion char(50), precio integer, fecha_hora datetime, Estado enum('Pendiente','Armado','Viaje','Cancelado','Facturado'), observaciones long, delivery char(1),
					primary key(num_pedido));

create table producto_pedido(num_pedido integer, producto char(4), sabor char(250), cantidad integer,
					primary key (num_pedido, producto, sabor),
					foreign key (num_pedido) references pedido(num_pedido),
					foreign key (producto, sabor) references sabor_producto(product_id, sabor));
					
create table repartidor(id_empleado integer, nombre char(30), apellido char(30), tel char(14), direccion char(30),
					primary key(id_empleado));
					
create table pedido_repartidor(id_empleado integer, num_pedido integer,
					primary key(id_empleado, num_pedido),
					foreign key (id_empleado) references repartidor(id_empleado),
					foreign key (num_pedido) references pedido(num_pedido));