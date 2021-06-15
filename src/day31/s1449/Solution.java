package day31.s1449;

import java.util.Arrays;

/**
 * 给你一个整数数组cost和一个整数target。请你返回满足如下规则可以得到的最大整数：
 * <p>
 * 给当前结果添加一个数位（i + 1）的成本为 cost[i]（cost数组下标从 0 开始）。
 * 总成本必须恰好等于target。
 * 添加的数位中没有数字 0 。
 * 由于答案可能会很大，请你以字符串形式返回。
 * <p>
 * 如果按照上述要求无法得到任何整数，请你返回 "0" 。
 */
public class Solution {
    public String largestNumber(int[] cost, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;
        for (int c : cost) {
            for (int i = c; i <= target; i++) {
                dp[i] = Math.max(dp[i], 1 + dp[i - c]);
            }
        }
        int maxLength = dp[target];
        StringBuilder sb = new StringBuilder();
        int index = target;
        for (int i = maxLength - 1; i >= 0; i--) {
            for (int j = cost.length - 1; j >= 0; j--) {
                int c = cost[j];
                if (index < c || dp[index - c] != i) {
                    continue;
                }
                sb.append(j + 1);
                index -= c;
                break;
            }
        }
        String result = sb.toString();
        return result.equals("") ? "0" : result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.largestNumber(new int[]{6, 10, 15, 40, 40, 40, 40, 40, 40}, 47));
    }
}
