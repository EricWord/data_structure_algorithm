package recursion;

/**
 * @Description
 * @Author eric
 * @Version V1.0.0
 * @Date 2019/6/25
 */
public class MiGong {

    public static void main(String[] args) {
        int[][] map = new int[8][7];
        //使用1表示墙
//        上下全部置为1
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }

        //左右全部置为1
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;

        }

        //设置挡板
        map[3][1] = 1;
        map[3][2] = 1;
//        map[1][2] = 1;
//        map[2][2] = 1;

        //输出地图
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + "\t");

            }
            System.out.println();

        }
        System.out.println();

        //使用递归回溯帮小球找路
        setWay2(map, 1, 1);
        //输出地图
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + "\t");

            }
            System.out.println();

        }


    }


    /**
     * 使用递归帮小球找路
     * 如果小球能够达到map[6][5]说明找到通路
     * 当map[i][j]=0时表示该点还没有走过，当为1时表示墙，为2表示通路可以走，3表示该点已经走过，但是走不通
     * 走迷宫时的策略：下->右->上->左，走不通再回溯
     *
     * @param map 地图
     * @param i   从哪个位置开始找
     * @param j
     * @return true:找到
     */
    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            //通路已经找到
            return true;

        } else {
            //通路还没有找到
            //根据map[6][5]的不同值来进行判断
            if (map[i][j] == 0) {
                //表示该点还没有走过
                //按照策略走
                //假定该点可以走通
                map[i][j] = 2;
                //先向下走
                if (setWay(map, i + 1, j)) {
                    //能走通
                    return true;

                } else if (setWay(map, i, j + 1)) {//向右走
                    //能走通
                    return true;

                } else if (setWay(map, i - 1, j)) {
                    //向上走
                    //能走通
                    return true;
                } else if (setWay(map, i, j - 1)) {
                    //向左走
                    //能走通
                    return true;
                } else {
                    //说明该点走不通
                    map[i][j] = 3;
                    return false;
                }

            } else {

                //如果不是0
                //可能的值为1.2.3都不能走
                return false;
            }
        }


    }


    /**
     * 走迷宫时的策略：上->右->下->左，走不通再回溯
     * 上：setWay2(map, i - 1, j)
     * 右：setWay2(map, i, j + 1)
     * 下：setWay2(map, i + 1, j)
     * 左：setWay2(map, i, j - 1)
     *
     * @param map 地图
     * @param i   从哪个位置开始找
     * @param j
     * @return true:找到
     */
    public static boolean setWay2(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            //通路已经找到
            return true;

        } else {
            //通路还没有找到
            //根据map[6][5]的不同值来进行判断
            if (map[i][j] == 0) {
                //表示该点还没有走过
                //按照策略走
                //假定该点可以走通
                map[i][j] = 2;
                //先向上走
                if (setWay2(map, i - 1, j)) {
                    //能走通
                    return true;

                } else if (setWay2(map, i, j + 1)) {//向右走
                    //能走通
                    return true;

                } else if (setWay2(map, i + 1, j)) {
                    //向下走
                    //能走通
                    return true;
                } else if (setWay2(map, i, j - 1)) {
                    //向左走
                    //能走通
                    return true;
                } else {
                    //说明该点走不通
                    map[i][j] = 3;
                    return false;
                }

            } else {

                //如果不是0
                //可能的值为1.2.3都不能走
                return false;
            }
        }


    }


}
