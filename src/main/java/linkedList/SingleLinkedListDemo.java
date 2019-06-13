package linkedList;

/**
 * @Description 单链表
 * @Author eric
 * @Version V1.0.0
 * @Date 2019/6/13
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {

        HeroNode node1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode node2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode node3 = new HeroNode(3, "吴用", "智多星");
        HeroNode node4 = new HeroNode(4, "林冲", "豹子头");


        //创建链表
        SingleLikedList singleLikedList = new SingleLikedList();
        //加入
        singleLikedList.add(node1);
        singleLikedList.add(node2);
        singleLikedList.add(node3);
        singleLikedList.add(node4);

        //显示单链表
        singleLikedList.list();

    }


}


//定义HeroNode,每个对象就是一个节点
class HeroNode {
    public int no;
    public String name;
    public String nickName;
    //指向下一个节点
    public HeroNode next;


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
                ", next=" + next +
                '}';
    }
}


//定义SingleLinkedList管理英雄
class SingleLikedList {
    //先初始化一个头节点，头节点不要动，不存放具体的数据
    private HeroNode head = new HeroNode(0, "", "");


    /**
     * 添加节点到单向链表
     *
     * @param node 要添加的节点
     */
    public void add(HeroNode node) {
        /**
         * 思路：当不考虑节点编号顺序时
         * 1.找到当前链表的最后节点
         * 2.将最后这个节点的next指向新的节点
         */

        //因为头结点不能动，所以需要一个辅助节点
        HeroNode temp = head;

        //遍历链表，找打最后
        while (true) {
            //找到链表的最后
            if (temp.next == null) {
                break;
            }
            //如果没有找到最后
            //当前指针向后移动
            temp = temp.next;

        }
        //循环结束时就到了链表的尾部
        temp.next = node;


    }


    //显示链表
    public void list() {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空！");
            //结束当前操作
            return;

        }

        HeroNode temp = head.next;
        while (true) {
            //判断是否到达链表最后
            if (temp == null) {
                break;
            }
            //输出节点信息
            System.out.println(temp);
            //当前指针后移
            temp = temp.next;

        }
    }


}
