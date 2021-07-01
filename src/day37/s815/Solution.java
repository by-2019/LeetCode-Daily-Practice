package day37.s815;

import java.util.*;

/**
 * 给你一个数组 routes ，表示一系列公交线路，其中每个 routes[i] 表示一条公交线路，第 i 辆公交车将会在上面循环行驶。
 * <p>
 * 例如，路线 routes[0] = [1, 5, 7] 表示第 0 辆公交车会一直按序列 1 -> 5 -> 7 -> 1 -> 5 -> 7 -> 1 -> ... 这样的车站路线行驶。
 * 现在从 source 车站出发（初始时不在公交车上），要前往 target 车站。 期间仅可乘坐公交车。
 * <p>
 * 求出 最少乘坐的公交车数量 。如果不可能到达终点车站，返回 -1 。
 */
public class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }
        Map<Integer, Set<Integer>> busSites = new HashMap<>();
        int max = 0;
        for (int i = 0; i < routes.length; i++) {
            for (int r : routes[i]) {
                Set<Integer> busRoutes = busSites.computeIfAbsent(r, k -> new HashSet<>());
                busRoutes.add(i);
                max = Math.max(max, r);
            }
        }

        int[] dp = new int[routes.length];
        Arrays.fill(dp, -1);

        Set<Integer> busRoutes = busSites.get(source);
        for (int depth = 1; !busRoutes.isEmpty(); depth++) {
            Set<Integer> nextSites = new HashSet<>();
            for (Integer busRoute : busRoutes) {
                if (dp[busRoute] != -1 && dp[busRoute] <= depth) {
                    continue;
                }
                dp[busRoute] = depth;
                for (int r : routes[busRoute]) {
                    if (r == target) {
                        return depth;
                    }
                    nextSites.add(r);
                }
            }
            busRoutes = new HashSet<>();
            for (Integer nextSite : nextSites) {
                busRoutes.addAll(busSites.get(nextSite));
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.numBusesToDestination(new int[][]{{1, 2, 7}, {3, 6, 7}}, 1, 6));
    }
}