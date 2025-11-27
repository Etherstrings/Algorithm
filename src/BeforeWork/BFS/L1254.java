package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class L1254 {
    //1254. 统计封闭岛屿的数目
    //二维矩阵 grid 由 0 （土地）和 1 （水）组成。岛是由最大的4个方向连通的 0 组成的群，封闭岛是一个 完全 由1包围（左、上、右、下）的岛。
    //
    //请返回 封闭岛屿 的数目。
    //
    //
    //
    //示例 1：
    //
    //
    //
    //输入：grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]
    //输出：2
    //解释：
    //灰色区域的岛屿是封闭岛屿，因为这座岛屿完全被水域包围（即被 1 区域包围）。
    //示例 2：
    //
    //
    //
    //输入：grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
    //输出：1
    //示例 3：
    //
    //输入：grid = [[1,1,1,1,1,1,1],
    //             [1,0,0,0,0,0,1],
    //             [1,0,1,1,1,0,1],
    //             [1,0,1,0,1,0,1],
    //             [1,0,1,1,1,0,1],
    //             [1,0,0,0,0,0,1],
    //             [1,1,1,1,1,1,1]]
    //输出：2
    public static void main(String[] args) {
        int[][] grid=new int[][]{{0,0,1,0,0},{0,1,0,1,0},{0,1,1,1,0}};
        System.out.println(closedIsland(grid));
    }
    public static int closedIsland(int[][] grid) {
        //该岛的所有土地均不位于矩阵的边缘--封闭
        //从所有不是边缘的土地0出发，逐层渲染，如果发现了边缘，那就是不是封闭的
        //每次更新之后，将所有染色的更新为已更新
        int m=grid.length;int n=grid[0].length;
        ans=0;
        //从不是边缘的所有格出发
        for(int i=1;i<m-1;i++){
            for(int j=1;j<n-1;j++){
                if(grid[i][j]==0){
                    boolean closed=true;
                    Queue<int[]> que=new LinkedList<>();
                    que.offer(new int[]{i,j});
                    grid[i][j]=2;
                    //只有队列为空，代表着这次渲染结束
                    while(!que.isEmpty()){
                        int[] now=que.poll();
                        for(int k=0;k<4;k++){
                            int nowx=now[0]+dir[k][0];
                            int nowy=now[1]+dir[k][1];
                            if (nowx < 0 || nowx >= grid.length || nowy < 0 || nowy >= grid[0].length) {
                                continue;  // 越界了，直接跳过
                            }
                            if(grid[nowx][nowy]==0){
                                //是陆地，接着渲染
                                grid[nowx][nowy]=2;
                                que.offer(new int[]{nowx,nowy});
                                if (nowx == 0 || nowx == m - 1 || nowy == 0 || nowy == n - 1) closed = false;
                            }
                        }
                    }
                    if(closed){
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
    static int[][] dir ={{0, 1}, {1, 0}, {-1, 0}, {0, -1}}; // 四个方向
    static int ans;

}
