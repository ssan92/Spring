--by ssanchez
-- insert empleado
insert into empleado (id_empleado,nombre) values (1,'RENE');
insert into empleado (id_empleado,nombre) values (2,'ASTRID');
insert into empleado (id_empleado,nombre) values (3,'ANDRES');
--insert marcacion

 -- RENE = MO10: 00-12: 00, TU10: 00-12: 00, TH01: 00-03: 00, SA14: 00-18: 00, SU20: 00- 21:00
 -- ASTRID = MO10: 00-12: 00, TH12: 00-14: 00, SU20: 00-21: 00
 -- ANDRES = MO10: 00-12: 00, TH12: 00-14: 00, SU20: 00-21: 00

--semana de 2021-12-06 al 2021-12-12
insert into marcacion (id_marcacion,id_empleado,fecha_entrada,fecha_salida) values(1,1,'2021-12-06 10:00:00','2021-12-06 12:00:00');--lunes
insert into marcacion (id_marcacion,id_empleado,fecha_entrada,fecha_salida) values(2,1,'2021-12-07 10:00:00','2021-12-07 12:00:00');--martes
insert into marcacion (id_marcacion,id_empleado,fecha_entrada,fecha_salida) values(3,1,'2021-12-09 01:00:00','2021-12-09 03:00:00');--jueves
insert into marcacion (id_marcacion,id_empleado,fecha_entrada,fecha_salida) values(4,1,'2021-12-11 14:00:00','2021-12-11 18:00:00');--sabado
insert into marcacion (id_marcacion,id_empleado,fecha_entrada,fecha_salida) values(5,1,'2021-12-12 20:00:00','2021-12-12 21:00:00');--domingo

insert into marcacion (id_marcacion,id_empleado,fecha_entrada,fecha_salida) values(6,2,'2021-12-06 10:00:00','2021-12-06 12:00:00');
insert into marcacion (id_marcacion,id_empleado,fecha_entrada,fecha_salida) values(7,2,'2021-12-09 12:00:00','2021-12-09 14:00:00');
insert into marcacion (id_marcacion,id_empleado,fecha_entrada,fecha_salida) values(8,2,'2021-12-12 20:00:00','2021-12-12 21:00:00');

insert into marcacion (id_marcacion,id_empleado,fecha_entrada,fecha_salida) values(9,3,'2021-12-06 10:00:00','2021-12-06 12:00:00');
insert into marcacion (id_marcacion,id_empleado,fecha_entrada,fecha_salida) values(10,3,'2021-12-09 12:00:00','2021-12-09 14:00:00');
insert into marcacion (id_marcacion,id_empleado,fecha_entrada,fecha_salida) values(11,3,'2021-12-12 20:00:00','2021-12-12 21:00:00');

 -- RENE = MO10: 15-12: 00, TU10: 00-12: 00, TH13: 00-13: 15, SA14: 00-18: 00, SU20: 00-21: 00
 -- ASTRID = MO10: 00-12: 00, TH12: 00-14: 00, SU20: 00-21: 00

--semana de 2021-12-13 al 2021-12-19
insert into marcacion (id_marcacion,id_empleado,fecha_entrada,fecha_salida) values(12,1,'2021-12-13 10:15:00','2021-12-13 12:00:00');--lunes
insert into marcacion (id_marcacion,id_empleado,fecha_entrada,fecha_salida) values(13,1,'2021-12-14 10:00:00','2021-12-14 12:00:00');--martes
insert into marcacion (id_marcacion,id_empleado,fecha_entrada,fecha_salida) values(14,1,'2021-12-16 13:00:00','2021-12-16 13:15:00');--jueves
insert into marcacion (id_marcacion,id_empleado,fecha_entrada,fecha_salida) values(15,1,'2021-12-18 14:00:00','2021-12-18 18:00:00');--sabado
insert into marcacion (id_marcacion,id_empleado,fecha_entrada,fecha_salida) values(16,1,'2021-12-19 20:00:00','2021-12-19 21:00:00');--domingo

insert into marcacion (id_marcacion,id_empleado,fecha_entrada,fecha_salida) values(17,2,'2021-12-13 10:00:00','2021-12-13 12:00:00');
insert into marcacion (id_marcacion,id_empleado,fecha_entrada,fecha_salida) values(18,2,'2021-12-16 12:00:00','2021-12-16 14:00:00');
insert into marcacion (id_marcacion,id_empleado,fecha_entrada,fecha_salida) values(19,2,'2021-12-19 20:00:00','2021-12-19 21:00:00');