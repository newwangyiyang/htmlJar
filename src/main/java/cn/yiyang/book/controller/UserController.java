package cn.yiyang.book.controller;

import cn.yiyang.book.vo.UserLoginForm;
import cn.yiyang.common.utils.IdGen;
import cn.yiyang.common.utils.JWTUtil;
import cn.yiyang.common.utils.ResultBean;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * @Auther: Administrator
 * @Date: 2019/1/6 15:01
 * @Description:
 */

@RestController
@Slf4j
@Validated
@RequestMapping(value = "/user")
public class UserController {


    /**
     * 手机号，密码进行登录, 获取token令牌
     * @return
     */
    @RequestMapping(value = "/loginUser", method = {RequestMethod.POST})
    public ResultBean loginUser(@Validated @RequestBody UserLoginForm userLoginForm) {
        //根据登录信息，从数据库获取用户信息

        String userId = IdGen.uuid();
        String userRole = "user,admin"; // 多个权限用逗号进行分隔
        String[] userRoles = userRole.split(",");
        String token = JWTUtil.createToken(userId, userRoles);
        return ResultBean.success(token);
    }

    @PostMapping("/getUserByToken")
    @RequiresRoles(logical = Logical.OR, value = {"user", "admin"})
    public ResultBean getUserByToken() {
        String token = (String) SecurityUtils.getSubject().getPrincipal(); //获取到header中传递的token
        String userId = JWTUtil.getUserId(token);
        //根据userId获取数据库中存储的基本数据，返回给前端

        String user_name = "王一扬管理员";
        String[] roleList = "user,admin".split(",");
        HashMap<String, Object> map = Maps.newHashMap();
        map.put("user_name", user_name);
        map.put("roleList", roleList);
        return ResultBean.success(map);
    }
}
