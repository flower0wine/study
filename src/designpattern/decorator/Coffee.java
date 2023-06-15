package designpattern.decorator;

/**
 * @author flowerwine
 * @version 1.1
 * @projectName Algorithm
 * @description
 */
public abstract class Coffee implements Drink {
    protected String description;
    protected int price;

    @Override
    public int cost() {
        return price;
    }
}
