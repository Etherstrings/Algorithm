package HASH;
import java.util.*;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2023-11-24
 */
public class L2507 {
    public static void main(String[] args) {
        System.out.println(smallestValue(12));
    }

    public static int smallestValue(int n) {
        if (n == 4)
            return 4;
        // 判断n是否为质数
        if (isPrime(n)) {
            return n;
        }
        // 将n用质数分解
        int[] prime = new int[200];
        int[] count = new int[200];
        int index = 0;
        int sum = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                while (n % i == 0) {
                    prime[index] = i;
                    count[index]++;
                    n /= i;
                }
                sum += count[index] * prime[index];
                index++;
            }
        }
        return smallestValue(sum);
    }

    static boolean isPrime(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }



}
