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


    //前序遍历查找
    public HeroNode preOrderSearch(int no) {
        if (null != this.getRoot()) {
            return this.getRoot().preOrderSearch(no);

        } else {
            return null;
        }

    }

    /**
     * 中序遍历查找
     *
     * @param no 编号
     * @return
     */
    public HeroNode inOrderSearch(int no) {
        if (null != this.getRoot()) {
            return this.getRoot().inOrderSearch(no);

        } else {
            return null;
        }

    }


    /**
     * 后序遍历查找
     *
     * @param no 编号
     * @return
     */
    public HeroNode postOrderSearch(int no) {
        if (null != this.getRoot()) {
            return this.getRoot().postOrderSearch(no);

        } else {
            return null;
        }


    }

    /**
     * 删除结点
     *
     * @param no 要删除的结点编号
     */
    public void delNode(int no) {
        //根结点不为空
        if (null != this.getRoot()) {
            //根结点就是要删除的结点
            if (this.getRoot().getNo() == no) {
                this.setRoot(null);

            } else {


                //递归进行删除
                this.getRoot().delNode(no);
            }


        } else {

            System.out.println("空树不能删除！");
        }

    }

    public HeroNode getRoot() {
        return root;
    }

    public void setRoot(HeroNode root) {
        this.root = root;
    }
}
