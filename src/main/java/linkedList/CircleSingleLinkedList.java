package linkedList;

/**
 * @Description 环形单向链表
 * @Author eric
 * @Version V1.0.0
 * @Date 2019/6/20
 */
public class CircleSingleLinkedList {
    //创建first节点
    private Boy first = new Boy(-1);

    /**
     * 添加其他节点，构建成环形链表
     *
     * @param num 整个环形链表的节点总数
     */
    public void addBoys(int num) {
        //数据合法性校验
        if (num < 1) {
            System.out.println("num的值不正确");
            return;

        }
        Boy curBoy = null;

        //创建环形链表
        for (int i = 1; i <= num; i++) {
            //根据编号创建节点
            Boy boy = new Boy(i);
            //如果是第一个节点
            if (i == 1) {
                first = boy;
                //构成环
                first.setNext(first);
                //当前指针指向第一个节点
                curBoy = first;

            } else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }


        }

    }


    //遍历当前的环形链表
    public void showBoy() {

        //判断链表是否为空
        if (null == first) {
            System.out.println("链表为空！");
            return;

        }

        Boy curBoy = first;
        while (true) {
            System.out.printf("小孩的编号为%d \n", curBoy.getNo());
            //遍历完毕
            if (curBoy.getNext() == first) {
                break;
            }
            //指针后移
            curBoy = curBoy.getNext();

        }
    }

    /**
     * 根据用户输入计算出圈的顺序
     *
     * @param startNo  从第几个节点开始数
     * @param countNum 数几下
     * @param nums     最初的节点数量
     */
    public void countBoy(int startNo, int countNum, int nums) {
        //数据合法性校验
        if (null == first || startNo < 1 || startNo > nums) {
            System.out.println("参数输入有误，请重新输入！");
            return;

        }

        Boy helper = first;
        while (true) {
            //到达尾部
            if (helper.getNext() == first) {
                break;

            }
            helper = helper.getNext();
        }

        //当前指针移动到开始位置
        for (int i = 0; i < startNo - 1; i++) {
            first = first.getNext();
            helper = helper.getNext();

        }

        while (true){
            if(helper==first){
                //此时圈中只有一个节点
                break;

            }
            //如果不是上面的情况，则让first和helper同时移动countNum-1次
            for (int i = 0; i <countNum-1 ; i++) {
                first = first.getNext();
                helper = helper.getNext();


            }

            //这是first指向的节点就是要出圈的节点
            System.out.printf("小孩%d出圈\n",first.getNo());
            first=first.getNext();
            helper.setNext(first);


        }

        System.out.printf("最后留在圈中的节点编号：%d\n",first.getNo());


    }


}
