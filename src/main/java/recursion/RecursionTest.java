package recursion;

/**
 * @Description 递归测试
 * @Author eric
 * @Version V1.0.0
 * @Date 2019/6/25
 */
public class RecursionTest {

    public static void main(String[] args) {
//        test(5);

        int res = factorial(3);
        System.out.println(res);
    }

    public static void test(int n) {
        if (n > 2) {
            test(n - 1);


        }
        System.out.println("n=" + n);

    }

    //阶乘问题
    public static int factorial(int n) {
        if (n == 1) {
            return 1;

        } else {
            return factorial(n - 1) * n;
        }

    }
}
