package com.myblog.Controller;

import cn.hutool.core.bean.BeanUtil;
import com.myblog.Common.Result;
import com.myblog.Common.TokenTimeConstants;
import com.myblog.Dto.UserLoginDto;
import com.myblog.Utils.ThreadLocalUtil;
import com.myblog.VO.UserInfoVO;
import com.myblog.VO.UserLoginVO;
import com.myblog.Dto.UserRegisterDto;
import com.myblog.Service.UserService;
import com.myblog.Utils.JwtUtil;
import com.myblog.Utils.Md5Util;
import com.myblog.Common.RedisPrefixConstants;
import com.myblog.VO.UserTokenVO;
import com.myblog.pojo.User;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/api/auth")
public class UserController {

     @Autowired
     private UserService userService;

     @Resource
     private StringRedisTemplate stringRedisTemplate;

     //测试方法
    @GetMapping("/hello")
    public String sayHello(){
        System.out.println("hello,nihao");
        return "Hello...";
    }

     //用户登录接口
     @PostMapping("/login")
     public Result<UserLoginVO> userLogin(@RequestBody @Validated UserLoginDto userLoginDto){
          String username=userLoginDto.getUsername();
          String password=userLoginDto.getPassword();
          Boolean rememberMe=userLoginDto.getRememberMe();

          //获取用户
          User user=userService.getByUserName(username);
          //用户不存在
          if(user==null ){
               return Result.fail("用户名或者密码错误");
          }

         //校验是否被禁用或者被删除
         if(user.getStatus().equals((byte) 0)){
             return Result.fail("该用户已被禁用，无法登录");
         }

         if(user.getIsDeleted().equals(Boolean.TRUE)){
             return Result.fail("该用户已被删除，无法登录");
         }

          //校验密码不通过
          if(!Md5Util.getMD5String(password).equals(user.getPassword())){
              return Result.fail("用户名或者密码错误");
          }

         //校验密码通过
         UserLoginVO userLoginVO =userService.userLogin(user,rememberMe);

         return Result.success(userLoginVO);

     }



     //用户注册接口
     @PostMapping("/register")
     public Result userRegister(@RequestBody @Validated UserRegisterDto userRegisterDto){

        //检验是否用户名已存在
         if(userService.getByUserName(userRegisterDto.getUsername())!=null){
                return Result.fail("用户名已存在");
         }

         //检验两次密码输入是否相同
         if(!userRegisterDto.getPassword().equals(userRegisterDto.getConfirmPassword())){
             return Result.fail("两次密码输入不一致！");
         }

         //判断nickname是否为空，为空则设置为用户名
         if(!StringUtils.hasLength(userRegisterDto.getNickname())){
             userRegisterDto.setNickname(userRegisterDto.getUsername());
         }
         //调用userService层完成注册操作
         userService.userRegister(userRegisterDto);
         return Result.success();
     }


     //刷新accessToken令牌方法
     @PostMapping("/refresh")
     public Result<UserTokenVO> tokenRefresh(@RequestBody Map<String,Object> map){
        String refreshToken = map.get("refreshToken").toString();
        //检验不为空
        if(refreshToken==null){
            return Result.fail("refreshToken不能为空");
        }
         UserTokenVO userTokenVO=userService.getUserTokenVO(refreshToken);

        return Result.success(userTokenVO);
     }


      //用户登出接口
      @PostMapping("/logout")
      public Result userLogout(HttpServletRequest request){
        userService.userLogout(request);
        return Result.success();
     }



}