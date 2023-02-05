package DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Justice_wby
 * @create 2023-02-05 15:56
 */
public class L797 {
    //797. 所有可能的路径
    //给你一个有 n 个节点的 有向无环图（DAG），请你找出所有从节点 0 到节点 n-1 的路径并输出（不要求按特定顺序）
    //
    // graph[i] 是一个从节点 i 可以访问的所有节点的列表（即从节点 i 到节点 graph[i][j]存在一条有向边）。
    //
    //
    //
    //示例 1：
    //
    //
    //
    //输入：graph = [[1,2],[3],[3],[]]
    //输出：[[0,1,3],[0,2,3]]
    //解释：有两条路径 0 -> 1 -> 3 和 0 -> 2 -> 3
    List<Integer> Path=new ArrayList<>();
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        //graph
        //0 1 2 3
        //可以到哪些 可以到哪些
        Path.add(0);
        DFS(0,graph);
        return res;
    }

    void DFS(int now,int[][] graph){

        //因为最开始已经加了一个0
        if(now==graph.length-1){
            res.add(new ArrayList<>(Path));
            return;
        }

        for(int cango:graph[now]){
            Path.add(cango);
            DFS(cango,graph);
            Path.remove(Path.size()-1);
        }
    }
}
