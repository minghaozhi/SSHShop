
/创建用户表
DROP TABLE IF EXISTS `user`;

CREATE TABLE `user`(
‘uid’ INT(11) NOT NULL AUTO_INCREMENT,
‘username’ VARCHAR(255) DEFAULT NULL,
‘password’ VARCHAR(255) DEFAULT NULL,
‘name’ VARCHAR(255) DEFAULT NULL,
‘email’ VARCHAR(255) DEFAULT NULL,
’sex‘ VARCHAR(255) DEFAULT NULL,
‘phone’ VARCHAR(255) DEFAULT NULL,
‘addr’ VARCHAR(255) DEFAULT NULL,
  `state` INT(11) DEFAULT NULL,
CODE VARCHAR(64),
PRIMARY KEY (‘uid’)
) ENGINE=INNODB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;