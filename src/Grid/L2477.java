package Grid;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2023-12-06
 */
public class L2477 {
    //给你一棵 n 个节点的树（一个无向、连通、无环图），每个节点表示一个城市，编号从 0 到 n - 1 ，且恰好有 n - 1 条路。0 是首都。给你一个二维
    //整数数组 roads ，其中 roads[i] = [ai, bi] ，表示城市 ai 和 bi 之间有一条 双向路 。
    //
    // 每个城市里有一个代表，他们都要去首都参加一个会议。
    //
    // 每座城市里有一辆车。给你一个整数 seats 表示每辆车里面座位的数目。
    //
    // 城市里的代表可以选择乘坐所在城市的车，或者乘坐其他城市的车。相邻城市之间一辆车的油耗是一升汽油。
    //
    // 请你返回到达首都最少需要多少升汽油。
    //
    //
    //
    // 示例 1：
    //
    //
    //
    // 输入：roads = [[0,1],[0,2],[0,3]], seats = 5
    //输出：3
    //解释：
    //- 代表 1 直接到达首都，消耗 1 升汽油。
    //- 代表 2 直接到达首都，消耗 1 升汽油。
    //- 代表 3 直接到达首都，消耗 1 升汽油。
    //最少消耗 3 升汽油。
    //
    //
    // 示例 2：
    //
    //
    //
    // 输入：roads = [[3,1],[3,2],[1,0],[0,4],[0,5],[4,6]], seats = 2
    //输出：7
    //解释：
    //- 代表 2 到达城市 3 ，消耗 1 升汽油。
    //- 代表 2 和代表 3 一起到达城市 1 ，消耗 1 升汽油。
    //- 代表 2 和代表 3 一起到达首都，消耗 1 升汽油。
    //- 代表 1 直接到达首都，消耗 1 升汽油。
    //- 代表 5 直接到达首都，消耗 1 升汽油。
    //- 代表 6 到达城市 4 ，消耗 1 升汽油。
    //- 代表 4 和代表 6 一起到达首都，消耗 1 升汽油。
    //最少消耗 7 升汽油。
    //
    //
    // 示例 3：
    //
    //
    //
    // 输入：roads = [], seats = 1
    //输出：0
    //解释：没有代表需要从别的城市到达首都。
    //
    //
    //
    //
    // 提示：
    //
    //
    // 1 <= n <= 10⁵
    // roads.length == n - 1
    // roads[i].length == 2
    // 0 <= ai, bi < n
    // ai != bi
    // roads 表示一棵合法的树。
    // 1 <= seats <= 10⁵
    //
    //
    // Related Topics 树 深度优先搜索 广度优先搜索 图 👍 122 👎 0


    //> 2023/12/06 11:29:26
    //解答成功:
    //	执行耗时:45 ms,击败了44.08% 的Java用户
    //	内存消耗:106.8 MB,击败了14.70% 的Java用户
    long res = 0;

    public long minimumFuelCost(int[][] roads, int seats) {
        int n = roads.length;
        //初始化图
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            //城市从0到n+1 这些城市都会指向哪些城市
            graph.add(new ArrayList<>());
        }
        //构建图
        //由于是无向图，所以需要双向都要加
        for (int[] road : roads) {
            graph.get(road[0]).add(road[1]);
            graph.get(road[1]).add(road[0]);
        }
        dfs(0,-1, seats, graph);
        return res;
    }

    public int dfs(int cur, int father, int seats, List<List<Integer>> graph) {
        int passSum = 1;
        for(int v:graph.get(cur)){
            if(v==father){
                continue;
            }
            //如果当前为0，那就是先递归到了最后一层，然后再往上走
            int pass = dfs(v,cur,seats,graph);
            passSum += pass;
            res += (pass + seats - 1) / seats;
        }
        return passSum;
    }
}
