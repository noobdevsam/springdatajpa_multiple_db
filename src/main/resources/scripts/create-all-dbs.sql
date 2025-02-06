-- cardholder database
CREATE DATABASE IF NOT EXISTS cardholder;
GRANT ALL ON `cardholder`.* TO `cardholderadmin`@`localhost`;
GRANT SELECT, INSERT, UPDATE, DELETE, SHOW VIEW ON `cardholder`.* TO `cardholderuser`@`localhost`;
FLUSH PRIVILEGES;


-- card database
CREATE DATABASE IF NOT EXISTS card;
GRANT ALL ON `card`.* TO `cardadmin`@`localhost`;
GRANT SELECT, INSERT, UPDATE, DELETE, SHOW VIEW ON `card`.* TO `carduser`@`localhost`;
FLUSH PRIVILEGES;

-- card PAN database
CREATE DATABASE IF NOT EXISTS pan;
GRANT ALL ON `pan`.* TO `panadmin`@`localhost`;
GRANT SELECT, INSERT, UPDATE, DELETE, SHOW VIEW ON `pan`.* TO `panuser`@`localhost`;
FLUSH PRIVILEGES;
