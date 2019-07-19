package hashTable;

/**
 * @Description 员工链表
 * @Author eric
 * @Version V1.0.0
 * @Date 2019/7/18
 */
public class EmpLinkedList {

    //头指针，指向第一个雇员
    private Emp head;


    /**
     * 添加雇员,添加雇员时加在链表的末尾
     *
     * @param emp 要添加的员工对象
     */
    public void add(Emp emp) {
        //添加第一个雇员
        if (head == null) {
            head = emp;
            return;
        }
        //如果不是第一个雇员
        //辅助指针定位到最后
        Emp cur = head;
        while (true) {
            //到达最后
            if (cur.getNext() == null) {
                break;

            }
            //后移
            cur = cur.getNext();

        }
        //退出时直接将emp加入链表
        cur.setNext(emp);


    }

    //遍历员工信息
    public void list(int no) {
        //链表为空
        if (head == null) {
            System.out.println("第" + no + "条链表为空");
            return;

        }

        System.out.print("第" + no + "条链表的信息为：");
        //辅助指针
        Emp cur = head;
        while (true) {
            System.out.printf("=>id=%d name=%s\t", cur.getId(), cur.getName());
            //cur已经是最后一个
            if (cur.getNext() == null) {
                break;

            }

            cur = cur.getNext();
        }
        System.out.println();
    }


    /**
     * 根据id查找雇员
     *
     * @param id 员工id
     * @return
     */
    public Emp findEmpByID(int id) {
        //判断链表是否为空
        if (null == head) {
            System.out.println("链表空");
            return null;

        }

        //辅助指针
        Emp cur = head;
        while (true) {


            //找到
            if (cur.getId() == id) {
                break;


            }

            //退出的条件
            if (null == cur.getNext()) {
                //链表遍历完毕没有找到
                cur = null;

                break;
            }
            //后移
            cur = cur.getNext();

        }


        return cur;

    }
}
