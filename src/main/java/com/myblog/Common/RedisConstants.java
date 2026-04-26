package com.myblog.Common;

public class RedisConstants {
    private RedisConstants(){}
    //黑名单
    public static final String BLACKLIST_KEY_PREFIX="jwt:blacklist:";

    //token
    public static final String USERTOKENLIST_ACCESS_PREFIX="user:token:access:";
    public static final String USERTOKENLIST_REFRESH_PREFIX="user:token:refresh:";

    //用户访问文章的记录（防止重复浏览）
    public static final String ARTICLE_VIEW_PREFIX="article:view:";

    //防重过期时间：两天(不是防重的一天过期，而是针对key的过期设计，仅为清理内存，与本身一天内防重无关)
    public static final Long ARTICLE_VIEW_KEY_EXPIRE_TTL=48*60*60L;
}
