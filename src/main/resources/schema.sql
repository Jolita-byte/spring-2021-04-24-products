DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
                           `id` long(20) NOT NULL AUTO_INCREMENT,
                          `type` varchar(50),
                          `price` decimal,
                          PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `stocks`;
CREATE TABLE `stocks` (
                           `id` long(20) NOT NULL AUTO_INCREMENT,
                           `type` varchar(50),
                           `pieces` integer,
                           PRIMARY KEY (`id`)
);


