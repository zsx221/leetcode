package xhd.practice.GettingStarted;

import lombok.val;

/**
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
 *
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 */
public class Solution344 {
    /**
     * 示例
     * 输入：s = ["h","e","l","l","o"]
     * 输出：["o","l","l","e","h"]
     *
     */
    public static void main(String[] args) {
//         char[]s= {'H','a','n','n','a','h'};
//         reverseString(s);
//        for (char c : s) {
//            System.out.println(c);
//        }
        String s = "God Ding";
        System.out.println(reverseWords(s));
    }
    public static String reverseString(String t) {
        char[] s = t.toCharArray();
        for (int i=0,j=s.length-1;i<s.length;i++,j--)
        {
            if (i>=j)
                break;
            char temp=s[i];
            s[i]=s[j];
            s[j]=temp;
        }
        return String.valueOf(s);
    }
    public static String reverseWords(String s) {
        String[] strings = s.split(" ");
        StringBuffer buffer=new StringBuffer();
        for (String string : strings) {
            val s1 = reverseString(string);
            buffer.append(s1+" ");
        }
        return buffer.deleteCharAt(buffer.length()-1).toString();
    }
}
