/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2023-11-29
 */
import java.util.*;
public class L2789 {
    public static void main(String[] args) {
        //2,3,7,9,3
        System.out.println(maxArrayValue(new int[]{5,3,3}));
    }
    public static long maxArrayValue(int[] nums) {
        //将所有连续递增的都合并
        //再判断所有递增的是否可以再合并
        List<Long> temp = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            temp.add((long)nums[i]);
        }
        //判断这一轮是否可以合并
        boolean flag = true;
        long ans = 0;
        while(flag){
            flag=false;
            long tempsum = temp.get(0);
            List<Long> nextround = new ArrayList<>();
            for(int i=1;i<temp.size();i++){
                long now = temp.get(i);
                long pre = temp.get(i-1);
                if(i==temp.size()-1){
                    if(now>=pre){
                        tempsum += now;
                        nextround.add(tempsum);
                        ans= Math.max(ans,tempsum);
                        flag=true;
                    }else {
                        nextround.add(tempsum);
                        ans= Math.max(ans,tempsum);
                        nextround.add(now);
                        ans= Math.max(ans,now);
                    }
                    continue;
                }
                if(i==1){
                    if(now>=pre){
                        tempsum += now;
                        flag = true;
                    }else {
                        nextround.add(tempsum);
                        ans= Math.max(ans,tempsum);
                        tempsum = now;
                    }
                    continue;
                }

                if(now>=pre){
                    tempsum += now;
                    flag=true;
                }else {
                    nextround.add(tempsum);
                    ans= Math.max(ans,tempsum);
                    tempsum = now;
                }
            }
            temp = nextround;
        }
        return ans;
    }

    public long tmaxArrayValue(int[] nums) {
        int len = nums.length;
        long max = nums[len -1];
        for (int i = len - 2; i >= 0; i--) {
            max = (max >= nums[i] ? max + nums[i] : nums[i]);
        }
        return max;
    }
}
