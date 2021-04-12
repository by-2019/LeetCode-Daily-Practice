package day9.s529;

/**
 * 让我们一起来玩扫雷游戏！
 * <p>
 * 给定一个代表游戏板的二维字符矩阵。'M'代表一个未挖出的地雷，'E'代表一个未挖出的空方块，'B'代表没有相邻（上，下，左，右，和所有4个对角线）地雷的已挖出的空白方块，数字（'1' 到 '8'）表示有多少地雷与这块已挖出的方块相邻，'X'则表示一个已挖出的地雷。
 * <p>
 * 现在给出在所有未挖出的方块中（'M'或者'E'）的下一个点击位置（行和列索引），根据以下规则，返回相应位置被点击后对应的面板：
 * <p>
 * 如果一个地雷（'M'）被挖出，游戏就结束了- 把它改为'X'。
 * 如果一个没有相邻地雷的空方块（'E'）被挖出，修改它为（'B'），并且所有和其相邻的未挖出方块都应该被递归地揭露。
 * 如果一个至少与一个地雷相邻的空方块（'E'）被挖出，修改它为数字（'1'到'8'），表示相邻地雷的数量。
 * 如果在此次点击中，若无更多方块可被揭露，则返回面板。
 */
class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        int row = click[0];
        int col = click[1];
        if (board[row][col] == 'M') {
            board[row][col] = 'X';
            return board;
        }
        updateBoard(board, row, col, board.length, board[0].length);
        return board;
    }

    public void updateBoard(char[][] board, int row, int col, int maxRow, int maxCol) {
        if (row < 0 || row >= maxRow || col < 0 || col >= maxCol)
            return;
        if (board[row][col] != 'E')
            return;
        int landmineNum = 0;
        if (row - 1 >= 0) {
            if (col - 1 >= 0 && board[row - 1][col - 1] == 'M')
                landmineNum++;
            if (board[row - 1][col] == 'M')
                landmineNum++;
            if (col + 1 < maxCol && board[row - 1][col + 1] == 'M')
                landmineNum++;
        }
        if (col - 1 >= 0 && board[row][col - 1] == 'M')
            landmineNum++;
        if (col + 1 < maxCol && board[row][col + 1] == 'M')
            landmineNum++;
        if (row + 1 < maxRow) {
            if (col - 1 >= 0 && board[row + 1][col - 1] == 'M')
                landmineNum++;
            if (board[row + 1][col] == 'M')
                landmineNum++;
            if (col + 1 < maxCol && board[row + 1][col + 1] == 'M')
                landmineNum++;
        }
        if (landmineNum != 0) {
            board[row][col] = (char) ('0' + landmineNum);
            return;
        }
        board[row][col] = 'B';
        updateBoard(board, row - 1, col - 1, maxRow, maxCol);
        updateBoard(board, row - 1, col, maxRow, maxCol);
        updateBoard(board, row - 1, col + 1, maxRow, maxCol);
        updateBoard(board, row, col - 1, maxRow, maxCol);
        updateBoard(board, row, col + 1, maxRow, maxCol);
        updateBoard(board, row + 1, col - 1, maxRow, maxCol);
        updateBoard(board, row + 1, col, maxRow, maxCol);
        updateBoard(board, row + 1, col + 1, maxRow, maxCol);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        char[][] rs = s.updateBoard(new char[][]{{'E', 'E', 'E', 'E', 'E'}, {'E', 'E', 'M', 'E', 'E'}, {'E', 'E', 'E', 'E', 'E'}, {'E', 'E', 'E', 'E', 'E'}}, new int[]{3, 0});
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rs.length; i++) {
            char[] r = rs[i];
            for (int j = 0; j < r.length; j++) {
                sb.append(r[j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
