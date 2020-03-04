package com.shangguigu.bstest.component;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @author shkstart
 * @create 2020-01-07 17:46
 * 国际化
 *  可以在连接上携带区域信息
 *  在自动化配置类调用
 */
public class MyLocaleResolver implements LocaleResolver{
    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        String l = httpServletRequest.getParameter("l");
        Locale locale = Locale.getDefault();//创建一个区域，当连接没带就用默认的
        if (!StringUtils.isEmpty(l)){
            String[] split = l.split("_");
            //第一个参数是语言代码，第二个是国家代码
            locale = new Locale(split[0],split[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
