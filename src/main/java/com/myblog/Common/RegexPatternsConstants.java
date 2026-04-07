package com.myblog.Common;

public abstract class RegexPatternsConstants {
    private RegexPatternsConstants(){}
    //用户相关
    public static final String USERNAME_REGEX = "^\\w{3,20}$";
    public static final String PASSWORD_REGEX = "^.{6,32}$";
    public static final String NICKNAME_REGEX = "^.{1,20}$";

    //栏目相关
    public static final String CATEGORY_NAME_REGEX = "^.{1,30}$";


}
