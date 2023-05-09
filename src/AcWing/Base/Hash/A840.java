package AcWing.Base.Hash;

import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2023-04-29 14:32 AcWing.Base.Hash - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  A840 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/4/29 - the current system date.  14:32 - the current system time.  2023 - the current year.  04 - the current month.  29 - the current day of the month.  14 - the current hour.  32 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  4月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  四月 - full name of a month. Example: January, February, etc
 */
public class A840 {
    //840. 模拟散列表
    //   题目
    //   提交记录
    //   讨论
    //   题解
    //   视频讲解
    //
    //维护一个集合，支持如下几种操作：
    //
    //I x，插入一个数 x
    //；
    //Q x，询问数 x
    // 是否在集合中出现过；
    //现在要进行 N
    // 次操作，对于每个询问操作输出对应的结果。
    //
    //输入格式
    //第一行包含整数 N
    //，表示操作数量。
    //
    //接下来 N
    // 行，每行包含一个操作指令，操作指令为 I x，Q x 中的一种。
    //
    //输出格式
    //对于每个询问指令 Q x，输出一个询问结果，如果 x
    // 在集合中出现过，则输出 Yes，否则输出 No。
    //
    //每个结果占一行。
    //
    //数据范围
    //1≤N≤105
    //
    //−109≤x≤109
    //输入样例：
    //5
    //I 1
    //I 2
    //I 3
    //Q 2
    //Q 5
    //输出样例：
    //Yes
    //No
    public static int N=100003;
    public static int[] h=new int[N];
    public static int[] e=new int[N];
    public static int[] Ne=new int[N];
    public static int idx;
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int N=Integer.parseInt(in.nextLine());
        for(int i=0;i<N;i++){
            String[] line=in.nextLine().split(" ");
            if("I".equals(line[0])){
                insert(Integer.parseInt(line[1]));
            }else {
                if(find(Integer.parseInt(line[1]))){
                    System.out.println("Yes");
                }else {
                    System.out.println("No");
                }
            }
        }

    }
    public static void insert(Integer n){
        int k=Math.abs(n)%N;
        //将当前可用位置的一个链表的值存n
        e[idx]=n;
        //将当前新的这个节点的Next指向
        Ne[idx]=h[k];
        h[k]=idx++;
    }
    public static boolean find(Integer n){
        int k=Math.abs(n)%N;
        for(int i=h[k];i!=-1;i=Ne[i]){
            if(e[i]==n)
                return true;
        }
        return false;
    }
}
