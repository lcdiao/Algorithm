package LintCode.青铜到白银1;

/**
 * Created by diao on 2019/3/13
 * 给出一个字符串，找出第一个只出现一次的字符。
 *
 * 样例
 * 样例 1:
 * 	输入: "abaccdeff"
 * 	输出:  'b'
 *
 * 	解释:
 * 	'b' 是第一个出现一次的字符
 *
 *
 * 样例 2:
 * 	输入: "aabccd"
 * 	输出:  'b'
 *
 * 	解释:
 * 	'b' 是第一个出现一次的字符
 */
public class 第一个只出现一次的字符 {

    public static void main(String[] args) {
        String str = "aaaaaaaaaaaaaad";
        System.out.println(firstUniqChar(str));
    }

    /**
     * @param str: str: the given string
     * @return: char: the first unique character in a given string
     */
    public static char firstUniqChar(String str) {
        int[] ai = new int[70000];
        char[] ac = str.toCharArray();
        int len = ac.length;
        for (int i = 0; i < len-1; i++) {
            //跳过标记过的字符
            if(ai[ac[i]] == 0) {
                for (int j = i + 1; j < len; j++) {
                    if (ac[i] == ac[j]) {
                        //出现过的标记
                        ai[ac[i]] = 1;
                        break;
                    }
                    if (j == len - 1) {
                        return ac[i];
                    }
                }
            }
        }
        return ac[len-1];
    }
}
