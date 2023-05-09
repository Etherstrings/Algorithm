package AcWing.Base.DFS;

import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2023-05-02 13:54 AcWing.Base.DFS - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  A843 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/5/2 - the current system date.  13:54 - the current system time.  2023 - the current year.  05 - the current month.  02 - the current day of the month.  13 - the current hour.  54 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  5月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  五月 - full name of a month. Example: January, February, etc
 */
public class A843 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        char[][] board=new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }
        }
        dfs(board,0);
    }

    public static void dfs(char[][] board,int level){
        if(level==board.length){
            for(int i=0;i<board.length;i++){
                for(int j=0;j<board.length;j++){
                    if(j==board.length-1){
                        System.out.println(board[i][j]);
                        continue;
                    }
                    System.out.print(board[i][j]);
                }
            }
            System.out.println();
            return;
        }

        for(int i=0;i< board.length;i++){
            if(isVaild(board,level,i)){
                //放
                board[level][i]='Q';
                dfs(board,level+1);
                board[level][i]='.';
            }
        }
    }

    public static boolean isVaild(char[][] board, int row, int col) {
        // 检查列是否有皇后
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // 检查左上角到右下角的对角线是否有皇后
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // 检查右上角到左下角的对角线是否有皇后
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // 当前位置可以放置皇后
        return true;
    }

}
