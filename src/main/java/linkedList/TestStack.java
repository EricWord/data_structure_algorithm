package linkedList;

import java.util.Stack;

/**
 * @Description 栈的使用
 * @Author eric
 * @Version V1.0.0
 * @Date 2019/6/19
 */
public class TestStack {


    public static void main(String[] args) {
        Stack<String> st = new Stack<String>();
        //入栈
        st.add("a");
        st.add("b");
        st.add("c");
        //出栈
        while (st.size()>0){
            System.out.println(st.pop());
        }


    }
}
