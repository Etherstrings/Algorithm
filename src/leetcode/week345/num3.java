package leetcode.week345;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2023-05-14 10:20 leetcode.week345 - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  num3 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/5/14 - the current system date.  10:20 - the current system time.  2023 - the current year.  05 - the current month.  14 - the current day of the month.  10 - the current hour.  20 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  5月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  五月 - full name of a month. Example: January, February, etc
 */
public class num3 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int[][] grid=new int[3][];
        grid[0]=new int[]{3,2,4};
        grid[1]=new int[]{2,1,9};
        grid[2]=new int[]{1,1,7};
        System.out.println(maxMoves(grid));
    }

    public static int maxMoves1(int[][] grid) {
        int ans=0;
        int[][] dp=new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            grid[i][0]=0;
        }
        for(int i=0;i<grid.length;i++){
            int x=i;
            int y=1;
            int nowx=x+1;
            int nowy=y-1;
            int a=0,b=0,c=0;
            if (nowx < 0 || nowx >= grid.length || nowy < 0 || nowy >= grid[0].length){

            }else {
                if(grid[nowx][nowy]>grid[x][y]){
                    a=dp[nowx][nowy]+1;
                }
            }
            nowx=x;
            nowy=y-1;
            if (nowx < 0 || nowx >= grid.length || nowy < 0 || nowy >= grid[0].length){

            }else {
                if(grid[nowx][nowy]>grid[x][y]){
                    b=dp[nowx][nowy]+1;
                }
            }
            nowx=x-1;
            nowy=y-1;
            if (nowx < 0 || nowx >= grid.length || nowy < 0 || nowy >= grid[0].length){

            }else {
                if(grid[nowx][nowy]>grid[x][y]){
                    c=dp[nowx][nowy]+1;
                }
            }
            dp[x][y]=Math.max(a,Math.max(b,c));
        }
        for(int i=0;i<grid.length;i++){
            for(int j=2;j<grid[0].length;j++){
                int x=i;
                int y=j;
                int nowx=x+1;
                int nowy=y-1;
                int a=0,b=0,c=0;
                if (nowx < 0 || nowx >= grid.length || nowy < 0 || nowy >= grid[0].length){

                }else {
                    if(grid[nowx][nowy]>grid[x][y]){
                        a=dp[nowx][nowy]+1;
                    }
                }
                nowx=x;
                nowy=y-1;
                if (nowx < 0 || nowx >= grid.length || nowy < 0 || nowy >= grid[0].length){

                }else {
                    if(grid[nowx][nowy]>grid[x][y]){
                        b=dp[nowx][nowy]+1;
                    }
                }
                nowx=x-1;
                nowy=y-1;
                if (nowx < 0 || nowx >= grid.length || nowy < 0 || nowy >= grid[0].length){

                }else {
                    if(grid[nowx][nowy]>grid[x][y]){
                        c=dp[nowx][nowy]+1;
                    }
                }
                dp[x][y]=Math.max(a,Math.max(b,c));
                ans=Math.max(dp[x][y],ans);
            }
        }
        return ans;
    }
    public static int maxMoves(int[][] grid) {
        int ans=0;
        for(int i=0;i<grid.length;i++){
            ans=Math.max(bfs(i,0,grid),ans);
        }
        return ans;
    }

    public static int bfs(int i,int j,int[][] grid){
        int ans=0;
        Queue<int[]> que=new LinkedList<>();
        que.offer(new int[]{i,j,0});
        while(!que.isEmpty()){
            int[] now=que.poll();
            //1.row-1,col+1
            int nowx=now[0]-1;
            int nowy=now[1]+1;
            if (nowx < 0 || nowx >= grid.length || nowy < 0 || nowy >= grid[0].length) {
                  // 越界了，直接跳过
            }else {
                if(grid[nowx][nowy]>grid[now[0]][now[1]]){
                    int step=now[2];
                    que.offer(new int[]{nowx,nowy,step+1});
                    ans=Math.max(step+1,ans);
                }
            }
            //2.
            nowx=now[0];
            nowy=now[1]+1;
            if (nowx < 0 || nowx >= grid.length || nowy < 0 || nowy >= grid[0].length) {
                 // 越界了，直接跳过
            }else {
                if(grid[nowx][nowy]>grid[now[0]][now[1]]){
                    int step=now[2];
                    que.offer(new int[]{nowx,nowy,step+1});
                    ans=Math.max(step+1,ans);
                }
            }
            //3.
            nowx=now[0]+1;
            nowy=now[1]+1;
            if (nowx < 0 || nowx >= grid.length || nowy < 0 || nowy >= grid[0].length) {
                  // 越界了，直接跳过
            }else {
                if(grid[nowx][nowy]>grid[now[0]][now[1]]){
                    int step=now[2];
                    que.offer(new int[]{nowx,nowy,step+1});
                    ans=Math.max(step+1,ans);
                }
            }

        }
        return ans;
    }
}
