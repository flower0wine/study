package designpattern.factory.simplefactory;

/**
 * @author flowerwine
 * @version 1.1
 * @projectName Algorithm
 * @description
 */
public class CheesePizza extends Pizza {
    public CheesePizza() {
        name = "奶酪";
    }

    @Override
    public void prepare() {
        System.out.println("准备奶酪");
    }
}
