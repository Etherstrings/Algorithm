package HASH;

import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @description:
 * @author： wuboyu
 * @date： 2022-08-12 09:38
 */
public class L1282 {
    //1282. 用户分组
    //有 n 个人被分成数量未知的组。每个人都被标记为一个从 0 到 n - 1 的唯一ID 。
    //
    //给定一个整数数组 groupSizes ，其中 groupSizes[i] 是第 i 个人所在的组的大小。例如，如果 groupSizes[1] = 3 ，则第 1 个人必须位于大小为 3 的组中。
    //
    //返回一个组列表，使每个人 i 都在一个大小为 groupSizes[i] 的组中。
    //
    //每个人应该 恰好只 出现在 一个组 中，并且每个人必须在一个组中。如果有多个答案，返回其中 任何 一个。可以 保证 给定输入 至少有一个 有效的解。
    //
    //
    //
    //示例 1：
    //
    //输入：groupSizes = [3,3,3,3,3,1,3]
    //输出：[[5],[0,1,2],[3,4,6]]
    //解释：
    //第一组是 [5]，大小为 1，groupSizes[5] = 1。
    //第二组是 [0,1,2]，大小为 3，groupSizes[0] = groupSizes[1] = groupSizes[2] = 3。
    //第三组是 [3,4,6]，大小为 3，groupSizes[3] = groupSizes[4] = groupSizes[6] = 3。
    //其他可能的解决方案有 [[2,1,6],[5],[0,4,3]] 和 [[5],[0,6,2],[4,3,1]]。
    //示例 2：
    //
    //输入：groupSizes = [2,1,3,3,3,2]
    //输出：[[1],[0,5],[2,3,4]]
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        // 分组大小a 分组大小为a的有哪些人？
        HashMap<Integer,List<Integer>> Judge=new HashMap<>();

        //遍历-判断-如果当前分组大小等于key值 也就是分组大小---输出
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<groupSizes.length;i++){
            if(groupSizes[i]==1){
                List<Integer> Temp=new ArrayList<>();
                Temp.add(i);
                ans.add(Temp);
                continue;
            }

            if(Judge.containsKey(groupSizes[i])){
                //已经有了这个分组
                //判断当前分组下面已经有几个人 够不够一个组
                if(Judge.get(groupSizes[i]).size()==groupSizes[i]){
                    //够了一个组的数目
                    //取出当前组
                    ans.add(Judge.get(groupSizes[i]));
                    Judge.remove(groupSizes[i]);
                    //加入当前新的
                    List<Integer> Temp=new ArrayList<>();
                    Temp.add(i);
                    Judge.put(groupSizes[i],Temp);
                }else {
                    //不够当前小组的数目
                    //把当前的人加入
                    List<Integer> Temp=Judge.get(groupSizes[i]);
                    Temp.add(i);
                    if(Temp.size()==groupSizes[i]){
                        ans.add(Temp);
                        Judge.remove(groupSizes[i]);
                    }else {
                        Judge.put(groupSizes[i],Temp);
                    }
                }
            }else {
                //还没有这个分组
                List<Integer> Temp=new ArrayList<>();
                Temp.add(i);
                Judge.put(groupSizes[i],Temp);
            }
        }
        return ans;
    }
}
