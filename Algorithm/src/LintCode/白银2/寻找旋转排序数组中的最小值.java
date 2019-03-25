package LintCode.白银2;

/**
 * 假设一个排好序的数组在其某一未知点发生了旋转（比如0 1 2 4 5 6 7 可能在第3和第4个元素间发生旋转变成4 5 6 7 0 1 2）。
 *
 * 你需要找到其中最小的元素。
 *
 * 你可以假设数组中不存在重复的元素。
 *
 * 样例
 * 给出[4,5,6,7,0,1,2]  返回 0
 *
 * 注意事项
 * 你可以假设数组中不存在重复元素。
 */
public class 寻找旋转排序数组中的最小值 {
    public static void main(String[] args) {
        int[] nums = new int[]{4,5,6,7};
        System.out.println(findMin(nums));
    }

    /**
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     */
    public static int findMin(int[] nums) {
        int len = nums.length;
        if (nums == null || len == 0) {
            return 0;
        }
        for (int i = len-1; i > 0; i--) {
            if (nums[i]<nums[i-1]) {
                return nums[i];
            }
        }
        return nums[0];
    }
}
