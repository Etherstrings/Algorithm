package Moni;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2023-10-13
 */
public class L1488 {
    //你的国家有无数个湖泊，所有湖泊一开始都是空的。当第 n 个湖泊下雨前是空的，那么它就会装满水。如果第 n 个湖泊下雨前是 满的 ，这个湖泊会发生 洪水 。你的目标是避免任意一个湖泊发生洪水。
    //
    //给你一个整数数组 rains ，其中：
    //
    //rains[i] > 0 表示第 i 天时，第 rains[i] 个湖泊会下雨。
    //rains[i] == 0 表示第 i 天没有湖泊会下雨，你可以选择 一个 湖泊并 抽干 这个湖泊的水。
    //请返回一个数组 ans ，满足：
    //
    //ans.length == rains.length
    //如果 rains[i] > 0 ，那么ans[i] == -1 。
    //如果 rains[i] == 0 ，ans[i] 是你第 i 天选择抽干的湖泊。
    //如果有多种可行解，请返回它们中的 任意一个 。如果没办法阻止洪水，请返回一个 空的数组 。
    //
    //请注意，如果你选择抽干一个装满水的湖泊，它会变成一个空的湖泊。但如果你选择抽干一个空的湖泊，那么将无事发生。
    //
    //示例 1：
    //
    //输入：rains = [1,2,3,4]
    //输出：[-1,-1,-1,-1]
    //解释：第一天后，装满水的湖泊包括 [1]
    //第二天后，装满水的湖泊包括 [1,2]
    //第三天后，装满水的湖泊包括 [1,2,3]
    //第四天后，装满水的湖泊包括 [1,2,3,4]
    //没有哪一天你可以抽干任何湖泊的水，也没有湖泊会发生洪水。
    //示例 2：
    //
    //输入：rains = [1,2,0,0,2,1]
    //输出：[-1,-1,2,1,-1,-1]
    //解释：第一天后，装满水的湖泊包括 [1]
    //第二天后，装满水的湖泊包括 [1,2]
    //第三天后，我们抽干湖泊 2 。所以剩下装满水的湖泊包括 [1]
    //第四天后，我们抽干湖泊 1 。所以暂时没有装满水的湖泊了。
    //第五天后，装满水的湖泊包括 [2]。
    //第六天后，装满水的湖泊包括 [1,2]。
    //可以看出，这个方案下不会有洪水发生。同时， [-1,-1,1,2,-1,-1] 也是另一个可行的没有洪水的方案。
    //示例 3：
    //
    //输入：rains = [1,2,0,1,2]
    //输出：[]
    //解释：第二天后，装满水的湖泊包括 [1,2]。我们可以在第三天抽干一个湖泊的水。
    //但第三天后，湖泊 1 和 2 都会再次下雨，所以不管我们第三天抽干哪个湖泊的水，另一个湖泊都会发生洪水。
    public static void main(String[] args) {
        int[] rains={1,2,0,1,2};
        int[] ans=avoidFlood(rains);
        for(int i=0;i<ans.length;i++){
            System.out.print(ans[i]+" ");
        }
        System.out.println();
    }
    public static int[] avoidFlood(int[] rains) {
        //湖泊编号-注水次数
        //只维护注水次数大于等于2的湖泊
        //如果注水次数为1，那就是不用管的湖泊
        int cansuck=0;
        Map<Integer,Integer> map_first=new HashMap<>();
        Map<Integer,Integer> map_second=new HashMap<>();
        int[] ans=new int[rains.length];
        for(int i=0;i<rains.length;i++){
            int rainkey=rains[i];
            if(rainkey==0){
                cansuck++;
                ans[i]=0;
            }else {
                //当前某个湖泊降水
                if(map_first.containsKey(rainkey)){
                    //之前已经注入一次了
                    int times=map_first.get(rainkey)+1;
                    map_second.put(rainkey,times);
                    map_first.put(rainkey,times);
                }else {
                    map_first.put(rainkey,1);
                }
                ans[i]=-1;
            }
        }
        //System.out.println(map_first);
        if(map_second.size()==0){
            //没有湖泊注水两次以上
            for(int i=0;i<rains.length;i++){
                if(ans[i]==0){
                    ans[i]=-1;
                }
            }
            return ans;
        }
        //此时有需要抽水的湖泊
        for(int i=0;i<ans.length;i++){
            if(ans[i]==0){
                boolean flag=true;
                for(int key: map_second.keySet()){
                    if(map_second.get(key)>=2){
                        flag=false;
                        if(cansuck<=0){
                            return new int[0];
                        }else {
                            ans[i]=key;
                            map_second.put(key,map_second.get(key)-1);
                            if(map_second.get(key)==1){
                                map_second.remove(key);
                            }
                            cansuck--;
                            break;
                        }
                    }
                }
                if(flag==true){
                    ans[i]=-1;
                }
            }
        }
        return map_second.size()==0?ans:new int[0];
    }


    public int[] avoidFlood_win(int[] rains) {
            int length = rains.length;
            int[] ans = new int[length];
            Arrays.fill(ans, -1);
            int[] nextRains = new int[length];
            Map<Integer, Integer> lakeDays = new HashMap<Integer, Integer>();
            for (int i = length - 1; i >= 0; i--) {
                int lake = rains[i];
                if (lake > 0) {
                    nextRains[i] = lakeDays.getOrDefault(lake, Integer.MAX_VALUE);
                    lakeDays.put(lake, i);
                }
            }
            Set<Integer> fullLakes = new HashSet<Integer>();
            PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);
            for (int i = 0; i < length; i++) {
                int lake = rains[i];
                if (lake > 0) {
                    if (!fullLakes.add(lake)) {
                        return new int[0];
                    }
                    if (nextRains[i] < length) {
                        pq.offer(new int[]{lake, nextRains[i]});
                    }
                } else {
                    if (pq.isEmpty()) {
                        ans[i] = 1;
                    } else {
                        int[] pair = pq.poll();
                        int nextLake = pair[0];
                        ans[i] = nextLake;
                        fullLakes.remove(nextLake);
                    }
                }
            }
            return ans;
    }


}
