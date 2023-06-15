package designpattern.decorator;

/**
 * @author flowerwine
 * @version 1.1
 * @projectName Algorithm
 * @description
 */
public class Milk extends Decorator {
    public Milk(Drink drink) {
        price = 1;
        description = "牛奶";
        super.drink = drink;
    }
}
