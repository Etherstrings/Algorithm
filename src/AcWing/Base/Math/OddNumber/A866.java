package AcWing.Base.Math.OddNumber;

import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2023-05-18 15:13 AcWing.Base.Math.OddNumber - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  A866 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/5/18 - the current system date.  15:13 - the current system time.  2023 - the current year.  05 - the current month.  18 - the current day of the month.  15 - the current hour.  13 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  5月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  五月 - full name of a month. Example: January, February, etc
 */
public class A866 {
    //866. 试除法判定质数
    //   题目
    //   提交记录
    //   讨论
    //   题解
    //   视频讲解
    //
    //给定 n
    // 个正整数 ai
    //，判定每个数是否是质数。
    //
    //输入格式
    //第一行包含整数 n
    //。
    //
    //接下来 n
    // 行，每行包含一个正整数 ai
    //。
    //
    //输出格式
    //共 n
    // 行，其中第 i
    // 行输出第 i
    // 个正整数 ai
    // 是否为质数，是则输出 Yes，否则输出 No。
    //
    //数据范围
    //1≤n≤100
    //,
    //1≤ai≤231−1
    //输入样例：
    //2
    //2
    //6
    //输出样例：
    //Yes
    //No
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        for(int i=0;i<n;i++){
            if(TryDiv(in.nextInt())){
                System.out.println("Yes");
            }else {
                System.out.println("No");
            }
        }
    }

    public static boolean TryDiv(int x){
        //试除法
        if(x<2){
            return false;
        }
        for(int i=2;i<=x/i;i++){
            if(x%i==0){
                return false;
            }
        }
        return true;
    }
}
