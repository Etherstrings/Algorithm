package BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2023-10-08
 */
public class L130 {

    //思路
    //四条边上是O的，这个O所连接的联通块都不是陆地。
    //那么就首先进行分析，将四条边所有的O更新为一个新的字符，比如#。
    //通过BFS将所有的#作为入口，染色它碰到的所有O为#。
    //最后遍历整个矩阵，将O变为X，#变为O。

    //> 2023/10/08 20:14:28
    //已提交,请稍等
    //
    //> 2023/10/08 20:14:29
    //解答成功:
    //	执行耗时:2 ms,击败了42.06% 的Java用户
    //	内存消耗:42.8 MB,击败了42.66% 的Java用户

    public void solve(char[][] board) {
        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int row= board.length;
        int col= board[0].length;
        Queue<int[]> queue=new LinkedList<>();
        //遍历四周，将这些更新为#，并且将这些#作为入口
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(i==0||i==row-1||j==0||j==col-1){
                    if(board[i][j]=='O'){
                        board[i][j]='#';
                        queue.offer(new int[]{i,j});
                    }
                }
            }
        }
        while(!queue.isEmpty()){
            int[] now=queue.poll();
            for(int i=0;i<4;i++){
                int x=now[0]+dir[i][0];
                int y=now[1]+dir[i][1];
                if(x>=0&&x<row&&y>=0&&y<col&&board[x][y]=='O'){
                    board[x][y]='#';
                    queue.offer(new int[]{x,y});
                }
            }
        }
        //此时，所有的与四周联通的O都变成了#，那么剩下的O就是被X包围的，将其变为X，#变为O
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }
                if(board[i][j]=='#'){
                    board[i][j]='O';
                }
            }
        }
    }
}
