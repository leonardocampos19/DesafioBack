-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema db_desafio
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema db_desafio
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `db_desafio` DEFAULT CHARACTER SET utf8 ;
USE `db_desafio` ;

-- -----------------------------------------------------
-- Table `db_desafio`.`tb_customer_account`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_desafio`.`tb_customer_account` (
  `id_customer` INT(6) NOT NULL,
  `cpf_cnpj` VARCHAR(15) NULL DEFAULT NULL,
  `nm_customer` VARCHAR(60) NULL DEFAULT NULL,
  `is_active` BIT(1) NULL DEFAULT NULL,
  `vl_total` DECIMAL(9,2) NULL DEFAULT NULL,
  PRIMARY KEY (`id_customer`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
