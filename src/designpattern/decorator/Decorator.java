package designpattern.decorator;

/**
 * @author flowerwine
 * @version 1.1
 * @projectName Algorithm
 * @description
 */
public abstract class Decorator implements Drink {
    protected int price;
    protected String description;
    protected Drink drink;

    @Override
    public int cost() {
        return price + drink.cost();
    }
}
