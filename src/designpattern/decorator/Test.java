package designpattern.decorator;

/**
 * @author flowerwine
 * @version 1.1
 * @projectName Algorithm
 * @description
 */
public class Test {
    public static void main(String[] args) {
        Drink order = new Decaf();
        System.out.println(order.cost());

        order = new Milk(order);
        System.out.println(order.cost());


        order = new Milk(order);
        System.out.println(order.cost());
    }
}
