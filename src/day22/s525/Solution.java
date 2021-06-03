package day22.s525;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
 */
public class Solution {
    public int findMaxLength(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = -1;
            }
        }
        int max = 0;
        Map<Integer, Integer> sums = new HashMap<>();
        sums.put(0, -1);
        int counter = 0;
        for (int i = 0; i < nums.length; i++) {
            counter += nums[i];
            Integer index = sums.get(counter);
            if (null == index) {
                sums.put(counter, i);
            } else {
                max = Math.max(max, i - index);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findMaxLength(new int[]{1}));
    }
}
