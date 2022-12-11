package xhd.practice.GettingStarted;

import lombok.val;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class Solution3 {
    //用递归，每次都返回无重复字符的最长字符
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("dvdf"));
    }
    public static int lengthOfLongestSubstring(String s) {
        if (s==null||s.length()==0)
            return  0;
        char[] array = s.toCharArray();
        int length = s.length();
        int i=0,j=0;
        int max=0,now=0;
        Set<Character> set=new HashSet<>();
        while (i<length&&j<length){
            if (!set.contains(array[j])){//如果set包含已有的，就代表失败了
                set.add(array[j]);
                j++;
                now++;
            }else {
                set=new HashSet<>();
                i++;
                j=i;
                now=0;
            }
            max=Math.max(max,now);

        }
        return max;
    }
}
