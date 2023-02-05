package BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Justice_wby
 * @create 2023-02-05 17:00
 */
public class L200 {

    //此时采用BFS的形式进行遍历
    //依然是 我每次都会进去一个节点
    //当前节点按照可有的方向循环
    public int numIslands(char[][] grid) {
        //BFS应该可以直接在这里BFS
        boolean[][] visisted=new boolean[grid.length][grid[0].length];
        int result = 0;
        for(int i=0;i< grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(!visisted[i][j]&&grid[i][j]=='1'){
                    result++;
                    visisted[i][j]=true;
                    BFS(grid,visisted,i,j);
                }
            }
        }
        return result;
    }

    void BFS(char[][] grid,boolean[][] visisted,int x,int y){
        int[][] dir ={{0, 1}, {1, 0}, {-1, 0}, {0, -1}}; // 四个方向
        Queue<int[]> Judge=new LinkedList<>();
        Judge.offer(new int[]{x,y});
        visisted[x][y]=true;
        while(!Judge.isEmpty()){
            int[] now=Judge.poll();
            for(int i=0;i<4;i++){
                int nowx=now[0]+dir[i][0];
                int nowy=now[1]+dir[i][1];
                if (nowx < 0 || nowx >= grid.length || nowy < 0 || nowy >= grid[0].length) {
                    continue;  // 越界了，直接跳过
                }
                if(grid[nowx][nowy]=='1'&&!visisted[nowx][nowy]){
                    Judge.offer(new int[]{nowx,nowy});
                    visisted[nowx][nowy]=true;
                }
            }
        }
    }


}
