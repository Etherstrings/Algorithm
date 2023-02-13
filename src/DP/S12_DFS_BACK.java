package DP;

/**
 * @author Etherstrings
 * @create 2022-09-18 0:24 DP - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  S12_DFS_BACK - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/18 - the current system date.  0:24 - the current system time.  2022 - the current year.  09 - the current month.  18 - the current day of the month.  00 - the current hour.  24 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class S12_DFS_BACK {
    //剑指 Offer 12. 矩阵中的路径
    //给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
    //
    //单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
    //
    //
    //
    //例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。
    public boolean exist(char[][] board, String word) {

        int level=board.length;
        int col=board[0].length;
        if(level==0||word.length()==0){
            return false;
        }
        boolean[][] visited=new boolean[board.length][board[0].length];
        //回溯不是在这里回溯 而是进去选好起点之后再回溯
        for(int i=0;i<level;i++){
            for(int j=0;j<col;j++){
                visited[i][j]=false;
            }
        }
        boolean flag=false;
        for(int i=0;i<level;i++){
            for(int j=0;j<col;j++){
                if(BackTarcking(0,i,j,word,board,visited)){
                    flag=true;
                    break;
                }
            }
        }
        return flag;
    }

    boolean BackTarcking(int index,int i,int j,String word,char[][] board,boolean[][] visited){
        if(index==word.length()){
            return true;
        }
        Character now=word.charAt(index);
        Character temp=board[i][j];
        if(now!=temp){
            return false;
        }
        boolean result=false;
        visited[i][j]=true;
        //上下左右四个方向递归
        int newi=i-1;
        if(newi>=0){
            if(!visited[newi][j]==true){
                if( BackTarcking(index+1,newi,j,word,board,visited)){
                    result=true;
                }
            }
        }
        newi=i+1;
        if(newi< board.length){
            if(!visited[newi][j]==true){
                if(BackTarcking(index+1,newi,j,word,board,visited)){
                    result=true;
                }
            }
        }
        //左右
        int newj=j+1;
        if(newj<board[0].length){
            if(!visited[i][newj]==true){
                if(BackTarcking(index+1,i,newj,word,board,visited)){
                    result=true;
                }
            }
        }

        newj=j-1;
        if(newj>=0){
            if(!visited[i][newj]==true){
                if(BackTarcking(index+1,i,newj,word,board,visited)){
                    result=true;
                }
            }
        }
        //判断上下左右能不能递归
        visited[i][j]=false;
        return result;
    }
}
