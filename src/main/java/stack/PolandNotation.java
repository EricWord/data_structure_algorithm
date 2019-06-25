package stack;

import sun.rmi.log.LogInputStream;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Description 逆波兰表达式实现逆波兰计算器
 * @Author eric
 * @Version V1.0.0
 * @Date 2019/6/24
 */
public class PolandNotation {


    public static void main(String[] args) {


        /*
        //定义逆波兰表达式
        String suffixExpression = "30 4 + 5 * 6 -";

        //思路：
        //1.先将逆波兰表达式放入ArrayList
        //2.将ArrayList传给一个方法，遍历ArrayList配合栈完成计算


        List<String> list = getList(suffixExpression);
        System.out.println(calc(list));

        */

        //将中缀表达式转为后缀表达式   1+((2+3)*4)+5
        //转成1 2 3 + 4 * + 5 -
        String expression = "1+((2+3)*4)+5";

        List<String> list = toInfixExpression(expression);
        System.out.println(list);


    }


    /**
     * 将逆波兰表达式中的数据和符号依次放入ArrayList中
     *
     * @param exp 逆波兰表达式字符串
     * @return
     */
    public static List<String> getList(String exp) {
        //将逆波兰表达式按照空格分割
        String[] split = exp.split(" ");
        List<String> list = new ArrayList<>();
        for (String s : split) {

            list.add(s);

        }


        return list;
    }


    //计算
    public static int calc(List<String> list) {
        //创建一个栈
        Stack<String> stack = new Stack<>();
        //遍历
        for (String s : list) {

            //如果是数则入栈
            if (s.matches("\\d+")) {//匹配多位数
                //入栈
                stack.push(s);

            } else {
                //是运算符
                //取出两个数进行运算
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                //最后的运算结果
                int res = 0;
                //如果运算符是加号
                if (s.equals("+")) {
                    res = num1 + num2;


                } else if (s.equals("-")) {
                    res = num1 - num2;


                } else if (s.equals("*")) {
                    res = num1 * num2;

                } else if (s.equals("/")) {
                    res = num1 / num2;
                } else {
                    throw new RuntimeException("运算符格式不正确！");
                }

                //将运算结果入栈
                stack.push(res + "");


            }

        }

        return Integer.parseInt(stack.pop());

    }


    //将中缀表达式转为List

    public static List<String> toInfixExpression(String s) {
        List<String> list = new ArrayList<>();

        int i = 0;
        //对多位数的拼接
        String str;
        //每遍历到一个字符放入c
        char c;
        do {
            //如果不是数字，言外之意是运算符
            //加入到list中
            if ((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57) {
                list.add("" + c);
                i++;

            } else {
                //如果是一个数需要考虑多位数的问题
                str = "";
                while (i < s.length() && (c = s.charAt(i)) >= 48 && (c = s.charAt(i)) <= 57) {
                    str += c;
                    i++;

                }
                list.add(str);
            }

        } while (i < s.length());

        return list;

    }



    //将中缀表达式转为后缀表达式
    public static  List<String> parseSuffixExression(List<String> ls){
        //符号栈
        Stack<String> stack1 = new Stack<>();
        //存放中间结果的栈
        Stack<String> stack2 = new Stack<>();



        return  null;

    }

}
