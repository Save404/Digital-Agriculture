package com.config;

import com.domain.NhBasic;
import com.exception.GlobalException;
import com.result.CodeMsg;
import com.service.NhService;
import com.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public class NhArgumentResolver implements HandlerMethodArgumentResolver {

    @Autowired
    NhService nhService;

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        Class<?> clazz = methodParameter.getParameterType();
        return clazz == NhBasic.class;
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer,
                                  NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        HttpServletRequest request = nativeWebRequest.getNativeRequest(HttpServletRequest.class);
        HttpServletResponse response = nativeWebRequest.getNativeResponse(HttpServletResponse.class);
        String paramToken = request.getParameter(NhService.COOKI_NH_ID_TOKEN);
        String cookieToken = getCookieValue(request, NhService.COOKI_NH_ID_TOKEN);
        if(StringUtils.isEmpty(cookieToken) && StringUtils.isEmpty(paramToken)) {
            throw new GlobalException(CodeMsg.LOGIN_ERROR);
        }
        String token = StringUtils.isEmpty(paramToken)?cookieToken:paramToken;
        NhBasic nhBasic = nhService.getNhBasicByIdToken(response, token);
        if(null == nhBasic) {
            throw new GlobalException(CodeMsg.LOGIN_ERROR);
        }
        return nhBasic;
    }

    private String getCookieValue(HttpServletRequest request, String cookiNhIdToken) {
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie : cookies) {
            if(cookie.getName().equals(cookiNhIdToken)) {
                return cookie.getValue();
            }
        }
        return null;
    }
}
