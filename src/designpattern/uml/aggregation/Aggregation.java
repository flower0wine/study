package designpattern.uml.aggregation;

/**
 * @author flowerwine
 * @version 1.1
 * @projectName Algorithm
 * @description
 */
public class Aggregation {
}

class Computer {
    Monitor monitor = new Monitor();
    Mouse mouse = new Mouse();
}
class Mouse {}
class Monitor {}
