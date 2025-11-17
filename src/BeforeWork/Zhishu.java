import StringExer.Try;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Zhishu {
    public static List<Integer> findPrime(Zhishu z){
        List<Integer> list = new ArrayList<>(100000);
        for (int n = 2; n < 1000000; n++) {
            boolean isP = true;
            int sqrt = (int) Math.sqrt(n);
            for (int i = 2; i <= sqrt; i++) {
                if (n % i == 0) {
                    isP = false;
                    break;
                }
            }
            if (isP) {
                list.add(n);
            }
        }
        return list;
    }


    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        double[] arr = new double[m + n];
        //两数组索引
        int p = 0;
        int q = 0;
        //合并两数组
        for (int i = 0; i < m + n; i++) {
            //两数组都没有合并完
            if (q < n && p < m) {
                if (nums1[p] < nums2[q]) {
                    arr[i] = nums1[p];
                    p++;
                } else {
                    arr[i] = nums2[q];
                    q++;
                }
                continue;
            }
            //合并nums2剩余部分，p>=m表示nums1合并结束
            if (p >= m && q < n) {
                arr[i] = nums2[q];
                q++;
            }
            if (q >= n && p < m) {
                arr[i] = nums1[p];
                p++;
            }
        }
        if ((n + m) % 2 == 1) {
            return arr[(m + n) / 2];
        } else {
            return (arr[(m + n) / 2] + arr[(m + n) / 2 - 1])/2;
        }

}



}
