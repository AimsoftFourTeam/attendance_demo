package com.example.mybatis.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.mybatis.logic.domain.UserModel;
import com.example.mybatis.logic.dto.UserDto;
import com.example.mybatis.mapper.UserMapper;

/**
 * ユーザー情報リポジトリ.
 */
@Repository
public class UserRepository {

	/** ユーザー情報マッパー. */
	@Autowired
	private UserMapper mapper;
	
	/** コンストラクタ. */
	public UserRepository(){
		
	}
	
	/**
	 * ユーザーマスタより全件取得します。
	 * 
	 * @param userId ユーザーID
	 * @return UserModel ユーザーモデル
	 */
	public List<UserModel> findByUserId(){
		
		List<UserDto> dtos = new ArrayList<UserDto>();
		
		// 全件検索
		dtos = mapper.getAllUser();
		List<UserModel> resultModel = dtos.stream().map(dto -> this.copyDtoToModel(dto)).collect(Collectors.toList());
		
		return resultModel;
	}
	
	/**
	 * 引数のユーザーモデルの値をDBへ登録します。
	 * 
	 * @param inputModel ユーザーモデル
	 */
	public void add(UserModel inputModel){
			
		UserDto dto = new UserDto();
		BeanUtils.copyProperties(inputModel, dto);
		
		mapper.add(dto);
	}
	
	/**
	 * UserDtoをUserModelにコピーし返却します。
	 * 
	 * @param dto UserDto
	 * @return UserModel
	 */
	private UserModel copyDtoToModel(UserDto dto){
		
		UserModel model = new UserModel();
		BeanUtils.copyProperties(dto, model);
		return model;
	}
}
