package LintCode.青铜到白银1;

/**
 *
 * 给定一个字符串str,现在你需要统计出现次数最多的字母。返回这个字母出现的次数。
 *
 * 样例
 * Example1
 *
 * Input: str="ABCabcA"
 * Output: 2
 * Explanation:
 * A appeared 2 times, B appeared once, C appeared once, a appeared once, b appeared once, c appeared once, A appeared the most, so returned 2.
 * Example2
 *
 * Input: str="abca"
 * Output: 2
 * Explanation:
 * a appeared 2 times, b and c appear once
 * so return 2
 * 注意事项
 * Only uppercase or lowercase letters may appear in the letters.
 * String length does not exceed 100,000
 */
public class 出现次数最多的字母 {

    public static void main(String[] args) {
        System.out.println(mostFrequentlyAppearingLetters("ABCabcA"));
    }


    /**
     * @param str: the str
     * @return: the sum that the letter appears the most
     */
    public static int mostFrequentlyAppearingLetters(String str) {
        if (null == str || "".equals(str)){
            return 0;
        }
        int[] a = new int[127];
        int len = str.length();
        char[] ac = str.toCharArray();
        for (int i = 0; i < len; i++) {
            a[ac[i]]++;
        }
        int max = 0;
        for (int i = 0; i < 127; i++) {
            if (a[i] > max){
                max = a[i];
            }
        }
        return max;
    }
}
