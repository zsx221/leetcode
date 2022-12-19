package xhd.practice.GettingStarted;

import java.util.LinkedList;
import java.util.Queue;

/**
 * grid = [
 * [0,0,1,0,0,0,0,1,0,0,0,0,0],
 * [0,0,0,0,0,0,0,1,1,1,0,0,0],
 * [0,1,1,0,1,0,0,0,0,0,0,0,0],
 * [0,1,0,0,1,1,0,0,1,0,1,0,0],
 * [0,1,0,0,1,1,0,0,1,1,1,0,0],
 * [0,0,0,0,0,0,0,0,0,0,1,0,0],
 * [0,0,0,0,0,0,0,1,1,1,0,0,0],
 * [0,0,0,0,0,0,0,1,1,0,0,0,0]
 * ]
 */
public class Solution695 {
    public static void main(String[] args) {
//        int[][] grid = {{1,1,1},{1,1,0},{1,0,1}};
        int[][]grid={{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};
        System.out.println(maxAreaOfIsland(grid));;
        for (int[] ints : grid) {
            for (int i : ints) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
    public static int maxAreaOfIsland(int[][] grid) {
        //解决办法：广度优先算法
        //两个步骤，1、找到最近的1 ，2、找到周围的面积
        //反复进行
        if (grid == null) {
            return 0;
        }
        int row = grid.length;
        int column = grid[0].length;
        int max = 0;
        Queue<int[]> queue = new LinkedList<>();
//        queue.offer(new int[]{0, 0, 1});
        for (int i = 0; i < row; i++)
            for (int j = 0; j < column; j++){
                if (grid[i][j]==1){
                    queue.offer(new int[]{i, j});
                    grid[i][j]=2;
                    max=Math.max(max,findMaxLenth(grid, row, column, queue));
                }
            }
        return max;
    }

    private static int findMaxLenth(int[][] grid, int row, int column, Queue<int[]> queue) {
        int max = 1;
        while (!queue.isEmpty()) {
            int[] remove = queue.remove();
            int i = remove[0];//获取横坐标
            int j = remove[1];//获取纵坐标
            if (i < row && j < column) {
                if (i - 1 >= 0 && grid[i - 1][j] == 1) { //上
                    queue.add(new int[]{i - 1, j});
                    grid[i - 1][j] = 2;
                    max++;
                }
                if (i + 1 < row && grid[i + 1][j] == 1) { //下
                    queue.add(new int[]{i + 1, j});
                    grid[i + 1][j] = 2;
                    max++;
                }
                if (j - 1 >= 0 && grid[i][j - 1] == 1) { //左
                    queue.add(new int[]{i, j - 1});
                    grid[i][j - 1] = 2;
                    max++;
                }
                if (j + 1 < column && grid[i][j + 1] == 1) { //下
                    queue.add(new int[]{i, j + 1});
                    grid[i][j + 1] = 2;
                    max++;
                }
            }
        }
        return max;
    }
}
