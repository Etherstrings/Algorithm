import java.util.HashMap;
import java.util.Map;

/**
 * @author Justice_wby
 * @create 2023-01-28 11:52
 */
public class L1664 {
    public int waysToMakeFair(int[] nums) {
        int ans=0;

        int ou=0;
        int ji=0;

        //奇数和 偶数和
        Map<Integer,int[]> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(i,new int[]{ji,ou});
            if(i%2==0){
                ou+=nums[i];
            }else {
                ji+=nums[i];
            }
        }
        //通过HashMap来进行设定
        //i 前i-1项和
        for(int i=0;i<nums.length;i++){
            if(i%2==0){
                //当前删除的为偶数
                //剩下的偶数
                int leftou=ou-nums[i]-map.get(i)[1];
                int leftji=ji-map.get(i)[0];

                if(map.get(i)[0]+leftou==leftji+map.get(i)[1]){
                    ans++;
                }
            }else {
                //当前删除的为奇数
                int leftji=ji-map.get(i)[0]-nums[i];
                int leftou=ou-map.get(i)[1];
                if(map.get(i)[0]+leftou==leftji+map.get(i)[1]){
                    ans++;
                }
            }
        }
        return ans;

    }

}
