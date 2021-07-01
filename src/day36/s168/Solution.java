package day36.s168;

/**
 * 给你一个整数 columnNumber ，返回它在 Excel 表中相对应的列名称。
 */
public class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        do {
            int m = (columnNumber - 1) % 26;
            sb.insert(0, (char) ('A' + m));
            columnNumber = (columnNumber - m) / 26;
        } while (columnNumber > 0);
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.convertToTitle(26));
    }
}
