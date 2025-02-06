-- cardholder-user
CREATE USER IF NOT EXISTS `cardholderadmin`@`localhost` IDENTIFIED BY 'password';
CREATE USER IF NOT EXISTS `cardholderuser`@`localhost` IDENTIFIED BY 'password';


-- card=user
CREATE USER IF NOT EXISTS `cardadmin`@`localhost` IDENTIFIED BY 'password';
CREATE USER IF NOT EXISTS `carduser`@`localhost` IDENTIFIED BY 'password';

-- cardPAN-user
CREATE USER IF NOT EXISTS `panadmin`@`localhost` IDENTIFIED BY 'password';
CREATE USER IF NOT EXISTS `panuser`@`localhost` IDENTIFIED BY 'password';

