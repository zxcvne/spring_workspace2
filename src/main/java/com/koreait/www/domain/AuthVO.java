package com.koreait.www.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AuthVO {
//	+-------+--------------+------+-----+---------+----------------+
//	| Field | Type         | Null | Key | Default | Extra          |
//	+-------+--------------+------+-----+---------+----------------+
//	| id    | bigint       | NO   | PRI | NULL    | auto_increment |
//	| email | varchar(256) | NO   |     | NULL    |                |
//	| auth  | varchar(256) | NO   |     | NULL    |                |
//	+-------+--------------+------+-----+---------+----------------+
	
	private String id;
	private String email;
	private String auth;
}
