

select * from sicar.registros_aut;





-------------------------------------
drop PROCEDURE
sicar.registroArti;
-------------------------------------

DELETE FROM sicar.registros_aut
WHERE  sicar.registros_aut.art_id='3306';

DELETE FROM sicar.detalleped
WHERE  sicar.detalleped.art_id='3306';



DELETE FROM sicar.registros_aut
WHERE  sicar.registros_aut.art_id='3327';

DELETE FROM sicar.detalleped
WHERE  sicar.detalleped.ped_id='27';

------------------------------------------------------------------------------------------------------------------------
call sicar.registroArti('B111111','Pruebaprueba2','esto es una prueba Smith generada auto',1,150,30,1,'DDV890119HC9','ip');
call sicar.registroArti('B34511','Pruebaprueba2','esto es una prueba Smith generada auto',1,130,30,1,'DDV890119HC9','ip');
call sicar.registroArti('AB-205425','Pruebaprueba2','esto es una prueba Smith generada auto',1,1200,30,1,'DDV890119HC9','ip');
call sicar.registroArti('AB-236075','Pruebaprueba2','esto es una prueba Smith generada auto',1,100,30,1,'DDV890119HC9','ip');
call sicar.registroArti('AB-2075','Pruebaprueba2','esto es una prueba Smith generada auto',1,10,30,1,'DDV890119HC9','ip');



call sicar.registroArti('B111111','Pruebaprueba2','esto es una prueba Smith generada auto',150,30,1,'DDV890119HC9','ip');
call sicar.registroArti('B34511','Pruebaprueba2','esto es una prueba Smith generada auto',130,30,1,'DDV890119HC9','ip');
call sicar.registroArti('AB-205425','Pruebaprueba2','esto es una prueba Smith generada auto',12000,30,1,'DDV890119HC9','ip');
call sicar.registroArti('AB-236075','Pruebaprueba2','esto es una prueba Smith generada auto',100,30,1,'DDV890119HC9','ip');
call sicar.registroArti('AB-2075','Pruebaprueba2','esto es una prueba Smith generada auto',10000,150,1,'DDV890119HC9','ip');

------------------------------------------------------------------------------------------------------------------------
ALTER TABLE  sicar.registros_aut MODIFY sicar.registros_aut.Fecha DATETIME;

alter table sicar.registros_aut MODIFY sicar.registros_aut.ipuser text;
alter table sicar.registros_aut MODIFY sicar.registros_aut.factura LONGTEXT;
ALTER TABLE  sicar.registros_aut MODIFY sicar.registros_aut.usuario varchar(30);
ALTER TABLE  sicar.registros_aut MODIFY sicar.registros_aut.estado varchar(50);
ALTER TABLE  sicar.registros_aut add sicar.registros_aut.reg_auto int(50);
ALTER TABLE  sicar.registros_aut add sicar.registros_aut.Registro varchar(50);
ALTER TABLE  sicar.registros_aut add sicar.registros_aut.ped_id int;

update  sicar.registros_aut  SET sicar.registros_aut.reg_auto =0;

------------------------------------------------------------------------------------------------------------------------


CREATE PROCEDURE sicar.registroArti
( IN Nofactura_i   VARCHAR(50),
  IN clave_i       VARCHAR(100),
  IN descripcion_i LONGTEXT,
  IN PrecioCompra_i FLOAT,
  IN uti_i      FLOAT,
  IN cantidad_i INT(20),
  IN rfc_i      VARCHAR(100),
  IN ipsuer_i   LONGTEXT
  )
  
BEGIN

DECLARE Nofactura_v VARCHAR(50);
DECLARE precioVenta_v float;
DECLARE estado_v  VARCHAR(50);
DECLARE ped_id_v  INT(20);
DECLARE art_id_v  INT(20);
DECLARE fecha_v   DATETIME;
DECLARE EXIS_AUX  INT(2);
DECLARE usuario_v VARCHAR(50);
DECLARE pro_id_V  INT(10);
DECLARE precioAntC_v float;
DECLARE PrecioDespC_v float;
DECLARE precioAntP_v float;
DECLARE precioDespP_v float;
DECLARE utiliA_v float;
DECLARE orden_i    INT(20);

DECLARE factor_v float;

DECLARE AUXP1_V float;
DECLARE AUXP2_V float;
DECLARE AUXP3_V float;
DECLARE EXISTENCIA_V INT(10);
DECLARE AuxPrecio float;
declare auxsuma int(10);
declare trunpala VARCHAR(50);
DECLARE reg_auto_v int(10);
DECLARE registro_v VARCHAR(10);

set registro_v='0';
set AUXP1_V =0;
set AUXP2_V =0;
set AUXP3_V =0;




select now() INTO fecha_v ;                        -- alta de fecha

SET Nofactura_v = CONCAT(Nofactura_i,'%');                     --

