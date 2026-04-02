package com.myblog.Common;

public class ResultCodeConstants {
    private ResultCodeConstants(){}
    // ==================== 通用成功状态码 ====================
    public static final int SUCCESS_CODE = 200;
    public static final String SUCCESS_MSG = "操作成功";

    // ==================== 通用系统错误码 (1000-1999) ====================
    public static final int PARAM_ERROR_CODE = 1001;
    public static final String PARAM_ERROR_MSG = "参数校验失败";

    public static final int SYSTEM_ERROR_CODE = 1002;
    public static final String SYSTEM_ERROR_MSG = "系统内部异常";

    public static final int RATE_LIMIT_ERROR_CODE = 1003;
    public static final String RATE_LIMIT_ERROR_MSG = "接口请求频率超限";

    public static final int METHOD_NOT_SUPPORTED_CODE = 1004;
    public static final String METHOD_NOT_SUPPORTED_MSG = "请求方法不支持";

    public static final int DATA_FORMAT_ERROR_CODE = 1005;
    public static final String DATA_FORMAT_ERROR_MSG = "请求数据格式错误";

    // ==================== 认证授权错误码 (2000-2999) ====================
    public static final int TOKEN_EMPTY_CODE = 2001;
    public static final String TOKEN_EMPTY_MSG = "令牌为空";

    public static final int TOKEN_EXPIRED_CODE = 2002;
    public static final String TOKEN_EXPIRED_MSG = "令牌已过期";

    public static final int TOKEN_SIGN_INVALID_CODE = 2003;
    public static final String TOKEN_SIGN_INVALID_MSG = "令牌签名无效";

    public static final int USER_NOT_LOGIN_CODE = 2004;
    public static final String USER_NOT_LOGIN_MSG = "用户未登录";

    public static final int NO_PERMISSION_CODE = 2005;
    public static final String NO_PERMISSION_MSG = "无接口访问权限";

    public static final int ACCOUNT_DISABLED_CODE = 2006;
    public static final String ACCOUNT_DISABLED_MSG = "账号已被禁用";

    public static final int USERNAME_PASSWORD_ERROR_CODE = 2007;
    public static final String USERNAME_PASSWORD_ERROR_MSG = "用户名或密码错误";

    // ==================== 用户管理模块错误码 (3000-3999) ====================
    public static final int USER_NOT_FOUND_CODE = 3001;
    public static final String USER_NOT_FOUND_MSG = "用户不存在";

    public static final int USERNAME_EXIST_CODE = 3002;
    public static final String USERNAME_EXIST_MSG = "用户名已存在";

    public static final int EMAIL_REGISTERED_CODE = 3003;
    public static final String EMAIL_REGISTERED_MSG = "邮箱已被注册";

    public static final int PASSWORD_INCONSISTENT_CODE = 3004;
    public static final String PASSWORD_INCONSISTENT_MSG = "两次输入密码不一致";

    public static final int OLD_PASSWORD_ERROR_CODE = 3005;
    public static final String OLD_PASSWORD_ERROR_MSG = "原密码错误";

    // ==================== 文章管理模块错误码 (4000-4999) ====================
    public static final int ARTICLE_NOT_FOUND_CODE = 4001;
    public static final String ARTICLE_NOT_FOUND_MSG = "文章不存在";

    public static final int ARTICLE_TITLE_EMPTY_CODE = 4002;
    public static final String ARTICLE_TITLE_EMPTY_MSG = "文章标题不能为空";

    public static final int ARTICLE_NO_PERMISSION_CODE = 4003;
    public static final String ARTICLE_NO_PERMISSION_MSG = "无文章操作权限";

    public static final int CATEGORY_NOT_EXIST_FOR_ARTICLE_CODE = 4004;
    public static final String CATEGORY_NOT_EXIST_FOR_ARTICLE_MSG = "文章所属栏目不存在";

    public static final int ARTICLE_STATUS_INVALID_CODE = 4005;
    public static final String ARTICLE_STATUS_INVALID_MSG = "文章状态不支持该操作";

    // ==================== 栏目管理模块错误码 (5000-5999) ====================
    public static final int CATEGORY_NOT_FOUND_CODE = 5001;
    public static final String CATEGORY_NOT_FOUND_MSG = "栏目不存在";

    public static final int CATEGORY_NAME_EXIST_CODE = 5002;
    public static final String CATEGORY_NAME_EXIST_MSG = "栏目名称已存在";

    public static final int CATEGORY_HAS_ARTICLE_CODE = 5003;
    public static final String CATEGORY_HAS_ARTICLE_MSG = "栏目下存在文章，禁止删除";

    public static final int CATEGORY_NAME_EMPTY_CODE = 5004;
    public static final String CATEGORY_NAME_EMPTY_MSG = "栏目名称不能为空";

    // ==================== 数据统计模块错误码 (6000-6999) ====================
    public static final int STAT_TIME_RANGE_INVALID_CODE = 6001;
    public static final String STAT_TIME_RANGE_INVALID_MSG = "统计时间范围不合法";

    public static final int STAT_DATA_NOT_EXIST_CODE = 6002;
    public static final String STAT_DATA_NOT_EXIST_MSG = "统计数据不存在";

}
