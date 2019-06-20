package stack;

import com.sun.org.apache.bcel.internal.generic.RETURN;

/**
 * @Description
 * @Author eric
 * @Version V1.0.0
 * @Date 2019/6/20
 */
public class ArrayStack {
    //栈的大小

    private int maxSize;
    //栈中数据存储
    private int[] stack;
    //栈顶

    private int top = -1;

    public ArrayStack(int maxSize) {

        this.maxSize = maxSize;
        //初始化数组
        stack = new int[maxSize];
    }

    //判断栈是否已满
    public boolean isFull() {
        return top == maxSize;
    }

    //判断栈空
    public boolean isEmpty() {
        return top == -1;
    }

    //入栈
    public void push(int value) {
        //先判断栈是否已满
        if (isFull()) {
            System.out.println("栈满，无法继续加入！");
            //结束操作
            return;

        }

        top++;
        stack[top] = value;

    }

    //出栈操作,将栈顶数据返回
    public int pop() {
        //先判断栈是否为空
        if (isEmpty()) {
            throw new RuntimeException("栈为空！");

        }
        //取得栈顶值
        int value = stack[top];
        top--;
        return value;

    }


    //显示栈的情况
    public void list(){
        //判断是否为空
        if(isEmpty()){
            System.out.println("栈为空！");
            return;

        }

        for (int i = top; i >=0; i--) {
            System.out.printf("stack[%d]=%d",i,stack[i]);

        }


    }


}
