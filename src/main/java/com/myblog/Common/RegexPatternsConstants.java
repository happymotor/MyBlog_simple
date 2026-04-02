package com.myblog.Common;

public abstract class RegexPatternsConstants {
    private RegexPatternsConstants(){}
    public static final String USERNAME_REGEX = "^\\w{3,20}$";
    public static final String PASSWORD_REGEX = "^.{6,32}$";
    public static final String NICKNAME_REGEX = "^.{1,20}$";
}
