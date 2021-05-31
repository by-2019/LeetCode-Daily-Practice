package day18.s477;

/**
 * 两个整数的 汉明距离 指的是这两个数字的二进制数对应位不同的数量。
 * <p>
 * 给你一个整数数组 nums，请你计算并返回 nums 中任意两个数之间汉明距离的总和。
 */
public class Solution {
    public int totalHammingDistance(int[] nums) {
        int[] bitArr = new int[32];
        for (int i = 0; i < nums.length; i++) {
            int tmp = nums[i];
            for (int j = 0; j < 32 && tmp > 0; j++, tmp >>= 1) {
                if ((tmp & 1) != 0) {
                    bitArr[j] += 1;
                }
            }
        }
        int total = 0;
        for (int i = 0; i < bitArr.length; i++) {
            total += bitArr[i] * (nums.length - bitArr[i]);
        }
        return total;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.totalHammingDistance(new int[]{4, 14, 4}));
    }
}
