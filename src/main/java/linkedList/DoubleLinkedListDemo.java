package linkedList;

/**
 * @Description 双向链表，双向链表与单链表相比可以实现自我删除
 * @Author eric
 * @Version V1.0.0
 * @Date 2019/6/20
 */
public class DoubleLinkedListDemo {

    public static void main(String[] args) {
        System.out.println("双向链表：");
        //创建节点
        HeroNode node1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode node2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode node3 = new HeroNode(3, "吴用", "智多星");
        HeroNode node4 = new HeroNode(4, "林冲", "豹子头");
        //创建双向链表
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(node1);
        doubleLinkedList.add(node2);
        doubleLinkedList.add(node3);
        doubleLinkedList.add(node4);
        //输出双向链表内容
        doubleLinkedList.list();

        //修改双向链表内容
        HeroNode newNode = new HeroNode(4, "公孙胜", "入云龙");
        doubleLinkedList.update(newNode);
        System.out.println("修改后的双向链表：");
        doubleLinkedList.list();

        //删除双向链表中的某个元素
        doubleLinkedList.del(3);
        System.out.println("删除某个元素后的双向链表：");
        doubleLinkedList.list();


    }


}

//双向链表数据结构类

class DoubleLinkedList {
    //先初始化一个头节点，头节点不要动，不存放具体的数据
    private HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

    //遍历双向链表的方法
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
        //循环结束时就到了链表的尾部，形成双向链表
        temp.next = node;
        node.pre = temp;


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
            temp.nickName = newNode.nickName;
        } else {
            System.out.printf("没有找到编号为%d的节点", newNode.no);

        }


    }


    /**
     * 删除双向链表中的某个元素
     * 对于双向链表可以直接找到要删除的元素，找到后自我删除即可
     *
     * @param no
     */
    public void del(int no) {

        //判断当前链表是否为空
        if (head.next == null) {
            System.out.println("链表为空，无法删除！");
            return;

        }
        HeroNode temp = head;
        //标识是否找到待删除的节点
        boolean flag = false;
        while (true) {
            //已经到链表的最后
            if (temp.next == null) {
                break;

            }
            //注意这个地方与单链表的删除也有不同，
            //单链表的删除是判断当前节点的next节点的no与目标节点no是否相同
            //而双向链表由于可以自我删除所以只需要判断当前节点的no是否与目标节点的no相同即可
            if (temp.no == no) {
                //找到的待删除节点的前一个节点temp
                flag = true;
                break;

            }
            //没找到继续遍历
            temp = temp.next;
        }

        //循环结束后根据flag来判断是否已经找到
        if (flag) {
            //单向链表的删除方式
//            temp.next = temp.next.next;
            temp.pre.next = temp.next;
            //如果是最后一个节点则不需要执行下面这行代码，否则会出现空指针问题
            if (temp.next != null) {

                temp.next.pre = temp.pre;

            }


        } else {
            System.out.println("要删除的节点不存在！");
        }


    }


}


