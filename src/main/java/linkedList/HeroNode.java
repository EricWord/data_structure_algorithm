package linkedList;

/**
 * @Description
 * @Author eric
 * @Version V1.0.0
 * @Date 2019/6/20
 */
public class HeroNode {

    public int no;
    public String name;
    public String nickName;
    //指向下一个节点
    public HeroNode next;
    //指向前一个节点
    public HeroNode pre;


    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
