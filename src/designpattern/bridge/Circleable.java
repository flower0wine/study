package designpattern.bridge;

public class Circleable implements PhoneStyle {
    @Override
    public void printStyle() {
        System.out.print("旋转式");
    }
}
