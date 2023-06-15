package designpattern.builder;

/**
 * @author flowerwine
 * @version 1.1
 * @projectName Algorithm
 * @description
 */
public class HouseBuilder extends Builder {
    private House house;

    @Override
    public void collect() {
        System.out.println("购买原材料");
    }

    @Override
    public void make() {
        System.out.println("建造房子");
    }

    @Override
    public void check() {
        System.out.println("房子收官");
    }

    @Override
    public void sell() {
        System.out.println("卖房");
    }
}
