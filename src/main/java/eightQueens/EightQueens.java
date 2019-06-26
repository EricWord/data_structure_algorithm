package eightQueens;

/**
 * @Description 八皇后问题
 * @Author eric
 * @Version V1.0.0
 * @Date 2019/6/25
 */
public class EightQueens {
    //最多有8个皇后
    private int max = 8;
    //皇后放置位置
    private int[] arr = new int[max];
    private static  int count=0;

    /**
     * 思路：
     * 1.第一个皇后放在第一行第一列
     * 2.第二个皇后放在第二行第一列，然后判断是否ok,如果不ok继续放在第二列、第三列、依次把所有列都放完，找到一个合适的
     * 3.继续第三个皇后，还是第一列、第二列...直到第8个皇后也能放在一个不冲突的位置，算是找到了一个正确解
     * 4.当得到一个正确解时，在栈回退到上一个栈时，就开始回溯，即将第一个皇后放到第一列的所有正确解全部得到
     * 5.然后回头继续第一个皇后放第二列，后面继续循环执行1-2-3-4
     * <p>
     * <p>
     * 步骤
     *
     * @param args
     */

    public static void main(String[] args) {
        EightQueens eightQueens = new EightQueens();
        eightQueens.check(0);
        System.out.println(count);


    }

    //放置第n个皇后
    public void check(int n) {
        if (n == max) {
            //前8个皇后已经放好
            //输出皇后
            showPos();
            return;

        }
        //依次放入皇后并判断是否冲突
        for (int i = 0; i < max; i++) {
            //先把当前这个皇后放到第1列
            arr[n] = i;
            //判断当放置第n个皇后到i列时，是否冲突
            if (judge(n)) {
                //不冲突接着放第n+1个皇后
                check(n + 1);


            }
            //如果冲突，则将皇后放在本行的一个位置


        }

    }


    /**
     * 查看皇后是否和之前放置的皇后位置冲突
     *
     * @param n 第n个皇后
     * @return
     */
    private boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            //在同一列或者同一斜线
            if (arr[i] == arr[n] || Math.abs(n - i) == Math.abs(arr[n] - arr[i])) {
                //不能放在当前位置
                return false;

            }

        }

        return true;


    }


    //输出皇后放置位置
    public void showPos() {
        count++;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");

        }
        System.out.println();
    }
}
