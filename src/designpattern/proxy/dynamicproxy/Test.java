package designpattern.proxy.dynamicproxy;

import designpattern.proxy.staticproxy.TeacherProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author flowerwine
 * @version 1.1
 * @projectName Algorithm
 * @description
 */
public class Test {
    public static void main(String[] args) {
        Teacher teacher = new TeacherImpl();
        Teacher teacher1 = (Teacher) Proxy.newProxyInstance(
                teacher.getClass().getClassLoader(),
                teacher.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println(proxy.getClass().getName());
                        System.out.println(method.getName());
                        Object returnVal = method.invoke(teacher, args);
                        System.out.println("返回结果为: " + returnVal);
                        return returnVal;
                    }
                }
        );
        teacher1.teach("马宝国");
    }
}
