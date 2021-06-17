package day35.s65;

/**
 * 有效数字（按顺序）可以分成以下几个部分：
 *
 * 一个 小数 或者 整数
 * （可选）一个 'e' 或 'E' ，后面跟着一个 整数
 * 小数（按顺序）可以分成以下几个部分：
 *
 * （可选）一个符号字符（'+' 或 '-'）
 * 下述格式之一：
 * 至少一位数字，后面跟着一个点 '.'
 * 至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字
 * 一个点 '.' ，后面跟着至少一位数字
 * 整数（按顺序）可以分成以下几个部分：
 *
 * （可选）一个符号字符（'+' 或 '-'）
 * 至少一位数字
 * 部分有效数字列举如下：
 *
 * ["2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789"]
 * 部分无效数字列举如下：
 *
 * ["abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53"]
 * 给你一个字符串 s ，如果 s 是一个 有效数字 ，请返回 true 。
 */
public class Solution {
    public boolean isNumber(String s) {
        // sign number dot e
        boolean[] flags = new boolean[]{true, true, true, true};
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '+' || c == '-') {
                if (!flags[0]) {
                    return false;
                }
                flags[0] = false;
            } else if (c >= '0' && c <= '9') {
                flags[0] = false;
                flags[1] = false;
            } else if (c =='.') {
                if (!flags[2]) {
                    return false;
                }
                flags[0] = false;
                flags[2] = false;
            } else if (c == 'e' || c == 'E') {
                if (flags[1] || !flags[3]) {
                    return false;
                }
                flags[0] = true;
                flags[1] = true;
                flags[2] = false;
                flags[3] = false;
            } else {
                return false;
            }
        }
        return !flags[1];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isNumber(".0e7"));
    }
}
