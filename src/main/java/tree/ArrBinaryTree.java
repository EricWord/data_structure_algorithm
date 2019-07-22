package tree;

/**
 * @Description
 * @Author eric
 * @Version V1.0.0
 * @Date 2019/7/22
 */
public class ArrBinaryTree {
    //存储数据的数组
    private int[] arr;

    public ArrBinaryTree() {
    }

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }


    /**
     * 顺序存储二叉树
     *
     * @param index 数组的下标
     */
    public void preOrder(int index) {

        //数组为空后者索引
        if (null == arr || arr.length == 0) {
            System.out.println("数组为空，不能按照二叉树前序遍历");

        }
        //输出当前这个元素
        System.out.println(arr[index]);
        //向左递归遍历
        //防止越界，这里先判断一下
        if (index * 2 + 1 < arr.length) {
            preOrder(index * 2 + 1);

        }

        //向右递归遍历
        if (2 * index + 2 < arr.length) {
            preOrder(2 * index + 2);

        }

    }
}
