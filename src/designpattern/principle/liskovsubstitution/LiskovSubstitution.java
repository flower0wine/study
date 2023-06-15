package designpattern.principle.liskovsubstitution;

/**
 * @author flowerwine
 * @version 1.1
 * @projectName Algorithm
 * @description
 */
public class LiskovSubstitution {
    public static void main(String[] args) {

    }
}

class Base {
    void hello() {}
}

class A extends Base {
    @Override
    void hello() {
        System.out.println("你好啊");
    }
}
class B extends Base {
    @Override
    void hello() {
        System.out.println("hello");
    }
}


