CREATE TABLE IF NOT EXISTS `Run` (
    `id` INT NOT NULL ,
    `title` VARCHAR(255) NOT NULL ,
    `miles` INT NOT NULL ,
    `started_on` TIMESTAMP NOT NULL ,
    `completed_on` TIMESTAMP NOT NULL ,
    `location` VARCHAR(10) NOT NULL ,
--     THIS IS ONLY FOR SPRING DATA
    `version` INT,
    PRIMARY KEY (`id`)
);