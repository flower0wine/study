package Algorithms.ClassicAlgorithms;

/**
 * @Project_Name Algorithm
 * @Author 李志
 * @Version 1.0
 * @Start_Time 2022 10 24 13:05
 * <p>
 * 背包问题( 01 背包 )
 */
public class KnapsackProblem {
    // 商品重量及价格表
    private int[][] commodity;
    // 背包的容量对应的商品
    private int[][] knapsack;
    // 商品名称
    private String[] tradeName;
    // 商品价格相加路径
    private int[][] path;

    public KnapsackProblem(int[][] commodity, String[] tradeName, int knapsackCapacity) {
        this.commodity = commodity;
        this.tradeName = tradeName;
        this.knapsack = new int[commodity.length][knapsackCapacity];
        this.path = new int[commodity.length][knapsackCapacity];
    }

    // 计算该背包最大能装多少价值的东西
    public int maxMoney() {
        int a, b;
        for (int i = 0; i < knapsack.length; i++) {
            for (int j = 0; j < knapsack[i].length; j++) {
                // 如果背包容量大于等于当前物品的大小
                if(j + 1 >= commodity[i][0]) {
                    if(i - 1 >= 0) { // 这里的限制条件是为了确保下标不越界
                        // 当前背包大小对应的 j (实际 j + 1 为背包大小), 减去当前物品对应的容量大小并不放入当前物品得出相减后的背包对应的最大物品价格, 再加上该
                        // 当前物品的价格后的价格与当前背包大小对应的上一个价格相比, 较大者填入当前单元格
                        if(j - commodity[i][0] >= 0){
                            if((a = knapsack[i - 1][j]) > (b = knapsack[i - 1][j - commodity[i][0]] + commodity[i][1])) {
                                knapsack[i][j] = a;
                            } else {
                                knapsack[i][j] = b;
                                path[i][j] = 1;
                            }
                        } else {
                            knapsack[i][j] = knapsack[i - 1][j];
                        }
                    } else {
                        // 否则是第一行, 为初始数据, 直接赋值
                        knapsack[i][j] = commodity[i][1];
                        path[i][j] = 1;
                    }
                } else {
                    // 如果当前物品大小太大就赋给它上一个值
                    if(i - 1 >= 0) {
                        knapsack[i][j] = knapsack[i - 1][j];
                    }
                }
            }
        }
        int i = knapsack.length - 1;
        int j = knapsack[i].length - 1;
        while (i >= 0 && j >= 0) {
            if(path[i][j] == 1) {
                System.out.println(tradeName[i]);
                j -= commodity[i][0];
            }
            i--;
        }
        return knapsack[knapsack.length - 1][knapsack[knapsack.length - 1].length - 1];
    }

    public static void main(String[] args) {
        int[][] commodity = new int[6][2];
        commodity[0][0] = 8;
        commodity[1][0] = 3;
        commodity[2][0] = 4;
        commodity[3][0] = 2;
        commodity[4][0] = 1;
        commodity[5][0] = 6;
        commodity[0][1] = 600;
        commodity[1][1] = 500;
        commodity[2][1] = 50;
        commodity[3][1] = 1200;
        commodity[4][1] = 800;
        commodity[5][1] = 300;
        String[] tradeName = new String[6];
        tradeName[0] = "尿布湿";
        tradeName[1] = "暖宝宝";
        tradeName[2] = "电冰箱";
        tradeName[3] = "显卡";
        tradeName[4] = "七度空间";
        tradeName[5] = "小爱同学";
        KnapsackProblem knapsackProblem = new KnapsackProblem(commodity, tradeName, 10);
        System.out.println(knapsackProblem.maxMoney());
    }
}
