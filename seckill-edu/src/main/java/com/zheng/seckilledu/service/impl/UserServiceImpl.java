package com.zheng.seckilledu.service.impl;

import com.zheng.seckilledu.mapper.UserMapper;
import com.zheng.seckilledu.pojo.User;
import com.zheng.seckilledu.service.UserService;
import com.zheng.seckilledu.utils.MD5Util;
import com.zheng.seckilledu.utils.ValidatorUtil;
import com.zheng.seckilledu.vo.LoginVo;
import com.zheng.seckilledu.vo.RespBean;
import com.zheng.seckilledu.vo.RespBeanEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.validation.constraints.NotNull;

/**
 * @Author zheng
 * @Date 2023/2/20 11:05
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public RespBean login(LoginVo loginVo) {
        @NotNull(message = "手机号码不能为空") String mobile = loginVo.getMobile();
        @NotNull(message = "密码不能为空") String password = loginVo.getPassword();
        if(StringUtils.isEmpty(mobile)||StringUtils.isEmpty(password)){
            return RespBean.error(RespBeanEnum.LOGIN_ERROR);
        }
        if(!ValidatorUtil.isMobile(mobile)){
            return RespBean.error(RespBeanEnum.MOBILE_ERROR);
        }

        //根据手机号获取用户
        User user = userMapper.selectById(mobile);
        if(null==user){
            return RespBean.error(RespBeanEnum.LOGIN_ERROR);
        }

        //校验密码
        System.out.println(MD5Util.formPassToDBPass(password,user.getSalt()));
        System.out.println(user.getPassword());
        if(!MD5Util.formPassToDBPass(password,user.getSalt()).equals(user.getPassword())){
            return RespBean.error(RespBeanEnum.LOGIN_ERROR);
        }

        return RespBean.success();
    }
}
