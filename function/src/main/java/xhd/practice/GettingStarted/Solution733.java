package xhd.practice.GettingStarted;

import lombok.Data;
import lombok.val;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 输入: image = [[1,1,1],[1,1,0],[1,0,1]]，sr = 1, sc = 1, newColor = 2
 * 输出: [[2,2,2],[2,2,0],[2,0,1]]
 * 解析: 在图像的正中间，(坐标(sr,sc)=(1,1)),在路径上所有符合条件的像素点的颜色都被更改成2。
 * 注意，右下角的像素没有更改为2，因为它不是在上下左右四个方向上与初始点相连的像素点。
 */
public class Solution733 {
    public static void main(String[] args) {
        int[][] image = {{0,0,0},{0,0,0}};
        image=new Solution733().floodFill(image,1,1,2);
        for (int[] ints : image) {
            for (int i : ints) {
                System.out.println(i);
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
/**
 * 1 1 1   2 2 2
 * 1 1 0   2 2 0
 * 1 0 1   2 0 1
 */     //记录数组的行列号
        //使用广度优先算法,使用队列解决问题
        Queue<int []> queue=new LinkedList<>();
        //第一步，找到坐标点
        int row=image.length;
        int column=image[0].length;
//        test test=new test(sr,sc);
        int tage=image[sr][sc];
        image[sr][sc]=color;
        queue.offer(new int[] {sr,sc});
        while (!queue.isEmpty()){
            int [] remove = queue.remove();
            int i = remove[0];//获取横坐标
            int j = remove[1];//获取纵坐标
            if (i<row&&j<column){
                if (i-1>=0&&image[i-1][j]==tage){ //上
                    queue.add(new int[]{i-1,j});
                    image[i-1][j]=color;
                }
                if (i+1<row&&image[i+1][j]==tage){ //下
                    queue.add(new int[]{i+1,j});
                    image[i+1][j]=color;
                }
                if (j-1>=0&&image[i][j-1]==tage){ //左
                    queue.add(new int[]{i,j-1});
                    image[i][j-1]=color;
                }
                if (j+1<column&&image[i][j+1]==tage){ //下
                    queue.add(new int[]{i,j+1});
                    image[i][j+1]=color;
                }
            }
        }
        return image;
    }

}
