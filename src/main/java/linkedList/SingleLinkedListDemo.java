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
        System.out.println("修改前的链表：");
        singleLikedList.list();

        HeroNode newNode = new HeroNode(2, "卢俊义dvlha", "玉麒麟dsvj");
        singleLikedList.update(newNode);
        System.out.println("修改后的链表：");
        singleLikedList.list();

        singleLikedList.del(1);
        System.out.println("删除某个节点后的链表：");
        singleLikedList.list();


        //输出链表有有效节点的个数
        System.out.println(getLength(singleLikedList.getHead()));

    }


    /**
     * 获取单链表中有效节点的个数(如果是带头节点的单链表，要把头节点排除在外)
     *
     * @param head 链表的头节点
     * @return 有效节点个数
     */
    public static int getLength(HeroNode head) {

        //判断是否是空链表
        if (head.next == null) {
            return 0;

        }

        int length = 0;
        HeroNode cur = head.next;
        while (cur != null) {
            length++;
            //遍历
            cur = cur.next;


        }

        return length;

    }


    //查找单链表中的倒数第k个节点
    //编写一个方法接收head节点，同时接收一个Index
    //index表示倒数第index个节点
    //先把链表从头到尾遍历一遍，得到链表的总长度
    //得到链表的总长度后，从链表的第一个节点开始遍历，遍历到(length-index)个节点
    public static HeroNode findLastIndexNode(HeroNode head, int index) {
        //链表为空，直接返回Null
        if (head.next == null) {
            return null;

        }

        //第一次遍历得到链表的长度
        int size = getLength(head);
        //第二次遍历到(size-index)位置，就是倒数第K个节点的位置
        //校验index
        if (index <= 0 || index > size) {
            return null;

        }

        HeroNode cur = head.next;
        for (int i = 0; i < size - index; i++) {
            cur = cur.next;

        }


        return cur;

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
                '}';
    }
}


//定义SingleLinkedList管理英雄
class SingleLikedList {
    //先初始化一个头节点，头节点不要动，不存放具体的数据
    private HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

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


    /**
     * 修改节点的信息，根据编号来修改，即编号不能修改
     * 根据newNode的节点信息修改即可
     *
     * @param newNode
     */
    public void update(HeroNode newNode) {
        //判断是否为空
        if (head.next == null) {
            System.out.println("链表为空！");
            return;

        }
        //不为空，根据no来找到需要修改的节点

        HeroNode temp = head.next;
        //表示是否找到该节点
        boolean flag = false;//默认没有找到
        while (true) {
            if (temp == null) {
                //到达链表的结尾,链表遍历结束
                break;
            }

            if (temp.no == newNode.no) {
                //找到了要修改的节点
                flag = true;
                break;
            }

            //没找到继续找
            temp = temp.next;

        }

        //根据flag判断是否找到
        if (flag) {
            temp.name = newNode.name;
            temp.nickName = newNode.name;
        } else {
            System.out.printf("没有找到编号为%d的节点", newNode.no);

        }


    }


    //删除节点
    //思路：
    //1.找到要删除节点的前一个节点
    public void del(int no) {
        HeroNode temp = head;
        //标识是否找到待删除的节点
        boolean flag = false;
        while (true) {
            //已经到链表的最后
            if (temp.next == null) {
                break;

            }
            if (temp.next.no == no) {
                //找到的待删除节点的前一个节点temp
                flag = true;
                break;

            }
            //没找到继续遍历
            temp = temp.next;
        }

        //循环结束后根据flag来判断是否已经找到
        if (flag) {
            //已经找到，删除
            temp.next = temp.next.next;

        } else {
            System.out.println("要删除的节点不存在！");
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
            System.out.println(temp.toString());
            //当前指针后移
            temp = temp.next;

        }
    }


}
