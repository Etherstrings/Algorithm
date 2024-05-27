package Moni;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2024-05-27
 */
public class L2028 {
    //4,2,2,5,4,5,4,5,3,3,6,1,2,4,2,1,6,5,4,2,3,4,2,3,3,5,4,1,4,4,5,3,6,1,5,2,3,3,6,1,6,4,1,3
    //2
    //53
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] rolls = in.nextLine().split(",");
        int[] rollsInt = new int[rolls.length];
        for (int i = 0; i < rolls.length; i++) {
            rollsInt[i] = Integer.parseInt(rolls[i]);
        }
        int mean = in.nextInt();
        int n = in.nextInt();
        int[] res = missingRolls(rollsInt, mean, n);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
    public static int[] missingRolls(int[] rolls, int mean, int n) {
        //最大值不到10的7次方
        //总和可以用Int存
        int m = rolls.length;
        int sum = mean * (m + n);
        for (int roll : rolls) {
            sum -= roll;
        }
        if (sum <= 0 || sum > 6 * n) {
            return new int[0];
        }
        if (n>sum){
            return new int[0];
        }
        int[] ans = new int[n];
        //把剩下的数，先按个平均分配一下
        Arrays.fill(ans, sum / n);
        sum = sum % n;
        //只要有一个超过6了 就有问题，要不然就按照最大值加一下
        for (int i = 0; i < n; i++) {
            if (sum > 0) {
                int canadd = Math.min(6 - ans[i], sum);
                ans[i] += canadd;
                sum -= canadd;
            }
        }
        if(sum > 0){
            return new int[0];
        }
        return ans;
    }
}
