package com.myblog.Common;

public class TokenTimeConstants {

    private TokenTimeConstants(){}

    //ACCESS_TOKEN过期时间 2小时
    public static final long ACCESS_TOKEN_EXPIRE=2*60*60*1000;
    //REFRESH_TOKEN过期时间 7天
    public static final long REFRESH_TOKEN_EXPIRE=7*24*60*60*1000;
    //REFRESH_TOKEN_LONG过期时间 20天,用于登录延长时间
    public static final long REFRESH_TOKEN_LONG_EXPIRE=20*24*60*60*1000;
}
