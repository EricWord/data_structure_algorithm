package search;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author eric
 * @Version V1.0.0
 * @Date 2019/7/17
 */
public class BinarySearch {

    /**
     * 用于线性查找的数据必须有序，如果没有顺序要排序
     * 二分查找的实现方式主要有两种，递归和非递归
     * 这里实现方式是递归实现的
     * 思路分析：
     * 1.确定数组中间下标，mid
     * 2.让需要查找的数和中间的值进行比较
     * 3.如果目标值比中间值小说明需要向左递归
     * 4.如果目标值大于中间值说明需要向右递归
     * 5.如果正好相等说明找到了
     * 什么时候结束递归：
     * 1.找到了或者是遍历完了整个数组但是仍旧没有找到(left>right了)
     */

    public static void main(String[] args) {

        int arr[] = {1, 8, 10, 89, 1000,1000,1000,1000,1000,1000,1000, 1234};
//        int i = bSearch(arr, 0, arr.length - 1, 1000);
//        System.out.println(i);
        List<Integer> integers = bSearchWithAll(arr, 0, arr.length - 1, 1000);
        for (Integer integer : integers) {
            System.out.println(integer);
        }


    }


    /**
     * 二分查找算法
     *
     * @param arr     所查的数组
     * @param left    数组起始元素下标
     * @param right   数组结尾元素下标
     * @param findVal 要找的值
     * @return 目标值在数组中的下标，返回-1表示没有找到
     */
    public static int bSearch(int[] arr, int left, int right, int findVal) {

        //遍历完所有数据都没有找到的情况
        if (left > right) {
            return -1;

        }
        //数组中间值的下标
        int mid = (left + right) / 2;
        //中间的值
        int midVal = arr[mid];

        //目标值比中间值大
        if (findVal > midVal) {
            //向右递归
            return bSearch(arr, mid + 1, right, findVal);

        }
        //目标值比中间值小
        if (findVal < midVal) {

            //向左递归
            return bSearch(arr, left, mid - 1, findVal);
        }


        //恰好找到
        if (findVal == midVal) {
            return mid;

        }


        return -1;

    }


    /**
     * 当要查找的数据中有多个相同的数据符合要求时，要把所有的符合要求的索引值都返回
     * 思路分析：
     * 1.找到Mid索引值后不直接返回
     * 2.向mid的左边扫描，将所有满足条件的索引加入List中
     * 3.向mid的右边扫描，将所有满足条件的索引加入到List中
     * 4.最后将List返回
     *
     * @param arr     在哪些数据里查找
     * @param left    最左边的索引
     * @param right   最右边的索引
     * @param findVal 要查找的目标值
     * @return 满足条件的下表索引的list
     */


    public static List<Integer> bSearchWithAll(int[] arr, int left, int right, int findVal) {

        //遍历完所有数据都没有找到的情况
        if (left > right) {
            return new ArrayList<>();

        }
        //数组中间值的下标
        int mid = (left + right) / 2;
        //中间的值
        int midVal = arr[mid];

        //目标值比中间值大
        if (findVal > midVal) {
            //向右递归
            return bSearchWithAll(arr, mid + 1, right, findVal);

        }
        //目标值比中间值小
        if (findVal < midVal) {

            //向左递归
            return bSearchWithAll(arr, left, mid - 1, findVal);
        }


        //恰好找到
        if (findVal == midVal) {

            //下表结果集合
            ArrayList<Integer> resIndexList = new ArrayList<>();
            int temp = mid - 1;
            while (true) {
                if (temp < 0 || arr[temp] != findVal) {
                    break;

                }
                //否则就将temp放入到List中
                resIndexList.add(temp);
                //左移
                temp -= 1;
            }
            //最后把中间的放进去
            resIndexList.add(mid);
            //向右边扫描
            temp = mid + 1;
            while (true) {
                if (temp > arr.length || arr[temp] != findVal) {
                    break;

                }
                //否则就将temp放入到List中
                resIndexList.add(temp);
                //左移
                temp += 1;


            }

            return resIndexList;


        }


        return new ArrayList<>();

    }

}
