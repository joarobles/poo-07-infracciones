INSERT INTO `poo-infracciones`.`Estado` (`nombre`) VALUES ('Pagada');
INSERT INTO `poo-infracciones`.`Estado` (`nombre`) VALUES ('Labrada');

INSERT INTO `poo-infracciones`.`Pais` (`nombre`) VALUES ('Argentina');
INSERT INTO `poo-infracciones`.`Provincia` (`nombre`, `idPais`) VALUES ('Cordoba', 1);
INSERT INTO `poo-infracciones`.`Localidad` (`nombre`, `idProvincia`) VALUES ('Cordoba', 1);

INSERT INTO `poo-infracciones`.`OrganismoEmisor` (`nombre`, `idLocalidad`) VALUES ('Emisiones de la Capital', '1');

INSERT INTO `poo-infracciones`.`Marca` (`nombre`) VALUES ('Chevrolet');
INSERT INTO `poo-infracciones`.`Modelo` (`nombre`, `idMarca`) VALUES ('Onix', '1');
INSERT INTO `poo-infracciones`.`Vehiculo` (`dominio`, `anioPatentamiento`, `color`, `idModelo`) VALUES ('AB710ST', '2017', 'Blanco', '1');

INSERT INTO `poo-infracciones`.`AutoridadConstatacion` (`legajo`, `apellido`, `nombre`, `dni`, `fechaNacimiento`, `numeroPlaca`, `sexo`) VALUES ('1234', 'Martinez', 'Rosario', '22123123', '1980-12-12', '223344', 'F');

INSERT INTO `poo-infracciones`.`TipoRuta` (`nombre`) VALUES ('Nacional');
INSERT INTO `poo-infracciones`.`Ruta` (`numero`, `nombre`, `idTipoRuta`) VALUES ('9', 'Ruta 9', '1');

INSERT INTO `poo-infracciones`.`TipoInfraccion` (`codigo`, `cantidadPuntosDescontados`, `descripcion`, `importe`, `observaciones`, `porcentajeDescuento`) VALUES ('1', '5', 'Adelantamiento indebido', '2500', 'Adelantamiento en doble linea amarilla', '10');
INSERT INTO `poo-infracciones`.`TipoInfraccion` (`codigo`, `cantidadPuntosDescontados`, `descripcion`, `importe`, `observaciones`, `porcentajeDescuento`) VALUES ('2', '15', 'Luces bajas apagadas en ruta', '700', 'Luces bajas apagadas en ruta', '5');
