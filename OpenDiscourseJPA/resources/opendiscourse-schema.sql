-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema opendiscourse
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema opendiscourse
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `opendiscourse` DEFAULT CHARACTER SET latin1 ;
USE `opendiscourse` ;

-- -----------------------------------------------------
-- Table `opendiscourse`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `opendiscourse`.`user` ;

CREATE TABLE IF NOT EXISTS `opendiscourse`.`user` (
  `iduser` INT(11) NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(100) NOT NULL,
  `username` VARCHAR(30) NOT NULL,
  `password` VARCHAR(50) NOT NULL,
  `dateJoined` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`iduser`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC),
  UNIQUE INDEX `iduser_UNIQUE` (`iduser` ASC),
  UNIQUE INDEX `iduser_idx_UNIQUE` (`iduser` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `opendiscourse`.`topic`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `opendiscourse`.`topic` ;

CREATE TABLE IF NOT EXISTS `opendiscourse`.`topic` (
  `idTopic` INT(11) NOT NULL AUTO_INCREMENT,
  `idUser` INT(11) NOT NULL,
  `topicValue` VARCHAR(500) NOT NULL,
  `thumbsUp` INT(11) NULL DEFAULT '0',
  `thumbsDown` INT(11) NULL DEFAULT '0',
  `datePosted` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`idTopic`),
  INDEX `fk_to_iduser_idx` (`idUser` ASC),
  CONSTRAINT `fk_to_iduser`
    FOREIGN KEY (`idUser`)
    REFERENCES `opendiscourse`.`user` (`iduser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `opendiscourse`.`remark`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `opendiscourse`.`remark` ;

CREATE TABLE IF NOT EXISTS `opendiscourse`.`remark` (
  `idremark` INT(11) NOT NULL AUTO_INCREMENT,
  `idTopic` INT(11) NOT NULL,
  `idUser` INT(11) NOT NULL,
  `remarkValue` VARCHAR(1000) NOT NULL,
  `against` TINYINT(4) NOT NULL,
  `thumbsUp` INT(11) NULL DEFAULT '0',
  `thumbsDown` INT(11) NULL DEFAULT '0',
  `datePosted` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`idremark`),
  INDEX `fk_idtopic_idx` (`idTopic` ASC),
  INDEX `fk_re_iduser_idx` (`idUser` ASC),
  CONSTRAINT `fk_idtopic`
    FOREIGN KEY (`idTopic`)
    REFERENCES `opendiscourse`.`topic` (`idTopic`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_re_iduser`
    FOREIGN KEY (`idUser`)
    REFERENCES `opendiscourse`.`user` (`iduser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
