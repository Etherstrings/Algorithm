package BackStracking;

import java.util.Arrays;

/**
 * @description:
 * @author： wuboyu
 * @date： 2022-08-23 14:06
 */
public class L52 {

    public int totalNQueens(int n) {
        int[][] chess=new int[n][n];
        for(int i=0;i<chess.length;i++){
            Arrays.fill(chess[i],0);
        }
        //0是未设置棋盘
        //1是设置了皇后
        FindAll(chess,0);
        return ans;
    }
    int ans=0;
    void FindAll(int[][] chess,int level){
        //当前位置已经加出去了
        if(level==chess.length){
            ans++;
            return;
        }
        for(int i=0;i<chess.length;i++){
            //判断当前层的当前列能不能放
            if(isok(chess,level,i)){
                chess[level][i]=1;
                FindAll(chess,level+1);
                chess[level][i]=0;
            }
        }
    }

    boolean isok(int[][] chess,int level,int col){
        //行不用看 因为是进入下一行了
        //判断列是不是有相同的
        for(int i=0;i<chess.length;i++) {
            if (i == level) {
                continue;
            }
            if (chess[i][col] == 1) {
                return false;
            }
        }
        //45度角
        for(int i=level-1,j=col-1;i>=0&&j>=0;i--,j--){
            if(chess[i][j]==1){
                return false;
            }
        }
        //135
        for(int i=level-1,j=col+1;i>=0&&j<=chess.length-1;i--,j++){
            if(chess[i][j]==1){
                return false;
            }
        }
        return true;

    }
}
