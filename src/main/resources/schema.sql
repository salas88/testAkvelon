
CREATE TABLE IF NOT EXISTS `akvelon`.`country`(
    `id` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(64) NOT NULL,
    `small_name` VARCHAR(3) NOT NULL,
    PRIMARY KEY (`id`)
    );

CREATE TABLE IF NOT EXISTS `akvelon`.`weather`(
    `id` INT NOT NULL AUTO_INCREMENT,
    `country` VARCHAR(255),
    `name` VARCHAR(255),
    `temperature` DOUBLE ,
    `temperature_max` DOUBLE,
    `temperature_min` DOUBLE,
    `weather_description` VARCHAR(255),
    `wind_speed` DOUBLE,
    PRIMARY KEY (`id`)
    );