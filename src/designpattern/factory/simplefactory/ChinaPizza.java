package designpattern.factory.simplefactory;

/**
 * @author flowerwine
 * @version 1.1
 * @projectName Algorithm
 * @description
 */
public class ChinaPizza extends Pizza {
    public ChinaPizza() {
        name = "中国";
    }

    @Override
    void prepare() {
        System.out.println("走近中国");
    }
}
