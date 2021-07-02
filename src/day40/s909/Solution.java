package day40.s909;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * N x N 的棋盘board 上，按从1 到 N*N的数字给方格编号，编号 从左下角开始，每一行交替方向。
 * <p>
 * r 行 c 列的棋盘，按前述方法编号，棋盘格中可能存在 “蛇” 或 “梯子”；如果 board[r][c] != -1，那个蛇或梯子的目的地将会是 board[r][c]。
 * <p>
 * 玩家从棋盘上的方格1 （总是在最后一行、第一列）开始出发。
 * <p>
 * 每一回合，玩家需要从当前方格 x 开始出发，按下述要求前进：
 * <p>
 * 选定目标方格：从编号为 x+1，x+2，x+3，x+4，x+5，或者 x+6 的方格中选出一个作为目标方格 s ，目标方格的编号 <= N*N。
 * 该选择模拟了掷骰子的情景，无论棋盘大小如何，你的目的地范围也只能处于区间 [x+1, x+6] 之间。
 * 传送玩家：如果目标方格 S 处存在蛇或梯子，那么玩家会传送到蛇或梯子的目的地。否则，玩家传送到目标方格 S 。
 * 注意，玩家在每回合的前进过程中最多只能爬过蛇或梯子一次：就算目的地是另一条蛇或梯子的起点，你也不会继续移动。
 * <p>
 * 返回达到方格 N*N 所需的最少移动次数，如果不可能，则返回 -1。
 */
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
