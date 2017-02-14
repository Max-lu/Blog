package cn.maxlu.controller;

import cn.maxlu.cookie.CookieConstants;
import cn.maxlu.cookie.CookieContext;
import cn.maxlu.annotation.LoginRequired;
import cn.maxlu.exception.BusinessException;
import cn.maxlu.request.LoginRequest;
import cn.maxlu.response.AjaxResponse;
import cn.maxlu.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;

@Controller
public class LoginController {

    @Inject
    private CookieContext cookieContext;
    @Inject
    private LoginService loginService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String goLoginPage() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(LoginRequest loginRequest, ModelMap map) {
        try {
            loginService.login(loginRequest);
            cookieContext.addCookie(CookieConstants.LOGIN, "Y");
            map.put("success", "登陆成功！");
            return "redirect:/my/home/1/10";
        } catch (BusinessException ex) {
            map.put("exception", "登录失败！");
            return "login";
        }
    }

    @LoginRequired
    @RequestMapping(value = "/loginOut", method = RequestMethod.GET)
    public String loginOut() {
        cookieContext.deleteCookie(CookieConstants.LOGIN);
        return "home_page";
    }
}
