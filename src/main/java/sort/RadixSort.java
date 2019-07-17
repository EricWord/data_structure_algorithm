package sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @Description 基数排序
 * @Author eric
 * @Version V1.0.0
 * @Date 2019/7/11
 */
public class RadixSort {


    public static void main(String[] args) {
        //要排序的数组
//        int[] arr = {53, 3, 542, 748, 14, 214};
//        sort(arr);


        int[] num = new int[80000];
        Random random = new Random();
        for (int i = 0; i < 80000; i++) {
            num[i] = random.nextInt(80000) + 1;

        }


        long start = System.currentTimeMillis();
        sort(num);

        System.out.println("排序后的序列：" + Arrays.toString(num));
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start) + "毫秒");

    }

    /**
     * 基数排序的基本原理：
     */


    //基数排序方法
    public static void sort(int[] arr) {


        //得到数组中最大的位数
        int max = arr[0];//假设第一个数就是最大的
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];


            }

        }

        //最大数的位数
        int maxLength = (max + "").length();


        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            //对每个元素的对应位进行排序处理
            //定义一个二维数组，表示10个桶，每个桶就是一个一维数组

            //二维数组包含10个一维数组
            //为了防止在放入数的时候，数据溢出，，每一个数组的大小定为arr.length
            int[][] bucket = new int[10][arr.length];


            //为了记录每个桶中实际存放了多少数据，我们定义一个一维数组来记录各个桶每次放入的数据个数
            int[] buckElementCount = new int[10];


            //针对每个元素的各位进行排序处理
            for (int j = 0; j < arr.length; j++) {
                //取出每个元素的个位数
                int digitOfElement = arr[j] / n % 10;
                //放入到对应的桶中
                bucket[digitOfElement][buckElementCount[digitOfElement]] = arr[j];
                buckElementCount[digitOfElement]++;
            }

            //按照这个桶的顺序(一维数组的下标依次取出数据，放入原来的数组)
            int index = 0;
            //遍历每一个桶，并将桶中的数据放入每一个数组
            for (int k = 0; k < buckElementCount.length; k++) {


                //如果桶中有数据才放入原来的数组
                if (buckElementCount[k] != 0) {
                    //遍历第k个桶，即第k个一维数组
                    for (int l = 0; l < buckElementCount[k]; l++) {
                        //取出元素放入到arr中
                        arr[index++] = bucket[k][l];
                    }
                }
            }
            System.out.println("第"+(i+1)+"轮排序后的结果：" + Arrays.toString(arr));
        }
    }
}
