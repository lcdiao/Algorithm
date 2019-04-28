package LintCode.白银3;

import java.io.Serializable;

/**
 给定一个字符串，请找出其中无重复字符的最长子字符串。

 样例
 样例 1:

 输入: "abcabcbb"
 输出: 3
 解释: 最长子串是 "abc".
 样例 2:

 输入: "bbbbb"
 输出: 1
 解释: 最长子串是 "b".
 挑战
 O(n) 时间复杂度
 */
public class 最长无重复字符的子串  {

    public static void main(String[] args) {
        String s = "abcabcdd";
        //s="aab";
        //s="bpfbhmipx";
        System.out.println(lengthOfLongestSubstring(s));
    }

    /**
     * @param s: a string
     * @return: an integer
     */
    public static int lengthOfLongestSubstring(String s) {
        if (null == s || s.length() == 0) {
            return 0;
        }
        char[] cs = s.toCharArray();
        int len = s.length();
        int result = 1;
        int num = 1;
        String sub = s.substring(0,1);
        for (int i = 1; i < len ; i++) {
            int n = sub.length();
            if (!sub.contains(cs[i] + "")) {
                if (i+1 < len && cs[i+1] == cs[i]) {
                    sub = cs[i]+"";
                    i++;
                    continue;
                }
                sub = s.substring(i-n,i+1);
                num=n+1;
                if (num > result) {
                    result = num;
                }
            } else {
                for (int j = 0;j < n; j++) {
                    if (sub.charAt(j) == cs[i]) {
                        sub = s.substring(i-n+j+1,i+1);
                        break;
                    }
                }
            }
        }
        return result;
    }
}
