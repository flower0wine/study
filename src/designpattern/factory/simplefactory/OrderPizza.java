package designpattern.factory.simplefactory;

/**
 * @author flowerwine
 * @version 1.1
 * @projectName Algorithm
 * @description
 */
public class OrderPizza {

    public void order(String type) {
        Pizza pizza = PizzaFactory.create(type);
        if(pizza != null) {
            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.box();
        }
    }
}
