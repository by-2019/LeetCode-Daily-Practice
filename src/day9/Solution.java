package day9;

import java.util.*;

/**
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 * <p>
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 */
class Solution {
    public String largestNumber(int[] nums) {
        List<String> ns = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            ns.add(String.valueOf(nums[i]));
        }
        ns.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (String s : ns) {
            sb.append(s);
        }
        String rs = sb.toString();
        if (rs.charAt(0) == '0')
            return "0";
        return rs;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.largestNumber(new int[]{0, 0}));
    }
}
