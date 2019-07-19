package tree;

/**
 * @Description 二叉树
 * @Author eric
 * @Version V1.0.0
 * @Date 2019/7/19
 */
public class BinaryTree {

    private HeroNode root;



    /**
     * 前序遍历
     */
    public void preOrder() {
        if (null != this.getRoot()) {
            this.getRoot().preOrder();

        } else {
            System.out.println("当前二叉树为空，无法遍历");
        }
    }

    /**
     * 中序遍历
     */
    public void inOrder() {
        if (null != this.getRoot()) {
            this.getRoot().inOrder();

        } else {
            System.out.println("当前二叉树为空，无法进行遍历");

        }

    }

    /**
     * 后序遍历
     */
    public void postOrder() {
        if (null != this.getRoot()) {
            this.getRoot().postOrder();
        } else {
            System.out.println("当前二叉树为空，无法进行遍历！");
        }
    }

    public HeroNode getRoot() {
        return root;
    }

    public void setRoot(HeroNode root) {
        this.root = root;
    }
}
