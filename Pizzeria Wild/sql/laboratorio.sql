/* source C:/Documents and Settings/nicolas/Escritorio/SVN/LaboratorioContruccionSoftware/trunk/Pizzeria Wild/sql/laboratorio.sql; */
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
/* Modulo de Ventas a clientes. */
create table cliente(id_cliente integer, nombres char(50), apellido char(30), direccion char(50),tel char(20),
					primary key (id_cliente));
					
/* Para poder seleccionar diferentes productos y diferentes variedades de gustos. */					
create table producto(product_id char(4), descripcion char(100) unique, mixta char(1), cocina char(1),
					primary key (product_id));
					
create table sabor_producto(product_id char(4), sabor char(100), precio integer,
					primary key(product_id, sabor),
					foreign key (product_id) references producto(product_id));
					
/*create table pedido(num_pedido integer, cliente char(80), direccion char(50), tel_cliente char(20), precio integer, fecha_hora datetime, Estado enum('Pendiente','Armado','Viaje','Cancelado','Facturado'), observaciones long, delivery char(1),
					primary key(num_pedido));*/
create table venta(effdt date, num_venta integer, cliente char(80), direccion char(50), tel_cliente char(20), precio integer, hora time, estado enum('Pendiente','Armado','Viaje','Cancelado','Facturado'), observaciones long, delivery char(1), obs_delivery long,
					primary key(effdt, num_venta));

/*create table producto_pedido(num_pedido integer, producto char(4), sabor char(250), cantidad integer,
					primary key (num_pedido, producto, sabor),
					foreign key (num_pedido) references pedido(num_pedido),
					foreign key (producto, sabor) references sabor_producto(product_id, sabor));*/
create table venta_producto(effdt date, num_venta integer, producto char(4), sabor char(250), cantidad integer,
					primary key (effdt, num_venta, producto, sabor),
					foreign key (effdt, num_venta) references venta(effdt, num_venta),
					foreign key (producto, sabor) references sabor_producto(product_id, sabor));
					
create table repartidor(empleado_id integer, nombre char(30), apellido char(30), tel char(14), direccion char(30),
					primary key(empleado_id));
					
/*create table pedido_repartidor(id_empleado integer, num_pedido integer,
					primary key(id_empleado, num_pedido),
					foreign key (id_empleado) references repartidor(id_empleado),
					foreign key (num_pedido) references pedido(num_pedido));*/
create table delivery(effdt date, num_delivery integer, empleado_id integer, hora time, obs long,
					primary key(effdt, num_delivery));
					
/*create table delivery_repartidor(effdt date, num_delivery integer, empleado_id integer,
					primary key(effdt, num_delivery, empleado_id),
					foreign key(effdt, num_delivery) references delivery(effdt, num_delivery),
					foreign key(empleado_id) references repartidor(empleado_id));*/

create table delivery_venta(effdt date, num_delivery integer,fecha_venta date, num_venta integer, estado enum('pendiente','entregado','no entregado'), obs_noentregado char(100),
					primary key(effdt, num_delivery, num_venta),
					foreign key(effdt, num_delivery) references delivery(effdt, num_delivery),
					foreign key(fecha_venta, num_venta) references venta(effdt, num_venta));

/* ************************************************************************************************************************************* */
/* ************************************************ Modulo de Pedidos de materias Primas. ********************************************** */
/* ************************************************************************************************************************************* */
create table proveedor(proveedor_id char(11), nombre char(100), telefono char(20), mail char(30),
					primary key(proveedor_id));
					
create table categoria(categoria_id char(8), descripcion char(100),
					primary key(categoria_id));
					
create table materia_prima(materia_prima char(50), unidad enum('Kg', 'Lts', 'Unidad'),
					primary key(materia_prima));
					
create table mp_categoria(categoria_id char(8), materia_prima char(50),
					primary key(categoria_id, materia_prima),
					foreign key(categoria_id) references categoria(categoria_id),
					foreign key(materia_prima) references materia_prima(materia_prima));
					
create table mp_proveedor(proveedor_id char(11), categoria_id char(8), materia_prima char(50),
					primary key(proveedor_id, categoria_id, materia_prima),
					foreign key(proveedor_id) references proveedor(proveedor_id),
					foreign key(categoria_id, materia_prima) references mp_categoria(categoria_id, materia_prima));

/*create table pedido(effdt date, num_pedido integer, enviado char(1), fecha_envio date, ref_num_pedido integer,*/
create table pedido(effdt date, num_pedido integer, estado enum('Guardado', 'Enviado', 'Recibido'), fecha_envio date, ref_num_pedido integer, fecha_entrega date, costo integer,
					primary key(effdt, num_pedido));
					
create table pedido_proveedor(effdt date, num_pedido integer, proveedor_id char(11),
					primary key(effdt, num_pedido, proveedor_id),
					foreign key(effdt, num_pedido) references pedido(effdt, num_pedido),
					foreign key(proveedor_id) references proveedor(proveedor_id));
					
/*create table pedido_mp(effdt date, num_pedido integer, categoria_id char(8), materia_prima char(50), cantidad integer,
					primary key(effdt, num_pedido, categoria_id, materia_prima),
					foreign key(effdt, num_pedido) references pedido(effdt, num_pedido),
					foreign key(categoria_id, materia_prima) references mp_categoria(categoria_id, materia_prima));*/
create table pedido_mp(effdt date, num_pedido integer, materia_prima char(50), cantidad integer,
					primary key(effdt, num_pedido, materia_prima),
					foreign key(effdt, num_pedido) references pedido(effdt, num_pedido),
					foreign key(materia_prima) references materia_prima(materia_prima));