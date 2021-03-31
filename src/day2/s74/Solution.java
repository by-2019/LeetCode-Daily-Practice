package day2.s74;

/**
 * 编写一个高效的算法来判断m x n矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * <p>
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        if (target < matrix[0][0] || target > matrix[m - 1][n - 1])
            return false;
        int minLine = 0;
        int maxLine = m - 1;
        int midLine = (minLine + maxLine) / 2;
        while (minLine < maxLine) {
            int cmpNum = matrix[midLine][n - 1];
            if (cmpNum == target)
                return true;
            if (cmpNum > target)
                maxLine = midLine;
            else
                minLine = midLine + 1;
            midLine = (minLine + maxLine) / 2;
        }

        int minIndex = 0;
        int maxIndex = n - 1;
        int midIndex = (minIndex + maxIndex) / 2;
        while (minIndex < maxIndex) {
            int cmpNum = matrix[midLine][midIndex];
            if (cmpNum == target)
                return true;
            if (cmpNum > target)
                maxIndex = midIndex - 1;
            else
                minIndex = midIndex + 1;
            midIndex = (minIndex + maxIndex) / 2;
        }
        return target == matrix[midLine][midIndex];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 13));
    }
}
