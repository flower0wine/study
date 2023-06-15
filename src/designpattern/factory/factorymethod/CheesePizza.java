package designpattern.factory.factorymethod;

public class CheesePizza extends Pizza {
    public CheesePizza() {
        name = "奶酪";
    }

    @Override
    public void prepare() {
        System.out.println("准备奶酪");
    }
}