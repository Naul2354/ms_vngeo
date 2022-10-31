CREATE TABLE IF NOT EXISTS `province` (
    `matp` varchar(5) CHARACTER SET utf8 NOT NULL,
    `name` varchar(100) CHARACTER SET utf8 NOT NULL,
    `type` varchar(30) CHARACTER SET utf8 NOT NULL,
    `slug` varchar(30) DEFAULT NULL,
    PRIMARY KEY (`matp`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE IF NOT EXISTS `district` (
    `maqh` varchar(5) CHARACTER SET utf8 NOT NULL,
    `name` varchar(100) CHARACTER SET utf8 NOT NULL,
    `type` varchar(30) CHARACTER SET utf8 NOT NULL,
    `matp` varchar(5) CHARACTER SET utf8 NOT NULL,
    PRIMARY KEY (`maqh`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE IF NOT EXISTS `ward` (
    `xaid` varchar(5) CHARACTER SET utf8 NOT NULL,
    `name` varchar(100) CHARACTER SET utf8 NOT NULL,
    `type` varchar(30) CHARACTER SET utf8 NOT NULL,
    `maqh` varchar(5) CHARACTER SET utf8 NOT NULL,
    PRIMARY KEY (`xaid`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
