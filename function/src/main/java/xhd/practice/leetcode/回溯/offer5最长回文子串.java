package xhd.practice.leetcode.回溯;


import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * <p>
 * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串
 */
public class offer5最长回文子串 {

    public static String longestPalindrome(String s) {
        char[] cArray = s.toCharArray();
        // 由长倒短，遍历cArray的所有子串
        for (int len = cArray.length; len > 1; len--) {
            for (int left = 0, right = left + len - 1; right < cArray.length; left++, right++)
                // 是回文串，找到结果
                if (subIsPalindrome(cArray, left, right))
                    return s.substring(left, right + 1);
        }
        return s.substring(0, 1);
    }

    // 判断左右区间中的字符串是回文串
    public static boolean subIsPalindrome(char[] cArray, int left, int right) {
        while (left < right)
            if (cArray[left++] != cArray[right--])
                return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("xeeevvgrqunieginnvgvttbloinzpmoiaczszxswpmsxkhtnyrzimeckwndjnrvczcokshsachapcsbhijbbedfjnccqifibbumjchrarmvfoacdxwwkwrsnnebsdqksjmxzuwlpztltsgtllviztsqzzzzsrxkhmrugklfxinlkbdtgzaqgrrnplsbbtoqfrjwzqhwozesjqanifdswbtrkbtzkwtcodejwdorsdcairdodaluaafbviigevezrkovmcbswauhkvhrhzojdmlevuvfycjqntgpxtjtqqtjtxpgtnqjcyfvuvelmdjozhrhvkhuawsbcmvokrzevegiivbfaauladodriacdsrodwjedoctwkztbkrtbwsdfinaqjsezowhqzwjrfqotbbslpnrrgqazgtdbklnixflkgurmhkxrszzzzqstzivlltgstltzplwuzxmjskqdsbennsrwkwwxdcaofvmrarhcjmubbifiqccnjfdebbjihbscpahcashskoczcvrnjdnwkcemizrynthkxsmpwsxzszcaiompzniolbttvgvnnigeinuqrgvveeex"));
    }
}
