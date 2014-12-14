CREATE TABLE `company_kpi` (
  `id` double NOT NULL AUTO_INCREMENT,
  `kpi` varchar(60) DEFAULT NULL,
  `name` varchar(192) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=93 DEFAULT CHARSET=utf8;
INSERT INTO company_kpi (name,kpi) values('李四','2.9');
INSERT INTO company_kpi (name,kpi) values('王五','2.9');
INSERT INTO company_kpi (name,kpi) values('赵二','2.9');