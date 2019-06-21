package stack;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.lang.reflect.Array;

/**
 * @Description 使用栈实现计算器
 * @Author eric
 * @Version V1.0.0
 * @Date 2019/6/21
 */
public class Calculator {

    public static void main(String[] args) {

        String expression = "7*2*2-5+1-5+3-4";
        //创建操作数栈和运算符栈
        ArrayStack numStack = new ArrayStack(10);
        ArrayStack opStack = new ArrayStack(10);
        int index = 0;//用于扫描
        int num1, num2;
        int op, res;
        //用于拼接多位数
        String keepNum = "";
        //将每次扫描得到的字符保存到ch中
        char ch = ' ';
        //循环扫描表达式
        while (true) {
            //依次得到表达式中的每一个字符
            ch = expression.substring(index, index + 1).charAt(0);
            //判断ch并做相应的处理
            //是操作符
            if (opStack.isOp(ch)) {
                //判断当前的符号栈是否为空
                //如果不为空
                if (!opStack.isEmpty()) {
                    //当前运算符的优先级小于或者等于栈中运算符的优先级
                    if (opStack.getPriority(ch) <= opStack.getPriority(opStack.peek())) {
                        //从操作数栈中出栈两个操作数
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        op = opStack.pop();
                        res = opStack.calc(num1, num2, op);
                        //将运算结果加入数栈
                        numStack.push(res);
                        //将当前操作符加入符号栈
                        opStack.push(ch);


                    } else {
                        //直接将当前符号加入符号栈
                        opStack.push(ch);


                    }


                    //当前运算符的优先级大于栈中运算符的优先级


                } else {
                    //操作符号栈是空
                    //直接将运算符加入栈中
                    opStack.push(ch);

                }


            } else {
                //如果是数直接入数栈
                //这个地方有可能是多位数
                //遍历到数字之后需要继续向后遍历一位数
                keepNum += ch;
                //如果ch已经是表达式的最后一位，就直接入栈
                if (index == expression.length() - 1) {
                    numStack.push(Integer.parseInt(keepNum));


                } else {
                    //判断下一个字符是否是数字
                    if (opStack.isOp(expression.substring(index + 1, index + 2).charAt(0))) {
                        //后一位是运算符，则入栈
                        numStack.push(Integer.parseInt(keepNum));
                        //清空keepNum
                        keepNum = "";


                    }
                    //如果是数字，继续扫描
                    //如果是运算符，则入栈

                }


            }

            //让index+1并判断是否扫描到表达式的末尾
            index++;
            if (index >= expression.length()) {
                break;

            }
        }

        //表达式扫描完毕后，数栈中只会剩余1个数，这个数就是运算结果
        while (true) {
            //如果运算符号栈为空，并且数栈中只有一个数，则这个数就是运算结果
            if (opStack.isEmpty()) {
                //结束
                break;

            }
            //否则就继续进行运算
            num1 = numStack.pop();
            num2 = numStack.pop();
            op = opStack.pop();
            res = opStack.calc(num1, num2, op);
            //将运算结果加入数栈
            numStack.push(res);

        }


        System.out.printf("%s=%d", expression, numStack.pop());

    }


}
