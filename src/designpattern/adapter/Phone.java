package designpattern.adapter;

/**
 * @author flowerwine
 * @version 1.1
 * @projectName Algorithm
 * @description
 */
public class Phone {
    public void charging(VAdapter vAdapter) {
        System.out.println(vAdapter.transform() + " 伏电压");
    }
}
