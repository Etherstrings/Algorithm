package src;

/**
 * @author Etherstrings
 * @create 2022-01-31 17:18
 */
public class L1342 {

    /**
     * 1342. 将数字变成 0 的操作次数
     * 给你一个非负整数 num ，请你返回将它变成 0 所需要的步数。
     * 如果当前数字是偶数，你需要把它除以 2 ；否则，减去 1 。
     */

    public int numberOfSteps(int num) {
        if (num == 0) {
            return 0;
        }
        int times = 0;
        while (num != 0) {
            if (num % 2 == 0) {
                num = num / 2;
                times++;
            } else {
                num = num - 1;
                times++;
            }
        }
        return times;
    }
}
