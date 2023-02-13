package leetcode.week326;

import java.util.HashSet;
import java.util.Set;

public class L6279 {
    public int distinctPrimeFactors(int[] nums) {
        Set<Long> set = new HashSet<>();
        for (int num : nums) {
            set.addAll(primeFactors(num));
        }
        return set.size();
    }

    private Set<Long> primeFactors(long m) {
        Set<Long> set = new HashSet<>();
        long k = 2;
        while (k <= m) {
            if (m == k) {
                set.add(k);
                break;
            } else if (m % k == 0) {
                set.add(k);
                m = m / k;
            } else {
                k++;
            }
        }
        return set;
    }
}
