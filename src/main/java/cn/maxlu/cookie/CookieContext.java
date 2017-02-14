package cn.maxlu.cookie;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by max.lu on 2016/2/24.
 */
public class CookieContext {

    private HttpServletResponse response;

    private Map<String, String> cookies = new HashMap<String, String>();

    public String getCookie(CookieSpec cookieSpec) {
        return cookies.get(cookieSpec.getName());
    }

    public void addCookie(CookieSpec cookieSpec, String value) {
        Cookie cookie = new Cookie(cookieSpec.getName(), value);
        cookie.setMaxAge(cookieSpec.getMaxAge());
        response.addCookie(cookie);
        cookies.put(cookieSpec.getName(), value);
    }

    public void deleteCookie(CookieSpec cookieSpec) {
        Cookie cookie = new Cookie(cookieSpec.getName(), null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        cookies.remove(cookieSpec.getName());
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }

    public Map<String, String> getCookies() {
        return cookies;
    }

    public void setCookies(Map<String, String> cookies) {
        this.cookies = cookies;
    }
}
