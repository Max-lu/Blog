package cn.maxlu.interceptor;

import cn.maxlu.annotation.LoginRequired;
import cn.maxlu.cookie.CookieConstants;
import cn.maxlu.cookie.CookieContext;
import cn.maxlu.dao.ArticleDao;
import cn.maxlu.entity.Article;
import cn.maxlu.response.ArticleResponse;
import cn.maxlu.util.DataConvert;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Inject
    private CookieContext cookieContext;

    @Inject
    private ArticleDao articleDao;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            LoginRequired loginRequired = findAnnotation((HandlerMethod) handler, LoginRequired.class);
            if (loginRequired != null && !loginIn()) {
                redirectToLoginPage(response);
                return false;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("post handle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        List<Article> articleList = articleDao.getArticleList(1, 10);
        List<ArticleResponse> articleResponseList = new ArrayList<>();
        for (Article article : articleList) {
            ArticleResponse articleResponse = new ArticleResponse();
            DataConvert.convert(articleResponse, article);
            articleResponseList.add(articleResponse);
        }
        request.setAttribute("newArticleList", articleResponseList);
    }

    private boolean loginIn() {
        String loggedIn = cookieContext.getCookie(CookieConstants.LOGIN);
//        return "Y".equalsIgnoreCase(loggedIn);
        return true;
    }

    private void redirectToLoginPage(HttpServletResponse response) throws IOException {
        response.sendRedirect("/login");
    }

    private <T extends Annotation> T findAnnotation(HandlerMethod handler, Class<T> annotationType) {
        T annotation = handler.getBeanType().getAnnotation(annotationType);
        if (annotation != null) return annotation;
        return handler.getMethodAnnotation(annotationType);
    }
}
