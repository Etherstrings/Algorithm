package AcWing.Base.PreSum;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2023-03-23 15:25 AcWing.Base.PreSum - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  A796_Double_Pre - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/23 - the current system date.  15:25 - the current system time.  2023 - the current year.  03 - the current month.  23 - the current day of the month.  15 - the current hour.  25 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class A796_Double_Pre {
    //S[i,j]的前缀和怎么求？
    //S[j,j]=S[i-1,j]+S[i,j-1]-S[i-1,j-1]+a[i,j]

    //S[x1,y1] S[x2,y2] 子矩阵所有数的和怎么求？
    //S[x2,y2]-S[x1-1,y2]-S[x2,y1-1]+S[x1-1,y1-1]
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int m=in.nextInt();
        int q=in.nextInt();
        int[][] grid=new int[n+1][m+1];
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                grid[i][j]=in.nextInt();
            }
        }

        int[][] Presum=new int[n+1][m+1];
        //先初始化第一行
        for(int i=1;i<m+1;i++){
            if(i==1){
                Presum[1][i]=grid[1][i];
                continue;
            }
            Presum[1][i]=Presum[1][i-1]+grid[1][i];
        }
        //再初始化第一列
        for(int i=1;i<n+1;i++){
            if(i==1){
                continue;
            }
            Presum[i][1]=Presum[i-1][1]+grid[i][1];
        }
        //    //S[i,j]的前缀和怎么求？
        //    //S[j,j]=S[i-1,j]+S[i,j-1]-S[i-1,j-1]+a[i,j]
        //初始化Pre矩阵
        for(int i=2;i<n+1;i++){
            for(int j=2;j<m+1;j++){
                Presum[i][j]=Presum[i-1][j]+Presum[i][j-1]-Presum[i-1][j-1]+grid[i][j];
            }
        }
        //S[x1,y1] S[x2,y2] 子矩阵所有数的和怎么求？
        //S[x2,y2]-S[x1-1,y2]-S[x2,y1-1]+S[x1-1,y1-1]
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<q;i++){
            int x1=in.nextInt();
            int y1=in.nextInt();
            int x2=in.nextInt();
            int y2=in.nextInt();
            int traget=Presum[x2][y2]-Presum[x1-1][y2]-Presum[x2][y1-1]+Presum[x1-1][y1-1];
            ans.add(traget);
        }
        for(int t:ans){
            System.out.println(t);
        }
    }
}
