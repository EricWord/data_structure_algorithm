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
    public void list() {
        //判断是否为空
        if (isEmpty()) {
            System.out.println("栈为空！");
            return;

        }

        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d", i, stack[i]);

        }


    }


    /**
     * 计算运算符的优先级
     *
     * @param op 运算符
     * @return
     */
    public int getPriority(int op) {
        if (op == '*' || op == '/') {
            return 1;


        }
        if (op == '+' || op == '-') {
            return 0;

        }
        //假定目前的计算器只有加减乘除
        return -1;

    }


    /**
     * 判断是否是运算符
     *
     * @param val 字符符号
     * @return
     */
    public boolean isOp(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }


    /**
     * 输入操作数和操作符后进行运算
     *
     * @param num1 操作数1
     * @param num2 操作数2
     * @param op   运算符
     * @return
     */
    public int calc(int num1, int num2, int op) {
        //计算结果
        int res = 0;
        switch (op) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;

    }


    //返回栈顶元素的值
    public int peek(){
        return  stack[top];
    }


}
