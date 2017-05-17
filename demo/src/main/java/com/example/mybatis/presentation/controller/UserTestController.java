package com.example.mybatis.presentation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.mybatis.logic.domain.UserModel;
import com.example.mybatis.logic.service.UserService;
import com.example.mybatis.presentation.form.UserTestForm;
import com.example.mybatis.presentation.helper.UserTestHelper;

/**
 * SpringBoot-MyBatis-Postgres.
 */
@Controller
public class UserTestController {
	
	/** ユーザーロジック. */
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserTestHelper helper;

	/** コンストラクタ. */
	public UserTestController(){
		
	}
	
	/**
	 * 初期表示.
	 * 
	 * @return response
	 */
	@RequestMapping("/mybatis/display")
	public String mybatisTestFirstDisplay(){
		
		return "mybatisTest";
	}
	
	/**
	 * ユーザー情報を1件登録
	 * 
	 * @param model ユーザー情報
	 * @return response
	 */
	@RequestMapping(name = "/mybatis/add" , method = {RequestMethod.POST})
	public String mybatisTestAdd(@ModelAttribute UserTestForm form){
		
		UserModel userModel = helper.createUserModel(form);
		
		userService.addUser(userModel);
		return "mybatisTestAddResult";
	}
	
	/**
	 * 全件取得し画面に表示する。
	 * 
	 * @param viewable ModelAndView
	 * @return ModelAndView
	 */
	@RequestMapping(name = "/mybatis/select", method = {RequestMethod.GET})
	public ModelAndView mybatisTestGetAll(ModelAndView viewable) {
		
		List<UserModel> userModelList = userService.findByUserId();
		viewable.addObject("userModelList",userModelList);
		viewable.setViewName("mybatisTestGetAll");
		return viewable;
	}
}
