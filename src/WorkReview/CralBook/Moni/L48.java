package WorkReview.CralBook.Moni;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2026-01-08
 */
public class L48 {
    public static void main(String[] args) {
        //输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
        //输出：[[7,4,1],[8,5,2],[9,6,3]]
        new L48().rotate(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
    }
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] ans = new int[n][n];
        for (int i=0;i<n;i++) {
            int[] row = matrix[i];
            for (int j=0;j<n;j++) {
                ans[j][n-i-1] = row[j];
            }
        }
        matrix = ans;
    }
}
