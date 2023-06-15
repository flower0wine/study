package designpattern.factory.factorymethod;

import designpattern.factory.factorymethod.factory.PizzaFactory;

/**
 * @author flowerwine
 * @version 1.1
 * @projectName Algorithm
 * @description
 */
public class OrderPizza {
    PizzaFactory factory;
    public void order(String name) {
        Pizza pizza = factory.createPizza();
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
    }
}
