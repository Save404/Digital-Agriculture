package com.config.argumentResolver;

import com.domain.MjBasic;
import com.exception.GlobalException;
import com.result.CodeMsg;
import com.service.imp.MjServiceImp;
import com.common.commonUtils.StringUtils;
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
public class MjArgumentResolver implements HandlerMethodArgumentResolver {

    @Autowired
    MjServiceImp mjService;

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        Class<?> clazz = methodParameter.getParameterType();
        return clazz == MjBasic.class;
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer,
                                  NativeWebRequest nativeWebRequest,
                                  WebDataBinderFactory webDataBinderFactory) {
        HttpServletRequest request = nativeWebRequest.getNativeRequest(HttpServletRequest.class);
        HttpServletResponse response = nativeWebRequest.getNativeResponse(HttpServletResponse.class);
        String paramToken = request.getParameter(MjServiceImp.COOKI_MJ_ID_TOKEN);
        String cookieToken = getCookieValue(request, MjServiceImp.COOKI_MJ_ID_TOKEN);
        if(StringUtils.isEmpty(cookieToken) && StringUtils.isEmpty(paramToken)) {
            throw new GlobalException(CodeMsg.LOGIN_ERROR);
        }
        String token = StringUtils.isEmpty(paramToken)?cookieToken:paramToken;
        MjBasic mjBasic = mjService.getMjBasicByIdToken(response, token);
        if(null == mjBasic) {
            throw new GlobalException(CodeMsg.LOGIN_ERROR);
        }
        return mjBasic;
    }

    private String getCookieValue(HttpServletRequest request, String cookiMjIdToken) {
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie : cookies) {
            if(cookie.getName().equals(cookiMjIdToken)) {
                return cookie.getValue();
            }
        }
        return null;
    }
}
