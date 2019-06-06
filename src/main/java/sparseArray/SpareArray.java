package sparseArray;

/**
 * @Description 稀疏矩阵
 * @Author eric
 * @Version V1.0.0
 * @Date 2019/6/6
 */
public class SpareArray {

    public static void main(String[] args) {
        //创建一个原始的二维数组  11*11
        //0:表示没有棋子 1：黑子 2：蓝子
        int[][] chessArr1 = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        //输出原始的二维数组
        System.out.println("原始的二维数组：");
        for (int[] ints : chessArr1) {
            for (int i : ints) {
                System.out.print(i + "\t");
            }
            System.out.println();

        }
//        chessArr1.

        //将二维数组转为稀疏数组
        //1.先遍历二维数组，等到非零数据个数,原始数组的行数和列数
        int sum = 0;
        //列数
        int column = chessArr1[0].length;
        //行数
        int row = chessArr1.length;
        for (int[] ints : chessArr1) {
            for (int i : ints) {
                if (0 != i)
                    sum++;
            }
        }
        System.out.println("稀疏矩阵中不为零的元素个数为：" + sum + "\n行数为:" + row + "\n列数为:" + column);
        //2.创建对应的稀疏数组
        int[][] sparseArr = new int[sum + 1][3];
        //给稀疏数组赋值
        //第一行存储原来的稀疏矩阵的行列数以及非零元素的个数
        sparseArr[0][0] = row;
        sparseArr[0][1] = column;
        sparseArr[0][2] = sum;
        //遍历二维数组，将非零元素存储进数组

        int coun = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (0 != chessArr1[i][j]) {
                    coun++;

                    sparseArr[coun][0] = i;
                    sparseArr[coun][1] = j;
                    sparseArr[coun][2] = chessArr1[i][j];
                }

            }

        }
        //输出稀疏数组
        System.out.println("稀疏数组:");
        for (int[] ints : sparseArr) {
            for (int anInt : ints) {

                System.out.print(anInt + "\t");
            }
            System.out.println();
        }


        //将稀疏数组转为原始数组
        //1.先读取稀疏数组的第一行，得到原始数组的行列数以及非零元素的个数
        //原始数组的行数
        int originalArrayRow=sparseArr[0][0];
        //原始数组列数
        int originalArrayColumn=sparseArr[0][1];
        //根据行数和列数创建数组
        int[][] originalArray = new int[originalArrayRow][originalArrayColumn];
        //读取稀疏数组的后面几行数据，将非零元素赋值给原始数组的对应位置
        for(int i=1;i<sparseArr.length;i++){
            originalArray[sparseArr[i][0]][sparseArr[i][1]]=sparseArr[i][2];

        }
        //输出原始数组
        System.out.println("原始数组为:");
        for (int[] ints : originalArray) {
            for (int anInt : ints) {
                System.out.print(anInt+"\t");
            }
            System.out.println();
        }


    }
}
