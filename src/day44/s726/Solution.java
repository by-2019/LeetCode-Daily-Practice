package day44.s726;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 给定一个化学式formula（作为字符串），返回每种原子的数量。
 * <p>
 * 原子总是以一个大写字母开始，接着跟随0个或任意个小写字母，表示原子的名字。
 * <p>
 * 如果数量大于 1，原子后会跟着数字表示原子的数量。如果数量等于 1 则不会跟数字。例如，H2O 和 H2O2 是可行的，但 H1O2 这个表达是不可行的。
 * <p>
 * 两个化学式连在一起是新的化学式。例如H2O2He3Mg4 也是化学式。
 * <p>
 * 一个括号中的化学式和数字（可选择性添加）也是化学式。例如 (H2O2) 和 (H2O2)3 是化学式。
 * <p>
 * 给定一个化学式formula ，返回所有原子的数量。格式为：第一个（按字典序）原子的名字，跟着它的数量（如果数量大于 1），然后是第二个原子的名字（按字典序），跟着它的数量（如果数量大于 1），以此类推。
 */
public class Solution {
    public String countOfAtoms(String formula) {
        formula = "(" + formula + ")";
        Map<String, Integer> atomNums = new TreeMap<>();
        dealBrackets(atomNums, formula, 0);
        StringBuilder rs = new StringBuilder();
        for (Map.Entry<String, Integer> entry : atomNums.entrySet()) {
            rs.append(entry.getKey());
            Integer num = entry.getValue();
            if (num > 1) {
                rs.append(num);
            }
        }
        return rs.toString();
    }

    private int dealBrackets(Map<String, Integer> atomNums, String formula, int leftBracketsIndex) {
        int rightBracketsIndex = leftBracketsIndex + 1;
        Map<String, Integer> tmps = new HashMap<>();
        StringBuilder atomName = new StringBuilder();
        StringBuilder number = new StringBuilder();
        for (; rightBracketsIndex < formula.length(); rightBracketsIndex++) {
            char c = formula.charAt(rightBracketsIndex);
            if (isBigAlphabet(c)) {
                // 先把上一个存入
                String name = atomName.toString();
                if (!name.equals("")) {
                    Integer old = tmps.getOrDefault(name, 0);
                    String num = number.toString();
                    int add = num.equals("") ? 1 : Integer.parseInt(num);
                    tmps.put(name, add + old);
                }
                atomName = new StringBuilder().append(c);
                number = new StringBuilder();
                continue;
            }
            if (isLittleAlphabet(c)) {
                atomName.append(c);
                continue;
            }
            if (isNumber(c)) {
                number.append(c);
                continue;
            }
            if (isLeftBrackets(c)) {
                int length = dealBrackets(tmps, formula, rightBracketsIndex);
                rightBracketsIndex += length;
                continue;
            }
            if (isRightBrackets(c)) {
                // 最后一个填进去
                String name = atomName.toString();
                if (!name.equals("")) {
                    Integer old = tmps.getOrDefault(name, 0);
                    String num = number.toString();
                    int add = num.equals("") ? 1 : Integer.parseInt(num);
                    tmps.put(name, add + old);
                }
                StringBuilder m = new StringBuilder();
                for (int i = rightBracketsIndex + 1; i < formula.length(); i++, rightBracketsIndex++) {
                    char n = formula.charAt(i);
                    if (!isNumber(n)) {
                        break;
                    }
                    m.append(n);
                }
                String multi = m.toString();
                int multiple = 1;
                if (!"".equals(multi)) {
                    multiple = Integer.parseInt(multi);
                }
                for (Map.Entry<String, Integer> entry : tmps.entrySet()) {
                    Integer old = atomNums.getOrDefault(entry.getKey(), 0);
                    atomNums.put(entry.getKey(), entry.getValue() * multiple + old);
                }
                break;
            }
        }
        return rightBracketsIndex - leftBracketsIndex;
    }

    private boolean isBigAlphabet(char c) {
        return c >= 'A' && c <= 'Z';
    }

    private boolean isLittleAlphabet(char c) {
        return c >= 'a' && c <= 'z';
    }

    private boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }

    private boolean isLeftBrackets(char c) {
        return c == '(';
    }

    private boolean isRightBrackets(char c) {
        return c == ')';
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.countOfAtoms("K4(ON(SO3)2)2"));
    }
}
