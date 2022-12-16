package src.BackStracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Etherstrings
 * @create 2022-07-09 14:09 BackStracking - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L51NQueen - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/7/9 - the current system date.  14:09 - the current system time.  2022 - the current year.  07 - the current month.  09 - the current day of the month.  14 - the current hour.  09 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  7月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  七月 - full name of a month. Example: January, February, etc
 */
public class L51NQueen {
    //51. N 皇后
    //按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
    //
    //n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
    //
    //给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
    //
    //每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
    //
    //
    //
    //示例 1：
    //
    //
    //输入：n = 4
    //输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
    //解释：如上图所示，4 皇后问题存在两个不同的解法。
    //示例 2：
    //
    //输入：n = 1
    //输出：[["Q"]]
    List<List<String>> res=new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        //大名鼎鼎N皇后

        //横向 第一行的 1-N
        //纵向 第二行的1—N---判断与第一行位置
        //传入一个棋盘，棋盘上记录现在有哪些了
        char[][] chessboard=new char[n][n];
        //填充棋盘为空棋盘---此时全都是'.'
        for(char[] c:chessboard){
            Arrays.fill(c,'.');
        }
        backTarcking(n,0,chessboard);
        return res;
    }

    //传参传什么？
    //总共是多少皇后
    //现在是第几层了？
    //棋盘现状如何？
    void backTarcking(int n,int level,char[][] chessboard){

        if(level==n){
            res.add(Array2List(chessboard));
            return;
        }

        for(int i=0;i<n;i++){
            //每一层都需要从0判断
            //判断当前层的每个位置是不是可以放Q

            //当前位置是不是合法，合法放皇后
            if(isVaild(level,i,n,chessboard)){
                chessboard[level][i]='Q';
                backTarcking(n,level+1,chessboard);
                chessboard[level][i]='.';
            }
        }
    }

    boolean isVaild(int level,int col,int n,char[][] chessboard){
        //当前传入了什么？
        //现在的棋盘 在前边的每一层都有一个皇后 找出当前位置是不是能放
        for(int i=0;i<level;i++){
            if(chessboard[i][col]=='Q'){
                //垂直上面有Q
                return false;
            }
        }

        //检查45度---左上角遍历
        for(int i=level-1,j=col-1;i>=0&&j>=0;i--,j--){
            if(chessboard[i][j]=='Q'){
                return false;
            }
            return true;
        }

        //135
        for(int i=level-1,j=col+1;i>=0&&j<=n-1;i--,j++){
            if(chessboard[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }

    List Array2List(char[][] chessboard) {
        List<String> list = new ArrayList<>();

        for (char[] c : chessboard) {
            list.add(String.copyValueOf(c));
        }
        return list;
    }
}
