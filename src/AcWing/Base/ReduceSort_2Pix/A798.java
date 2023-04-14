package AcWing.Base.ReduceSort_2Pix;

import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2023-03-23 23:59 AcWing.Base.ReduceSort_2Pix - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  A798 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/23 - the current system date.  23:59 - the current system time.  2023 - the current year.  03 - the current month.  23 - the current day of the month.  23 - the current hour.  59 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class A798 {
    public static int[][] A;
    public static int[][] B;

    //用Scanner读入数据会超时
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int m=in.nextInt();
        int q=in.nextInt();
        A=new int[1010][1010];
        B=new int[1010][1010];
        //读入A矩阵
        //构造差分矩阵
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                A[i][j]=in.nextInt();
                insert(i,j,i,j,A[i][j]);
            }
        }
        for(int i=0;i<q;i++){
            int x1=in.nextInt();
            int y1=in.nextInt();
            int x2=in.nextInt();
            int y2=in.nextInt();
            int c=in.nextInt();
            insert(x1,y1,x2,y2,c);
        }
        //求前缀和
        //输出前缀和矩阵
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                B[i][j]+=B[i-1][j]+B[i][j-1]-B[i-1][j-1];
                if(j==m){
                    System.out.println(B[i][j]);
                }else {
                    System.out.print(B[i][j]+" ");
                }

            }
        }

    }

    public static void insert(int x1,int y1,int x2,int y2,int c){
        B[x1][y1] += c; //整个矩阵
        B[x2 + 1][y1] -= c; // x2之后(长x2+1...右端，宽y1的长方形)【高】[红色区域]
        B[x1][y2+ 1] -= c; //y2之后 (长x1..右端, 宽y2 + 1..的长方形) 【短粗胖】[绿色区域]
        B[x2 + 1][y2 + 1] += c; // 右下角小矩阵，从x2+1, y2+ 1往右下的矩形
        // 原本O(N) 现在就4*O(1)= O(1). 不用操作矩阵里每个数，只用改这四个。
    }
}
