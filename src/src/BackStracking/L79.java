package src.BackStracking;

public class L79 {
    //给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
    //
    //单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
    //
    //
    //
    //示例 1：
    //
    //
    //输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
    //输出：true
    //示例 2：
    //
    //
    //输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
    //输出：true
    //示例 3：
    //
    //
    //输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
    //输出：false
    public boolean exist(char[][] board, String word) {
        //有两个回溯都要写
        //舍弃一个  选择回溯word
        //这个循环的意义是：在board上的每一个位置都开始回溯
        int level=board.length,col=board[0].length;
        boolean[][] visited = new boolean[level][col];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                boolean result=backTarcking(board,visited,i,j,word,0);
                if(result){
                    return true;
                }
            }
        }
        return false;
    }

    boolean backTarcking(char[][] board,boolean[][] vistied,int i,int j,String word,int index){
        if(index==word.length()-1){
            //如果可以查到word的最后一位
            //成功了
            return true;
        }else if(board[i][j]!=word.charAt(index)){
            //如果当前的字母 不是最后一位
            //失败了
            return false;
        }


        vistied[i][j]=true;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        boolean result=false;

        for(int []dir:directions){
            //这里是写上下左右
            //四个方向依次循环判断--回溯
            int newi = i + dir[0], newj = j + dir[1];
            if (newi >= 0 && newi < board.length && newj >= 0 && newj < board[0].length) {
                if (!vistied[newi][newj]) {
                    boolean flag = backTarcking(board, vistied, newi, newj, word, index + 1);
                    if (flag) {
                        result = true;
                        break;
                    }
                }
            }
        }
        vistied[i][j]=false;

        return result;

    }
}
