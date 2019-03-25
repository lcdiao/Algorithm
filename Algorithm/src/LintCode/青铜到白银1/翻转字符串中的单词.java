package LintCode.青铜到白银1;

/**
 * Created by diao on 2019/3/13
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 *
 * 样例
 * 给出s = "the sky is blue"，返回"blue is sky the"
 *
 * 说明
 * 单词的构成：无空格字母构成一个单词
 * 输入字符串是否包括前导或者尾随空格？可以包括，但是反转后的字符不能包括
 * 如何处理两个单词间的多个空格？在反转字符串中间空格减少到只含一个
 */
public class 翻转字符串中的单词 {

    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));
    }

    /*
     * @param s: A string
     * @return: A string
     */
    public static String reverseWords(String s) {
        String regex = "\\s+";
        s = s.replaceAll(regex," ");
        String[] a = s.split(" ");
        int len = a.length;
        int end = len/2;
        String c;
        for(int i=0;i<end;i++){
            c=a[i];
            a[i]=a[len-1-i];
            a[len-1-i]=c;

        }
        s= "";
        for(int i=0;i<len;i++){
            if(i!=len-1){
                s+=a[i]+" ";
            }else {
                s += a[i];
            }
        }
        return s;
    }
}
