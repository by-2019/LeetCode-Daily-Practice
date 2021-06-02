package day21.s523;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 给你一个整数数组 nums 和一个整数k ，编写一个函数来判断该数组是否含有同时满足下述条件的连续子数组：
 * <p>
 * 子数组大小 至少为 2 ，且
 * 子数组元素总和为 k 的倍数。
 * 如果存在，返回 true ；否则，返回 false 。
 * <p>
 * 如果存在一个整数 n ，令整数 x 符合 x = n * k ，则称 x 是 k 的一个倍数。
 */
public class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length <= 1) {
            return false;
        }
        long[] sums = new long[nums.length];
        sums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }
        Map<Integer, Integer> needs = new HashMap<>();
        needs.put(0, -1);
        for (int i = 0; i < sums.length; i++) {
            int mod = (int) (sums[i] % k);
            Integer old = needs.get(mod);
            if (null != old) {
                if (i - old >= 2) {
                    return true;
                }
            } else {
                needs.put(mod, i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.checkSubarraySum(new int[]{5, 0, 0, 0}, 3));
    }
}
