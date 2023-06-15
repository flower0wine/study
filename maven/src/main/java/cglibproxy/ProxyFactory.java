package cglibproxy;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author flowerwine
 * @version 1.1
 * @projectName Algorithm
 * @description
 */
public class ProxyFactory implements MethodInterceptor {
    private Teacher teacher;

    public ProxyFactory(Teacher teacher) {
        this.teacher = teacher;
    }

    public Object getProxyInstance() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(teacher.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib 代理 -- start --");
        Object returnVal = method.invoke(teacher, args);
        System.out.println("cglib 代理 -- end --");
        return returnVal;
    }
}
