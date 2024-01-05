package BingChaJi;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2023-11-30
 */
public class L934 {
    //给你一个大小为 n x n 的二元矩阵 grid ，其中 1 表示陆地，0 表示水域。
    //
    // 岛 是由四面相连的 1 形成的一个最大组，即不会与非组内的任何其他 1 相连。grid 中 恰好存在两座岛 。
    //
    //
    //
    // 你可以将任意数量的 0 变为 1 ，以使两座岛连接起来，变成 一座岛 。
    //
    //
    //
    // 返回必须翻转的 0 的最小数目。
    //
    //
    //
    // 示例 1：
    //
    //
    //输入：grid = [[0,1],[1,0]]
    //输出：1
    //
    //
    // 示例 2：
    //
    //
    //输入：grid = [[0,1,0],[0,0,0],[0,0,1]]
    //输出：2
    //
    //
    // 示例 3：
    //
    //
    //输入：grid = [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
    //输出：1
    //
    //
    //
    //
    // 提示：
    //
    //
    // n == grid.length == grid[i].length
    // 2 <= n <= 100
    // grid[i][j] 为 0 或 1
    // grid 中恰有两个岛
    //
    //
    // Related Topics 深度优先搜索 广度优先搜索 数组 矩阵 👍 494 👎 0
    public int shortestBridge(int[][] grid) {
        //从一个岛屿的边缘开始，BFS去查找另外一个岛屿
        //只要碰到1，就是另外一个岛屿
        //需要保证这个1不是自己的岛屿
        int rows = grid.length;
        int cols = grid[0].length;
        //总共有比如9*9=81个格子，每个格子都有一个编号，编号从0开始
        //这里的意思是[0,82)
        //将每一个格子都先指向自己
        UnionFind unionFind = new UnionFind(rows * cols + 1);
        return -1;
    }

    private int getIndex(int x, int y, int cols) {
        return x * cols + y;
    }

    class UnionFind {

        private int[] parent;

        public UnionFind(int n) {
            this.parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }

        public int find(int x) {
            while (x != parent[x]) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public void union(int x, int y) {
            int xRoot = find(x);
            int yRoot = find(y);
            if (xRoot == yRoot) {
                return;
            }
            parent[xRoot] = yRoot;
        }
    }
}
