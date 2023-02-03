package xhd.practice.leetcode;

import lombok.val;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 最小的k个数
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 */
public class Offer40 {
    public static void main(String[] args) {
        int arr[]=new int[]{3,2,1};
        int[] result = getLeastNumbers(arr, 2);
        for (int i : result) {
            System.out.println(i);
        }
    }
    public static int[] getLeastNumbers(int[] arr, int k) {
        IntStream stream = Arrays.stream(arr).sorted();
        int[] toArray = stream.toArray();
        return Arrays.copyOf(toArray,k);
    }
}
