package src.leetcode.week305;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Etherstrings
 * @create 2022-08-07 15:27 leetcode.week305 - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L6139 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/8/7 - the current system date.  15:27 - the current system time.  2022 - the current year.  08 - the current month.  07 - the current day of the month.  15 - the current hour.  27 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  8月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  八月 - full name of a month. Example: January, February, etc
 */
public class L6139 {
    //6139. 受限条件下可到达节点的数目 显示英文描述
    //通过的用户数3749
    //尝试过的用户数5071
    //用户总通过次数3851
    //用户总提交次数10499
    //题目难度Medium
    //现有一棵由 n 个节点组成的无向树，节点编号从 0 到 n - 1 ，共有 n - 1 条边。
    //
    //给你一个二维整数数组 edges ，长度为 n - 1 ，其中 edges[i] = [ai, bi] 表示树中节点 ai 和 bi 之间存在一条边。另给你一个整数数组 restricted 表示 受限 节点。
    //
    //在不访问受限节点的前提下，返回你可以从节点 0 到达的 最多 节点数目。
    //
    //注意，节点 0 不 会标记为受限节点。
    //
    //
    //
    //示例 1：
    //
    //
    //输入：n = 7, edges = [[0,1],[1,2],[3,1],[4,0],[0,5],[5,6]], restricted = [4,5]
    //输出：4
    //解释：上图所示正是这棵树。
    //在不访问受限节点的前提下，只有节点 [0,1,2,3] 可以从节点 0 到达。
    //示例 2：
    //
    //
    //输入：n = 7, edges = [[0,1],[0,2],[0,5],[0,4],[3,2],[6,5]], restricted = [4,2,1]
    //输出：3
    //解释：上图所示正是这棵树。
    //在不访问受限节点的前提下，只有节点 [0,5,6] 可以从节点 0 到达。
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        //存节点0可以到的所有节点
        Set<Integer> Judge0=new HashSet<>();
        for(int[] a:edges){
            if(a[0]!=0&&a[1]!=0){
                continue;
            }
            if(a[0]==0){
                Judge0.add(a[1]);
            }else if(a[1]==0){
                Judge0.add(a[0]);
            }
        }

        return -1;

    }
}
