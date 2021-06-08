package day26.s494;

/**
 * 给你一个整数数组 nums 和一个整数 target 。
 * <p>
 * 向数组中的每个整数前添加'+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 * <p>
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 */
public class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int diff = sum - target;
        if (diff < 0 || diff % 2 != 0) {
            return 0;
        }
        int totalNeed = diff / 2;
        int[] dp = new int[totalNeed + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int i = totalNeed; i >= num; i--) {
                dp[i] += dp[i - num];
            }
        }
        return dp[totalNeed];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }
}
