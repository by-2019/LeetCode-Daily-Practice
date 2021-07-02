package day40.s909;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int total = n * n;

        boolean[] vis = new boolean[total + 1];
        vis[1] = true;
        int[] dp = new int[total + 1];

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        while (!queue.isEmpty()) {
            Integer number = queue.poll();
            for (int i = number + 1; i <= number + 6 && i <= total; i++) {
                int x = getX(n, i);
                int y = getY(x, n, i);
                int next = board[x][y] == -1 ? i : board[x][y];
                if (next == total) {
                    return dp[number] + 1;
                }
                if (!vis[next]) {
                    vis[next] = true;
                    dp[next] = dp[number] + 1;
                    queue.add(next);
                }
            }
        }
        return -1;
    }

    private int getX(int max, int number) {
        return max - 1 - (number - 1) / max;
    }

    private int getY(int x, int max, int number) {
        if (x % 2 == max % 2) {
            // 逆序的
            return (max - x) * max - number;
        }
        return number - (max - 1 - x) * max - 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.snakesAndLadders(new int[][]{{-1, -1, 19, 10, -1}, {2, -1, -1, 6, -1}, {-1, 17, -1, 19, -1}, {25, -1, 20, -1, -1}, {-1, -1, -1, -1, 15}}));
    }
}
