package day19.s1190;

import java.util.Stack;

/**
 * 给出一个字符串s（仅含有小写英文字母和括号）。
 * <p>
 * 请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。
 * <p>
 * 注意，您的结果中 不应 包含任何括号。
 */
public class Solution {

    public String reverseParentheses(String s) {
        int[] pairs = new int[s.length()];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
                continue;
            }
            if (c == ')') {
                int left = stack.pop();
                pairs[left] = i;
                pairs[i] = left;
            }
        }

        StringBuilder sb = new StringBuilder();
        int index = 0;
        int step = 1;
        while (index < s.length()) {
            char c = s.charAt(index);
            if (c == '(' || c == ')') {
                index = pairs[index];
                step = -step;
            } else {
                sb.append(c);
            }
            index += step;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.reverseParentheses("sxmdll(q)eki(x)"));
    }
}
