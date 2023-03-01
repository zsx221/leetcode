package xhd.practice.leetcode.常规题目;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
 */
public class offer139 {
    public static void main(String[] args) {
     String   s = "catsandog";
//     wordDict = ["leet", "code"
        List<String> wordDict=new ArrayList<>();
        wordDict.add("cats");
        wordDict.add("dog");
        wordDict.add("sand");
        wordDict.add("and");
        wordDict.add("cat");
        wordBreak(s,wordDict);

    }
    public static boolean wordBreak(String s, List<String> wordDict) {
        for (String s1 : wordDict) {
            if (!s.contains(s1))
                return false;
        }
        return true;
    }

}
