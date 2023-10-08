package ChaFen;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2023-09-27
 */
public class L2536 {
    //给你一个正整数 n ，表示最初有一个 n x n 、下标从 0 开始的整数矩阵 mat ，矩阵中填满了 0 。
    //
    //另给你一个二维整数数组 query 。针对每个查询 query[i] = [row1i, col1i, row2i, col2i] ，请你执行下述操作：
    //
    //找出 左上角 为 (row1i, col1i) 且 右下角 为 (row2i, col2i) 的子矩阵，将子矩阵中的 每个元素 加 1 。也就是给所有满足 row1i <= x <= row2i 和 col1i <= y <= col2i 的 mat[x][y] 加 1 。
    //返回执行完所有操作后得到的矩阵 mat 。

    //> 2023/09/27 17:33:40
    //解答成功:
    //	执行耗时:7 ms,击败了98.32% 的Java用户
    //	内存消耗:55.4 MB,击败了5.04% 的Java用户
    public static void main(String[] args) {
        int n=3;
        int[][] queries={{1,1,2,2},{0,0,1,1}};
        int[][] mat=rangeAddQueries(n,queries);
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }
    //二维差分
    public static int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] mat=new int[n][n];
        B=new int[n+2][n+2];
        for(int i=0;i<queries.length;i++){
            int x1=queries[i][0]+1;
            int y1=queries[i][1]+1;
            int x2=queries[i][2]+1;
            int y2=queries[i][3]+1;
            insert(x1,y1,x2,y2,1);
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                B[i][j]+=B[i-1][j]+B[i][j-1]-B[i-1][j-1];
                mat[i-1][j-1]=B[i][j];
            }
        }
        return mat;
    }
    public static int[][] B;
    public static void insert(int x1,int y1,int x2,int y2,int c){
        B[x1][y1] += c; //整个矩阵
        B[x2 + 1][y1] -= c; // x2之后(长x2+1...右端，宽y1的长方形)【高】[红色区域]
        B[x1][y2+ 1] -= c; //y2之后 (长x1..右端, 宽y2 + 1..的长方形) 【短粗胖】[绿色区域]
        B[x2 + 1][y2 + 1] += c; // 右下角小矩阵，从x2+1, y2+ 1往右下的矩形
        // 原本O(N) 现在就4*O(1)= O(1). 不用操作矩阵里每个数，只用改这四个。
    }
}
