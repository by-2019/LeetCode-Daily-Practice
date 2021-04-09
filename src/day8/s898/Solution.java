package day8.s898;

import java.util.HashSet;
import java.util.Set;

/**
 * 我们有一个非负整数数组A。
 * <p>
 * 对于每个（连续的）子数组B =[A[i], A[i+1], ..., A[j]] （i <= j），我们对B中的每个元素进行按位或操作，获得结果A[i] | A[i+1] | ... | A[j]。
 * <p>
 * 返回可能结果的数量。 （多次出现的结果在最终答案中仅计算一次。）
 */
class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> results = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            results.add(arr[i]);
            for (int j = i - 1; j >= 0; j--) {
                if ((arr[j] | arr[i]) == arr[j])
                    break;
                arr[j] |= arr[i];
                results.add(arr[j]);
            }
        }
        return results.size();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.subarrayBitwiseORs(new int[]{1, 2, 4}));
    }
}