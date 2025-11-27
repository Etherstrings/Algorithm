package DFS;

/**
 * @author Justice_wby
 * @create 2023-02-05 17:28
 */
public class L695 {
    //695. 岛屿的最大面积
    //给你一个大小为 m x n 的二进制矩阵 grid 。
    //
    //岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着。
    //
    //岛屿的面积是岛上值为 1 的单元格的数目。
    //
    //计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。
    //
    //
    //
    //示例 1：
    //
    //
    //输入：grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
    //输出：6
    //解释：答案不应该是 11 ，因为岛屿只能包含水平或垂直这四个方向上的 1 。
    int temp;
    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] visited=new boolean[grid.length][grid[0].length];
        //岛屿的最大面积
        int result=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(!visited[i][j]&&grid[i][j]==1){
                    //当前找到了一个新的岛屿
                    //当前岛屿的面积
                    temp=1;
                    visited[i][j] = true;
                    DFS(grid,visited,i,j);
                    result=Math.max(result,temp);
                }
            }
        }
        return result;
    }

    void DFS(int[][] grid,boolean[][] visited,int x,int y){
        int[][] dir ={{0, 1}, {1, 0}, {-1, 0}, {0, -1}}; // 四个方向
        for(int i=0;i<4;i++){
            int nx=x+dir[i][0];
            int ny=y+dir[i][1];
            if (nx < 0 || nx >= grid.length || ny < 0 || ny >= grid[0].length) continue;
            if(!visited[nx][ny]&&grid[nx][ny]==1){
                visited[nx][ny]=true;
                temp++;
                DFS(grid,visited,nx,ny);
            }
        }
    }
}
