package Luogu;

import java.util.Scanner;

/**
 * @author Justice_wby
 * @create 2023-02-11 19:25
 */
public class NOIP2002 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String[] line1=in.nextLine().split(" ");
        int[] end= {Integer.parseInt(line1[0]),Integer.parseInt(line1[1])};
        int[] Ma={Integer.parseInt(line1[2]),Integer.parseInt(line1[3])};
        //25行25列
        //初始化矩阵
        int[][] grid=new int[25][25];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                grid[i][j]=0;
            }
        }
        //将马和所有可以跳到的地方都标记为1
        int Max=Ma[0];
        int May=Ma[1];
        grid[Max][May]=1;
        grid[Max-1][May-2]=1;
        grid[Max-2][May-1]=1;
        grid[Max-2][May+1]=1;
        grid[Max-1][May+2]=1;

        grid[Max+1][May+2]=1;
        grid[Max+2][May+1]=1;
        grid[Max+2][May-1]=1;
        grid[Max+1][May-2]=1;

        //到达当前位置可走路径
        long[][] dp=new long[25][25];
        //初始化x
        //初始化y
        dp[1][1]=1;

        for(int i=1;i<=end[0];i++){
            for(int j=1;j<=end[1];j++){
                if(i==1&&j==1){
                    continue;
                }
                if(grid[i][j]==1){
                    continue;
                }
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        System.out.println(dp[end[0]][end[1]]);
    }
}
