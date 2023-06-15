package designpattern.principle.singleresponsibility;

/**
 * @author flowerwine
 * @version 1.1
 * @projectName Algorithm
 * @description
 */
public class SingleResponsibility2 {
    public static void main(String[] args) {
        new AirVehicle().run("飞机");
        new WaterVehicle().run("轮船");
    }
}

class AirVehicle {
    public void run(String vehicle) {
        System.out.println(vehicle + "在天上飞");
    }
}

class WaterVehicle {
    public void run(String vehicle) {
        System.out.println(vehicle + "在水里游");
    }
}
