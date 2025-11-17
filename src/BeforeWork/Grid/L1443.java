package Grid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2023-12-13
 */
public class L1443 {

    //给你一棵有 n 个节点的无向树，节点编号为 0 到 n-1 ，它们中有一些节点有苹果。通过树上的一条边，需要花费 1 秒钟。你从 节点 0 出发，请你返回最
    //少需要多少秒，可以收集到所有苹果，并回到节点 0 。
    //
    // 无向树的边由 edges 给出，其中 edges[i] = [fromi, toi] ，表示有一条边连接 from 和 toi 。除此以外，还有一个布尔数
    //组 hasApple ，其中 hasApple[i] = true 代表节点 i 有一个苹果，否则，节点 i 没有苹果。
    //
    //
    //
    // 示例 1：
    //
    //
    //
    //
    //输入：n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple = [false,
    //false,true,false,true,true,false]
    //输出：8
    //解释：上图展示了给定的树，其中红色节点表示有苹果。一个能收集到所有苹果的最优方案由绿色箭头表示。
    //
    //
    // 示例 2：
    //
    //
    //
    //
    //输入：n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple = [false,
    //false,true,false,false,true,false]
    //输出：6
    //解释：上图展示了给定的树，其中红色节点表示有苹果。一个能收集到所有苹果的最优方案由绿色箭头表示。
    //
    //
    // 示例 3：
    //
    //
    //输入：n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple = [false,
    //false,false,false,false,false,false]
    //输出：0
    //
    //
    //
    //
    // 提示：
    //
    //
    // 1 <= n <= 10^5
    // edges.length == n - 1
    // edges[i].length == 2
    // 0 <= ai < bi <= n - 1
    // hasApple.length == n
    //
    //
    // Related Topics 树 深度优先搜索 广度优先搜索 哈希表 👍 91 👎 0

    private Map<Integer, Set<Integer>> children;

    public int minTime(int n, int[][] edges, boolean[] hasApple) {
        children = new HashMap<>();

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            children.computeIfAbsent(u, k -> new HashSet<>()).add(v);
            children.computeIfAbsent(v, k -> new HashSet<>()).add(u);
        }

        return helper(0, -1,hasApple)[0];
    }

    private int[] helper(int root, int parent, boolean[] hasApple) {
        // Base case
        if (!children.containsKey(root) || children.get(root).isEmpty()) {
            return new int[]{0, hasApple[root] ? 1 : 0};
        }

        int tmp = 0;
        boolean childHasApple = false;

        for (int child : children.get(root)) {
            // No backwards
            if (child == parent) {
                continue;
            }

            int[] result = helper(child, root,hasApple);
            int time = result[0];
            int apple = result[1];

            if (apple == 1) {
                childHasApple = true;
                tmp += time + 2;
            }
        }

        return new int[]{tmp, childHasApple || hasApple[root] ? 1 : 0};
    }

}
