package cn.maxlu.aop;

public class ExtendsClass {
    public void beforeMethod() {
        System.out.println("aop before target method");
    }

    public void afterMethod() {
        System.out.println("aop after target method");
    }
}
