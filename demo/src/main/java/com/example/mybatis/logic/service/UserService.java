package com.example.mybatis.logic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.mybatis.logic.domain.UserModel;
import com.example.mybatis.repository.UserRepository;

/**
 * ユーザーロジック.
 */
@Service
@Transactional
public class UserService {

	/** ユーザーリポジトリ. */
	@Autowired
	private UserRepository repository;
	
	/** コンストラクタ. */
	public UserService(){
		
	}
	
	/**
	 * DBアクセスし、1件ユーザーを登録します。
	 * 
	 * @param inputModel ユーザーモデル.
	 */
	@Transactional
	public void addUser(UserModel inputModel){
		
		repository.add(inputModel);
	}
	
	/**
	 * 引数のユーザーIDを元に全件ユーザーを取得します。
	 * 
	 * @param userId ユーザーID
	 * @return UserModel ユーザーモデル
	 */
	@Transactional
	public List<UserModel> findByUserId(){
		
		List<UserModel> resultModel = repository.findByUserId();
	
		return resultModel;
	}
}
