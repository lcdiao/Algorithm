package LintCode.白银4;
/*
给定一篇由大写字母、小写字母、逗号、句号组成的文章，求使文章不合法的字母数。
文章不合法有2种情况：
1.句子的第一个字母用了小写。
2.不是单词的首字母用了大写。

样例
样例1

输入: s="This won iz correkt. It has, No Mistakes et Oll. But there are two BIG mistakes in this sentence. and here is one more."
输出: 3
解释:
'BIG' 中'I'和''G'，以及最后一句话中的第一个字母不合法.
样例2

输入: s="Hahaha. HahaHa. hahahah."
输出: 2
解释:
'HahaHa' 中的第二个'H'和最后一个单词的第一个'h'不合法.
注意事项
一个句子当且仅当句号时结束。
文章的总长度不超过1000010000
 */
public class 合法文章 {
    public static void main(String[] args) {
        System.out.println((char)('A'+32));
        System.out.println(count("This won iz correkt. It has, No Mistakes et Oll. But there are two BIG mistakes in this sentence. and here is one more."));//3
        System.out.println(count("Hahaha. HahaHa. hahahah"));//2
        System.out.println(count("CsXwLzffsbRnGOKGnwhmSiT.BOBFSKIFufrRJ lfmrhFIPsDyX"));//23
    }
    /**
     * @param s: the article
     * @return: the number of letters that are illegal
     */
    public static int count(String s) {
        if (null == s) {
            return 0;
        }
        int result = 0;
        char[] c = s.toCharArray();
        if (c[0] >= 'a') {
            result++;
        }
        for (int i = 1; i < c.length; i++) {
            if (c[i] >= 'A' && c[i] <= 'Z' && !(c[i-1] == ' ' || c[i-1] == '.')) {
                result++;
            }else if (c[i] == '.') {
                if (i+1<c.length){
                    if(c[i+1] == ' ') {
                        if (i + 2 < c.length && c[i+2] >= 'a' && c[i+2] <= 'z') {
                            result++;
                        }
                    } else if (c[i+1] >= 'a' && c[i+1] <= 'z') {
                        result++;
                    }
                }
            }
        }
        return result;
    }
}
