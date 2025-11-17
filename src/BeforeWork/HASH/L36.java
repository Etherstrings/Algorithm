package HASH;

import java.util.HashMap;

/**
 * @author Etherstrings
 * @create 2023-02-24 17:51 HASH - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L36 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/2/24 - the current system date.  17:51 - the current system time.  2023 - the current year.  02 - the current month.  24 - the current day of the month.  17 - the current hour.  51 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  2月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  二月 - full name of a month. Example: January, February, etc
 */
public class L36 {
    public boolean isValidSudoku(char[][] board) {
        //1 2 3 4 5 6 7 8 9
        //0 0
        //0 3
        //0 6
        int level=board.length;
        int col=board[0].length;
        boolean flag=true;
        //行
        for(int i=0;i<level;i++){
            HashMap<Character,Integer> jud=new HashMap<>();
            for(int j=0;j<col;j++){
                if(board[i][j]=='.'){
                    continue;
                }
                if(jud.containsKey(board[i][j])){
                    flag=false;
                    break;
                }else {
                    jud.put(board[i][j],1);
                }
            }
            if(flag==false){
                break;
            }
        }
        //列
        if(flag==false){
            return flag;
        }else {
            for(int j=0;j<level;j++){
                HashMap<Character,Integer> jud=new HashMap<>();
                for(int i=0;i<col;i++){
                    if(board[i][j]=='.'){
                        continue;
                    }
                    if(jud.containsKey(board[i][j])){
                        flag=false;
                        break;
                    }else {
                        jud.put(board[i][j],1);
                    }
                }
                if(flag==false){
                    break;
                }
            }
        }

        if(flag==false){
            return flag;
        }else {
            for(int i=0;i<level;i+=3){
                for(int j=0;j<col;j+=3){
                    if(Vai(board,i,j)){
                        continue;
                    }else {
                        flag=false;
                        break;
                    }
                }
            }
        }
        return flag;

    }

    public static boolean Vai(char[][] board,int x,int y){
        //验证当前位置的九个
        boolean flag=true;
        HashMap<Character,Integer> jud=new HashMap<>();
        for(int i=x;i<x+3;i++){
            for(int j=y;j<y+3;j++){
                if(board[i][j]=='.'){
                    continue;
                }
                if(jud.containsKey(board[i][j])){
                    flag=false;
                    break;
                }else {
                    jud.put(board[i][j],1);
                }
            }
        }
        return flag;
    }
}
