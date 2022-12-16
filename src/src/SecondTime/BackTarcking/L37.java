package src.SecondTime.BackTarcking;

/**
 * @description:
 * @author： wuboyu
 * @date： 2022-08-23 10:46
 */
public class L37 {
    public void solveSudoku(char[][] board) {
        Backtarck(board);
    }

    boolean Backtarck(char[][] board){
        //「一个for循环遍历棋盘的行，一个for循环遍历棋盘的列，
        // 一行一列确定下来之后，递归遍历这个位置放9个数字的可能性！」
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]!='.'){
                    continue;
                }


                for(char k='1';k<='9';k++){
                    if(isvaild(i,j,k,board)){
                        board[i][j]=k;
                        if(Backtarck(board)){
                            return true;
                        }
                        board[i][j]='.';
                    }
                }
                return false;
            }
        }
        return true;
    }
    boolean isvaild(int level,int col,char k,char[][] board){
        //同行是否重复
        for(int i=0;i<9;i++){
            if(board[level][i]==k){
                return false;
            }
        }
        //同列是否重复
        for(int j=0;j<9;j++){
            if(board[j][col]==k){
                return false;
            }
        }
        //周围九个是不是重复
        int startRow = (level / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++){
            for (int j = startCol; j < startCol + 3; j++){
                if (board[i][j] == k){
                    return false;
                }
            }
        }
        return true;
    }
}
