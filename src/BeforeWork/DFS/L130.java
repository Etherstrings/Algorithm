package DFS;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2023-10-08
 */
public class L130 {
    //DFS考虑怎么进行
    //依然是寻找入口，四周所有的O就是入口
    //这些入口所有可以接触到的O都是不需要变化的，将其变为#，然后遍历整个矩阵，将O变为X，#变为O
    public void solve(char[][] board){
        int row=board.length;
        int col=board[0].length;
        //遍历四周，将这些更新为#，并且将这些#作为入口
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(i==0||i==row-1||j==0||j==col-1){
                    if(board[i][j]=='O'){
                        dfs(board,i,j);
                    }
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

    public void dfs(char[][] board,int x,int y){
        int[][] dir={{0,1},{0,-1},{1,0},{-1,0}};
        int row=board.length;
        int col=board[0].length;
        board[x][y]='#';
        for(int i=0;i<4;i++){
            int newx=x+dir[i][0];
            int newy=y+dir[i][1];
            if(newx>=0&&newx<row&&newy>=0&&newy<col&&board[newx][newy]=='O'){
                dfs(board,newx,newy);
            }
        }
    }
}
