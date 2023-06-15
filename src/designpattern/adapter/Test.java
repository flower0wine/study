package designpattern.adapter;

/**
 * @author flowerwine
 * @version 1.1
 * @projectName Algorithm
 * @description
 */
public class Test {
    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.charging(new V5Adapter(new V220v()));
    }
}
