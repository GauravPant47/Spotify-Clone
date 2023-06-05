create database securityTest;

use securityTest;

show tables;
select * from account_authority;
drop database files;

drop table files;

CREATE TABLE `audios` (
	`id` bigint auto_increment,
	`audio_data` longblob,
	`title` varchar(255),
	PRIMARY KEY (`id`)
);

CREATE TABLE `images` (
	`id` bigint auto_increment,
	`image_data` longblob,
	`title` varchar(255),
	PRIMARY KEY (`id`)
);