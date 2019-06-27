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
     *
     * 冒泡排序的时间复杂度为o(n^2)
     */


    public static void main(String[] args) {
        int arr[] = {3, 9, 1, 10, -2};


        int temp = 0;//临时变量
        //第一趟排序就是将最大的数放在最后
     for(int i=0;i<arr.length-1;i++){
         for (int j = 0; j < arr.length - 1-i; j++) {
             //如果前面的数比后面的数大，则交换
             if (arr[j] > arr[j + 1]) {
                 temp = arr[j];
                 arr[j] = arr[j + 1];
                 arr[j + 1] = temp;
             }
         }


         System.out.println("第"+(i+1)+"趟排序后的数组：");
         System.out.println(Arrays.toString(arr));

     }
    }


}
