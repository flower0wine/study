package designpattern.builder;

/**
 * @author flowerwine
 * @version 1.1
 * @projectName Algorithm
 * @description
 */
public class HouseDirector {
    private Builder builder;

    public HouseDirector(Builder builder) {
        this.builder = builder;
    }

    public void build() {
        builder.collect();
        builder.make();
        builder.check();
        builder.sell();
    }
}
