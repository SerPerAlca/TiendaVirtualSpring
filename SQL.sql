/* CREACION BBDD */
CREATE DATABASE diversa


/* CREACIONES DE TABLAS */
CREATE TABLE `usuarios` (
    `id` INT (3) NOT NULL AUTO_INCREMENT,
    `nombre_usuario` VARCHAR (20) NOT NULL,
    `apellido_usuario` VARCHAR (25) NOT NULL,
    `email_usuario` VARCHAR (30) NOT NULL,
    `contrasenia` VARCHAR (60) NOT NULL,
    PRIMARY KEY (`id`)
    )ENGINE=INNODB AUTO_INCREMENT=1;

CREATE TABLE `empleados` ( 
    `id`INT (3) NOT NULL, 
    `num_TGSS` VARCHAR (16) NOT NULL, 
    PRIMARY KEY (`id`))
    ENGINE=INNODB;

    CREATE TABLE `clientes` (
    `id` INT (3) NOT NULL AUTO_INCREMENT,
    `preferencias` VARCHAR (20) NOT NULL,
    `ultima_conexion` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`))
    ENGINE=INNODB AUTO_INCREMENT=1;

    

    CREATE TABLE `administrador`(
        `id_administrador` INT (1) NOT NULL AUTO_INCREMENT,
        `email_administrador` VARCHAR (25) NOT NULL,
        `contrasenia` VARCHAR (16) NOT NULL,
        PRIMARY KEY (`id_administrador`)
    )ENGINE=INNODB AUTO_INCREMENT=1;   

    

    CREATE TABLE `productos`(
    `id_producto` INT (2) NOT NULL AUTO_INCREMENT,
    `nombre_producto` VARCHAR (30) NOT NULL,
    `precio` DECIMAL (6,2) NOT NULL,
    `categoria` VARCHAR (10) NOT NULL,
    `descripcion` VARCHAR (50), 
    `url_imagen` VARCHAR (40),
    PRIMARY KEY (`id_producto`)
    )ENGINE=INNODB AUTO_INCREMENT=1;

    /* INSERCCIONES DE REGISTROS
    
    /* -------------------------------------- Productos --------------------------------------------------------------- */
    INSERT INTO `productos` (nombre_producto, precio, categoria, descripcion, url_imagen) VALUES ("Redmi Note 9 Pro", "650", "telefonía", "Nuevo Redmi Note 9 Pro", "/public/images/redmi9Pro.jfif");
    INSERT INTO `productos` (nombre_producto, precio, categoria, descripcion, url_imagen) VALUES ("Iphone X", "1150", "telefonía", "Lo más exclusivo de Apple", "/public/images/iphoneX.jfif");
    INSERT INTO `productos` (nombre_producto, precio, categoria, descripcion, url_imagen) VALUES ("Huawei Honor 10 Lite", "450", "telefonía", "Vuelve Huawei, vuelve Honor", "/public/images/Huawei_Honor.jfif");
    INSERT INTO `productos` (nombre_producto, precio, categoria, descripcion, url_imagen) VALUES ("Huawei Y6", "340", "telefonía", "El nuevo Huawei Y6", "/public/images/Huawei_Y6.jfif");
    INSERT INTO `productos` (nombre_producto, precio, categoria, descripcion, url_imagen) VALUES ("Samsung S20", "660", "telefonía", "Otro nivel de Samsung", "/public/images/samsung_s20.jfif");

    /*-------------------------------------- Administrador ------------------------------------------------------------*/
    INSERT INTO `administrador` (email_administrador, contrasenia) VALUES ("serperalca@gmail.com", "Madriler_69");

    ALTER TABLE `empleados` ADD CONSTRAINT `FK_EMPLEADOS_USUARIOS` FOREIGN KEY (`id`) REFERENCES `usuarios` (`id`) 
    ALTER TABLE `clientes` ADD CONSTRAINT `FK_CLIENTES_USUARIOS` FOREIGN KEY (`id`) REFERENCES `usuarios` (`id`)