package com.zheng.seckilledu.vo;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 * @Author zheng
 * @Date 2023/2/17 16:09
 */

@Data
@ToString
public class LoginVo {

    @NotNull(message = "手机号码不能为空")
    private String mobile;

    @NotNull(message = "密码不能为空")
    private String password;

}
