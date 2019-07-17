package search;

/**
 * @Description 顺序查找
 * @Author eric
 * @Version V1.0.0
 * @Date 2019/7/17
 */
public class SeqSearch {


    public static void main(String[] args) {
        int arr[] = {1, 9, 11, -1, 34, 89};
        int res = search(arr, 11);
        if (res == -1) {
            System.out.println("没有找到！");

        } else {
            System.out.println("要查找的目标值得下标索引为:" + res);
        }

    }

    /**
     * 查找的方法
     * 线性查找就是遍历然后逐一比对，有相同的值时就返回
     *
     * @param arr   数据
     * @param value 要查找的目标值
     * @return 目标值在数组中的索引
     */
    public static int search(int[] arr, int value) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
