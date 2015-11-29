 
drop database if exists PizzeriaWild;

create database PizzeriaWild;

use PizzeriaWild;
 
create table preferencias(db_usuario char(50), db_pass char(50), estilo char(30));

create table estilos(id_estilo char(30), codigo char(200),
			primary key(id_estilo)); 
create table cliente(id_cliente integer, nombres char(50), apellido char(30), direccion char(50),tel char(20),
					primary key (id_cliente));
					 		
create table producto(product_id char(4), descripcion char(100) unique, mixta char(1), cocina char(1),
					primary key (product_id));
					
create table sabor_producto(product_id char(4), sabor char(100), precio integer,
					primary key(product_id, sabor),
					foreign key (product_id) references producto(product_id));
					 
create table venta(effdt date, num_venta integer, cliente char(80), direccion char(50), tel_cliente char(20), precio integer, hora time, estado enum('Pendiente','Armado','Viaje','Cancelado','Facturado'), observaciones long, delivery char(1), obs_delivery long,
					primary key(effdt, num_venta));
 
create table venta_producto(effdt date, num_venta integer, producto char(4), sabor char(250), cantidad integer,
					primary key (effdt, num_venta, producto, sabor),
					foreign key (effdt, num_venta) references venta(effdt, num_venta),
					foreign key (producto, sabor) references sabor_producto(product_id, sabor));
					
create table combo(id integer, descr char(30) unique,
			primary key(id));

create table combo_activo(combo_id integer, effdt date, precio integer, estado char(1),
			primary key(combo_id, effdt),
			foreign key(combo_id) references combo(id));

create table combo_producto(combo_id integer, effdt date, product_id char(4), sabor char(100), cantidad integer,
			primary key(combo_id, effdt, product_id, sabor),
			foreign key(combo_id, effdt) references combo_activo(combo_id, effdt),
			foreign key(product_id, sabor) references sabor_producto(product_id, sabor));

create table combo_venta(effdt date, num_venta integer, combo_id integer, cantidad integer,
			primary key (effdt, num_venta, combo_id),
			foreign key (effdt, num_venta) references venta(effdt,num_venta),
			foreign key (combo_id) references combo(id));			

create table repartidor(empleado_id integer, nombre char(30), apellido char(30), tel char(14), direccion char(30), vehiculo_id char(10), tipo_vehiculo char(20), modelo_vehiculo char(30), activo char(1),
					primary key(empleado_id));
					 
create table delivery(effdt date, num_delivery integer, empleado_id integer, hora time, obs long,
					primary key(effdt, num_delivery)); 

create table delivery_venta(effdt date, num_delivery integer,fecha_venta date, num_venta integer, estado enum('pendiente','entregado','no entregado'), obs_noentregado char(100),
					primary key(effdt, num_delivery, num_venta),
					foreign key(effdt, num_delivery) references delivery(effdt, num_delivery),
					foreign key(fecha_venta, num_venta) references venta(effdt, num_venta)); 
					
create table proveedor(proveedor_id char(11), nombre char(100), telefono char(20), mail char(30), activo char(1),
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
 
create table pedido(effdt date, num_pedido integer, estado enum('Guardado', 'Enviado', 'Recibido'), fecha_envio date, ref_num_pedido integer, fecha_entrega date, costo integer,
					primary key(effdt, num_pedido));
					
create table pedido_proveedor(effdt date, num_pedido integer, proveedor_id char(11),
					primary key(effdt, num_pedido, proveedor_id),
					foreign key(effdt, num_pedido) references pedido(effdt, num_pedido),
					foreign key(proveedor_id) references proveedor(proveedor_id));
					 
create table pedido_mp(effdt date, num_pedido integer, materia_prima char(50), cantidad integer,
					primary key(effdt, num_pedido, materia_prima),
					foreign key(effdt, num_pedido) references pedido(effdt, num_pedido),
					foreign key(materia_prima) references materia_prima(materia_prima))