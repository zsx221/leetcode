package xhd.practice.leetcode.常规题目;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 */
public class offer56 {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        intervals= (int[][]) Arrays.stream(intervals).sorted().toArray();
        merge(intervals);
    }

    public static int[][] merge(int[][] intervals) {
        for (int[] ints : intervals) {
            System.out.println(ints[0]+" "+ints[1]);
        }
        for (int i=1;i<intervals.length;i++){
            //每个都与第一个数组比较

        }
        return intervals;
    }
}
