package xhd.practice.leetcode;
/*
*
* 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
*
        * 输入：s = "We are happy."
           输出："We%20are%20happy."
* */
public class offer5 {
    public String replaceSpace(String s) {
        char[] chars = s.toCharArray();
        String t="";

        for (char c : chars) {
            if (c==' ')
                t=t+"%20";
            else
                t=t+c;
        }
        return s;
    }
}
