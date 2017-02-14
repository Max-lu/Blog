package cn.maxlu.service;

import cn.maxlu.dao.UserDao;
import cn.maxlu.exception.BusinessException;
import cn.maxlu.request.LoginRequest;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class LoginService {

    @Inject
    private UserDao userDao;

    public void login(LoginRequest loginRequest) {
        if (userDao.getUser(loginRequest.getUserName(), loginRequest.getPassword()) == null) {
            throw new BusinessException("用户名或密码错误...");
        }
    }

}
