package day33.s374;

public class GuessGame {
    int num;

    public GuessGame(int num) {
        this.num = num;
    }

    /**
     * Forward declaration of guess API.
     * @param  num   your guess
     * @return 	     -1 if num is lower than the guess number
     *			      1 if num is higher than the guess number
     *               otherwise return 0
     */
    int guess(int num) {
        return Integer.compare(this.num, num);
    }
}
