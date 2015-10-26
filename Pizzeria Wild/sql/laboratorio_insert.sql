/* source C:/Documents and Settings/nicolas/Escritorio/SVN/LaboratorioContruccionSoftware/trunk/Pizzeria Wild/sql/laboratorio_insert.sql; */
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
(000000001,	'Pepito',	'Gomez',		'Avenida Siempreviva 4323',	'011-4952-7401'),
(000000002,	'Carlos',	'Perez',		'Tucuman 400',	'11-38460249'),
(000000003,	'Gaston',	'Barrionuevo',	'Cordoba 400',	'011-15-2573-1592'),
(000000005,	'Mauro',	'Abella',		'Corrientes 5000',	'1125794638');

insert into producto values
('PIZZ','Pizza'),
('EMPA','Empanada'),
('FAIN','Faina');

insert into sabor_producto values
('PIZZ','Muzzarella'						,100),
('PIZZ','Crudo y Tomates Cherry'			,120),
('EMPA','Horno Carnes Picada'				,7),
('EMPA','Horno Carne Cortada a Cuchillo'	,8),
('EMPA','Frita Carne Cortada a Cuchillo'	,8),
('FAIN','Apio'								,7);

insert into venta values
('2015-07-21', 1, "nicolas", "bolivia 2577", "011-15-66149730", 120, "22:27:36", "Pendiente", "ninguna.", "N", '');

insert into repartidor values
(1,"Repartidor 1", "Motoquero"	, "12344321", "Cercano"),
(2,"Repartidor 2", "Bicicletero", "98766789", "Lejos");

select * from cliente;			
select * from producto;
select * from sabor_producto;
select * from venta;
select * from venta_producto;
select * from repartidor;
select * from delivery;	
/*select * from delivery_repartidor;*/
select * from delivery_venta;

/* ************************************************************************************************************************************* */
/* ************************************************ Modulo de Pedidos de materias Primas. ********************************************** */
/* ************************************************************************************************************************************* */
insert into proveedor values
('SERENICIMA'	, 'La Serenisima SA.'						, '3571949572'	, 'pedidos@serenicima.com'),
('SANCOR'		, 'Sancor SA.'								, '907548264'	, 'pedido@sancor.com.ar'),
('TRESTRIGOS'	, 'Molino Tres Trigos'						, '392-24-61-6'	, 'pedido@molinos.com.ar'),
('HEREFORD'		, 'Carniceria Hereford'						, '0237-462946'	, 'g.perez@gmail.com.ar'),
('COTOPROV'		, 'Proveedor de cadena supermercado COTO'	, '39279517'	, 'cotopedido@coto.com.ar');

insert into categoria values
('LACTEO'		, 'Categorias para todos los productos derivados de la leche.'),
('CARNE'		, 'Derivados de vaca, pollo y pescado.'),
('VERDU'		, 'Productos de Verduleria.'),
('CEREAL'		, 'Productos derivados de cereales ejem. harinas.');
					
insert into materia_prima values
('Leche Descremada'	, 'Lts'),
('Leche Larga Vida'	, 'Lts'),
('Cuadril'			, 'Kg'),
('Pechuga'			, 'Kg'),
('Atún'				, 'Kg'),
('Tomate'			, 'Kg'),
('Tomate en Lata'	, 'Unidad'),
('Tomate Cherry'	, 'Kg'),
('Rucula'			, 'Kg'),
('Harina 000'		, 'Kg'),
('Harina Integral'	, 'Kg');

insert into mp_categoria values
('LACTEO'		, 'Leche Descremada'),
('LACTEO'		, 'Leche Larga Vida'),
('CARNE'		, 'Cuadril'),
('CARNE'		, 'Pechuga'),
('CARNE'		, 'Atún'),
('VERDU'		, 'Tomate'),
('VERDU'		, 'Tomate en Lata'),
('VERDU'		, 'Tomate Cherry'),
('VERDU'		, 'Rucula'),
('CEREAL'		, 'Harina 000'),
('CEREAL'		, 'Harina Integral');
					
insert into mp_proveedor values
('SERENICIMA'	, 'LACTEO'		, 'Leche Larga Vida'),
('HEREFORD'		, 'CARNE'		, 'Pechuga'),
('HEREFORD'		, 'CARNE'		, 'Cuadril'),
('COTOPROV'		, 'VERDU'		, 'Tomate'),
('TRESTRIGOS'	, 'CEREAL'		, 'Harina 000');

insert into pedido values
('2015-07-21', 1, 'Y',	'2015-07-21', 1),
('2015/10/01', 1, 'N',	'2015/10/01', 1);

insert into pedido_proveedor values
('2015-07-21', 1, 'TRESTRIGOS'),
('2015/10/01', 1, 'HEREFORD');
					
/*insert into pedido_mp values
('2015-07-21', 1, 'CEREAL'	, 'Harina 000'		, 100),
('2015-07-21', 1, 'CEREAL'	, 'Harina Integral'	, 30),
('2015/10/31', 2, 'CARNE'	, 'Pechuga'			, 50),
('2015-10-31', 2, 'CARNE'	, 'Cuadril'			, 70);*/
insert into pedido_mp values
('2015-07-21', 1, 'Harina 000'		, 100),
('2015-07-21', 1, 'Harina Integral'	, 30),
('2015/10/01', 1, 'Pechuga'			, 50),
('2015-10-01', 1, 'Cuadril'			, 70);

select * from proveedor;
select * from categoria;
select * from materia_prima;
select * from mp_categoria;
select * from mp_proveedor;
select * from pedido;
select * from pedido_proveedor;
select * from pedido_mp;