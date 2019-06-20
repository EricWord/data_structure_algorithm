package linkedList;

/**
 * @Description 用于约瑟夫问题的Boy类
 * @Author eric
 * @Version V1.0.0
 * @Date 2019/6/20
 */
public class Boy {
    //编号
    private  int no;

    //指向下一个节点，默认是空
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }


    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
