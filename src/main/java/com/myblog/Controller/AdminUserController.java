package com.myblog.Controller;


import com.myblog.Common.Result;
import com.myblog.Dto.UserPageDto;
import com.myblog.Dto.UserStatusUpdateDto;
import com.myblog.Service.AdminUserService;
import com.myblog.VO.PageVO;
import com.myblog.VO.UserInfoVO;
import com.myblog.pojo.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/user")
public class AdminUserController {

    @Autowired
    private AdminUserService adminUserService;


    //用户分页列表查询接口
    @GetMapping("/list")
    public Result<PageVO<UserInfoVO>> userQueryPages(@Validated UserPageDto userPageDto){
        return Result.success(adminUserService.userQueryPages(userPageDto));
    }


    //TODO 目前逻辑错误，登出变成了自己登出，但应该是操作用户id的登出
    //用户状态修改接口
    @PatchMapping("/status/{userId}")
    public Result userStatusUpdate(@PathVariable Integer userId,
                                   @RequestBody @Validated UserStatusUpdateDto userStatusUpdateDto){
        User user = adminUserService.getByUserId(userId);
        if(user==null){
            return Result.fail("该userId不存在");
        }
        Byte status = userStatusUpdateDto.getStatus();
        if(status!=0&&status!=1){
            return Result.fail("status只能为0或者1");
        }
        if(status.equals(user.getStatus())){
            return Result.fail("修改状态不可以与用户当前状态一致");
        }

        user.setStatus(status);
        adminUserService.userStatusUpdate(user);
        return Result.success();
    }

}
