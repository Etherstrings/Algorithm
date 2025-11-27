package TanXin;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Justice_wby
 * @create 2023-02-04 13:41
 */
public class L1798 {

    public int getMaximumConsecutive(int[] coins) {
        int nowrage=0;
        Arrays.sort(coins);
        for(int c:coins){
            if(c>nowrage+1){
                break;
            }
            nowrage+=c;
        }
        return nowrage+1;
    }
    public int getMaximumConsecutive1(int[] coins) {
        if(coins==null){
            return 0;
        }
        int now=0;
        Set<Integer> set=new HashSet<>();
        set.add(now);
        for(int i=0;i<coins.length;i++){
            now+=coins[i];
            set.add(now);
        }
        int ans=0;
        for(int i=0;i<=set.size();i++){
            if(set.contains(i)){
                ans++;
            }else {
                break;
            }
        }
        return ans;
    }
}
