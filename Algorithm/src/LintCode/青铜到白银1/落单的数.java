package LintCode.青铜到白银1;

/**
 * 给出2*n + 1 个的数字，除其中一个数字之外其他每个数字均出现两次，找到这个数字。
 *
 *
 *
 * 样例
 * 给出 [1,2,2,1,3,4,3]，返回 4
 *
 * 挑战
 * 一次遍历，常数级的额外空间复杂度
 */
public class 落单的数 {

    public static void main(String[] args) {
        int[] a = {1,2,2,1,3,4,3};
        System.out.println(singleNumber(a));
    }
    /**
     * @param A: An integer array
     * @return: An integer
     */
    public static int singleNumber(int[] A) {
        // write your code here
        int len = A.length;
        for(int i = 1;i < len;i++){
            A[i] = A[i]^A[i-1];
        }
        return A[len-1];
    }
}
