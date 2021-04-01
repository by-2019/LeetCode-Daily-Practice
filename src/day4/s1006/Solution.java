package day4.s1006;

/**
 * 通常，正整数 n 的阶乘是所有小于或等于 n 的正整数的乘积。例如，factorial(10) = 10 * 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2 * 1。
 * <p>
 * 相反，我们设计了一个笨阶乘 clumsy：在整数的递减序列中，我们以一个固定顺序的操作符序列来依次替换原有的乘法操作符：乘法(*)，除法(/)，加法(+)和减法(-)。
 * <p>
 * 例如，clumsy(10) = 10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1。然而，这些运算仍然使用通常的算术运算顺序：我们在任何加、减步骤之前执行所有的乘法和除法步骤，并且按从左到右处理乘法和除法步骤。
 * <p>
 * 另外，我们使用的除法是地板除法（floor division），所以10 * 9 / 8等于11。这保证结果是一个整数。
 * <p>
 * 实现上面定义的笨函数：给定一个整数 N，它返回 N 的笨阶乘。
 */
class Solution {
    public int clumsy(int N) {
        int sum = N--;
        if (N <= 0)
            return sum;
        sum *= N--;
        if (N <= 0)
            return sum;
        sum /= N--;
        if (N <= 0)
            return sum;
        sum += N--;
        if (N <= 0)
            return sum;
        return sum -= subClumsy(N);
    }

    private int subClumsy(int N) {
        int sum = N--;
        if (N <= 0)
            return sum;
        sum *= N--;
        if (N <= 0)
            return sum;
        sum /= N--;
        if (N <= 0)
            return sum;
        sum -= N--;
        if (N <= 0)
            return sum;
        return sum += subClumsy(N);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.clumsy(12));
    }
}
