package designpattern.adapter;

/**
 * @author flowerwine
 * @version 1.1
 * @projectName Algorithm
 * @description
 */
public class V5Adapter implements VAdapter {
    private V220v v220v;

    public V5Adapter(V220v v220v) {
        this.v220v = v220v;
    }

    @Override
    public int transform() {
        return v220v.getV() / 44;
    }
}
