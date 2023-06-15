package designpattern.proxy.staticproxy;

/**
 * @author flowerwine
 * @version 1.1
 * @projectName Algorithm
 * @description
 */
public class Test {
    public static void main(String[] args) {
        new TeacherProxy(new TeacherImpl()).teach();
    }
}
