package com.myblog.Common;

public class RedisPrefixConstants {
    private RedisPrefixConstants(){}
    public static final String BLACKLIST_KEY_PREFIX="jwt:blacklist:";
    public static final String USERTOKENLIST_ACCESS_PREFIX="user:token:assess:";
    public static final String USERTOKENLIST_REFRESH_PREFIX="user:token:refresh:";
}
