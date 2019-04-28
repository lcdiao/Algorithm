package LintCode.白银3;

import java.util.Arrays;

/**
 给定一个已经 按升序排列 的数组，找到两个数使他们加起来的和等于特定数。
 函数应该返回这两个数的下标，index1必须小于index2。注意返回的值不是 0-based。

 样例
 Example 1:

 Input: nums = [2, 7, 11, 15], target = 9
 Output: [1, 2]
 Example 2:

 Input: nums = [2,3], target = 5
 Output: [1, 2]
 注意事项
 你可以假设每个输入刚好只有一个答案
 */
public class 两数和II输入已排序的数组 {
    public static void main(String[] args) {
        int[] a = new int[]{-111,-100,-98,-11,-6,-5,-4,-3,-2,-1};
        System.out.println(Arrays.toString(twoSum(a,-111)));
    }

    /**
     * @param nums: an array of Integer
     * @param target: target = nums[index1] + nums[index2]
     * @return: [index1 + 1, index2 + 1] (index1 < index2)
     */
    public static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int[] result = new int[2];
        int len = nums.length;
        for (int i = 0; i < len; i++) {

            for (int j = i + 1; j < len; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i+1,j+1};
                }
                if (nums[i] + nums[j] > target) {
                    break;
                }
            }
        }
        return null;
    }
}
