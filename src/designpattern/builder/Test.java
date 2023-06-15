package designpattern.builder;

/**
 * @author flowerwine
 * @version 1.1
 * @projectName Algorithm
 * @description
 */
public class Test {

    public static void main(String[] args) {
        HouseDirector houseDirector = new HouseDirector(new BookBuilder());
        houseDirector.build();

    }
}
