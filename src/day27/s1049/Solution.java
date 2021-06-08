package day27.s1049;

/**
 * 有一堆石头，用整数数组stones 表示。其中stones[i] 表示第 i 块石头的重量。
 * <p>
 * 每一回合，从中选出任意两块石头，然后将它们一起粉碎。假设石头的重量分别为x 和y，且x <= y。那么粉碎的可能结果如下：
 * <p>
 * 如果x == y，那么两块石头都会被完全粉碎；
 * 如果x != y，那么重量为x的石头将会完全粉碎，而重量为y的石头新重量为y-x。
 * 最后，最多只会剩下一块 石头。返回此石头 最小的可能重量 。如果没有石头剩下，就返回 0。
 */
public class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        int mid = sum / 2;
        boolean[] dp = new boolean[mid + 1];
        dp[0] = true;
        for (int stone : stones) {
            for (int i = mid; i >= stone; i--) {
                dp[i] = dp[i] || dp[i - stone];
            }
        }
        for (int i = mid; i >= 0; i--) {
            if (dp[i]) {
                return sum - 2 * i;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.lastStoneWeightII(new int[]{2, 7, 4, 1, 8, 1}));
    }
}
