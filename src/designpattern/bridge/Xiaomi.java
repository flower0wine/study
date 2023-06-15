package designpattern.bridge;

/**
 * @author flowerwine
 * @version 1.1
 * @projectName Algorithm
 * @description
 */
public class Xiaomi extends AbstractPhone {
    private String name = "小米";

    public Xiaomi(PhoneStyle phoneStyle) {
        super(phoneStyle);
    }

    @Override
    public void open() {
        phoneStyle.printStyle();
        System.out.println(name + "开机");
    }

    @Override
    public void call() {
        phoneStyle.printStyle();
        System.out.println(name + "打电话");
    }

    @Override
    public void close() {
        phoneStyle.printStyle();
        System.out.println(name + "关机");
    }
}
