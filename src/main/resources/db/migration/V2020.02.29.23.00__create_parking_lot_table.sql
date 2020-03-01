CREATE TABLE `parking_boy` (
    `parking_boy_id` char(36) NOT NULL,
    `name` nvarchar(100) NULL,
    PRIMARY KEY (`parking_boy_id`)
);

INSERT INTO `parking_boy` VALUES ('BOY001', '张伟');
INSERT INTO `parking_boy` VALUES ('BOY002', '曾小贤');

CREATE TABLE `parking_lot` (
    `parking_lot_id` char(36) NOT NULL,
    `parking_boy_id` char(36),
    `capacity` int(10),
    PRIMARY KEY (`parking_lot_id`)
);

INSERT INTO `parking_lot` VALUES ('LOT001', 'BOY001', 20);
INSERT INTO `parking_lot` VALUES ('LOT002', 'BOY001', 40);
INSERT INTO `parking_lot` VALUES ('LOT003', 'BOY002', 20);

CREATE TABLE `license_plate` (
    `number` nvarchar(100),
    `parking_lot_id` char(36),
    PRIMARY KEY (`number`)
);