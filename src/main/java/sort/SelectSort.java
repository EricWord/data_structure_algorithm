package sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @Description 选择排序
 * @Author eric
 * @Version V1.0.0
 * @Date 2019/6/27
 */
public class SelectSort {
    /**
     * 选择排序的原理：
     * 第一次从arr[0]~arr[n-1]中选取最小值与arr[0]交换，
     * 第二次从arr[1]~arr[n-1]中选取最小值，与arr[1]交换
     * ...
     * 第i次从arr[i-1]~arr[n-1]中选取最小值，与arr[i-1]交换
     * 第n-1次从arr[n-2]~arr[n-1]中选取最小值，与arr[n-2]交换
     * 总共通过n-1次，得到一个从小到大的有序序列
     * <p>
     * 选择排序的时间复杂度也是o(n^2)
     */

    public static void main(String[] args) {
        //创建一个含有80000个元素的数组来测试冒泡排序的性能
        int[] num = new int[80000];
        Random random = new Random();
        for (int i = 0; i < 80000; i++) {
            num[i] = random.nextInt(80000) + 1;

        }

        long start = System.currentTimeMillis();

        sort(num);
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start) + "毫秒");//1853毫秒


    }

    public static void sort(int[] arr) {
        //原始序列：101,34，119，1


        for (int i = 0; i < arr.length - 1; i++) {
            //最小的索引位置
            int minIndex = i;
            //最小的数
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    minIndex = j;


                }

            }

            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
//            System.out.println("第" + (i + 1) + "轮后：");
//            System.out.println(Arrays.toString(arr));


        }


    }
}
