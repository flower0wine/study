package designpattern.principle.interfacesegregation;

/**
 * @author flowerwine
 * @version 1.1
 * @projectName Algorithm
 * @description
 */
public class InterfaceSegregation {
    public static void main(String[] args) {

    }
}

interface Interface1 {
    void method1();
    void method2();
}

interface Interface2 {
    void method3();
    void method4();
}

interface Interface3 {
    void method5();
}

class A implements Interface1, Interface3 {
    @Override
    public void method1() {
    }
    @Override
    public void method2() {
    }
    @Override
    public void method5() {
    }
}

class B implements Interface2, Interface3 {
    @Override
    public void method3() {
    }
    @Override
    public void method4() {
    }
    @Override
    public void method5() {
    }
}
