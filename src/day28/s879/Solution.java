package day28.s879;

/**
 * 集团里有 n 名员工，他们可以完成各种各样的工作创造利润。
 * <p>
 * 第i种工作会产生profit[i]的利润，它要求group[i]名成员共同参与。如果成员参与了其中一项工作，就不能参与另一项工作。
 * <p>
 * 工作的任何至少产生minProfit 利润的子集称为 盈利计划 。并且工作的成员总数最多为 n 。
 * <p>
 * 有多少种计划可以选择？因为答案很大，所以 返回结果模10^9 + 7的值。
 */
public class Solution {
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int[][] dp = new int[n + 1][minProfit + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        int MOD = (int) (1e9 + 7);
        for (int i = 1; i <= group.length; i++) {
            int member = group[i - 1];
            int earn = profit[i - 1];
            for (int j = n; j >= member; j--) {
                for (int k = minProfit; k >= 0; k--) {
                    dp[j][k] = (dp[j][k] + dp[j - member][Math.max(0, k - earn)]) % MOD;
                }
            }
        }
        return dp[n][minProfit];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.profitableSchemes(64, 0, new int[]{80, 40}, new int[]{88, 88}));
    }
}