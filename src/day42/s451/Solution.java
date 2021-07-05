package day42.s451;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 */
public class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> nums = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer old = nums.getOrDefault(c, 0);
            nums.put(c, old + 1);
        }
        List<Character> chars = new ArrayList<>(nums.keySet());
        chars.sort((a, b) -> nums.get(b) - nums.get(a));

        StringBuilder sb = new StringBuilder();
        for (Character c : chars) {
            for (int j = 0; j < nums.get(c); j++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.frequencySort("tree"));
    }
}
