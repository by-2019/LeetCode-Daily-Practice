package day33.s374;

/**
 * 猜数字游戏的规则如下：
 * <p>
 * 每轮游戏，我都会从1到n 随机选择一个数字。 请你猜选出的是哪个数字。
 * 如果你猜错了，我会告诉你，你猜测的数字比我选出的数字是大了还是小了。
 * 你可以通过调用一个预先定义好的接口 int guess(int num) 来获取猜测结果，返回值一共有 3 种可能的情况（-1，1或 0）：
 * <p>
 * -1：我选出的数字比你猜的数字小 pick < num
 * 1：我选出的数字比你猜的数字大 pick > num
 * 0：我选出的数字和你猜的数字一样。恭喜！你猜对了！pick == num
 * 返回我选出的数字。
 */
public class Solution extends GuessGame {
    public Solution(int num) {
        super(num);
    }

    public int guessNumber(int n) {
        long low = 1;
        long high = n;
        while (low <= high) {
            int mid = (int) ((low + high) / 2);
            int guess = guess(mid);
            if (guess == 0) {
                return mid;
            } else if (guess == -1) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution(6);
        System.out.println(s.guessNumber(10));
    }
}
