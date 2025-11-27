package AcWing.Base.Math.OddNumber;

import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2023-05-29 17:03 AcWing.Base.Math.OddNumber - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  A867 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/5/29 - the current system date.  17:03 - the current system time.  2023 - the current year.  05 - the current month.  29 - the current day of the month.  17 - the current hour.  03 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  5月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  五月 - full name of a month. Example: January, February, etc
 */
public class A867 {
    //867. 分解质因数
    //   题目
    //   提交记录
    //   讨论
    //   题解
    //   视频讲解
    //
    //给定 n
    // 个正整数 ai
    //，将每个数分解质因数，并按照质因数从小到大的顺序输出每个质因数的底数和指数。
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
    //对于每个正整数 ai
    //，按照从小到大的顺序输出其分解质因数后，每个质因数的底数和指数，每个底数和指数占一行。
    //
    //每个正整数的质因数全部输出完毕后，输出一个空行。
    //
    //数据范围
    //1≤n≤100
    //,
    //2≤ai≤2×109
    //输入样例：
    //2
    //6
    //8
    //输出样例：
    //2 1
    //3 1
    //
    //2 3
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        for(int i=0;i<n;i++){
            decompose_prime(in.nextInt());
        }
    }
    public static void decompose_prime(int n) {
        for (int i = 2; i <= n / i; i++) {
            if (n % i == 0) {
                int res = 0;//循环整除判断质因子的指数
                while (n % i == 0) {
                    n /= i;
                    res++;
                }
                System.out.print(i + " " + res + "\n");
            }
        }
        if (n > 1) {//表示存在一个大于sqrt(n)的质因子存在
            System.out.print(n + " 1\n");
        }
        System.out.print("\n");
    }

}
