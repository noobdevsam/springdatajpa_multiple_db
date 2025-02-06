-- cardholder database
CREATE DATABASE IF NOT EXISTS cardholder;
CREATE USER IF NOT EXISTS `cardholderadmin`@`localhost` IDENTIFIED BY 'password';
GRANT ALL ON `cardholder`.* TO `cardholderadmin`@`localhost`;
CREATE USER IF NOT EXISTS `cardholderuser`@`localhost` IDENTIFIED BY 'password';
GRANT SELECT, INSERT, UPDATE, DELETE, SHOW VIEW ON `cardholder`.* TO `cardholderuser`@`localhost`;
FLUSH PRIVILEGES;


-- card database
CREATE DATABASE IF NOT EXISTS card;
CREATE USER IF NOT EXISTS `cardadmin`@`localhost` IDENTIFIED BY 'password';
GRANT ALL ON `card`.* TO `cardadmin`@`localhost`;
CREATE USER IF NOT EXISTS `carduser`@`localhost` IDENTIFIED BY 'password';
GRANT SELECT, INSERT, UPDATE, DELETE, SHOW VIEW ON `card`.* TO `carduser`@`localhost`;
FLUSH PRIVILEGES;

-- card PAN database
CREATE DATABASE IF NOT EXISTS pan;
CREATE USER IF NOT EXISTS `panadmin`@`localhost` IDENTIFIED BY 'password';
GRANT ALL ON `pan`.* TO `panadmin`@`localhost`;
CREATE USER IF NOT EXISTS `panuser`@`localhost` IDENTIFIED BY 'password';
GRANT SELECT, INSERT, UPDATE, DELETE, SHOW VIEW ON `pan`.* TO `panuser`@`localhost`;
FLUSH PRIVILEGES;
