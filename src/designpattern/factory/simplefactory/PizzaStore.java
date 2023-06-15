package designpattern.factory.simplefactory;

/**
 * @author flowerwine
 * @version 1.1
 * @projectName Algorithm
 * @description
 */
public class PizzaStore {
    public static void main(String[] args) {
        String type = "china";
        new OrderPizza().order(type);
    }
}
