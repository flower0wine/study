package designpattern.principle.singleresponsibility;

/**
 * @author flowerwine
 * @version 1.1
 * @projectName Algorithm
 * @description
 */
public class SingleResponsibility {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        vehicle.runAir("飞机");
        vehicle.runWater("轮船");
    }
}

class Vehicle {
    public void runAir(String vehicle) {
        System.out.println(vehicle + "在马路上跑");
    }
    public void runWater(String vehicle) {
        System.out.println(vehicle + "在水里游");
    }
}
