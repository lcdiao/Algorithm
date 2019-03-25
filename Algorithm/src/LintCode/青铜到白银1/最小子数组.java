package LintCode.青铜到白银1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by diao on 2019/3/13
 * 给定一个整数数组，找到一个具有最小和的子数组。返回其最小和。
 *
 * 样例
 * 样例 1
 *
 * 输入：[1, -1, -2, 1]
 * 输出：-3
 * 样例 2
 *
 * 输入：[1, -1, -2, 1, -4]
 * 输出：-6
 * 注意事项
 * 子数组最少包含一个数字
 */
public class 最小子数组 {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(1);nums.add(-1);nums.add(-2);nums.add(1);
        System.out.println(minSubArray(nums));
    }

    /*
     * @param nums: a list of integers
     * @return: A integer indicate the sum of minimum subarray
     */
    public static int minSubArray(List<Integer> nums) {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            sum += nums.get(i);
            min = sum < min ? sum : min;
            sum = sum < 0 ? sum : 0;
        }
        return min;
    }
}
