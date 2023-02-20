package com.zheng.seckilledu.service;

import com.zheng.seckilledu.vo.LoginVo;
import com.zheng.seckilledu.vo.RespBean;
import org.springframework.stereotype.Service;

/**
 * @Author zheng
 * @Date 2023/2/17 16:15
 */

public interface UserService {

    /**
     * 登陆方法
     */
    RespBean login(LoginVo loginVo);
}
