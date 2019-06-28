package sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @Description 插入排序
 * @Author eric
 * @Version V1.0.0
 * @Date 2019/6/27
 */
public class InsertSort {


    /**
     * 插入排序的思路：
     * 把n个待排序的元素看成一个有序表和一个无序表，开始时有序表只含有一个元素
     * 无序表中包含n-1个元素，排序过程中每次从无序表中取出一个元素
     * 将其值依次与有序表中的元素的值进行比较，
     * 将其插入到有序表中的适当位置，使之成为新的有序表
     * <p>
     * <p>
     * 插入排序的时间复杂度为 o()
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
        System.out.println("耗时：" + (end - start) + "毫秒");//522毫秒


    }

    public static void sort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            //定义待插入的数
            int insertVal = arr[i];
            //待插入数的索引

            int insertIndex = i - 1;
            //给insertVal找到插入的位置
            /**
             * insertIndex>=0 保证在给insertVal找插入位置时不越界
             * insertVal<arr[insertIndex] 表示待插入的数还没有找到要插入的位置
             * 就需要将arr[insertIndex]后移
             *
             *
             */
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                //后移
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;

            }
            //当退出while循环时说明插入的位置找到，inserVal + 1
            //判断是否需要赋值
            if (insertIndex + 1 != i) {
                arr[insertIndex + 1] = insertVal;
            }


        }


    }

}
