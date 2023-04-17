package BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Etherstrings
 * @create 2023-03-02 13:31 BFS - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L994 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/2 - the current system date.  13:31 - the current system time.  2023 - the current year.  03 - the current month.  02 - the current day of the month.  13 - the current hour.  31 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class L994 {
    //994. 腐烂的橘子
    //在给定的 m x n 网格 grid 中，每个单元格可以有以下三个值之一：
    //
    //值 0 代表空单元格；
    //值 1 代表新鲜橘子；
    //值 2 代表腐烂的橘子。
    //每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。
    //
    //返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。
    //
    //
    //
    //示例 1：
    //
    //
    //
    //输入：grid = [[2,1,1],[1,1,0],[0,1,1]]
    //输出：4
    //示例 2：
    //
    //输入：grid = [[2,1,1],[0,1,1],[1,0,1]]
    //输出：-1
    //解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个正向上。
    //示例 3：
    //
    //输入：grid = [[0,2]]
    //输出：0
    //解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
    public int orangesRotting(int[][] grid) {
        int[][] dir ={{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        int fresh=0;
        int level=grid.length;
        int col=grid[0].length;
        Queue<int[]> Judge=new LinkedList<>();
        for(int i=0;i<level;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==1){
                    fresh++;
                }else if(grid[i][j]==2){
                    Judge.offer(new int[]{i,j});
                }
            }
        }
        if(fresh==0){
            return 0;
        }
        int round=0;
        while(!Judge.isEmpty()&&fresh>0){
            int size=Judge.size();
            for(int i=0;i<size;i++){
                int[] now=Judge.poll();
                for(int j=0;j<4;j++){
                    int nowx=now[0]+dir[j][0];
                    int nowy=now[1]+dir[j][1];
                    if (nowx < 0 || nowx >= grid.length || nowy < 0 || nowy >= grid[0].length) {
                        continue;  // 越界了，直接跳过
                    }
                    if(grid[nowx][nowy]==1){
                        fresh--;
                        grid[nowx][nowy]=2;
                        Judge.offer(new int[]{nowx,nowy});
                    }
                }
            }
            round++;
        }
        if(fresh!=0){
            return -1;
        }
        return round;
    }
}
