package day46.s1711;

import java.util.HashMap;
import java.util.Map;

/**
 * 大餐 是指 恰好包含两道不同餐品 的一餐，其美味程度之和等于 2 的幂。
 * <p>
 * 你可以搭配 任意 两道餐品做一顿大餐。
 * <p>
 * 给你一个整数数组 deliciousness ，其中 deliciousness[i] 是第 i 道餐品的美味程度，返回你可以用数组中的餐品做出的不同 大餐 的数量。结果需要对 10^9 + 7 取余。
 * <p>
 * 注意，只要餐品下标不同，就可以认为是不同的餐品，即便它们的美味程度相同。
 */
public class Solution {
    public int countPairs(int[] deliciousness) {
        Map<Integer, Integer> deliNums = new HashMap<>();
        for (int deli : deliciousness) {
            Integer old = deliNums.getOrDefault(deli, 0);
            deliNums.put(deli, old + 1);
        }

        long sum = 0;
        int num = 1;
        while (num <= Math.pow(2, 21)) {
            for (int delicious : deliciousness) {
                if (delicious > num) {
                    continue;
                }
                int diff = num - delicious;
                sum += deliNums.getOrDefault(diff, 0) - (delicious == diff ? 1 : 0);
            }
            num <<= 1;
        }
        int mod = (int) (Math.pow(10, 9) + 7);
        return (int) ((sum / 2) % mod);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] tests = new int[100000];
        for (int i = 0; i < 100000; i++) {
            tests[i] = 32;
        }
        System.out.println(s.countPairs(tests));
    }
}
