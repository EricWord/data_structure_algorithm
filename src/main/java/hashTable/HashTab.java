package hashTable;

/**
 * @Description 哈希表，管理多条链表,所有对员工链表的添加、删除等操作都是通过该类实现
 * @Author eric
 * @Version V1.0.0
 * @Date 2019/7/19
 */
public class HashTab {


    //员工链表数组
    private EmpLinkedList[] empLinkedListArray;
    //链表数组的大小，表示共有多少条链表
    private int size;

    public HashTab() {

    }

    public HashTab(int size) {
        this.size = size;
        empLinkedListArray = new EmpLinkedList[size];

    }


    /**
     * 添加雇员
     *
     * @param emp 员工对象
     */
    public void add(Emp emp) {

        //根据员工的id，得到该员工应当添加到哪条链表
        int empLinkedListNo = hashFunc(emp.getId());
        //将emp添加到对应的链表中
        empLinkedListArray[empLinkedListNo].add(emp);


    }

    /**
     * 取模法散列函数
     *
     * @param id 员工id
     * @return 在员工链表中的下标位置
     */
    public int hashFunc(int id) {


        return id % size;

    }


    //遍历所有的链表
    public void list() {

        for (int i = 0; i < size; i++) {
            empLinkedListArray[i].list();

        }


    }
}
