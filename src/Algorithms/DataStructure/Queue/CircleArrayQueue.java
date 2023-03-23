package Algorithms.DataStructure.Queue;

/**
 * @Project_Name Algorithm
 * @Author 李志
 * @Version 1.0
 * @Start_Time 2022 09 28 9:04
 * <p>
 * 数组实现队列
 */
public class CircleArrayQueue {

    // 数组队列
    // 约定：队列最大空间为 maxSize - 1
    private int maxSize;
    private int front;
    private int rear;
    private int[] queue;

    // 创建数组队列
    public void createQueue(int maxSize) {
        queue = new int[maxSize];
        this.maxSize = maxSize;
    }

    // 添加数据
    public void addData(int data) {
        if (!isFull()) {
            queue[rear] = data;
            rear = (rear + 1) % maxSize;
        } else {
            System.out.println("队列已满");
        }
    }

    // 删除数据
    public int popData() {
        if (isNull()) {
            System.out.println("队列为空");
            return -1;
        }
        int temp = queue[front];
        front = (front + 1) % maxSize;
        return temp;
    }

    // 判断队列是否为空
    public boolean isNull() {
        return rear == front;
    }

    // 判断队列是否满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    // 输出数组有效数据
    public void showArray() {
        if (!isNull()) {
            for (int i = front; i < front + size(); i++) {
                System.out.println(queue[i % maxSize]);
            }
        }
    }

    // 获取有效数的个数
    public int size() {
        return (rear - front + maxSize) % maxSize;
    }

    public static void main(String[] args) {
        CircleArrayQueue circleArrayQueue = new CircleArrayQueue();
        circleArrayQueue.createQueue(3);
        circleArrayQueue.addData(10);
        circleArrayQueue.addData(20);
        circleArrayQueue.popData();
        circleArrayQueue.showArray();
    }
}


