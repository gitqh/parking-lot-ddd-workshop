CREATE TABLE `parking_boy` (
    `parking_boy_id` char(36) NOT NULL,
    `name` nvarchar(100) NULL,
    PRIMARY KEY (`parking_boy_id`)
);

INSERT INTO `parking_boy` VALUES ('001', '张伟');
INSERT INTO `parking_boy` VALUES ('002', '曾小贤');

CREATE TABLE `parking_lot` (
    `id` char(36) NOT NULL,
    `parking_boy_id` char(36),
    `capacity` int(10),
    PRIMARY KEY (`id`)
);

CREATE TABLE `license_plate` (
    `number` nvarchar(100),
    `parking_lot_id` char(36),
    PRIMARY KEY (`number`)
);