package tree;

/**
 * @Description 以数组的方式来存储二叉树
 * @Author eric
 * @Version V1.0.0
 * @Date 2019/7/22
 */
public class ArrBinaryTreeDemo {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};


        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        arrBinaryTree.preOrder(0);

    }
}
