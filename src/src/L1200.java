package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L1200 {
    //1200. 最小绝对差
    //给你个整数数组 arr，其中每个元素都 不相同。
    //
    //请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回。
    //
    //
    //
    //示例 1：
    //
    //输入：arr = [4,2,1,3]
    //输出：[[1,2],[2,3],[3,4]]
    //示例 2：
    //
    //输入：arr = [1,3,6,10,15]
    //输出：[[1,3]]
    //示例 3：
    //
    //输入：arr = [3,8,-10,23,19,-4,-14,27]
    //输出：[[-14,-10],[19,23],[23,27]]
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int minsum=1;
        int index=1;
        for(int i=1;i<arr.length;i++){
            if(index==1){
                if(arr[i]-arr[i-1]>minsum){
                    minsum=arr[i]-arr[i-1];
                }else {
                    minsum=Math.min(minsum,arr[i]-arr[i-1]);
                }
                index++;
                continue;
            }

            minsum=Math.min(minsum,arr[i]-arr[i-1]);

        }
        List<List<Integer>> ans=new ArrayList<>();

        for(int i=1;i<arr.length;i++){
            if(arr[i]-arr[i-1]==minsum){
                List<Integer> temp=new ArrayList<>();
                temp.add(arr[i-1]);
                temp.add(arr[i]);
                ans.add(temp);
            }
        }
        return ans;

    }
}
