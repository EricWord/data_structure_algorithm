package search;

import java.util.Arrays;

/**
 * @Description 斐波那契查找
 * @Author eric
 * @Version V1.0.0
 * @Date 2019/7/18
 */
public class FibonacciSearch {
    //斐波那契数列的最大size
    private static final int MAX_SIZE = 20;

    /**
     * 斐波那契查找算法思路分析：
     */


    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1234};

        System.out.println(search(arr, 10));


    }


    /**
     * 得到一个斐波那契数列
     *
     * @return
     */
    public static int[] fib() {
        int[] f = new int[MAX_SIZE];

        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < MAX_SIZE; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }


    /**
     * 斐波那契查找算法 非递归实现
     *
     * @param arr 在哪些数据里查找
     * @param key 要查找的目标数字
     * @return 满足条件的下标
     */
    public static int search(int[] arr, int key) {

        int low = 0;
        int high = arr.length - 1;
        //斐波那契分割数值的下标
        int k = 0;
        int mid = 0;
        //获取到斐波那契数列

        int[] f = fib();
        //获取斐波那契分割数值的下标
        while (high > f[k] - 1) {
            //没找到继续找
            k++;

        }
        //因为f[k]的长度可能大于arr的长度
        //因此需要构造一个新的数组
        int[] temp = Arrays.copyOf(arr, f[k]);
        //将后面多余的0用最大值来填充
        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = arr[high];
        }

        //查找目标数值
        while (low <= high) {
            mid = low + f[k - 1] - 1;
            if (key < temp[mid]) {
                //继续向数组的左边查找
                high = mid - 1;
                k--;
            } else if (key > temp[mid]) {
                //向数组的右边查找
                low = mid + 1;
                k -= 2;
            } else {
                //找到了
                if (mid < high) {
                    return mid;

                } else {
                    return high;
                }

            }

        }

        return -1;
    }
}
