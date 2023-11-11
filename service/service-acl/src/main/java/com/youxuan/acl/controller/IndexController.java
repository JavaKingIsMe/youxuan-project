package com.youxuan.acl.controller;

import com.youxuan.common.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * @author Lee
 * @version 1.0
 * <p>
 * 用户管理员： 登录 获取信息 退出
 */
@Api(tags = "登录功能接口")
@RestController
@RequestMapping("/admin/acl/index")
@CrossOrigin // 解决跨域问题
public class IndexController {

    //登录login
    @ApiOperation("登录")
    @PostMapping("/login")
    public Result login() {
        //返回token
        HashMap<String, String> map = new HashMap<>();
        map.put("token", "token-admin");
        return Result.ok(map);
    }

    //信息info
    @GetMapping("/info")
    public Result info() {
        HashMap<String, String> map = new HashMap<>();
        map.put("name", "admin");
        map.put("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        return Result.ok(map);
    }

    //退出logout
    @PostMapping("/logout")
    public Result logout() {
        return Result.ok(null);
    }

}
