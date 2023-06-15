package designpattern.principle.openandclose;

/**
 * @author flowerwine
 * @version 1.1
 * @projectName Algorithm
 * @description
 */
public class OpenAndClose {

    public static void main(String[] args) {
        Say say = new Say();
        say.say(new A());
        say.say(new B());
    }
}
class Say {
    public void say(Base base) {
        if(base.type == 1) {
            System.out.println("A");
        } else if (base.type == 2) {
            System.out.println("B");
        }
    }
}
class Base {
    int type;
}
class A extends Base {
    public A() {
        super.type = 1;
    }
}
class B extends Base {
    public B() {
        super.type = 2;
    }
}
