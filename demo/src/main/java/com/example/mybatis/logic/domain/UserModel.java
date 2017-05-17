package com.example.mybatis.logic.domain;

/**
 * ユーザー情報
 */
public class UserModel {

	/** ユーザーID. */
	private String userId;
	
	/** ユーザー名. */
	private String userName;
	
	/** ユーザーパスワード. */
	private String userPassword;
	
	/** 保有有給休暇日数. */
	private String numberOdaysPaidVacation;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getNumberOdaysPaidVacation() {
		return numberOdaysPaidVacation;
	}

	public void setNumberOdaysPaidVacation(String numberOdaysPaidVacation) {
		this.numberOdaysPaidVacation = numberOdaysPaidVacation;
	}
	
}
