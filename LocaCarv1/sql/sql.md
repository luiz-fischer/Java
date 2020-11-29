-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema LocaCar
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema LocaCar
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `LocaCar` DEFAULT CHARACTER SET utf8 ;
USE `LocaCar` ;

-- -----------------------------------------------------
-- Table `LocaCar`.`cliente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `LocaCar`.`cliente` ;

CREATE TABLE IF NOT EXISTS `LocaCar`.`cliente` (
  `IdCliente` INT UNSIGNED NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL,
  `CPF` VARCHAR(45) NULL,
  `data_de_nascimento` VARCHAR(16) NULL,
  `qtd_dias` INT UNSIGNED NULL,
  PRIMARY KEY (`IdCliente`),
  UNIQUE INDEX `IdCliente_UNIQUE` (`IdCliente` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `LocaCar`.`veiculo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `LocaCar`.`veiculo` ;

CREATE TABLE IF NOT EXISTS `LocaCar`.`veiculo` (
  `idVeiculo` INT UNSIGNED NULL AUTO_INCREMENT,
  `marca` VARCHAR(45) NULL,
  `modelo` VARCHAR(45) NULL,
  `ano` INT NULL,
  `valor_diaria` DOUBLE NULL,
  `veiculo_idVeiculo` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`idVeiculo`),
  UNIQUE INDEX `idVeiculo_UNIQUE` (`idVeiculo` ASC),
  INDEX `fk_veiculo_veiculo1_idx` (`veiculo_idVeiculo` ASC),
  CONSTRAINT `fk_veiculo_veiculo1`
    FOREIGN KEY (`veiculo_idVeiculo`)
    REFERENCES `LocaCar`.`veiculo` (`idVeiculo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `LocaCar`.`veiculo_leve`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `LocaCar`.`veiculo_leve` ;

CREATE TABLE IF NOT EXISTS `LocaCar`.`veiculo_leve` (
  `IdVeiculoLeve` INT UNSIGNED NULL AUTO_INCREMENT,
  `marca` VARCHAR(40) NULL,
  `modelo` VARCHAR(45) NULL,
  `ano` INT UNSIGNED NULL,
  `valor_diaria` DOUBLE UNSIGNED NULL,
  `cor` VARCHAR(45) NULL,
  PRIMARY KEY (`IdVeiculoLeve`),
  UNIQUE INDEX `IdVeiculoLeve_UNIQUE` (`IdVeiculoLeve` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `LocaCar`.`aluguel`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `LocaCar`.`aluguel` ;

CREATE TABLE IF NOT EXISTS `LocaCar`.`aluguel` (
  `IdAluguel` INT UNSIGNED NULL AUTO_INCREMENT,
  `idCliente` INT UNSIGNED NOT NULL,
  `data_da_locacao` VARCHAR(16) NULL,
  `data_da_devolucao` VARCHAR(16) NULL,
  PRIMARY KEY (`IdAluguel`),
  INDEX `fk_aluguel_cliente1_idx` (`idCliente` ASC),
  UNIQUE INDEX `IdAluguel_UNIQUE` (`IdAluguel` ASC),
  CONSTRAINT `fk_aluguel_cliente1`
    FOREIGN KEY (`idCliente`)
    REFERENCES `LocaCar`.`cliente` (`IdCliente`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `LocaCar`.`veiculo_pesado`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `LocaCar`.`veiculo_pesado` ;

CREATE TABLE IF NOT EXISTS `LocaCar`.`veiculo_pesado` (
  `idVeiculoPesado` INT UNSIGNED NULL AUTO_INCREMENT,
  `marca` VARCHAR(45) NULL,
  `modelo` VARCHAR(45) NULL,
  `ano` INT UNSIGNED NULL,
  `valor_diaria` DOUBLE UNSIGNED NULL,
  `restricao` VARCHAR(20) NULL,
  PRIMARY KEY (`idVeiculoPesado`),
  UNIQUE INDEX `idVeiculoPesado_UNIQUE` (`idVeiculoPesado` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `LocaCar`.`veiculosAlugados`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `LocaCar`.`veiculosAlugados` ;

CREATE TABLE IF NOT EXISTS `LocaCar`.`veiculosAlugados` (
  `IdVeiculosAlugados` INT UNSIGNED NULL AUTO_INCREMENT,
  `idAluguel` INT UNSIGNED NULL,
  `IdVeiculoLeve` INT UNSIGNED NULL,
  `idVeiculoPesado` INT UNSIGNED NULL,
  PRIMARY KEY (`IdVeiculosAlugados`),
  INDEX `fk_veiculosAlugados_aluguel1_idx` (`idAluguel` ASC),
  UNIQUE INDEX `IdVeiculosAlugados_UNIQUE` (`IdVeiculosAlugados` ASC),
  INDEX `fk_veiculosAlugados_veiculo_leve1_idx` (`IdVeiculoLeve` ASC),
  INDEX `fk_veiculosAlugados_veiculo_pesado1_idx` (`idVeiculoPesado` ASC),
  CONSTRAINT `fk_veiculosAlugados_aluguel1`
    FOREIGN KEY (`idAluguel`)
    REFERENCES `LocaCar`.`aluguel` (`IdAluguel`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_veiculosAlugados_veiculo_leve1`
    FOREIGN KEY (`IdVeiculoLeve`)
    REFERENCES `LocaCar`.`veiculo_leve` (`IdVeiculoLeve`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_veiculosAlugados_veiculo_pesado1`
    FOREIGN KEY (`idVeiculoPesado`)
    REFERENCES `LocaCar`.`veiculo_pesado` (`idVeiculoPesado`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
