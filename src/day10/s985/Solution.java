package day10.s985;

/**
 * 给出一个整数数组A和一个查询数组queries。
 * <p>
 * 对于第i次查询，有val =queries[i][0], index= queries[i][1]，我们会把val加到A[index]上。然后，第i次查询的答案是 A 中偶数值的和。
 * <p>
 * （此处给定的index = queries[i][1]是从 0 开始的索引，每次查询都会永久修改数组A。）
 * <p>
 * 返回所有查询的答案。你的答案应当以数组answer给出，answer[i]为第i次查询的答案。
 */
class Solution {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int curSum = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0)
                curSum += A[i];
        }
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int index = queries[i][1];
            if (A[index] % 2 == 0)
                curSum -= A[index];
            A[index] += queries[i][0];
            if (A[index] % 2 == 0)
                curSum += A[index];
            answer[i] = curSum;
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] answer = s.sumEvenAfterQueries(new int[]{1, 2, 3, 4}, new int[][]{{1, 0}, {-3, 1}, {-4, 0}, {2, 3}});
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < answer.length; i++) {
            sb.append(answer[i]).append(" ");
        }
        System.out.println(sb.toString());
    }
}
