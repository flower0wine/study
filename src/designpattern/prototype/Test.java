package designpattern.prototype;

/**
 * @author flowerwine
 * @version 1.1
 * @projectName Algorithm
 * @description
 */

public class Test {
    public static void main(String[] args) throws Exception {
        Sheep sheep = new Sheep("肖恩", 14, new Student("小李"));
        Sheep sheep2 = (Sheep) sheep.deepObject();

        System.out.println(sheep.student == sheep2.student);
    }
}