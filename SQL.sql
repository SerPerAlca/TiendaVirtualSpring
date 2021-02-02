-- CREACION BBDD
CREATE DATABASE diversa


--CREACIONES DE TABLAS

CREATE TABLE `trabajador` ( 
    `id_trabajador`INT (3) NOT NULL AUTO_INCREMENT, 
    `id_usuario` INT (100) NOT NULL, 
    `num_TGSS` INT (16) NOT NULL, 
    PRIMARY KEY (`id_trabajador`), 
    FOREIGN KEY (`id_usuario`) REFERENCES usuarios(`id_usuario`)) 
    ENGINE=INNODB AUTO_INCREMENT=1;

    CREATE TABLE `clientes` (
    `id_cliente` INT (3) NOT NULL AUTO_INCREMENT,
    `id_usuario` INT (100) NOT NULL,
    `ultima_conexion` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id_cliente`),
    FOREIGN KEY (`id_usuario`) REFERENCES usuarios(`id_usuario`)) 
    ENGINE=INNODB AUTO_INCREMENT=1;

    CREATE TABLE `usuarios` (
    `id_usuario` INT (100) NOT NULL AUTO_INCREMENT,
    `nombre_usuario` VARCHAR (20) NOT NULL,
    `apellido_usuario` VARCHAR (25) NOT NULL,
    `email_usuario` VARCHAR (30) NOT NULL,
    `contrasenia` VARCHAR (10) NOT NULL,
    PRIMARY KEY (`id_usuario`)
    )ENGINE=INNODB AUTO_INCREMENT=1;

    CREATE TABLE `productos`(
    `id_producto` INT (3) NOT NULL AUTO_INCREMENT,
    `nombre_producto` VARCHAR (25) NOT NULL,
    `precio` DECIMAL (6,2) NOT NULL,
    `categoria` VARCHAR (10) NOT NULL,
    `descripcion` VARCHAR (30), 
    `url_imagen` VARCHAR (40),
    PRIMARY KEY (`id_producto`)
    )ENGINE=INNODB AUTO_INCREMENT=1;

    -- INSERCCIONES DE REGISTROS
    ------------------------------------- Usuarios ----------------------------------------------------------------
    INSERT INTO `usuarios` (nombre_usuario, apellido_usuario, email_usuario, contrasenia) VALUES ("Oliver", "Pérez", "soyoliver@gmail.com", "Oliver_69");
    INSERT INTO `usuarios` (nombre_usuario, apellido_usuario, email_usuario, contrasenia) VALUES ("Sergio", "Pérez", "serperalca@gmail.com", "Madriler_69");
    INSERT INTO `usuarios` (nombre_usuario, apellido_usuario, email_usuario, contrasenia) VALUES ("Beatriz", "Miguel", "beatrizmiguel@gmail.com", "BMI_87");

    -------------------------------------- Productos ---------------------------------------------------------------
    INSERT INTO `productos` (nombre_producto, precio, categoria, descripcion, url_imagen) VALUES ("Redmi Note 9 Pro", "650", "telefonía", "Nuevo Redmi Note 9 Pro", "/public/images/redmi9Pro.jfif");
    INSERT INTO `productos` (nombre_producto, precio, categoria, descripcion, url_imagen) VALUES ("Iphone X", "1150", "telefonía", "Lo más exclusivo de Apple", "/public/images/iphoneX.jfif");
    INSERT INTO `productos` (nombre_producto, precio, categoria, descripcion, url_imagen) VALUES ("Huawei Honor 10 Lite", "450", "telefonía", "Vuelve Huawei, vuelve Honor", "/public/images/Huawei_Honor.jfif");
    INSERT INTO `productos` (nombre_producto, precio, categoria, descripcion, url_imagen) VALUES ("Huawei Y6", "340", "telefonía", "El nuevo Huawei Y6", "/public/images/Huawei_Y6.jfif");
    INSERT INTO `productos` (nombre_producto, precio, categoria, descripcion, url_imagen) VALUES ("Samsung S20", "660", "telefonía", "Otro nivel de Samsung", "/public/images/samsung_s20.jfif");
