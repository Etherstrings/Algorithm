package BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2023-12-11
 */
public class L631 {
    //二分+BFS

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


    //> 2023/12/11 14:14:11
    //解答成功:
    //	执行耗时:126 ms,击败了18.39% 的Java用户
    //	内存消耗:42.7 MB,击败了86.08% 的Java用户

    public static void main(String[] args) {
        //[[1,2,2],[3,8,2],[5,3,5]]
        //答案应该是2
        //但是现在是最大值
        //为什么是最大值呢？
        int[][] heights = {{1,2,2},{3,8,2},{5,3,5}};
        System.out.println(new L631().minimumEffortPath(heights));
    }

    public int minimumEffortPath(int[][] heights) {
        //思路是什么？
        //因为高度是从1-10^6，所以我们可以二分查找，找到一个值，使得从左上角到右下角的路径中，所有相邻格子的高度差都小于等于这个值
        //找到这个值之后，通过BFS判断是否具有这样的一个路径
        //如果有，那么就继续缩小这个值，如果没有，就增大这个值
        int row = heights.length;
        int col = heights[0].length;
        if(heights == null || heights.length == 0 || heights[0].length == 0) {
            return 0;
        }
        if(heights.length == 1 && heights[0].length == 1) {
            return 0;
        }
        int left = 0;
        int right = 1000000;
        while (left < right) {
            int mid = (left + right) / 2;
            boolean[][] visited = new boolean[row][col];
            visited[0][0] = true;
            if (bfs(heights,visited,0,0,mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean bfs(int[][] heights,boolean[][] visited,int x,int y,int mid) {
        if (x == heights.length - 1 && y == heights[0].length - 1) {
            return true;
        }
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x,y});
        while (!queue.isEmpty()) {
            for(int i=0;i<queue.size();i++){
                int[] cur = queue.poll();
                for (int[] direction : directions) {
                    int newX = cur[0] + direction[0];
                    int newY = cur[1] + direction[1];
                    if (newX >= 0 && newX < heights.length && newY >= 0 && newY < heights[0].length && !visited[newX][newY] && Math.abs(heights[newX][newY] - heights[cur[0]][cur[1]]) <= mid) {
                        if (newX == heights.length - 1 && newY == heights[0].length - 1) {
                            return true;
                        }
                        queue.offer(new int[]{newX,newY});
                        visited[newX][newY] = true;
                    }
                }
            }
        }
        return false;
    }
}
