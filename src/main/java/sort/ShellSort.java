package sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @Description 希尔排序
 * @Author eric
 * @Version V1.0.0
 * @Date 2019/6/28
 */
public class ShellSort {
    /**
     * 希尔排序的原理：
     * 把记录按照下标的一定增量分组，对每组使用直接插入排序算法进行排序，随着增量逐渐减少，
     * 每组包含的关键词逐渐增多，当增量减少为1时，所有元素都在一组中，算法结束
     */


    public static void main(String[] args) {

//        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
//
//        sort(arr);
//        System.out.println(Arrays.toString(arr));
        //创建一个含有80000个元素的数组来测试冒泡排序的性能
        int[] num = new int[80000];
        Random random = new Random();
        for (int i = 0; i < 80000; i++) {
            num[i] = random.nextInt(80000) + 1;

        }

        long start = System.currentTimeMillis();

        sort(num);
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start) + "毫秒");//5551毫秒


    }


    public static void sort(int[] arr) {


        int temp = 0;
        //每轮排序完成后步长会发生改变
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //希尔排序的第一轮
            //将10个数据分为5组
            for (int i = gap; i < arr.length; i++) {
                //遍历每组中所有元素,每组两个元素，步长为5
                for (int j = i - gap; j >= 0; j -= gap) {

                    //当前元素大于加上步长后的那个元素
                    //交换
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;

                    }
                }

            }
        }


    }
}
