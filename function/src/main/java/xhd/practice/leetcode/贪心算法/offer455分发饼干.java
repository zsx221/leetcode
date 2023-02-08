package xhd.practice.leetcode.贪心算法;

import java.util.Arrays;

/**
 * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
 * <p>
 * 对每个孩子 i，都有一个胃口值 g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j，都有一个尺寸 s[j]
 * 如果 s[j] >= g[i]，我们可以将这个饼干 j 分配给孩子 i 这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子
 * 并输出这个最大数值。
 * 实例
 * 输入: g = [1,2,3], s = [1,1]
 * 输出: 1
 */
public class offer455分发饼干 {
    //解法思想：局部最优推出全局最优
    public static int findContentChildren(int[] g, int[] s) {//g数组为小孩子胃口，s为饼干大小
        g = Arrays.stream(g).sorted().toArray();
        s = Arrays.stream(s).sorted().toArray();
        int result = 0, i = g.length - 1, j = s.length - 1;
        while (i >= 0 && j >= 0) {
            if (s[j] >= g[i]) {
                result++;
                i--;
                j--;
            } else {
                i--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findContentChildren(new int[]{1, 2}, new int[]{1,2,3}));
    }
}
