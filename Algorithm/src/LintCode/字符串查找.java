package LintCode;

/**
 * Created by diao on 2019/3/13
 */
public class 字符串查找 {
    public static void main(String[] args) {
        String source = "source";
        String target = "rce";

        System.out.println(strStr(source,target));
    }

    /**
     * @param source:
     * @param target:
     * @return: return the index
     */
    public static int strStr(String source, String target) {
        if(source.equals(target)){
            return 0;
        }
        if ("".equals(target)){
            return 0;
        }
//        int sl = source.length();
//        int tl = target.length();
//        for(int i = 0; i < sl-tl+1; i++) {
//            if(source.charAt(i) == target.charAt(0)){
//                String s = source.substring(i,tl+i);
//                if(s.equals(target)){
//                    return i;
//                }
//            }
//        }
//        return -1;

        //KMP
        char[] t = source.toCharArray();
        char[] p = target.toCharArray();
        int i = 0; // 主串的位置
        int j = 0; // 模式串的位置
        int[] next = getNext(target);
        while (i < t.length && j < p.length) {
            if (j == -1 || t[i] == p[j]) { // 当j为-1时，要移动的是i，当然j也要归0
                i++;
                j++;
            } else {
                // i不需要回溯了
                // i = i - j + 1;
                j = next[j]; // j回到指定位置
            }
        }
        if (j == p.length) {
            return i - j;
        } else {
            return -1;
        }
    }

    public static int[] getNext(String ps) {
        char[] p = ps.toCharArray();
        int[] next = new int[p.length];
        next[0] = -1;
        int j = 0;
        int k = -1;
        while (j < p.length - 1) {
            if (k == -1 || p[j] == p[k]) {
                if (p[++j] == p[++k]) { // 当两个字符相等时要跳过
                    next[j] = next[k];
                } else {
                    next[j] = k;
                }
            } else {
                k = next[k];
            }
        }
        return next;

    }
}
