package designpattern.singleton;

/**
 * @author flowerwine
 * @version 1.1
 * @projectName Algorithm
 * @description
 */
public class Singleton {
    public static void main(String[] args) {
        System.out.println(SingletonClass.INSTANCE);
    }
}

enum SingletonClass {
    INSTANCE;
}
