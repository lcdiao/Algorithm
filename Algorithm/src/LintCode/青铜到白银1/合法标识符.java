package LintCode.青铜到白银1;

/**
 * 请判断字符串 str 是不是一个合法的标识符。
 * 合法的标识符由字母（A-Z，a-z）、数字（0-9）和下划线组成，并且首字符不能为数字。
 *
 * 样例
 * 样例 1：
 *
 * 输入：str= "LintCode"
 * 输出：true
 * 解释：
 * 因为 "LintCode" 由字母组成。
 * 样例 2：
 *
 * 输入：str = "123_abc"
 * 输出：false
 * 解释：
 * 虽然 "123_abc" 由字母、数字和下划线组成，但是它的首字符为数字。
 */
public class 合法标识符 {


    public static void main(String[] args) {
        System.out.println(isLegalIdentifier("123_abc"));
    }
    /**
     * @param str: The identifier need to be judged.
     * @return: Return if str is a legal identifier.
     */
    public static boolean isLegalIdentifier(String str) {
        if (null == str || "".equals(str)){
            return false;
        }
        char[] ac = str.toCharArray();
        if(!(ac[0] >= 'a' && ac[0] <='z' || ac[0] >= 'A' && ac[0] <= 'Z')){
            return false;
        }
        int len = ac.length;
        for(int i = 1; i < len; i++){
            if(!(ac[i] >= '0'&& ac[i] <= '9' || ac[i] >= 'a' && ac[i] <='z' || ac[i] >= 'A' && ac[i] <= 'Z' || ac[i] == '_')){
                return false;
            }
        }
        return true;
    }
}
