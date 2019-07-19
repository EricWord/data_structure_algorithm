package hashTable;

/**
 * @Description 雇员实体类
 * @Author eric
 * @Version V1.0.0
 * @Date 2019/7/18
 */
public class Emp {

    private String name;
    private int id;
    private Emp next;

    public Emp(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Emp getNext() {
        return next;
    }

    public void setNext(Emp next) {
        this.next = next;
    }
}
