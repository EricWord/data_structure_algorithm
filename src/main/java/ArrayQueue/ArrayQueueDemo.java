package ArrayQueue;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import java.util.Scanner;

/**
 * @Description
 * @Author eric
 * @Version V1.0.0
 * @Date 2019/6/10
 */
public class ArrayQueueDemo {

    public static void main(String[] args) {
        //创建一个队列
        ArrayQueue arrayQueue = new ArrayQueue(3);
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
                    arrayQueue.showQueue();
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
                    arrayQueue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = arrayQueue.getQueue();
                        System.out.println("取出的数据是：" + res);


                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 'h'://查看队列头数据
                    try {
                        int res = arrayQueue.headQueue();
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


//使用数组来模拟队列
class ArrayQueue {
    //数组最大容量
    private int maxSize;
    //队列头
    private int front;
    //队列尾
    private int rear;
    //用于存放数据，模拟队列
    private int[] arr;
    //队列的构造器

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        //指向队列头的前一个位置
        front = -1;
        //指向队列尾的具体数据，就是队列的最后一个数据
        rear = -1;

    }

    /**
     * 判断队列是否已满
     *
     * @return ture :已满
     */
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    /**
     * 判断队列是否为空
     *
     * @return true:队列为空
     */
    public boolean isEmpty() {
        return rear == front;
    }

    /**
     * 添加数据到队列
     *
     * @param n
     */
    public void addQueue(int n) {
        //判断队列是否满
        if (isFull()) {
            System.out.println("队列已满，不能再添加数据到队列");
            //结束添加
            return;

        }
        //让尾指针后移
        rear++;
        arr[rear] = n;

    }

    /**
     * 获取队列数据
     *
     * @return
     */
    public int getQueue() {
        //判断队列是否为空
        if (isEmpty()) {
            //通过抛出异常
            throw new RuntimeException("队列空，不能取数据！");

        }
        //头指针后移,因为头指针默认是指向最前面的一个元素的前一个
        front++;
        //返回头指针所指向的数据
        return arr[front];

    }

    /**
     * 显示队列数据
     */
    public void showQueue() {
        //判断队列是否为空
        if (isEmpty()) {
            System.out.println("队列为空，没有数据！");
            //直接结束
            return;

        }

        //遍历数组，输出队列中的所有数据
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);

        }

    }

    /**
     * 显示队列的头部，不是取出头数据
     *
     * @return
     */
    public int headQueue() {

        //判断队列是否为空
        if (isEmpty()) {
            System.out.println("队列为空，没有头数据！");
            throw new RuntimeException("没有头数据！");

        }
        return arr[front + 1];
    }

}