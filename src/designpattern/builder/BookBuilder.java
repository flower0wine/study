package designpattern.builder;

/**
 * @author flowerwine
 * @version 1.1
 * @projectName Algorithm
 * @description
 */
public class BookBuilder extends Builder {
    @Override
    public void collect() {
        System.out.println("购买纸张");
    }
    @Override
    public void make() {
        System.out.println("制造书本");
    }
    @Override
    public void check() {
        System.out.println("检查其质量");
    }
    @Override
    public void sell() {
        System.out.println("卖书");
    }
}
