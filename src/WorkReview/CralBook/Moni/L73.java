package WorkReview.CralBook.Moni;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2026-01-08
 */
public class L73 {
    public static void main(String[] args) {
        //输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
        //输出：[[1,0,1],[0,0,0],[1,0,1]]
        new L73().setZeroes(new int[][]{{1,1,1},{1,0,1},{1,1,1}});
    }
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] mark = new int[m][n];
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                if (matrix[i][j]==0) {
                    mark[i][j]=1;
                }
            }
        }
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                if (mark[i][j]==1) {
                    //行变成0
                    matrix[i] = new int[n];
                    for (int k=0;k<m;k++) {
                        matrix[k][j]=0;
                    }
                }
            }
        }
    }
}
