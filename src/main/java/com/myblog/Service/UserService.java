package com.myblog.Service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.myblog.Dto.UserRegisterDto;
import com.myblog.VO.UserLoginVO;
import com.myblog.VO.UserTokenVO;
import com.myblog.pojo.User;
import jakarta.servlet.http.HttpServletRequest;

public interface UserService extends IService<User>{

    //通过username获取整个user对象
    User getByUserName(String username);

    //用户登录
    UserLoginVO userLogin(User user, Boolean rememberMe);

    //用户注册
    void userRegister(UserRegisterDto userRegisterDto);

    //获得令牌刷新后的结果
    UserTokenVO getUserTokenVO(String refreshToken);

    //用户登出
    void userLogout(HttpServletRequest request);



}
