package AcWing.Base.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2023-05-04 15:07 AcWing.Base.BFS - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  A844 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/5/4 - the current system date.  15:07 - the current system time.  2023 - the current year.  05 - the current month.  04 - the current day of the month.  15 - the current hour.  07 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  5月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  五月 - full name of a month. Example: January, February, etc
 */
public class A844 {
    //844. 走迷宫
    //   题目
    //   提交记录
    //   讨论
    //   题解
    //   视频讲解
    //
    //给定一个 n×m
    // 的二维整数数组，用来表示一个迷宫，数组中只包含 0
    // 或 1
    //，其中 0
    // 表示可以走的路，1
    // 表示不可通过的墙壁。
    //
    //最初，有一个人位于左上角 (1,1)
    // 处，已知该人每次可以向上、下、左、右任意一个方向移动一个位置。
    //
    //请问，该人从左上角移动至右下角 (n,m)
    // 处，至少需要移动多少次。
    //
    //数据保证 (1,1)
    // 处和 (n,m)
    // 处的数字为 0
    //，且一定至少存在一条通路。
    //
    //输入格式
    //第一行包含两个整数 n
    // 和 m
    //。
    //
    //接下来 n
    // 行，每行包含 m
    // 个整数（0
    // 或 1
    //），表示完整的二维数组迷宫。
    //
    //输出格式
    //输出一个整数，表示从左上角移动至右下角的最少移动次数。
    //
    //数据范围
    //1≤n,m≤100
    //输入样例：
    //5 5
    //0 1 0 0 0
    //0 1 0 1 0
    //0 0 0 0 0
    //0 1 1 1 0
    //0 0 0 1 0
    //输出样例：
    //8
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        //n行m列
        int n=in.nextInt();
        int m=in.nextInt();
        int[][] grid=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                grid[i][j]=in.nextInt();
            }
        }
        //从左上角移动到右下角
        //最短的路径是什么？
        //0可以走 1不可以走
        bfs(0,0,grid);
    }

    static class Point{
        public int x;
        public int y;
        public int step;
        public Point(int x, int y, int step) {
            this.x = x;
            this.y = y;
            this.step = step;
        }
    }
    public static void bfs(int x,int y,int[][] grid){
        int temp=0;
        int[][] dir ={{0, 1}, {1, 0}, {-1, 0}, {0, -1}}; // 四个方向
        Queue<Point> Judge=new LinkedList<>();
        Judge.offer(new Point(x,y,0));
        temp++;
        while(!Judge.isEmpty()){
            Point now=Judge.poll();
            if (now.x == grid.length-1 && now.y == grid[0].length-1) {
                System.out.println(now.step);
                return;
            }
            for(int i=0;i<4;i++) {
                int nowx = now.x + dir[i][0];
                int nowy = now.y + dir[i][1];
                if (nowx < 0 || nowx >= grid.length || nowy < 0 || nowy >= grid[0].length) {
                    continue;  // 越界了，直接跳过
                }
                if(grid[nowx][nowy]==0){
                    Judge.offer(new Point(nowx,nowy, now.step+1));
                }
            }
            temp++;
        }

    }
}
