package designpattern.proxy.staticproxy;

/**
 * @author flowerwine
 * @version 1.1
 * @projectName Algorithm
 * @description
 */
public class TeacherImpl implements Teacher {
    @Override
    public void teach() {
        System.out.println("教书");
    }
}
