package com.unibro.ngsi.exception;

import lombok.Getter;

@Getter
public class GeneralException extends RuntimeException {

    public static final int NOTFOUND = 404;// Not found object
    public static final int ACCESS_DENY = 401;
    public static final int TOKEN_EXPIRED = 402;
    public static final int FORBIDEN = 403;
    public static final int EXIST_OBJECT = 204;
    public static final int EXIST_USERNAME = 200;
    public static final int EXIST_EMAIL = 201;
    public static final int EXIST_NICKNAME = 202;
    public static final int USER_LOGIN_INCORRECT_TYPE = 100;
    public static final int USER_USERNAME_PASSWORD_INCORRECT = 101;
    public static final int USER_LOGIN_FAIL_10_TIMES = 102;
    public static final int USER_DISABLED = 105;
    public static final int USER_NOT_SUPPORT_LOGIN = 103;
    public static final int USER_NOT_SUPPORT_PHONE_NUMBER = 104;
    public static final int USER_INVALID_TOKEN = 106;
    public static final int GENERAL = 500;// General error
    public static final int GENERAL_REJECT = 501;
    public static final int GENERAL_INVALID_DATA = 502;
    public static final int GENERAL_INVALID_FIELD = 503;
    public static final int GENERAL_IN_USE = 504;
    public static final int GENERAL_OPTIMISTIC_LOCK = 505;
    public static final int GENERAL_STORAGE_EXCEPTION = 506;
    public static final int GENERAL_INTERNAL_ERROR = 507;
    public static final int PRODUCT_IN_USE = 10000;
    public static final int PRODUCT_CODE_EXIST = 10001;
    public static final int TENANT_NOT_FOUND = 11000;
    private static final long serialVersionUID = 6236284227369736168L;

    public GeneralException(String message) {
        super(message);
    }

}
