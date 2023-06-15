package designpattern.bridge;

/**
 * @author flowerwine
 * @version 1.1
 * @projectName Algorithm
 * @description
 */
public class Foldable implements PhoneStyle {

    @Override
    public void printStyle() {
        System.out.print("折叠式");
    }
}
