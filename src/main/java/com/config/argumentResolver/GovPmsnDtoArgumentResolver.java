package com.config.argumentResolver;

import com.common.commonUtils.StringUtils;
import com.dto.GovPmsnDto;
import com.exception.GlobalException;
import com.result.CodeMsg;
import com.service.GovService;
import com.service.imp.GovServiceImp;
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
public class GovPmsnDtoArgumentResolver implements HandlerMethodArgumentResolver {

    @Autowired
    GovService govService;

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        Class<?> clazz = methodParameter.getParameterType();
        return clazz == GovPmsnDto.class;
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer,
                                  NativeWebRequest nativeWebRequest,
                                  WebDataBinderFactory webDataBinderFactory) {
        HttpServletRequest request = nativeWebRequest.getNativeRequest(HttpServletRequest.class);
        HttpServletResponse response = nativeWebRequest.getNativeResponse(HttpServletResponse.class);
        String paramToken = request.getParameter(GovServiceImp.COOKI_GOV_ID_TOKEN);
        String cookieToken = getCookieValue(request, GovServiceImp.COOKI_GOV_ID_TOKEN);
        if(StringUtils.isEmpty(cookieToken) && StringUtils.isEmpty(paramToken)) {
            throw new GlobalException(CodeMsg.LOGIN_ERROR);
        }
        String token = StringUtils.isEmpty(paramToken)?cookieToken:paramToken;
        GovPmsnDto gov = govService.getGovPmsnByIdToken(response, token);
        if(null == gov) {
            throw new GlobalException(CodeMsg.LOGIN_ERROR);
        }
        return gov;
    }

    private String getCookieValue(HttpServletRequest request, String cookieGovIdToken) {
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie : cookies) {
            if(cookie.getName().equals(cookieGovIdToken)) {
                return cookie.getValue();
            }
        }
        return null;
    }
}
