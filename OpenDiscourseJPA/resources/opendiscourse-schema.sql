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
-- Table `opendiscourse`.`topic`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `opendiscourse`.`topic` ;

CREATE TABLE IF NOT EXISTS `opendiscourse`.`topic` (
  `idTopic` INT(11) NOT NULL AUTO_INCREMENT,
  `topicValue` VARCHAR(500) NOT NULL,
  PRIMARY KEY (`idTopic`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `opendiscourse`.`remark`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `opendiscourse`.`remark` ;

CREATE TABLE IF NOT EXISTS `opendiscourse`.`remark` (
  `idremark` INT(11) NOT NULL AUTO_INCREMENT,
  `idTopic` INT(11) NOT NULL,
  `remarkValue` VARCHAR(1000) NOT NULL,
  `against` TINYINT(4) NOT NULL,
  `thumbsUp` INT(11) NULL DEFAULT '0',
  `thumbsDown` INT(11) NULL DEFAULT '0',
  PRIMARY KEY (`idremark`),
  INDEX `fk_idtopic_idx` (`idTopic` ASC),
  CONSTRAINT `fk_idtopic`
    FOREIGN KEY (`idTopic`)
    REFERENCES `opendiscourse`.`topic` (`idTopic`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 13
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `opendiscourse`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `opendiscourse`.`user` ;

CREATE TABLE IF NOT EXISTS `opendiscourse`.`user` (
  `iduser` INT(11) NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  `username` VARCHAR(30) NOT NULL,
  `password` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`iduser`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `opendiscourse`.`user_topics`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `opendiscourse`.`user_topics` ;

CREATE TABLE IF NOT EXISTS `opendiscourse`.`user_topics` (
  `iduser` INT(11) NOT NULL,
  `idtopic` INT(11) NOT NULL,
  PRIMARY KEY (`iduser`, `idtopic`),
  INDEX `fk_idtopic_idx` (`idtopic` ASC),
  INDEX `fk_ut_idtopic_idx` (`idtopic` ASC),
  CONSTRAINT `fk_ut_idtopic`
    FOREIGN KEY (`idtopic`)
    REFERENCES `opendiscourse`.`topic` (`idTopic`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ut_iduser`
    FOREIGN KEY (`iduser`)
    REFERENCES `opendiscourse`.`user` (`iduser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
