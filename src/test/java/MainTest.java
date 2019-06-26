import org.junit.Test;

/**
 * @Description
 * @Author eric
 * @Version V1.0.0
 * @Date 2019/6/26
 */
public class MainTest {


    @Test
    public void test() {

        String str = "你好[[2|2_2_3faoemfaemfa]]";
        String[] split2={""};
        String[] split = str.split("\\[\\[");
        split2[0]+="[["+split[1];
        System.out.println(split2[0]);
//        for (int i = 0; i < split.length; i++) {
////            System.out.println("split[" + i + "]=" + split[i]);
//
//        }


    }
}
