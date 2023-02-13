package BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Justice_wby
 * @create 2023-02-05 17:45
 */
public class L695 {
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
                    BFS(grid,visited,i,j);
                    result=Math.max(result,temp);
                }
            }
        }
        return result;
    }

    void BFS(int[][] grid,boolean[][] visited,int x,int y){
        int[][] dir ={{0, 1}, {1, 0}, {-1, 0}, {0, -1}}; // 四个方向
        Queue<int[]> Judge=new LinkedList<>();
        Judge.offer(new int[]{x,y});
        visited[x][y]=true;

        while(!Judge.isEmpty()){
            int[] now=Judge.poll();
            for(int i=0;i<4;i++){
                int nowx=now[0]+dir[i][0];
                int nowy=now[1]+dir[i][1];
                if (nowx < 0 || nowx >= grid.length || nowy < 0 || nowy >= grid[0].length) {
                    continue;  // 越界了，直接跳过
                }
                if(grid[nowx][nowy]==1&&!visited[nowx][nowy]){
                    Judge.offer(new int[]{nowx,nowy});
                    temp++;
                    visited[nowx][nowy]=true;
                }
            }
        }

    }
}
