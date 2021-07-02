package day41.s1833;

/**
 * 夏日炎炎，小男孩 Tony 想买一些雪糕消消暑。
 * <p>
 * 商店中新到 n 支雪糕，用长度为 n 的数组 costs 表示雪糕的定价，其中 costs[i] 表示第 i 支雪糕的现金价格。Tony 一共有 coins 现金可以用于消费，他想要买尽可能多的雪糕。
 * <p>
 * 给你价格数组 costs 和现金量 coins ，请你计算并返回 Tony 用 coins 现金能够买到的雪糕的 最大数量 。
 * <p>
 * 注意：Tony 可以按任意顺序购买雪糕。
 */
public class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int max = Integer.MIN_VALUE;
        for (int cost : costs) {
            max = Math.max(max, cost);
        }
        int[] sortedCosts = new int[max + 1];
        for (int cost : costs) {
            sortedCosts[cost]++;
        }
        int sum = 0;
        for (int i = 1; i <= max; i++) {
            if (coins < i) {
                break;
            }
            int count = Math.min(sortedCosts[i], coins / i);
            sum += count;
            coins -= i * count;
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxIceCream(new int[]{4, 7, 6, 4, 4, 2, 2, 4, 8, 8}, 41));
    }
}
