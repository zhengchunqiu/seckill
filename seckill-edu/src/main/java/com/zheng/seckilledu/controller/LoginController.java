package com.zheng.seckilledu.controller;

import com.zheng.seckilledu.service.UserService;
import com.zheng.seckilledu.vo.LoginVo;
import com.zheng.seckilledu.vo.RespBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zheng
 * @Date 2023/2/17 14:18
 */

/**
 * @Controller类中的方法可以直接通过返回String跳转到jsp、ftl、html等模版页面。在方法上加@ResponseBody注解，也可以返回实体对象。
 * @RestController类中的所有方法只能返回String、Object、Json等实体对象，不能跳转到模版页面。
 */

@Controller
@RequestMapping("/login")
@Slf4j
public class LoginController {

    @Autowired
    private UserService userService;

    /**
     * 跳转登录页
     */
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }

    /**
     * 登陆
     */
    @RequestMapping("/doLogin")
    @ResponseBody
    public RespBean doLogin(LoginVo loginVo){
        log.info("{}",loginVo);
        return userService.login(loginVo);
    }
}
