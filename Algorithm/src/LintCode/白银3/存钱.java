package LintCode.白银3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 现在你需要负责一家银行的存取款系统,给定大小为 n 的三个数组 op[], name[], w[] 表示按时间顺序记录的 n 条信息。
 其中 op[] 代表信息的类型,而系统中可能出现的信息有两类，对于每一条信息，按照要求输出答案，最后答案以数组形式返回。
 op = 0 代表用户名为 name 的用户要存 w 元钱进自己的账户，输出存钱后该用户账户的金额。
 op = 1 代表用户名为 name 的用户要从自己账户里取走 w 元钱，如果该用户账户里有足够的钱,输出该用户账户里的剩余存款，否则输出 -1，并且不处理账户。
 一开始所有用户的存款都是 0。

 样例
 样例 1：

 输入：
 op = [1,0,0,0,1,1,1],
 name = ["zzl","gyc","zzl","zzl","zzl","zzl","gyc"],
 w = [20,30,40,50,30,70,30]
 输出：[-1,30,40,90,60,-1,0]
 样例 2：

 输入：
 [1,1,1,1,1,0,1,0,0],
 ["lvh","lvh","iyf","jek","unv","lvh","lvh","jek","jek"],
 [110,8,98,72,142,99,39,89,108]
 输出：[-1,-1,-1,-1,-1,99,60,89,197]
 注意事项
 n <= 200000
 */
public class 存钱 {

    public static void main(String[] args) {
        int[]  op = new int[]{1,0,0,0,1,1,1};
        String[] name = new String[]{"zzl","gyc","zzl","zzl","zzl","zzl","gyc"};
        int[] w = new int[]{20,30,40,50,30,70,30};
        System.out.println(Arrays.toString(getAns(op,name,w)));
    }

    /**
     * @param op: the type of information
     * @param name: the name of user
     * @param w: the money need to save or take
     * @return: output the remaining money of the user.if the operation is illegal,output -1
     */
    public static int[] getAns(int[] op, String[] name, int[] w) {
        if (op == null || name == null || w == null) {
            return null;
        }
        int len = op.length;
        if (name.length != len || w.length != len) {
            return  null;
        }
        //保存用户的name和w
        Map<String,Integer> map = new HashMap<>();
        int[] result = new int[len];
        int index = 0;
        for (int i = 0; i < len; i++) {
            if (map == null || !map.containsKey(name[i])) {
                map.put(name[i],0);
            }
            if (op[i] == 1) {
                int v = map.get(name[i]);
                if (v >= w[i]) {
                    int n = v - w[i];
                    map.put(name[i],n);
                    result[index++] = n;
                } else {
                    result[index++] = -1;
                }
            } else if (op[i] == 0) {
                int v = map.get(name[i]);
                int n = v + w[i];
                map.put(name[i],n);
                result[index++] = n;
            }
        }
        return result;
    }
}
