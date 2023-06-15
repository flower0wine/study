package cglibproxy;


/**
 * @author flowerwine
 * @version 1.1
 * @projectName Algorithm
 * @description
 */
public class Test {
    public static void main(String[] args) {
        Teacher teacher = (Teacher) new ProxyFactory(new Teacher()).getProxyInstance();
        teacher.teach();
    }
}
