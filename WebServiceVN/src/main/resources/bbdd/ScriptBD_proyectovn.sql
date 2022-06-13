-- MySQL Script generated by MySQL Workbench
-- Fri Jun 10 23:49:40 2022
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema proyectovn
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `proyectovn` DEFAULT CHARACTER SET utf8 ;
USE `proyectovn` ;

-- -----------------------------------------------------
-- Table `proyectovn`.`ciudad`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proyectovn`.`ciudad` (
  `IDciu` INT NOT NULL,
  `NomCiu` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`IDciu`))
ENGINE = InnoDB;

INSERT INTO `ciudad` values 
(4, 'Almeria'),
(18, 'Granada'),
(29, 'Málaga'),
(11, 'Cádiz'),
(21, 'Huelva'),
(41, 'Sevilla'),
(14, 'Córdoba'),
(23, 'Jaén');

-- -----------------------------------------------------
-- Table `proyectovn`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proyectovn`.`usuario` (
  `IDusu` INT NOT NULL AUTO_INCREMENT,
  `NomUsu` VARCHAR(45) NOT NULL,
  `ApeUsu` VARCHAR(45) NOT NULL,
  `PassUsu` VARCHAR(45) NOT NULL,
  `Email` VARCHAR(45) NOT NULL,
  `Movil` VARCHAR(45) NULL,
  `IDciu` INT NULL,
  PRIMARY KEY (`IDusu`),
  INDEX `fk_usuario_ciudad1_idx` (`IDciu` ASC),
  UNIQUE INDEX `Nombre_UNIQUE` (`NomUsu` ASC),
  UNIQUE INDEX `Email_UNIQUE` (`Email` ASC),
  CONSTRAINT `fk_usuario_ciudad1`
    FOREIGN KEY (`IDciu`)
    REFERENCES `proyectovn`.`ciudad` (`IDciu`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

INSERT INTO `usuario` values 
(1, 'Admin', 'Admin', 'admin', 'admin@email.com', null, null),
(2, 'Usuario', 'Colaborador', 'usuario', 'usuario@email.com', null, null),
(3, 'veronica', 'González', 'veronica', 'veronica@email.com', 111-111-111, 29),
(4, 'natalia', 'castillo', 'natalia', 'natalia@email.com', 222-222-222, 18);

-- -----------------------------------------------------
-- Table `proyectovn`.`categoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proyectovn`.`categoria` (
  `IDcat` INT NOT NULL AUTO_INCREMENT,
  `NomCat` VARCHAR(45) NOT NULL,
  `Imagen` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`IDcat`))
ENGINE = InnoDB;

INSERT INTO `categoria` values 
(1, 'Teatro', 'https://vectorified.com/images/icon-museum-25.png'),
(2, 'Turismo', 'https://svgsilh.com/png-512/2797818.png'),
(3, 'Deporte', 'https://svgsilh.com/png-512/2768733.png'),
(4, 'Visitar', 'https://i1.wp.com/www.mastermeltgroup.com/wp-content/uploads/2017/08/location-icon.png?fit=512%2C512&ssl=1'),
(5, 'Entretenimiento', 'https://freesvg.org/img/mono-gnome-question.png'),
(6, 'Varios', 'no disponible');

-- -----------------------------------------------------
-- Table `proyectovn`.`empresa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proyectovn`.`empresa` (
  `IDemp` INT NOT NULL AUTO_INCREMENT,
  `NomEmp` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`IDemp`))
ENGINE = InnoDB;

INSERT INTO `empresa` values 
(1, 'Sin Empresa'),
(2, 'Alhambra'),
(3, 'Aliatar'),
(4, 'Alcazaba'),
(5, 'Cervantes'),
(6, 'EscapeRoom Solete');


-- -----------------------------------------------------
-- Table `proyectovn`.`actividad`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proyectovn`.`actividad` (
  `IDact` INT NOT NULL AUTO_INCREMENT,
  `IDcat` INT NOT NULL,
  `IDciu` INT NOT NULL,
  `NomAct` VARCHAR(45) NOT NULL,
  `IDemp` INT NULL DEFAULT 1,
  `Horario` VARCHAR(150) NULL DEFAULT 'No disponible',
  `Info` VARCHAR(100) NULL DEFAULT 'No disponible',
  PRIMARY KEY (`IDact`),
  INDEX `fk_categoria_has_ciudad_ciudad1_idx` (`IDciu` ASC),
  INDEX `fk_categoria_has_ciudad_categoria1_idx` (`IDcat` ASC),
  INDEX `fk_actividad_empresa1_idx` (`IDemp` ASC),
  CONSTRAINT `fk_categoria_has_ciudad_categoria1`
    FOREIGN KEY (`IDcat`)
    REFERENCES `proyectovn`.`categoria` (`IDcat`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_categoria_has_ciudad_ciudad1`
    FOREIGN KEY (`IDciu`)
    REFERENCES `proyectovn`.`ciudad` (`IDciu`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_actividad_empresa1`
    FOREIGN KEY (`IDemp`)
    REFERENCES `proyectovn`.`empresa` (`IDemp`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

INSERT INTO `actividad` VALUES
(1, 1, 18, 'El rey leon', 4, 'J-D de 18:00 a 23:00', 'No Disponible'),
(2, 1, 29, 'El rey leon', 5, 'J-D de 18:00 a 23:00', 'https://www.teatrocervantes.com/'),
(3, 5, 29, 'EscapeRoom1', 6, 'No Disponible', 'No Disponible'),
(4, 1, 18, 'Fortunata y Jacinta', 4, 'J-D de 18:00 a 23:00', 'No Disponible'),
(5, 3, 18, 'Senderismo', 2, 'No Disponible', 'No Disponible'),
(6, 5, 29, 'Paintball', 1, 'No Disponible', 'No Disponible');


-- -----------------------------------------------------
-- Table `proyectovn`.`reserva`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proyectovn`.`reserva` (
  `IDres` INT NOT NULL AUTO_INCREMENT,
  `IDusu` INT NOT NULL,
  `IDact` INT NOT NULL,
  `Hora` TIME NOT NULL,
  `Fecha` DATE NOT NULL,
  INDEX `fk_table1_usuario1_idx` (`IDusu` ASC),
  INDEX `fk_table1_actividad1_idx` (`IDact` ASC),
  PRIMARY KEY (`IDres`),
  CONSTRAINT `fk_table1_usuario1`
    FOREIGN KEY (`IDusu`)
    REFERENCES `proyectovn`.`usuario` (`IDusu`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_table1_actividad1`
    FOREIGN KEY (`IDact`)
    REFERENCES `proyectovn`.`actividad` (`IDact`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

INSERT INTO `reserva` VALUES
(1, 3, 1, '21:00:00', '2020-05-20'),
(2, 4, 1, '21:00:00', '2020-05-20'),
(3, 3, 3, '18:00:00', '2023-06-15'),
(4, 4, 5, '10:00:00', '2023-08-05');


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
