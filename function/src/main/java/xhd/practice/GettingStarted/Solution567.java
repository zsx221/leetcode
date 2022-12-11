package xhd.practice.GettingStarted;

import org.apache.commons.lang3.StringUtils;
import lombok.val;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
 *
 * 换句话说，s1 的排列之一是 s2 的 子串 。
 */
public class Solution567 {
    public static void main(String[] args) {
        String s1 = "ba";
        String s2 = "eidbaooo";
        System.out.println(checkInclusion(s1, s2));
    }

    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        // 字符串排个序
        s1 = sort(s1);
        boolean res = false;
        int n = s1.length();
        try {
            for (int i = 0; i < s2.length(); i++) {
                String tmp = s2.substring(i, n+i);
                tmp = sort(tmp);
                if (tmp.equals(s1)) {
                    return true;
                }
            }
        }catch (Exception e){
            return false;
        }

        return res;
    }

    public static String sort(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
    }
}
