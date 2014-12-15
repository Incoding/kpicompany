CREATE TABLE `company_kpi` (
  `id` double NOT NULL AUTO_INCREMENT,
  `kpi` varchar(60) DEFAULT NULL,
  `name` varchar(192) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=93 DEFAULT CHARSET=utf8;
INSERT INTO company_kpi (name,kpi) values('李四','2.9');
INSERT INTO company_kpi (name,kpi) values('王五','3.0');
INSERT INTO company_kpi (name,kpi) values('赵二','3.2');


-- for test transaction
select @@autocommit; 
select @@tx_isolation;
 
set autocommit=0;
set tx_isolation='read-uncommitted';