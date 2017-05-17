package com.example.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.mybatis.logic.dto.UserDto;

/**
 * ユーザー情報マッパー.
 */
@Mapper
public interface UserMapper {
		
	/** SELECT全件. */
	List<UserDto> getAllUser();

	/** INSERT. */
	void add(UserDto dto);
}
