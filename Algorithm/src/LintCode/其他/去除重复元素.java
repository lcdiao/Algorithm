package LintCode.其他;

import java.util.*;

/**
 * Created by diao on 2019/3/15\
 * 给一个整数数组，去除重复的元素。
 *
 * 你应该做这些事
 *
 * 1.在原数组上操作
 * 2.将去除重复之后的元素放在数组的开头
 * 3.返回去除重复元素之后的元素个数
 *
 * 样例
 * 例1:
 *
 * 输入:
 * nums = [1,3,1,4,4,2]
 * 输出:
 * [1,3,4,2,?,?]
 * 4
 *
 * 解释:
 * 1. 将重复的整数移动到 nums 的尾部 => nums = [1,3,4,2,?,?].
 * 2. 返回 nums 中唯一整数的数量  => 4.
 * 事实上我们并不关心你把什么放在了 ? 处, 只关心没有重复整数的部分.
 * 例2:
 *
 * 输入:
 * nums = [1,2,3]
 * 输出:
 * [1,2,3]
 * 3
 * 挑战
 * 1.O(n)时间复杂度.
 * 2.O(nlogn)时间复杂度但没有额外空间
 *
 * 注意事项
 * 不需要保持原数组的顺序
 */
public class 去除重复元素 {

    public static void main(String[] args) {
        int[] a = {1,3,1,4,4,2};
        System.out.println(deduplication(a));
        System.out.println(Arrays.toString(a));

    }
    /**
     * @param nums: an array of integers
     * @return: the number of unique integers
     */
    public static int deduplication(int[] nums) {
        int len = nums.length;
        if (null == nums || len == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < len; i++ ) {
            set.add(nums[i]);
        }
        int size = set.size();
        Iterator<Integer> integerIterator = set.iterator();
        int n = 0;
        while (integerIterator.hasNext()) {
            nums[n++] = integerIterator.next();
        }

        return size;

    }
}
