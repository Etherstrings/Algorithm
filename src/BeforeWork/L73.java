/**
 * @author Justice_wby
 * @create 2023-01-26 16:22
 */
public class L73 {
    //73. 矩阵置零
    //给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
    //
    //
    public void setZeroes(int[][] matrix) {
        if(matrix==null){
            return;
        }
        int level=matrix.length;
        int rol=matrix[0].length;
        boolean[][] flag=new boolean[level][rol];
        for(int i=0;i<level;i++){
            for(int j=0;j<rol;j++){
                if(matrix[i][j]==0){
                    flag[i][j]=true;
                }
            }
        }
        for(int i=0;i<level;i++){
            for(int j=0;j<rol;j++){
                if(flag[i][j]){
                    //上下左右
                    //向上
                    for(int now=i;now>=0;now--){
                        matrix[now][j]=0;
                    }
                    //向下
                    for(int now=i;now<level;now++){
                        matrix[now][j]=0;
                    }
                    //向左
                    for(int now=j;now>=0;now--){
                        matrix[i][now]=0;
                    }
                    //向右
                    for(int now=j;now<rol;now++){
                        matrix[i][now]=0;
                    }
                }
            }
        }
    }
}
