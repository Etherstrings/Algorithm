package leetcode.week373;

public class num1 {
    //给你一个大小为 m x n 的整数矩阵 mat 和一个整数 k 。请你将矩阵中的 奇数 行循环 右 移 k 次，偶数 行循环 左 移 k 次。
    //
    //如果初始矩阵和最终矩阵完全相同，则返回 true ，否则返回 false 。
    //
    //
    public boolean areSimilar(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        if(k%n==0){
            return true;
        }
        k=k%n;
        int[][] res = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i%2==0){
                    res[i][(j+k)%n]=mat[i][j];
                }else{
                    res[i][(j-k+n)%n]=mat[i][j];
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(res[i][j]!=mat[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}
