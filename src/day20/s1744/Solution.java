package day20.s1744;

import java.util.Arrays;

/**
 * 给你一个下标从 0 开始的正整数数组candiesCount，其中candiesCount[i]表示你拥有的第i类糖果的数目。同时给你一个二维数组queries，其中queries[i] = [favoriteTypei, favoriteDayi, dailyCapi]。
 * <p>
 * 你按照如下规则进行一场游戏：
 * <p>
 * 你从第0天开始吃糖果。
 * 你在吃完 所有第 i - 1类糖果之前，不能吃任何一颗第 i类糖果。
 * 在吃完所有糖果之前，你必须每天 至少吃 一颗糖果。
 * 请你构建一个布尔型数组answer，满足answer.length == queries.length 。answer[i]为true的条件是：在每天吃 不超过 dailyCapi颗糖果的前提下，你可以在第favoriteDayi天吃到第favoriteTypei类糖果；否则 answer[i]为 false。注意，只要满足上面 3 条规则中的第二条规则，你就可以在同一天吃不同类型的糖果。
 * <p>
 * 请你返回得到的数组answer。
 */
public class Solution {
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        long[] total = new long[candiesCount.length + 1];
        total[0] = 0;
        for (int i = 0; i < candiesCount.length; i++) {
            total[i + 1] = candiesCount[i] + total[i];
        }
        boolean[] answer = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            answer[i] = canEat(total, query);
        }
        return answer;
    }

    private boolean canEat(long[] total, int[] query) {
        long maxEat = (long) (query[1] + 1) * query[2];
        long leastNeedEat = total[query[0]];
        if (maxEat <= leastNeedEat) {
            return false;
        }
        int leastEat = query[1];
        long maxLimitEat = total[query[0] + 1];
        if (leastEat >= maxLimitEat) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.canEat(new int[]{16, 38, 8, 41, 30, 31, 14, 45, 3, 2, 24, 23, 38, 30, 31, 17, 35, 4, 9, 42, 28, 18, 37, 18, 14, 46, 11, 13, 19, 3, 5, 39, 24, 48, 20, 29, 4, 19, 36, 11, 28, 49, 38, 16, 23, 24, 4, 22, 29, 35, 45, 38, 37, 40, 2, 37, 8, 41, 33, 8, 40, 27, 13, 4, 33, 5, 8, 14, 19, 35, 31, 8, 8}, new int[][]{{43, 1054, 49}})));
    }
}
