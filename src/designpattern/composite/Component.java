package designpattern.composite;

import java.util.ArrayList;
import java.util.List;

public abstract class Component {
    protected String name;

    public Component(String name) {
        this.name = name;
    }

    protected List<Component> list = new ArrayList<>();

    protected void add(Component component) {
        throw new UnsupportedOperationException("不支持添加操作");
    }

    protected void remove(Component component) {
        throw new UnsupportedOperationException("不支持删除操作");
    }

    protected void print() {
        System.out.println("========" + name + "========");
        for(Component component : list) {
            component.print();
        }
    }
}
