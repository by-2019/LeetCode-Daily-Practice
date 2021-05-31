package day16.s342;

/**
 * 给定一个整数，写一个函数来判断它是否是 4 的幂次方。如果是，返回 true ；否则，返回 false 。
 * <p>
 * 整数 n 是 4 的幂次方需满足：存在整数 x 使得 n == 4x
 */
public class Solution {
    public boolean isPowerOfFour(int n) {
        return n > 0 && (n & (n - 1)) == 0 && (n & (0xaaaaaaaa)) == 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isPowerOfFour(1024));
    }
}
