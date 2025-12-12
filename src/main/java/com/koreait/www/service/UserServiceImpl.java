package com.koreait.www.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.koreait.www.domain.UserVO;
import com.koreait.www.repository.UserDAO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Service
public class UserServiceImpl implements UserService{
	private final UserDAO udao;
	
	@Transactional
	@Override
	public int insert(UserVO user) {
		// user 객체와 / auth 객체 2개를 insert
		int isOk = udao.insert(user);
		if(isOk > 0) {
			isOk *= udao.insertAuth(user.getEmail());
		}
		return isOk;
	}
}
