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
//        singleLikedList.add(node1);
//        singleLikedList.add(node2);
//        singleLikedList.add(node3);
//        singleLikedList.add(node4);


        //按照编号顺序加入
        singleLikedList.addByOrder(node1);
        singleLikedList.addByOrder(node4);
        singleLikedList.addByOrder(node2);
        singleLikedList.addByOrder(node3);

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


    /**
     * 按照英雄的编号添加
     *
     * @param node
     */
    public void addByOrder(HeroNode node) {
        HeroNode temp = head;
        //表示添加的编号是否存在
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                //指针已经到达链表最后
                break;

            }

            if (temp.next.no > node.no) {//位置找到，就在temp的后面插入
                //结束
                break;
            } else if (temp.next.no == node.no) {
                //希望添加的英雄的编号已经存在
                flag = true;
                break;

            }
            //指针后移
            temp = temp.next;
        }

        //遍历完毕后到底要不要添加英雄到链表中，要通过flag的值来判断
        if (flag) {
            //说明英雄编号已经存在
            System.out.println("英雄编号已经存在！");
        } else {
            //插入到链表中，temp的后面
            node.next = temp.next;
            temp.next = node;

        }


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
