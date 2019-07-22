package tree;

/**
 * @Description
 * @Author eric
 * @Version V1.0.0
 * @Date 2019/7/19
 */
public class HeroNode {

    private int no;
    private String name;
    //左子树
    private HeroNode left;
    private HeroNode right;


    public HeroNode() {
    }

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }


    //前序遍历

    public void preOrder() {
        //先输出父结点
        System.out.println(this);
        //递归左子树
        if (null != this.getLeft()) {
            this.getLeft().preOrder();


        }

        //递归向右子树进行前序遍历
        if (null != this.getRight()) {
            this.getRight().preOrder();

        }
    }

    //中序遍历
    public void inOrder() {
        //递归向左子树进行中序遍历
        if (null != this.getLeft()) {
            this.getLeft().inOrder();

        }
        //输出当前结点
        System.out.println(this);
        //递归向右子树进行中序遍历
        if (null != this.getRight()) {
            this.getRight().inOrder();

        }

    }


    //后序遍历
    public void postOrder() {
        //左右根
        //向左子树进行后序遍历
        if (null != this.getLeft()) {
            this.getLeft().postOrder();

        }
        //向右递归进行后序遍历
        if (null != this.getRight()) {
            this.getRight().postOrder();

        }

        //输出根节点
        System.out.println(this);
    }

    /**
     * 前序遍历查找
     *
     * @param no 雇员编号
     * @return
     */
    public HeroNode preOrderSearch(int no) {
        System.out.println("进入前序遍历查找");
        //判断当前结点是否是要查找的结点
        if (this.getNo() == no) {
            return this;

        }

        HeroNode resNode = null;
        //左结点不为空
        if (null != this.getLeft()) {

            resNode = this.getLeft().preOrderSearch(no);

        }

        if (null != resNode) {
            //说明左子树找到
            return resNode;

        }

        //向右递归
        if (null != this.getRight()) {
            resNode = this.getRight().preOrderSearch(no);

        }


        return resNode;

    }


    //中序遍历查找
    public HeroNode inOrderSearch(int no) {
        //左根右
        HeroNode res = null;
        //判断当前结点的左子树是否为空
        if (null != this.getLeft()) {
            res = this.getLeft().inOrderSearch(no);
        }

        if (null != res) {
            return res;

        }
        if (this.getNo() == no) {
            return this;

        }

        //判断当前结点的右结点是否为空
        if (null != this.getRight()) {
            res = this.getRight().inOrderSearch(no);

        }


        return res;

    }


    //后序遍历查找
    public HeroNode postOrderSearch(int no) {
        //左右根
        HeroNode res = null;
        //判断当前结点的左子树是否为空
        if (null != this.getLeft()) {
            res = this.getLeft().postOrderSearch(no);


        }
        if (null != res) {
            return res;
        }
        //判断当前结点的右结点是否为空
        if (null != this.getRight()) {
            res = this.getRight().postOrderSearch(no);

        }

        if (null != res) {
            return res;
        }
        //判断当前结点是否与要查找的目标结点相同
        if (this.getNo() == no) {
            return this;

        }

        return res;

    }


    /**
     * 递归删除结点
     * 因为二叉树是单向的，所以是判断当前结点的子结点是否需要删除结点，而不能去判断当前这个结点是否需要删除结点
     * <p>
     * 1.如果删除的结点是叶子结点，则删除该结点
     * 2.如果删除的是非叶子结点，则删除该子树
     *
     * @param no 结点编号
     */
    public void delNode(int no) {
        //判断左子树是的根结点否是要删除的结点
        if (null != this.getLeft() && this.getLeft().getNo() == no) {
            this.setLeft(null);
            return;

        }


        //判断右子树的根结点是否是要删除的结点
        if (null != this.getLeft() && this.getRight().getNo() == no) {
            this.setRight(null);
            return;

        }

        //向左子树进行递归删除
        if (null != this.getLeft()) {
            this.getLeft().delNode(no);


        }
        //向右子树进行递归删除
        if (null != this.getRight()) {
            this.getRight().delNode(no );

        }


    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}
