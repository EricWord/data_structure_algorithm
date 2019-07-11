package sort;

import java.util.Arrays;
import java.util.Map;
import java.util.Random;

/**
 * @Description 归并排序
 * @Author eric
 * @Version V1.0.0
 * @Date 2019/7/11
 */
public class MergeSort {


    public static void main(String[] args) {
//        int[] arr = {8, 4, 5, 7, 1, 3, 6, 2};

        int[] num = new int[80000];
        Random random = new Random();
        for (int i = 0; i < 80000; i++) {
            num[i] = random.nextInt(80000) + 1;

        }

        //归并排序所需要的额外空间

        int temp[] = new int[num.length];


        sort(num, 0, num.length - 1, temp);

        long start = System.currentTimeMillis();

        System.out.println("排序后的序列：" + Arrays.toString(num));
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start) + "毫秒");
    }


    /**
     * 分+合方法
     *
     * @param arr   待排序的数组
     * @param left  左边索引
     * @param right 右边索引
     * @param temp  临时数组
     */
    public static void sort(int[] arr, int left, int right, int[] temp) {

        if (left < right) {
            //中间索引
            int mid = (left + right) / 2;
            //向左递归进行分解
            sort(arr, left, mid, temp);
            //向右递归进行分解
            sort(arr, mid + 1, right, temp);
            //合并
            merge(arr, left, mid, right, temp);


        }


    }

    /**
     * 合并方法
     *
     * @param arr   排序的原始数组
     * @param left  左边有序的序列的初始索引
     * @param mid   中间索引
     * @param right 右边索引
     * @param temp  临时数组
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {

        //初始化左边索引
        int i = left;
        //初始化右边有序序列的所以你
        int j = mid + 1;
        //指向temp数组的当前索引
        int t = 0;


        //先将左右两边的有序数据按照规则填充到temp数组
        //直到左右两边的有序序列，有一边处理完毕为止

        while (i <= mid && j <= right) {
            //左边的有序序列的当前元素比右边的有序序列的当前元素小或者相等
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                t++;
                i++;
            } else {
                //将右边有序序列的元素填充到temp中
                temp[t] = arr[j];
                t++;
                j++;

            }

        }
        //把有剩余数据的一边的数据全部填充到temp数组中

        //左边的有序序列还有剩余的元素
        while (i <= mid) {
            temp[t] = arr[i];
            t++;
            i++;
        }

        //右边的有序序列还有剩余的元素
        while (j <= right) {
            temp[t] = arr[j];
            t++;
            j++;
        }


        //将temp数组中的元素拷贝到arr
        //并不是每次都拷贝所有
        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            t++;
            tempLeft++;
        }


    }
}
