package com.koreait.www.repository;

import java.util.List;

import com.koreait.www.domain.AuthVO;
import com.koreait.www.domain.UserVO;

public interface UserDAO {

	int insert(UserVO user);

	int insertAuth(String email);

	List<AuthVO> getAuthList(String username);
	
	UserVO getUser(String username);

	int updateLastLogin(String authEmail);


}
