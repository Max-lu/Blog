package cn.maxlu.interceptor;

import cn.maxlu.cookie.CookieContext;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class CookieInterceptor extends HandlerInterceptorAdapter {

    @Inject
    private CookieContext cookieContext;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Map<String, String> cookieMap = new HashMap<>();
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                cookieMap.put(cookie.getName(), cookie.getValue());
            }
        }
        cookieContext.setCookies(cookieMap);
        cookieContext.setResponse(response);
        return super.preHandle(request, response, handler);
    }
}
