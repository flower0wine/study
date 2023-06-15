package designpattern.composite;

/**
 * @author flowerwine
 * @version 1.1
 * @projectName Algorithm
 * @description
 */
public class College extends Component {
    public College(String name) {
        super(name);
    }

    @Override
    protected void add(Component component) {
        list.add(component);
    }

    @Override
    protected void remove(Component component) {
        list.remove(component);
    }
}
