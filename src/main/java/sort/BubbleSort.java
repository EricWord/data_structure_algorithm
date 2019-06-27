package sort;

import java.util.Arrays;

/**
 * @Description 冒泡排序
 * @Author eric
 * @Version V1.0.0
 * @Date 2019/6/26
 */
public class BubbleSort {
    /**
     * 冒泡排序的原理：
     * 通过对待排序序列从前向后(从下标较小的元素开始)，依次比较相邻元素的值，若发现逆序则交换，
     * 使值较大的元素从前移向后部
     * 如果一趟下来没有进行过交换，则说明序列有序
     * <p>
     * 冒泡排序的时间复杂度为o(n^2)
     */


    public static void main(String[] args) {
        int arr[] = {3, 9, 1, 10, 20};

        sort(arr);
        System.out.println("排序后：");
        System.out.println(Arrays.toString(arr));


    }


    //封装冒泡排序方法
    public static void sort(int[] arr) {
        //标识是否进行交换
        boolean flag = false;
        int temp = 0;//临时变量
        //第一趟排序就是将最大的数放在最后
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                //如果前面的数比后面的数大，则交换

                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }


            if (!flag) {
                //在一趟排序中一次交换都没有发生
                //结束
                break;

            } else {

                //重置flag，以便进行下次标记
                flag = false;
            }

        }


    }


}
