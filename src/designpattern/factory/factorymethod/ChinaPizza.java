package designpattern.factory.factorymethod;

public class ChinaPizza extends Pizza {
    public ChinaPizza() {
        name = "中国";
    }

    @Override
    void prepare() {
        System.out.println("走近中国");
    }
}