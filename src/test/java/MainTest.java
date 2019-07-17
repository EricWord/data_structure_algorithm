import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

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

    @Test
    public void test2(){
        String s="CSInstanceEnd";
        if(s.startsWith("C")){
            System.out.println(s);

        }else{
            System.out.println("不是以C开头");
        }

    }

    @Test
    public void  test3(){
        String ss="1,2";
        System.out.println(ss.length());



    }

    @Test
    public void test4(){
        Map<Integer, String> map = new HashMap<>();
        map.put(1,"aaa");
        map.put(2,"bbb");
        map.put(3,"ccc");
        map.put(4,"ddd");
        map.put(5,"eee");
//        map.forEach((k,v)->{
//            System.out.println(v);
//            if (v.equals("ccc")){
//                System.out.println("即将停止");
//                return;
//
//            }
//
//        });

        for (String value : map.values()) {
            System.out.println(value);
            if(value.equals("ccc")){
                break;

            }
        }


    }

    @Test
    public void test5(){
        String date = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new java.util.Date(604781185 * 1000));
        System.out.println(date);
    }

    @Test
    public void test6(){
        int aa=604781185/1000;
        //天数
        int days=aa/(24*60*60);
        //小时
        int hour=aa%(24*60*60)/(60*60);
        System.out.println(days+"天，"+hour+"小时");

    }

}
