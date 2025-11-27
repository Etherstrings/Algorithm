package BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2023-09-13
 */
public class L2596 {
    public static void main(String[] args) {
        //> 2023/09/13 16:24:46
        //解答成功:
        //	执行耗时:1 ms,击败了81.40% 的Java用户
        //	内存消耗:41.8 MB,击败了85.27% 的Java用户
        //测试用例:[[0,11,16,5,20],[17,4,19,10,15],[12,1,8,21,6],[3,18,23,14,9],[24,13,2,7,22]]
        //测试结果:true
        //期望结果:true
        int[][] grid = new int[][]{{0,11,16,5,20},{17,4,19,10,15},{12,1,8,21,6},{3,18,23,14,9},{24,13,2,7,22}};
        System.out.println(checkValidGrid(grid));
    }
    public static boolean checkValidGrid(int[][] grid) {
        //BFS
        if(grid[0][0]!=0){
            return false;
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0});
        int[][] dir = new int[][]{{1,2},{2,1},{-1,2},{-2,1},{1,-2},{2,-1},{-1,-2},{-2,-1}};
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;
        int round=0;
        while(!queue.isEmpty()){
            int[] now=queue.poll();
            int x= now[0];
            int y= now[1];
            if(grid[x][y]==n*n-1){
                return true;
            }
            for(int i=0;i<8;i++){
                int nowx = x+dir[i][0];
                int nowy = y+dir[i][1];
                if(nowx>=0&&nowx<n&&nowy>=0&&nowy<n&&!visited[nowx][nowy]){
                    if(grid[nowx][nowy]==round+1){
                        queue.offer(new int[]{nowx,nowy});
                        visited[nowx][nowy]=true;
                        round++;
                    }
                }
            }
        }
        return false;
    }
}
