
DELETE FROM sicar.pedido
WHERE  sicar.pedido.ped_id='27';
--------------------------------------------------------------------------------------------------------
call sicar.CreacionPedido(1000.0,'AB-236075 DR4RR','DDV890119HC9');

--------------------------------------------------------------------------------------------------------
drop PROCEDURE
sicar.CreacionPedido;
--------------------------------------------------------------------------------------------------------




create PROCEDURE sicar.CreacionPedido
  ( in  total_v float,
    in Nofactura_v LONGTEXT,
    in rfc_v varchar(100)
    )

BEGIN

DECLARE ped_id_v  int;
DECLARE fecha_v date;
DECLARE comentario_v varchar(100);
DECLARE pro_id_V int;

select pro_id from sicar.proveedor where rfc=rfc_v into pro_id_V ;
select CURDATE() into fecha_v ; 
select  max(sicar.pedido.ped_id)+1 from sicar.pedido into ped_id_v ;

insert into sicar.pedido(ped_id, fecha, total, img, caracteristicas,desglosado,comentario,status,usu_id,pro_id) values
(ped_id_v,fecha_v,total_v,false,false,false,Nofactura_v,1,1,pro_id_V);

end;