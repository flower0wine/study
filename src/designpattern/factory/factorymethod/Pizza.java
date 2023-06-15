package designpattern.factory.factorymethod;

public abstract class Pizza {
    String name;
    abstract void prepare();
    void bake() {
        System.out.println(name + " 烘烤");
    }
    void cut() {
        System.out.println(name + " 切割");
    }
    void box() {
        System.out.println(name + " 打包");
    }
}
