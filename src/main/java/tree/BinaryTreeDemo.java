package tree;

/**
 * @Description 二叉树
 * @Author eric
 * @Version V1.0.0
 * @Date 2019/7/19
 */
public class BinaryTreeDemo {


    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        //初始化结点信息，可以递归进行二叉树的创建，这里进行手动创建
        HeroNode root = new HeroNode(1, "张三");
        HeroNode node2 = new HeroNode(2, "李四");
        HeroNode node3 = new HeroNode(3, "王五");
        HeroNode node4 = new HeroNode(4, "赵柳");
        HeroNode node5 = new HeroNode(5, "陈七");
        binaryTree.setRoot(root);

        //初始化结点父子关系
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);

//        System.out.println("前序遍历");
//        binaryTree.preOrder();
//        System.out.println("后序遍历");
//        binaryTree.postOrder();
//        System.out.println("中序遍历");
//        binaryTree.inOrder();

        System.out.println("前序遍历查找：");
        HeroNode heroNode = binaryTree.preOrderSearch(25);
        if (null != heroNode) {
            System.out.printf("找到了，信息为No=%d,name=%s", heroNode.getNo(), heroNode.getName());

        } else {

            System.out.println("没有找到");
        }


    }


}
