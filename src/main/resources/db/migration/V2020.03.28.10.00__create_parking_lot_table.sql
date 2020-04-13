CREATE TABLE `parking_boy` (
   `id` char(36) NOT NULL,
   `name` nvarchar(100) NOT NULL,
   `parking_policy` char(20) NOT NULL,
   PRIMARY KEY (`id`)
);

INSERT INTO `parking_boy` VALUES ('BOY001', '张伟', 'FIRST_PRIORITY');
INSERT INTO `parking_boy` VALUES ('BOY002', '曾小贤', 'MAX_SPACE_PRIORITY');

CREATE TABLE `parking_boy_vs_parking_lot` (
    `id` char(36) NOT NULL,
    `parking_boy_id` char(36) NOT NULL,
    `parking_lot_id` char(36) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY (`parking_boy_id`),
    UNIQUE KEY (`parking_lot_id`)
);

INSERT INTO `parking_boy_vs_parking_lot` VALUES (unhex(replace(uuid(),'-','')), 'BOY001', 'LOT001');
INSERT INTO `parking_boy_vs_parking_lot` VALUES (unhex(replace(uuid(),'-','')), 'BOY001', 'LOT002');
INSERT INTO `parking_boy_vs_parking_lot` VALUES (unhex(replace(uuid(),'-','')), 'BOY002', 'LOT003');
INSERT INTO `parking_boy_vs_parking_lot` VALUES (unhex(replace(uuid(),'-','')), 'BOY002', 'LOT004');

CREATE TABLE `parking_lot` (
   `id` char(36) NOT NULL,
   `capacity` int(10),
   PRIMARY KEY (`id`)
);

INSERT INTO `parking_lot` VALUES ('LOT001', 20);
INSERT INTO `parking_lot` VALUES ('LOT002', 40);
INSERT INTO `parking_lot` VALUES ('LOT003', 20);
INSERT INTO `parking_lot` VALUES ('LOT003', 20);

CREATE TABLE `parking_manager` (
    `id` char(36) NOT NULL,
    `name` nvarchar(100) NOT NULL,
    PRIMARY KEY (`id`)
);

INSERT INTO `parking_manager` VALUES ('MANAGER001', '诸葛大力');
INSERT INTO `parking_manager` VALUES ('MANAGER002', '胡一菲');

CREATE TABLE `parking_manager_vs_parking_boy` (
  `id` char(36) NOT NULL,
  `parking_manager_id` char(36) NOT NULL,
  `parking_boy_id` char(36) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY (`parking_manager_id`),
  UNIQUE KEY (`parking_boy_id`)
);

INSERT INTO `parking_manager_vs_parking_boy` VALUES (unhex(replace(uuid(),'-','')), 'MANAGER001', 'BOY001');
INSERT INTO `parking_manager_vs_parking_boy` VALUES (unhex(replace(uuid(),'-','')), 'MANAGER002', 'BOY002');

CREATE TABLE `license_plate` (
     `number` nvarchar(100),
     `parking_lot_id` char(36),
     PRIMARY KEY (`number`)
);