package com.zheng.seckilledu.utils;

import org.springframework.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 手机号码验证类
 *
 * @Author zheng
 * @Date 2023/2/20 11:10
 */
public class ValidatorUtil {

    private static final Pattern mobile_pattern=Pattern.compile("[1]([3-9])[0-9]{9}$");

    public static boolean isMobile(String mobile){
        if(StringUtils.isEmpty(mobile)){
            return false;
        }
        Matcher matcher = mobile_pattern.matcher(mobile);
        return matcher.matches();
    }

    public static void main(String[] args) {
        String mobile="18725626654";
        boolean b = isMobile(mobile);
        System.out.println(b);
    }
}
