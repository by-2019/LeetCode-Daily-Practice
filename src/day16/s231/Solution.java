package day16.s231;

/**
 * 给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
 *
 * 如果存在一个整数 x 使得n == 2x ，则认为 n 是 2 的幂次方。
 */
public class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isPowerOfTwo(1024));
    }
}
