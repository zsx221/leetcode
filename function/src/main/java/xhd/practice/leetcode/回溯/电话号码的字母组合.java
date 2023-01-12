package xhd.practice.leetcode.回溯;

import lombok.val;

import java.util.*;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。
 */
public class 电话号码的字母组合 {
    public static void main(String[] args) {
        letterCombinations("23");
    }

    static List<String> result = new ArrayList<>();
    static LinkedList<Character> path = new LinkedList<>();
    static String[] numbers=new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public static List<String> letterCombinations(String digits) {
        //先处理字符串，将数字相应的字母做成字符串
        backbreaking(digits, 0);
        for (String s : result) {
            System.out.println(s);
        }
        return result;
    }

    private static void backbreaking(String digits, int index) {//index用来控制
        //终止条件
        if (index==digits.length()) {
            StringBuffer buffer=new StringBuffer();
            for (Character character : path) {
                buffer.append(character);
            }
            result.add(buffer.toString());
            return;
        }
        int digit = Integer.parseInt(String.valueOf(digits.charAt(index)));
        String number = numbers[digit];
        for (int i=0;i<number.length();i++){
            path.add(number.charAt(i));
            backbreaking(digits,index+1);
            path.removeLast();
        }
    }
}
