package designpattern.bridge;

/**
 * @author flowerwine
 * @version 1.1
 * @projectName Algorithm
 * @description
 */
public class Test {
    public static void main(String[] args) {
        Phone phone = new Vivo(new Wirelessable());

        phone.open();
        phone.call();
        phone.close();
    }
}
