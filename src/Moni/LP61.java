package Moni;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2024-06-21
 */
public class LP61 {
    public static void main(String[] args) {
        //21,18,18,18,31
        int[] A = {21,18,18,18,31};
        //34,32,16,16,17
        int[] B = {34,32,16,16,17};
        System.out.println(temperatureTrend(A, B));
    }
    public static int temperatureTrend(int[] temperatureA, int[] temperatureB) {
        int n = temperatureA.length;
        int m = temperatureB.length;
        if ( n == 0 || m == 0) {
            return 0;
        }
        if ( n == 1 || m == 1) {
            return 1;
        }
        int ans = 0;
        int temp = 0;
        for (int i = 1; i< n; i++) {
            int A = temperatureA[i] - temperatureA[i-1];
            int B = temperatureB[i] - temperatureB[i-1];
            if (i == n-1 ){
                if ( A > 0 && B >0 ){
                    temp++;
                    ans = Math.max(ans, temp);
                } else if ( A < 0 && B < 0) {
                    temp++;
                    ans = Math.max(ans, temp);
                } else if ( A == 0 && B == 0) {
                    temp++;
                    ans = Math.max(ans, temp);
                } else {
                    ans = Math.max(ans, temp);
                    temp = 0;
                }
                break;
            }
            if ( A > 0 && B >0 ){
                temp++;
            } else if ( A < 0 && B < 0) {
                temp++;
            } else if ( A == 0 && B == 0) {
                temp++;
            } else {
                ans = Math.max(ans, temp);
                temp = 0;
            }
        }
        return ans;
    }
}
