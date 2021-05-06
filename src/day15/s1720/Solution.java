package day15.s1720;

import java.util.Arrays;

/**
 * 未知 整数数组 arr 由 n 个非负整数组成。
 * <p>
 * 经编码后变为长度为 n - 1 的另一个整数数组 encoded ，其中 encoded[i] = arr[i] XOR arr[i + 1] 。例如，arr = [1,0,2,1] 经编码后得到 encoded = [1,2,3] 。
 * <p>
 * 给你编码后的数组 encoded 和原数组 arr 的第一个元素 first（arr[0]）。
 * <p>
 * 请解码返回原数组 arr 。可以证明答案存在并且是唯一的。
 */
class Solution {
    public int[] decode(int[] encoded, int first) {
        int[] rs = new int[encoded.length + 1];
        rs[0] = first;
        for (int i = 0; i < encoded.length; i++) {
            rs[i + 1] = rs[i] ^ encoded[i];
        }
        return rs;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.decode(new int[]{6, 2, 7, 3}, 4)));
    }
}
