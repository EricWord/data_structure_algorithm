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
