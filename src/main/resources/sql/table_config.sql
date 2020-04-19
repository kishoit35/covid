
-- User Table
CREATE TABLE `vyakta`.`users` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `user_name` VARCHAR(45) NULL,
  `role_type` VARCHAR(45) NULL,
  `user_type` VARCHAR(45) NULL,
  `member_since` DATETIME NULL,
  `password` VARCHAR(45) NULL,
  `email_id` VARCHAR(45) NULL,
  `contact_no` VARCHAR(45) NULL,
  PRIMARY KEY (`user_id`));

--Address Table
CREATE TABLE `vyakta`.`address` (
  `address_id` INT NOT NULL AUTO_INCREMENT,
  `address_label` VARCHAR(45) NULL,
  `user_id` INT NULL,
  `mail_id` VARCHAR(45) NULL,
  `add_line1` VARCHAR(45) NULL,
  `add_line2` VARCHAR(45) NULL,
  `add_line3` VARCHAR(45) NULL,
  `city` VARCHAR(45) NULL,
  `state` VARCHAR(45) NULL,
  `pincode` VARCHAR(45) NULL,
  `country` VARCHAR(45) NULL,
  `location` VARCHAR(45) NULL,
  `landmark` VARCHAR(45) NULL,
  PRIMARY KEY (`address_id`),
  INDEX `address_map_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `address_map`
    FOREIGN KEY (`user_id`)
    REFERENCES `vyakta`.`users` (`user_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);


--Posts Table
CREATE TABLE `vyakta`.`posts` (
  `post_id` INT NOT NULL AUTO_INCREMENT,
  `post_desc` VARCHAR(100) NULL,
  `post_create_date` DATETIME NULL,
  `post_request_date` DATETIME NULL,
  `type` VARCHAR(20) NULL,
  `sub_type` VARCHAR(45) NULL,
  `quantity` INT NOT NULL,
  `user_id` INT NULL,
  `status` VARCHAR(45) NULL,
  `post_end_date` DATETIME NULL,
  `recurring` VARCHAR(45) NULL,
  `address_id` INT NULL,
  `address_type` INT NULL,
  PRIMARY KEY (`post_id`, `quantity`),
  INDEX `post_map_addr_idx` (`address_id` ASC) VISIBLE,
  INDEX `post_map_user_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `post_map_addr`
    FOREIGN KEY (`address_id`)
    REFERENCES `vyakta`.`address` (`address_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `post_map_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `vyakta`.`users` (`user_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
