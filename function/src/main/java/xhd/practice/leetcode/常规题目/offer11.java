package xhd.practice.leetcode.常规题目;

import org.junit.Test;

import java.util.Arrays;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 *
 * 给你一个可能存在 重复 元素值的数组 numbers ，它原来是一个升序排列的数组，
 * 并按上述情形进行了一次旋转。请返回旋转数组的最小元素。例如，数组[3,4,5,1,2] 为 [1,2,3,4,5] 的一次旋转，该数组的最小值为 1。
 *
 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
 *
 */
public class offer11 {
    public int minArray(int[] numbers) {
        int pre=0;
        if (numbers.length==1)
            return numbers[0];
        pre=numbers[0];
        int min=numbers[0];
        for (int i=1;i<numbers.length;i++){
            if (pre>numbers[i])
                min=numbers[i];
            pre=numbers[i];
        }
        return min;
    }
    @Test
    public void ts(){//3,5,1     5,3,1
        int[] numbers = {1,3,5};
        System.out.println(minArray(numbers));
    }
}
