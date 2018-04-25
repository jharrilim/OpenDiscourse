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
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `opendiscourse`.`remark`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `opendiscourse`.`remark` ;

CREATE TABLE IF NOT EXISTS `opendiscourse`.`remark` (
  `idremark` INT(11) NOT NULL AUTO_INCREMENT,
  `idTopic` INT(11) NOT NULL,
  `remarkValue` VARCHAR(1000) NOT NULL,
  `thumbsUp` INT(11) NULL DEFAULT '0',
  `thumbsDown` INT(11) NULL DEFAULT '0',
  PRIMARY KEY (`idremark`),
  UNIQUE INDEX `topicId_UNIQUE` (`idTopic` ASC),
  CONSTRAINT `idTopic`
    FOREIGN KEY (`idTopic`)
    REFERENCES `opendiscourse`.`topic` (`idTopic`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
