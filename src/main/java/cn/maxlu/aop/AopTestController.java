package cn.maxlu.aop;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;

@Controller
public class AopTestController {
//    @Inject
//    private TargetClass targetClass;
//
//    @RequestMapping(value = "/aop", method = {RequestMethod.GET, RequestMethod.POST})
//    public String aopTest() {
//        targetClass.targetMethod();
//        return "home_page";
//    }
}
