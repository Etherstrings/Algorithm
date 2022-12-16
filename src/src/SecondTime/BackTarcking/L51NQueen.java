package src.SecondTime.BackTarcking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author： wuboyu
 * @date： 2022-08-23 09:17
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
    public List<List<String>> solveNQueens(int n) {
        String[][] chess=new String[n][n];
        //填充空棋盘
        for(int i=0;i<chess.length;i++){
            Arrays.fill(chess[i],".");
        }
        BackTarcking(chess,0);
        return ans;
    }

    //思路是什么？
    //这一行找完了 放当前位置
    //找下一行
    List<List<String>> ans=new ArrayList<>();
    void BackTarcking(String[][] chess,int level){
        if(level==chess.length){
            ans.add(Array2List(chess));
            return;
        }
        for(int i=0;i<chess[0].length;i++){
            if(keYi(chess,level,i)){
                chess[level][i]="Q";
                BackTarcking(chess,level+1);
                chess[level][i]=".";
            }
        }
    }

    boolean keYi(String[][] chess,int level,int col){
        int n=chess.length;
        //当前列有没有放
        for(int i=0;i<level;i++){
            if(chess[i][col].equals("Q")){
                return false;
            }
        }
        for(int i=level;i<n;i++){
            if(chess[i][col].equals("Q")){
                return false;
            }
        }
        //右上
        for(int i=level,j=col;i>=0&&j<n;i--,j++){
            if(chess[i][j].equals("Q")){
                return false;
            }
        }
        //右下
        for(int i=level,j=col;i<n&&j<n;i++,j++){
            if(chess[i][j].equals("Q")){
                return false;
            }
        }
        //左上
        for(int i=level,j=col;i>=0&&j>=0;i--,j--){
            if(chess[i][j].equals("Q")){
                return false;
            }
        }
        //左下
        for(int i=level,j=col;i<n&&j>=0;i++,j--){
            if(chess[i][j].equals("Q")){
                return false;
            }
        }
        return true;
    }
    public List Array2List(String[][] chess) {
        List<String> list = new ArrayList<>();

        for(String[] temp:chess){
            String now="";
            for(String a:temp){
                now+=a;
            }
            list.add(now);
        }
        return list;
    }
}
