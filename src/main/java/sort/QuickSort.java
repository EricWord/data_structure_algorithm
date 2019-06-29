package sort;

import java.util.Arrays;

/**
 * @Description 快速排序
 * @Author eric
 * @Version V1.0.0
 * @Date 2019/6/29
 */
public class QuickSort {
    /**
     * 快速排序的思路：
     * 通过一趟排序将要排序的数据分割成两个独立的部分，
     * 其中一部分的所有数据都比另外一部分的所有数据都要小
     * 然后再按照此方法对这两部分数据分别进行快速排序
     * 整个排序过程可以递归进行
     * 以此达到整个数据变为有序列
     */


    public static void main(String[] args) {

        int[] arr = {-9, 78, 0, 23, -567, 70};

        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));


    }


    /**
     * 快速排序
     *
     * @param arr   待排序数组
     * @param left  左索引
     * @param right 右索引
     */
    public static void sort(int[] arr, int left, int right) {


        int l = left;
        int r = right;
        //临时变量
        int temp = 0;
        //中间值
        int pivot = arr[(left + right) / 2];
        //将比中轴值小的放在左边
        while (l < r) {
            while (arr[l] < pivot) {
                l++;
            }

            while (arr[r] > pivot) {
                r--;
            }

            if (l >= r) {
                break;


            }
            //交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            if (arr[l] == pivot) {
                r--;

            }

            if (arr[r] == pivot) {
                l++;

            }
        }

        if (l == r) {
            l += 1;
            r -= 1;

        }

        //向左递归
        if (left < r) {
            sort(arr, left, r);

        }

        //向右递归
        if (right > l) {
            sort(arr, l, right);

        }

    }


}
