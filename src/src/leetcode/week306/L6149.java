package src.leetcode.week306;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * @author Etherstrings
 * @create 2022-08-14 10:54 leetcode.week306 - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L6149 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/8/14 - the current system date.  10:54 - the current system time.  2022 - the current year.  08 - the current month.  14 - the current day of the month.  10 - the current hour.  54 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  8月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  八月 - full name of a month. Example: January, February, etc
 */
public class L6149 {
    //6149. 边积分最高的节点 显示英文描述
    //通过的用户数2739
    //尝试过的用户数3359
    //用户总通过次数2744
    //用户总提交次数6097
    //题目难度Medium
    //给你一个有向图，图中有 n 个节点，节点编号从 0 到 n - 1 ，其中每个节点都 恰有一条 出边。
    //
    //图由一个下标从 0 开始、长度为 n 的整数数组 edges 表示，其中 edges[i] 表示存在一条从节点 i 到节点 edges[i] 的 有向 边。
    //
    //节点 i 的 边积分 定义为：所有存在一条指向节点 i 的边的节点的 编号 总和。
    //
    //返回 边积分 最高的节点。如果多个节点的 边积分 相同，返回编号 最小 的那个。
    //
    //
    //
    //示例 1：
    //
    //
    //输入：edges = [1,0,0,0,0,7,7,5]
    //输出：7
    //解释：
    //- 节点 1、2、3 和 4 都有指向节点 0 的边，节点 0 的边积分等于 1 + 2 + 3 + 4 = 10 。
    //- 节点 0 有一条指向节点 1 的边，节点 1 的边积分等于 0 。
    //- 节点 7 有一条指向节点 5 的边，节点 5 的边积分等于 7 。
    //- 节点 5 和 6 都有指向节点 7 的边，节点 7 的边积分等于 5 + 6 = 11 。
    //节点 7 的边积分最高，所以返回 7 。
    //示例 2：
    //
    //
    //输入：edges = [2,0,0,2]
    //输出：0
    //解释：
    //- 节点 1 和 2 都有指向节点 0 的边，节点 0 的边积分等于 1 + 2 = 3 。
    //- 节点 0 和 3 都有指向节点 2 的边，节点 2 的边积分等于 0 + 3 = 3 。
    //节点 0 和 2 的边积分都是 3 。由于节点 0 的编号更小，返回 0 。
    public int edgeScore(int[] edges) {
        if(edges.length==1){
            return edges[0];
        }
        HashMap<Integer,Long> Judge=new HashMap<>();
        for(int i=0;i<edges.length;i++){
            //i是当前节点
            //edges[i]是指向的节点
            //判断是不是存在了指向节点的
            if(Judge.containsKey(edges[i])){
                Judge.put(edges[i],Judge.get(edges[i])+i);
            }else {
                Long now= Long.valueOf(i);
                Judge.put(edges[i],now);
            }
        }
        //节点--节点的最大值
        long max=-1;
        for(int i=0;i<edges.length;i++){
            //遍历节点 取最大值
            if(Judge.containsKey(i)){
                max=Math.max(max,Judge.get(i));
            }
        }
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<edges.length;i++){
            if(Judge.containsKey(i)){
                if(Judge.get(i)==max){
                    ans.add(i);
                }
            }

        }
        Collections.sort(ans);
        return ans.get(0);
    }
}
