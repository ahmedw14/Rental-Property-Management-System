-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`renter`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`renter` (
  `email` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`email`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`landlord`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`landlord` (
  `email` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`email`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`manager`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`manager` (
  `email` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`email`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`property`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`property` (
  `propertyStatus` VARCHAR(45) NOT NULL,
  `propertyType` VARCHAR(45) NOT NULL,
  `numBedrooms` INT NOT NULL,
  `numBathrooms` INT NOT NULL,
  `furnished` VARCHAR(4) NOT NULL,
  `quadrant` VARCHAR(4) NOT NULL,
  `address` VARCHAR(45) NOT NULL,
  `houseIdNum` INT NOT NULL,
  `landlord_email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`houseIdNum`),
  INDEX `fk_property_landlord1_idx` (`landlord_email` ASC) VISIBLE,
  CONSTRAINT `fk_property_landlord1`
    FOREIGN KEY (`landlord_email`)
    REFERENCES `mydb`.`landlord` (`email`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`search_criteria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`search_criteria` (
  `propertyType` VARCHAR(45) NOT NULL,
  `numBedrooms` INT NOT NULL,
  `numBathrooms` INT NOT NULL,
  `furnished` VARCHAR(4) NOT NULL,
  `cityQuadrant` VARCHAR(4) NOT NULL,
  `renter_email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`renter_email`),
  INDEX `fk_search_criteria_renter_idx` (`renter_email` ASC) VISIBLE,
  CONSTRAINT `fk_search_criteria_renter`
    FOREIGN KEY (`renter_email`)
    REFERENCES `mydb`.`renter` (`email`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`fees`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`fees` (
  `amount` INT NOT NULL,
  `period` INT NOT NULL)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`emails`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`emails` (
  `landlord_email` VARCHAR(45) NOT NULL,
  `renter_email` VARCHAR(45) NOT NULL,
  `message` VARCHAR(120) NOT NULL,
  PRIMARY KEY (`landlord_email`, `renter_email`),
  INDEX `fk_landlord_has_renter_renter1_idx` (`renter_email` ASC) VISIBLE,
  INDEX `fk_landlord_has_renter_landlord1_idx` (`landlord_email` ASC) VISIBLE,
  CONSTRAINT `fk_landlord_has_renter_landlord1`
    FOREIGN KEY (`landlord_email`)
    REFERENCES `mydb`.`landlord` (`email`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_landlord_has_renter_renter1`
    FOREIGN KEY (`renter_email`)
    REFERENCES `mydb`.`renter` (`email`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
