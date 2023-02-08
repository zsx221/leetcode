package xhd.practice.leetcode.常规题目;

public class offer29 {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix==null)
            return null;

        int a=matrix.length;
        int b=matrix[0].length;
        int [] result=new int[a*b];
        int h=0;
        for (int i=0;i<a;i++){
            for (int j=0;j<b;j++){//优先级    1 右边有子，往右边走    2   下    3 左   4   上  走过的数字，不走了

                result[h++]=matrix[i][j];

            }
        }
        return result;
    }
    /**
     *  1 2 3
     *  4 5 6
     *  7 8 9
     */
}
