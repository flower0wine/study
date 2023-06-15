package designpattern.factory.simplefactory;

/**
 * @author flowerwine
 * @version 1.1
 * @projectName Algorithm
 * @description
 */
public class GreekPizza extends Pizza {
    public GreekPizza() {
        name = "希腊";
    }

    @Override
    public void prepare() {
        System.out.println("准备希腊");
    }
}