SELECT  sicar.pedido.ped_id  FROM  sicar.pedido WHERE comentario LIKE Nofactura_v order by sicar.pedido.ped_id DESC  limit 1 INTO ped_id_v ;

select count(sicar.detalleped.ped_id) from sicar.detalleped where sicar.detalleped.ped_id=ped_id_v into orden_i;

SELECT  COUNT(sicar.articulo.clavealterna) FROM  sicar.articulo WHERE  sicar.articulo.clavealterna=clave_i INTO  EXIS_AUX;

if EXIS_AUX=0 THEN 
SET uti_i =30;
SET EXISTENCIA_V=0;
set AuxPrecio=0;

ELSE

SELECT  sicar.articulo.existencia FROM  sicar.articulo WHERE  sicar.articulo.clavealterna=clave_i INTO EXISTENCIA_V;
SELECT  sicar.articulo.precioCompra FROM  sicar.articulo WHERE  sicar.articulo.clavealterna=clave_i INTO AuxPrecio;
 
 if AuxPrecio*1.02<PrecioCompra_i or EXISTENCIA_V<1 then

 SET uti_i =30;
 else
 
 SELECT count(sicar.REGISTROS_AUT.claveAlterna) FROM sicar.REGISTROS_AUT WHERE sicar.REGISTROS_AUT.claveAlterna=clave_i  into auxsuma;
 
if auxsuma>1 then

select sicar.calcularvalorventa(clave_i, PrecioCompra_i)into precioDespP_v;
 
 set uti_i= precioDespP_v/PrecioCompra_i;
 set uti_i=ROUND((uti_i-1)*100,2);
 
 set registro_v=CONCAT('Calculado');
 else
 
 SET uti_i =30;
end if;
 
end if;

end if;

SELECT  current_user()INTO  usuario_v ;

SELECT pro_id FROM  sicar.proveedor WHERE  rfc=rfc_i INTO  pro_id_V ;


SET precioVenta_v=ROUND(PrecioCompra_i*((uti_i/100)+1),2);




if orden_i=0 then set orden_i=0;
else
set orden_i=orden_i+1;
end if;
  
SELECT  MAX(sicar.registros_aut.reg_auto)+1 FROM sicar.registros_aut into reg_auto_v  ;

IF EXIS_AUX      =0 THEN

      SELECT  MAX(sicar.articulo.art_id)+1 FROM sicar.articulo INTO art_id_v ;
      
      SET estado_v='alta automatica';
      
      set trunpala= CONCAT(clave_i,'00');
INSERT INTO
  sicar.articulo
  (
    sicar.articulo.art_id,
    sicar.articulo.clave,
    sicar.articulo.clavealterna,
    sicar.articulo.descripcion,
    sicar.articulo.factor,
    sicar.articulo.preciocompra,
    sicar.articulo.margen1,
    sicar.articulo.precio1,
    sicar.articulo.servicio,
    sicar.articulo.invMin,
    sicar.articulo.invMax,
    sicar.articulo.preCompraProm,
    sicar.articulo.margen2,
    sicar.articulo.margen3,
    sicar.articulo.margen4,
    sicar.articulo.mayoreo1,
    sicar.articulo.mayoreo2,
    sicar.articulo.mayoreo3,
    sicar.articulo.mayoreo4,
    sicar.articulo.existencia,
    sicar.articulo.caracteristicas,
    sicar.articulo.cuentaPredial,
    sicar.articulo.status,
    sicar.articulo.unidadCompra,
    sicar.articulo.unidadVenta,
    sicar.articulo.cat_id
  )
  VALUES
  (
    art_id_v,
    trunpala,
    clave_i,
    descripcion_i,
    1,
    PrecioCompra_i,
    uti_i,
    precioVenta_v,
    false,3,0,PrecioCompra_i,20,18,0,0,0,0,0,0,'','',1,1,1,1);

INSERT INTO
  sicar.articuloimpuesto
  (
    sicar.articuloimpuesto.art_id,
    sicar.articuloimpuesto.imp_id
  )
  VALUES
  (
    art_id_v,
    1
  );
  
INSERT INTO
  sicar.registros_aut
  (
    sicar.registros_aut.usuario,
    sicar.registros_aut.estado,
    sicar.registros_aut.art_id,
    sicar.registros_aut.prov,
    sicar.registros_aut.factura,
    sicar.registros_aut.claveAlterna,
    sicar.registros_aut.fecha,
    sicar.registros_aut.precioAntC,
    sicar.registros_aut.PrecioDespC,
    sicar.registros_aut.precioAntP,
    sicar.registros_aut.precioDespP,
    sicar.registros_aut.utiliA,
    sicar.registros_aut.utiliD,
    sicar.registros_aut.reg_auto,
    sicar.registros_aut.registro,
    sicar.registros_aut.ipuser,
    sicar.registros_aut.ped_id
    
  )
  VALUES
  (
    usuario_v,
    estado_v,
    art_id_v,
    pro_id_V,
    Nofactura_i,
    clave_i,
    fecha_v,
    0,
    PrecioCompra_i,
    0,
    precioVenta_v,
    0,
    uti_i,
    reg_auto_v,
    registro_v,
    ipsuer_i,
    ped_id_v
  );
  
