package stack;

import java.util.Scanner;

/**
 * @Description 使用数组模拟实现栈
 * @Author eric
 * @Version V1.0.0
 * @Date 2019/6/20
 */
public class ArrayStackDemo {

    public static void main(String[] args) {


        ArrayStack stack = new ArrayStack(4);
        String key = "";
        //控制是否退出菜单
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        while (loop) {
            System.out.println("show:显示栈");
            System.out.println("exit:退出程序");
            System.out.println("push:添加数据到栈");
            System.out.println("pop:从栈中取出数据");
            System.out.println("请输入你的选择：");
            key = scanner.next();
            switch (key) {
                case "show":
                    stack.list();
                    break;
                case "push":
                    System.out.println("请输入一个数：");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    try {
                        int val = stack.pop();
                        System.out.println("出栈的数据是：" + val);

                    } catch (Exception e) {
                        System.out.println(e.getMessage());

                    }
                    break;
                case "exit":
                    scanner.close();
                    loop=false;


                    break;

                default:
                    break;
            }
        }
        System.out.println("程序退出");


    }


}
