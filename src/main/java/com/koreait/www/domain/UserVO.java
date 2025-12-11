package com.koreait.www.domain;

import java.util.List;

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
public class UserVO {
//	+------------+--------------+------+-----+-------------------+-------------------+
//	| Field      | Type         | Null | Key | Default           | Extra             |
//	+------------+--------------+------+-----+-------------------+-------------------+
//	| email      | varchar(256) | NO   | PRI | NULL              |                   |
//	| pwd        | varchar(256) | NO   |     | NULL              |                   |
//	| nick_name  | varchar(200) | YES  |     | NULL              |                   |
//	| reg_date   | datetime     | YES  |     | CURRENT_TIMESTAMP | DEFAULT_GENERATED |
//	| last_login | datetime     | YES  |     | CURRENT_TIMESTAMP | DEFAULT_GENERATED |
//	+------------+--------------+------+-----+-------------------+-------------------+
	
	private String email;
	private String pwd;
	private String nickName;
	private String regDate;
	private String lastLogin;
	private List<AuthVO> authList;
}
