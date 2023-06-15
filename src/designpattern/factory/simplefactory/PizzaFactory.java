package designpattern.factory.simplefactory;

/**
 * @author flowerwine
 * @version 1.1
 * @projectName Algorithm
 * @description
 */
public class PizzaFactory {

    public static Pizza create(String type) {
        if("cheese".equals(type)) {
            return new CheesePizza();
        } else if("greek".equals(type)) {
            return new GreekPizza();
        } else if("china".equals(type)) {
            return new ChinaPizza();
        }
        return null;
    }
}
