package DFS;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2023-12-11
 */
public class L631 {
    //二分+DFS

    //你准备参加一场远足活动。给你一个二维 rows x columns 的地图 heights ，其中 heights[row][col] 表示格子 (row,
    // col) 的高度。一开始你在最左上角的格子 (0, 0) ，且你希望去最右下角的格子 (rows-1, columns-1) （注意下标从 0 开始编号）。你
    //每次可以往 上，下，左，右 四个方向之一移动，你想要找到耗费 体力 最小的一条路径。
    //
    // 一条路径耗费的 体力值 是路径上相邻格子之间 高度差绝对值 的 最大值 决定的。
    //
    // 请你返回从左上角走到右下角的最小 体力消耗值 。
    //
    //
    //
    // 示例 1：
    //
    //
    //
    //
    //输入：heights = [[1,2,2],[3,8,2],[5,3,5]]
    //输出：2
    //解释：路径 [1,3,5,3,5] 连续格子的差值绝对值最大为 2 。
    //这条路径比路径 [1,2,2,2,5] 更优，因为另一条路径差值最大值为 3 。
    //
    //
    // 示例 2：
    //
    //
    //
    //
    //输入：heights = [[1,2,3],[3,8,4],[5,3,5]]
    //输出：1
    //解释：路径 [1,2,3,4,5] 的相邻格子差值绝对值最大为 1 ，比路径 [1,3,5,3,5] 更优。
    //
    //
    // 示例 3：
    //
    //
    //输入：heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
    //输出：0
    //解释：上图所示路径不需要消耗任何体力。
    //
    //
    //
    //
    // 提示：
    //
    //
    // rows == heights.length
    // columns == heights[i].length
    // 1 <= rows, columns <= 100
    // 1 <= heights[i][j] <= 10⁶
    //
    //
    // Related Topics 深度优先搜索 广度优先搜索 并查集 数组 二分查找 矩阵 堆（优先队列） 👍 418 👎 0

    //> 2023/12/11 11:46:28
    //解答成功:
    //	执行耗时:104 ms,击败了22.61% 的Java用户
    //	内存消耗:43.9 MB,击败了6.90% 的Java用户
    public int minimumEffortPath(int[][] heights) {
        //思路是什么？
        //因为高度是从1-10^6，所以我们可以二分查找，找到一个值，使得从左上角到右下角的路径中，所有相邻格子的高度差都小于等于这个值
        //找到这个值之后，通过DFS判断是否具有这样的一个路径
        //如果有，那么就继续缩小这个值，如果没有，就增大这个值
        //直到找到最小的那个值，这个值就是答案
        if(heights == null || heights.length == 0 || heights[0].length == 0){
            return 0;
        }
        if(heights.length== 1 && heights[0].length == 1){
            return 0;
        }
        int left = 0;
        int right = 1000000;
        while (left < right) {
            int mid = (left + right) / 2;
            if (dfs(heights, mid, 0, 0, new boolean[heights.length][heights[0].length])) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean dfs(int[][] heights, int max, int row, int col, boolean[][] visited){
        visited[row][col] = true;
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            if (newRow >= 0 && newRow < heights.length && newCol >= 0 && newCol < heights[0].length && !visited[newRow][newCol] && Math.abs(heights[newRow][newCol] - heights[row][col]) <= max) {
                if (newRow == heights.length - 1 && newCol == heights[0].length - 1) {
                    return true;
                }
                if (dfs(heights, max, newRow, newCol, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
}
