package ArrayQueue;

import java.util.Scanner;

/**
 * @Description
 * @Author eric
 * @Version V1.0.0
 * @Date 2019/6/11
 */
public class RingQueue {
    /*
    front的初始值为0
    rear的初始值为0
    队列满的条件：(rear+1) % maxSize=front
    队列为空的条件 rear=front
    队列中有效数据的个数：(rear+maxSize-front) % maxSize


     */

    /**
     * @param args
     */
    public static void main(String[] args) {
        //创建一个环形队列
        CircleArray queue = new CircleArray(4);//队列的最大有效数据就是4
        //接收用户输入
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        //输出一个菜单
        while (true) {
            System.out.println("S(show):显示队列");
            System.out.println("E(exit):退出程序");
            System.out.println("A(add):添加数据到队列");
            System.out.println("G(get):从队列中取出数据");
            System.out.println("H(head):查看队列头数据");
            //接收用户输入的一个字符
            key = scanner.next().charAt(0);
            //统一转为小写
            key = Character.toLowerCase(key);
            switch (key) {

                case 's':
                    queue.showQueue();
                    break;
                case 'e':
                    System.out.println("程序退出");
                    scanner.close();
                    loop = false;

                    break;
                case 'a':
                    //提示用户输入
                    System.out.println("请输入一个数字:");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = queue.getQueue();
                        System.out.println("取出的数据是：" + res);


                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 'h'://查看队列头数据
                    try {
                        int res = queue.headQueue();
                        System.out.println("队列头数据是：" + res);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    break;
                default:
                    break;
            }

        }

    }


}


class CircleArray {
    //数组最大容量
    private int maxSize;
    //队列头
    private int front;
    //队列尾
    private int rear;
    //用于存放数据，模拟队列
    private int[] arr;


    public CircleArray(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        //初始化工作,int类型的变量默认值就是0，所以可以不写
//        front=0;
//        rear=0;
    }


    /**
     * 判断队列是否已满
     *
     * @return
     */
    public boolean isFull() {

        return (rear + 1) % maxSize == front;
    }

    /**
     * 判断队列是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return rear == front;
    }


    /**
     * 添加数据到队列中
     *
     * @param n
     */
    public void addQueue(int n) {

        //判断队列是否已满
        if (isFull()) {
            System.out.println("队列已满，不能再添加元素！");
            return;

        }

        //直接将数据加入
        arr[rear] = n;
        //将rear后移，这里补必须考虑取模
        rear = (rear + 1) % maxSize;

    }

    /**
     * 获取队列中的数据
     *
     * @return
     */
    public int getQueue() {

        //判断队列是否为空
        if (isEmpty()) {
            System.out.println("队列为空，不能取出数据！");
            //抛出异常
            throw new RuntimeException("队列为空！");

        }
        //front是指向队列的第一个元素
        //先将front指向的变量保存到临时变量
        //front后移，考虑取模
        //将临时变量保存的值返回
        int val = arr[front];
        front = (front + 1) % maxSize;
        return val;

    }

    /**
     * 显示队列中的所有数据
     */
    public void showQueue() {
        //判断队列是否为空
        if (isEmpty()) {
            System.out.println("队列为空！");
            return;

        }
        //从front开始遍历
        for (int i = front; i < front + getSize(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i]);

        }


    }


    /**
     * 获取当前队列中有效数据的个数
     *
     * @return
     */
    public int getSize() {
        return (rear + maxSize - front) % maxSize;
    }


    /**
     * 显示头元素
     *
     * @return
     */
    public int headQueue() {

        //判断队列是否为空
        if (isEmpty()) {
            throw new RuntimeException("队列为空！");

        }
        return arr[front];
    }
}
