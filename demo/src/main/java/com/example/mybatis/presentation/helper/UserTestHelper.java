package com.example.mybatis.presentation.helper;

import org.springframework.stereotype.Service;

import com.example.mybatis.logic.domain.UserModel;
import com.example.mybatis.presentation.form.UserTestForm;

/**
 * UserTestControllerのヘルパークラス.
 * FIXME このクラスをヘルパーとして使用してよいか。他に適切なコンポーネントがないか。
 */
@Service
public class UserTestHelper {
	
	/**
	 * コンストラクタ.
	 */
	public UserTestHelper(){
		
	}
	
	public UserModel createUserModel(UserTestForm form){
		
		UserModel model = new UserModel();
		model.setUserId(form.getUserId());
		model.setUserName(form.getUserName());
		model.setUserPassword(form.getUserPassword());
		
		return model;
	}
}
