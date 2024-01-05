package Grid;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2023-12-07
 */
public class L1466 {
    //n 座城市，从 0 到 n-1 编号，其间共有 n-1 条路线。因此，要想在两座不同城市之间旅行只有唯一一条路线可供选择（路线网形成一颗树）。去年，交通运输
    //部决定重新规划路线，以改变交通拥堵的状况。
    //
    // 路线用 connections 表示，其中 connections[i] = [a, b] 表示从城市 a 到 b 的一条有向路线。
    //
    // 今年，城市 0 将会举办一场大型比赛，很多游客都想前往城市 0 。
    //
    // 请你帮助重新规划路线方向，使每个城市都可以访问城市 0 。返回需要变更方向的最小路线数。
    //
    // 题目数据 保证 每个城市在重新规划路线方向后都能到达城市 0 。
    //
    //
    //
    // 示例 1：
    //
    //
    //
    // 输入：n = 6, connections = [[0,1],[1,3],[2,3],[4,0],[4,5]]
    //输出：3
    //解释：更改以红色显示的路线的方向，使每个城市都可以到达城市 0 。
    //
    // 示例 2：
    //
    //
    //
    // 输入：n = 5, connections = [[1,0],[1,2],[3,2],[3,4]]
    //输出：2
    //解释：更改以红色显示的路线的方向，使每个城市都可以到达城市 0 。
    //
    // 示例 3：
    //
    // 输入：n = 3, connections = [[1,0],[2,0]]
    //输出：0
    //
    //
    //
    //
    // 提示：
    //
    //
    // 2 <= n <= 5 * 10^4
    // connections.length == n-1
    // connections[i].length == 2
    // 0 <= connections[i][0], connections[i][1] <= n-1
    // connections[i][0] != connections[i][1]
    //
    //
    // Related Topics 深度优先搜索 广度优先搜索 图 👍 179 👎 0
    /**
     * 既然是树形结构,那么,所有的点都是连接在一起的,就可以构建图
     * 根据题意,这是一个树形结构的有向无环图,如果不是树形的,比如题目变成了修路且无向的话,并查集就合适了,因为可能存在一个孤立的城市,跟任何城市可能都没关系
     * 另外,这个解法是建立在树的结构这个约束条件下的,如果是真正的图的话,就不正确了,因为存在这么一种情况,所有节点其实都可以到达城市0,但是在深度遍历的过程中,
     * 有可能某个路径是反方向的,此时计算的结果不会是0,但真正正确的答案是0
     * 相当于整个算法的思维是降维的,用图来解决树的问题
     */

    //> 2023/12/07 17:01:30
    //解答成功:
    //	执行耗时:39 ms,击败了57.51% 的Java用户
    //	内存消耗:67.1 MB,击败了41.85% 的Java用户

    //说实话 没有明白的很清楚
    public static void main(String[] args) {
        int[][] connections = new int[][]{{0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}};
        System.out.println(new L1466().minReorder(6, connections));
    }
    int ans;
    public int minReorder(int n, int[][] connections) {
        ans=0;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            graph.add(new ArrayList<>());
        }
        // 无向图
        for (int[] conn : connections) {
            graph.get(conn[0]).add(conn[1]);
            graph.get(conn[1]).add(-conn[0]);
        }
        dfs(graph, new boolean[n], 0);
        return ans;
    }

    public void dfs(List<List<Integer>> graph, boolean[] visited, int cur) {
        visited[cur] = true;
        for (int next : graph.get(cur)) {
            if (!visited[Math.abs(next)]) {
                if(next>0){
                    ans++;
                }
                dfs(graph, visited, Math.abs(next));
            }
        }
    }
}

