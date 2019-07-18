package search;

import java.util.Arrays;

/**
 * @Description 插值查找算法
 * @Author eric
 * @Version V1.0.0
 * @Date 2019/7/18
 */
public class InsertValueSearch {


    /**
     * 插值查找算法思路分析：
     */


    public static void main(String[] args) {
        int[] arr = new int[100];
        //遍历
        for (int i = 0; i < 100; i++) {
            arr[i] = i + 1;

        }

//        System.out.println(Arrays.toString(arr));

        int i = searchOne(arr, 0, arr.length - 1, 100);
        System.out.println(i);


    }


    /**
     * 插值查找算法，只找符合要求的第一个
     * 插值查找算法需要数据有序
     *
     * @param arr       在哪些数据中查找
     * @param left      最左边的索引
     * @param right     最右边的索引
     * @param findValue 要查找的值
     * @return 符合要求的数据在数组中的下标索引
     */
    public static int searchOne(int[] arr, int left, int right, int findValue) {
        //查找结束的条件
        //最左边的索引大于最右边的索引
        //要查找的目标值比最小值还小
        //要查找的目标值比最大值还大
        //后面的两个条件必须要有，否则得到的mid可能越界
        if (left > right || findValue < arr[0] || findValue > arr[arr.length - 1]) {
            return -1;

        }

        //求出mid
        //下面这个求mid的公式时插值查找算法的核心
        int mid = left + (right - left) * (findValue - arr[left]) / (arr[right] - arr[left]);
        int midValue = arr[mid];
        //要查找的值比中间的值要大
        if (findValue > midValue) {
            //向右查找
            return searchOne(arr, mid + 1, right, findValue);


        }
        if (findValue < midValue) {
            //向左边查找
            return searchOne(arr, left, mid - 1, findValue);

        }
        //刚好找到
        if (findValue == midValue) {
            return mid;


        }


        return 0;


    }
}
