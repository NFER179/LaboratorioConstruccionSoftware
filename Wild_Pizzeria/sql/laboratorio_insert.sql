/* source C:/Documents and Settings/hola/Escritorio/Proyectos/Workspace/Wild_Pizzeria/sql/laboratorio_insert.sql; */
/*insert into cliente values
(000000001,	'Cliente',	'Mostrados',	'-',				'-'),
(000000002,	'Diego',	'Martinez',		'ruta 23 al 000',	'011-4952-7401'),
(000000003,	'Esteban',	'Rivera',		'Desconocida',		'11-38460249'),
(000000004,	'Nicolas',	'Videla',		'Ruta 23 al 2000',	'011-15-2573-1592'),
(000000005,	'Nicolas',	'Fernández',	'Bolivia 3755',		'1166149740');

insert into producto values
('PIZZ','Pizza'),
('EMPA','Empanada'),
('FAIN','Faina');

insert into sabor_producto values
('PIZZ','Muzzarella',100),
('PIZZ','Crudo y Tomates Cherry',120),
('EMPA','Horno Carnes Picada',7),
('EMPA','Horno Carne Cortada a Cuchillo',8),
('EMPA','Frita Carne Cortada a Cuchillo',8),
('FAIN','Apio',7);

insert into pedido values
(00000001, 000000001, 'PIZZ', 'Muzzarella', '2015-07-21 13:26:12.000000', 2, 'Las quiere sin muzarella', 'pendiente', 'N');

select * from cliente;
select * from producto;
select * from sabor_producto;
select * from pedido;*/
/*-------------------------------------------------------------------------------------------------------------------------------------------------------------*/
/* Carga para version V.1.02. */

insert into cliente values
(000000001,	'Pepito',	'Gomez',		'Direccion pepito',	'011-4952-7401'),
(000000002,	'Carlos',	'Perez',		'Direccion carlos',	'11-38460249'),
(000000003,	'Gaston',	'Barrionuevo',	'Direccion gaston',	'011-15-2573-1592'),
(000000005,	'Mauro',	'Abella',		'Direccion Mauro',	'1125794638');

insert into producto values
('PIZZ','Pizza'),
('EMPA','Empanada'),
('FAIN','Faina');

insert into sabor_producto values
('PIZZ','Muzzarella',100),
('PIZZ','Crudo y Tomates Cherry',120),
('EMPA','Horno Carnes Picada',7),
('EMPA','Horno Carne Cortada a Cuchillo',8),
('EMPA','Frita Carne Cortada a Cuchillo',8),
('FAIN','Apio',7);

insert into pedido values
(1, "nicolas", "bolivia 2577", 120, "2015/10/31 22:27:36", "Pendiente", "ninguna.", "N");

select * from cliente;
select * from producto;
select * from sabor_producto;