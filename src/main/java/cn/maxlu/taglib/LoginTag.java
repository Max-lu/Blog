package cn.maxlu.taglib;

import cn.maxlu.cookie.CookieConstants;
import cn.maxlu.cookie.CookieContext;
import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.tags.RequestContextAwareTag;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * Created by lv on 2016/2/23.
 */
public class LoginTag extends RequestContextAwareTag {

    @Override
    protected int doStartTagInternal() throws Exception {
        ApplicationContext ctx = getRequestContext().getWebApplicationContext();
        CookieContext cookieContext = (CookieContext) ctx.getBean("cookieContext");
        if (Objects.equals(cookieContext.getCookies().get(CookieConstants.LOGIN.getName()), "Y")) {
            pageContext.getOut().print(getLoginedHtml());
            return SKIP_BODY;
        }
        pageContext.getOut().print(getNotLoginedHtml());
        return SKIP_BODY;
    }

    private String getLoginedHtml() {
        return "<span>Welcome, Max" + "<a href=\"" + pageContext.getRequest().getScheme() + "://" + pageContext.getRequest().getServerName() + ":" + pageContext.getRequest().getServerPort() + "/loginOut\">Login Out</a>";
    }

    private String getNotLoginedHtml() {
        return "<a href=\"" + pageContext.getRequest().getScheme() + "://" + pageContext.getRequest().getServerName() + ":" + pageContext.getRequest().getServerPort() + "/login\">Login in</a>";
    }
}
