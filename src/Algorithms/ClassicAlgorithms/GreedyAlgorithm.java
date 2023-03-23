package Algorithms.ClassicAlgorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * @Project_Name Algorithm
 * @Author 李志
 * @Version 1.0
 * @Start_Time 2022 10 26 11:09
 * <p>
 * 贪心算法应用 (广播台覆盖选择)
 */
public class GreedyAlgorithm {
    private String[][] address;

    public GreedyAlgorithm(String[][] address) {
        this.address = address;
    }

    public void broadcast() {
        List<String> addressList = new ArrayList<>();
        for (int i = 0; i < address.length; i++) {
            for (int j = 0; j < address[i].length; j++) {
                if (!addressList.contains(address[i][j])) {
                    addressList.add(address[i][j]);
                }
            }
        }
        int maxIndex = 0, before = 0, after = 0;
        while (!addressList.isEmpty()) {
            for (int i = 0; i < address.length; i++) {
                for (int j = 0; j < address[i].length; j++) {
                    if (addressList.contains(address[i][j])) {
                        after++;
                    }
                }
                if (after > before) {
                    maxIndex = i;
                    before = after;
                }
                after = 0;
            }
            before = 0;
            for (int i = 0; i < address[maxIndex].length; i++) {
                addressList.remove(address[maxIndex][i]);
            }
            System.out.println(maxIndex);
        }
    }

    public static void main(String[] args) {
        String[][] address = new String[][]{{"北京", "上海", "天津"}, {"广州", "北京", "深圳"}, {"成都", "上海", "杭州"}, {"上海", "天津"}, {"杭州", "大连"}};
        GreedyAlgorithm greedyAlgorithm = new GreedyAlgorithm(address);
        greedyAlgorithm.broadcast();
    }
}
