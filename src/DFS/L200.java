package DFS;

/**
 * @author Justice_wby
 * @create 2023-02-05 16:29
 */
public class L200 {
    //200. 岛屿数量
    //给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
    //
    //岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
    //
    //此外，你可以假设该网格的四条边均被水包围。
    //
    //
    //
    //示例 1：
    //
    //输入：grid = [
    //  ["1","1","1","1","0"],
    //  ["1","1","0","1","0"],
    //  ["1","1","0","0","0"],
    //  ["0","0","0","0","0"]
    //]
    //输出：1
    //示例 2：
    //
    //输入：grid = [
    //  ["1","1","0","0","0"],
    //  ["1","1","0","0","0"],
    //  ["0","0","1","0","0"],
    //  ["0","0","0","1","1"]
    //]
    //输出：3
    public int numIslands(char[][] grid) {
        //遍历每一个节点
        //1.当前节点为1 是陆地 为0 为海水
        //2.当前这个1是不是没有被染色
        //3.没有被染色 就+1 并且将自己可以连接到的所有陆地都染色
        //4.被染色了 那就被染色了
        int m=grid.length;
        int n=grid[0].length;

        boolean[][] visited=new boolean[m][n];

        int result=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(visited[i][j]==false&&grid[i][j]=='1'){
                    //当前这个为新陆地
                    result++;
                    visited[i][j]=true;
                    dfs(grid,visited,i,j);
                }
            }
        }

        return result;

    }

    void dfs(char[][] grid,boolean[][] visited,int x,int y){
        int[][] dir ={{0, 1}, {1, 0}, {-1, 0}, {0, -1}}; // 四个方向
        //当前向上 向下 向左 向右
        for(int i=0;i<4;i++){
            int nowx=x+dir[i][0];
            int nowy=y+dir[i][1];
            if (nowx < 0 || nowx >= grid.length || nowy < 0 || nowy >= grid[0].length) continue;
            if(visited[nowx][nowy]==false&&grid[nowx][nowy]=='1'){
                visited[nowx][nowy]=true;
                dfs(grid,visited,nowx,nowy);
            }
        }

    }
}
