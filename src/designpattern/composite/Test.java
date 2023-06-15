package designpattern.composite;

/**
 * @author flowerwine
 * @version 1.1
 * @projectName Algorithm
 * @description
 */
public class Test {
    public static void main(String[] args) {
        Component university = new University("清华大学");

        Component college1 = new College("软件学院");
        Component college2 = new College("信息工程学院");

        university.add(college1);
        university.add(college2);

        university.print();
    }
}
