package AcWing.Base.StackSort;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2023-04-28 15:49 AcWing.Base.StackSort - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  A838 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/4/28 - the current system date.  15:49 - the current system time.  2023 - the current year.  04 - the current month.  28 - the current day of the month.  15 - the current hour.  49 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  4月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  四月 - full name of a month. Example: January, February, etc
 */
public class A838 {
    //838. 堆排序
    //   题目
    //   提交记录
    //   讨论
    //   题解
    //   视频讲解
    //
    //输入一个长度为 n
    // 的整数数列，从小到大输出前 m
    // 小的数。
    //
    //输入格式
    //第一行包含整数 n
    // 和 m
    //。
    //
    //第二行包含 n
    // 个整数，表示整数数列。
    //
    //输出格式
    //共一行，包含 m
    // 个整数，表示整数数列中前 m
    // 小的数。
    //
    //数据范围
    //1≤m≤n≤105
    //，
    //1≤数列中元素≤109
    //输入样例：
    //5 3
    //4 5 1 3 2
    //输出样例：
    //1 2 3
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int m=in.nextInt();
        //小顶堆--堆顶小于每个子孩子
        Queue<Integer> SmallDui = new PriorityQueue<>((x, y) -> (x - y));
        for(int i=0;i<n;i++){
            SmallDui.offer(in.nextInt());
        }
        for(int i=0;i<m;i++){
            System.out.print(SmallDui.poll()+" ");
        }
    }

}
