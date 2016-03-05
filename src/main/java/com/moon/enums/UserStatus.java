package com.moon.enums;

public enum UserStatus {
	USER_EXISTS(0), USER_NOT_EXISTS(1), USER_REGISTER_ERROR_WITHOUT_NICKNAME(2), USER_REGISTER_ERROR_WITHOUT_PASS(
			3), USER_REGISTER_ERROR_WITHOUT_EMAIL(4),USER_LOGIN_ERROR(5),USER_REGISTER_ERROR(6),USER_REGISTER_SUCCESS(7),
	USER_LOGIN_ERROR_WITHOUT_NICKNAME(8),USER_LOGIN_ERROR_WITHOUT_PASS(9),USER_LOGOUT_ERROR_WITHOUT_NICKNAME(10),USER_LOGOUT_ERROR_WITHOUT_PASS(11);

	@SuppressWarnings("unused")
	private int status;

	private UserStatus(int status) {
		this.status = status;
	}

	public static int valueOf(UserStatus status) {
		switch (status) {
		case USER_EXISTS:
			return 0;
		case USER_NOT_EXISTS:
			return 1;
		case USER_REGISTER_ERROR_WITHOUT_NICKNAME:
			return 2;
		case USER_REGISTER_ERROR_WITHOUT_PASS:
			return 3;
		case USER_REGISTER_ERROR_WITHOUT_EMAIL:
			return 4;
		case USER_LOGIN_ERROR:
			return 5;
		case USER_REGISTER_ERROR:
			return 6;
		case USER_REGISTER_SUCCESS:
			return 7;
		case USER_LOGIN_ERROR_WITHOUT_NICKNAME:
			return 8;
		case USER_LOGIN_ERROR_WITHOUT_PASS:
			return 9;
		case USER_LOGOUT_ERROR_WITHOUT_NICKNAME:
			return 10;
		case USER_LOGOUT_ERROR_WITHOUT_PASS:
			return 11;
		default:
			return -1;
		}
	}
}
