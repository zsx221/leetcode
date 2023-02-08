package xhd.practice.leetcode.常规题目;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class offer4 {
    /*
    * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，
    * 每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，
    * 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数
    *
    *
    * */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        List<int[]> lists = Arrays.stream(matrix).collect(Collectors.toList());
        for (int[] list : lists) {
            for (int i : list) {
               if (i==target)
                   return true;
            }
        }
        return false;
    }
}
