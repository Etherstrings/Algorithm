package BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Etherstrings
 * @create 2023-02-27 12:49 BFS - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L733 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/2/27 - the current system date.  12:49 - the current system time.  2023 - the current year.  02 - the current month.  27 - the current day of the month.  12 - the current hour.  49 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  2月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  二月 - full name of a month. Example: January, February, etc
 */
public class L733 {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        //BFS应该可以直接在这里BFS
        if(image[sr][sc]==color){
            return image;
        }
        int[][] dir ={{0, 1}, {1, 0}, {-1, 0}, {0, -1}}; // 四个方向
        Queue<int[]> Judge=new LinkedList<>();
        Judge.offer(new int[]{sr,sc});
        while(!Judge.isEmpty()){
            int[] now=Judge.poll();
            for(int i=0;i<4;i++){
                int nowx=now[0]+dir[i][0];
                int nowy=now[1]+dir[i][1];
                if (nowx < 0 || nowx >= image.length || nowy < 0 || nowy >= image[0].length) {
                    continue;  // 越界了，直接跳过
                }
                image[nowx][nowy]=color;
                Judge.offer(new int[]{nowx,nowy});
            }
        }
        return image;

    }


}
