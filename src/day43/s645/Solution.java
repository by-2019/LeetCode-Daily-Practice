package day43.s645;

import java.util.Arrays;

/**
 * 集合 s 包含从 1 到n的整数。不幸的是，因为数据错误，导致集合里面某一个数字复制了成了集合里面的另外一个数字的值，导致集合 丢失了一个数字 并且 有一个数字重复 。
 * <p>
 * 给定一个数组 nums 代表了集合 S 发生错误后的结果。
 * <p>
 * 请你找出重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
 */
public class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int[] tmp = new int[n + 1];
        for (int num : nums) {
            tmp[num]++;
        }
        int[] rs = new int[2];
        for (int i = 1; i <= n; i++) {
            if (tmp[i] == 0) {
                rs[1] = i;
            } else if (tmp[i] == 2) {
                rs[0] = i;
            }
        }
        return rs;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.findErrorNums(new int[]{1, 1})));
    }
}
