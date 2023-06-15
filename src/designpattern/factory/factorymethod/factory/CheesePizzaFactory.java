package designpattern.factory.factorymethod.factory;

import designpattern.factory.factorymethod.CheesePizza;
import designpattern.factory.factorymethod.Pizza;

/**
 * @author flowerwine
 * @version 1.1
 * @projectName Algorithm
 * @description
 */
public class CheesePizzaFactory implements PizzaFactory {
    @Override
    public Pizza createPizza() {
        return new CheesePizza();
    }
}
