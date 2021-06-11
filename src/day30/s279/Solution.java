package day30.s279;

/**
 * 给定正整数n，找到若干个完全平方数（比如1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 * <p>
 * 给你一个整数 n ，返回和为 n 的完全平方数的 最少数量 。
 * <p>
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 */
public class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int num = 1; num * num <= n; num++) {
            int sum = num * num;
            for (int i = sum; i <= n; i++) {
                if (dp[i] == 0) {
                    dp[i] = 1 + dp[i - sum];
                } else {
                    dp[i] = Math.min(dp[i], 1 + dp[i - sum]);
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.numSquares(13));
    }
}
