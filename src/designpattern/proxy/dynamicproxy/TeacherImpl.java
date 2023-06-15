package designpattern.proxy.dynamicproxy;

/**
 * @author flowerwine
 * @version 1.1
 * @projectName Algorithm
 * @description
 */
public class TeacherImpl implements Teacher {
    @Override
    public String teach(String name) {
        return "你输入了: " + name;
    }
}