INSERT INTO
  sicar.detalleped
  (
    sicar.detalleped.ped_id,
    sicar.detalleped.art_id,
    sicar.detalleped.clave,
    sicar.detalleped.descripcion,
    sicar.detalleped.cantidad,
    sicar.detalleped.unidad,
    sicar.detalleped.precioCompra,
    sicar.detalleped.importeCompra,
    sicar.detalleped.orden
  )
  VALUES
  (
    ped_id_v,
    art_id_v,
    clave_i,
    descripcion_i,
    cantidad_i,
    'PZA',
    PrecioCompra_i,
    PrecioCompra_i*cantidad_i,
    orden_i
  );
  
  
  
      ELSE

      SET estado_v='En sistema';

SELECT
  sicar.articulo.art_id,
  sicar.articulo.clavealterna,
  sicar.articulo.preciocompra,
  sicar.articulo.margen1,
  sicar.articulo.precio1,
  sicar.articulo.factor
  
FROM  sicar.articulo WHERE sicar.articulo.clavealterna=clave_i INTO
  art_id_v,
  clave_i,
  precioAntC_v,
  utiliA_v,
  precioAntP_v,
  factor_v;
  
  
  
   
   IF factor_v>1 then
   set precioVenta_v=precioVenta_v/factor_v;
   END IF;
  
  
  
INSERT INTO
  sicar.registros_aut
  (
    sicar.registros_aut.usuario,
    sicar.registros_aut.estado,
    sicar.registros_aut.art_id,
    sicar.registros_aut.prov,
    sicar.registros_aut.factura,
    sicar.registros_aut.claveAlterna,
    sicar.registros_aut.fecha,
    sicar.registros_aut.precioAntC,
    sicar.registros_aut.PrecioDespC,
    sicar.registros_aut.precioAntP,
    sicar.registros_aut.precioDespP,
    sicar.registros_aut.utiliA,
    sicar.registros_aut.utiliD,
    sicar.registros_aut.reg_auto,
    sicar.registros_aut.registro,
    sicar.registros_aut.ipuser,
    sicar.registros_aut.ped_id
  )
  VALUES
  (
    usuario_v,
    estado_v,
    art_id_v,
    pro_id_V,
    Nofactura_i,
    clave_i,
    fecha_v,
    precioAntC_v,
    PrecioCompra_i,
    precioAntP_v,
    precioVenta_v,
    utiliA_v,
    uti_i,
    reg_auto_v,
    registro_v,
    ipsuer_i,
    ped_id_v
    
  );
  

  
  INSERT INTO
  sicar.detalleped
  (
    sicar.detalleped.ped_id,
    sicar.detalleped.art_id,
    sicar.detalleped.clave,
    sicar.detalleped.descripcion,
    sicar.detalleped.cantidad,
    sicar.detalleped.unidad,
    sicar.detalleped.precioCompra,
    sicar.detalleped.importeCompra,
    sicar.detalleped.orden
  )
  VALUES
  (
    ped_id_v,
    art_id_v,
    clave_i,
    descripcion_i,
    cantidad_i,
    'PZA',
    PrecioCompra_i,
    PrecioCompra_i*cantidad_i,
    orden_i
  );
  
  
END IF;
END

-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

CREATE FUNCTION sicar.calcularvalorventa( claveAlterna_i varchar(50), precioCom decimal)
 RETURNS float 
BEGIN
 DECLARE vventa float default 0;
 DECLARE vventa2 float default 0;
 DECLARE precioComN float default 0;
 DECLARE precioVenta float default 0;
 
  SELECT sicar.REGISTROS_AUT.PrecioDespC FROM sicar.REGISTROS_AUT WHERE sicar.REGISTROS_AUT.claveAlterna=claveAlterna_i order by sicar.REGISTROS_AUT.reg_auto desc limit 0,1 into vventa;
  SELECT sicar.REGISTROS_AUT.PrecioDespC FROM sicar.REGISTROS_AUT WHERE sicar.REGISTROS_AUT.claveAlterna=claveAlterna_i order by sicar.REGISTROS_AUT.reg_auto desc limit 1,1 into vventa2;

  set vventa=vventa+vventa2+precioCom;
  set precioComN=vventa/3;
  set precioVenta=precioComN*1.30;
    
 RETURN ROUND(precioVenta,2);
END 
------------------------------------------------------------------
select sicar.calcularvalorventa('Pruebaprueba2', 120);
----------------------------------------------------------------
drop FUNCTION sicar.calcularvalorventa;
-----------------------------------------------------------------
