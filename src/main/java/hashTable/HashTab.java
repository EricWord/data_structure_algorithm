package hashTable;

import java.util.Scanner;

/**
 * @Description 哈希表，管理多条链表,所有对员工链表的添加、删除等操作都是通过该类实现
 * @Author eric
 * @Version V1.0.0
 * @Date 2019/7/19
 */
public class HashTab {

    public static void main(String[] args) {
        //创建HashTab
        HashTab hashTab = new HashTab(7);
        //菜单
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while (true) {

            System.out.println("add:添加雇员");
            System.out.println("list:显示雇员");
            System.out.println("find:查找雇员");
            System.out.println("exit:退出菜单");
            key = scanner.next();
            //判断用户输入
            switch (key) {
                case "add":
                    System.out.println("输入id:");
                    int id = scanner.nextInt();
                    System.out.println("输入名字：");
                    String name = scanner.next();
                    //创建雇员
                    Emp emp = new Emp(name, id);
                    hashTab.add(emp);


                    break;
                case "list":
                    hashTab.list();
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);

                    break;
                case "find":
                    System.out.println("请输入要查找的id:");
                    int findId = scanner.nextInt();
                    hashTab.findEmpById(findId);


                    break;
                default:
                    break;
            }

        }


    }


    //员工链表数组
    private EmpLinkedList[] empLinkedListArray;
    //链表数组的大小，表示共有多少条链表
    private int size;

    public HashTab() {

    }

    public HashTab(int size) {
        this.size = size;
        empLinkedListArray = new EmpLinkedList[size];
        //需要分别初始化每一条链表
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i] = new EmpLinkedList();

        }

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
            empLinkedListArray[i].list(i);

        }


    }


    //根据id查找雇员
    public void findEmpById(int id) {
        //使用散列函数确定到哪条链表查找
        //根据员工的id，得到该员工应当添加到哪条链表
        int empLinkedListNo = hashFunc(id);
        Emp empByID = empLinkedListArray[empLinkedListNo].findEmpByID(id);
        if (null != empByID) {
            //找到

            System.out.printf("在第%d条链表中找到雇员，id=%d\n", empLinkedListNo + 1, id);


        } else {
            //没有找到
            System.out.println("在哈希表中没有找到该雇员");
        }


    }


}
