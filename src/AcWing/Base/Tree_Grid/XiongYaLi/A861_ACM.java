package AcWing.Base.Tree_Grid.XiongYaLi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2023-05-18 11:06 AcWing.Base.Tree_Grid.XiongYaLi - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  A861_ACM - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/5/18 - the current system date.  11:06 - the current system time.  2023 - the current year.  05 - the current month.  18 - the current day of the month.  11 - the current hour.  06 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  5月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  五月 - full name of a month. Example: January, February, etc
 */
public class A861_ACM {
    // 无向图,邻接表指针2*(n-1)故令M为2N
    public static int N=510,M=100010;

    // h[]存储邻接表各个头结点
    public static int[] h=new int[N];
    //index-Value  这个index对应的值
    public static int[] e=new int[M];
    //index.next  这个index对应的下个节点
    public static int[] ne=new int[M];
    //这个为当前链表可用的插槽指向哪里
    public static int idx;


    //存储当前这个女生匹配的是谁？
    public static int[] Match;
    //判断这个女生是不是已经看过了
    public static boolean[] used;
    public static void add(int a,int b){
        e[idx]=b;
        ne[idx]=h[a];
        h[a]=idx;
        idx++;
    }


    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        Arrays.fill(h,-1);
        int n1=in.nextInt();
        int n2=in.nextInt();
        int m=in.nextInt();
        for(int i=0;i<m;i++){
            int u=in.nextInt();
            int v=in.nextInt();
            add(u,v);
        }
        Match=new int[N];
        used=new boolean[N];
        int res=0;
        for(int i=1;i<=n1;i++){
            Arrays.fill(used,false);
            if(Canmatch(i)){
                res++;
            }
        }
        System.out.println(res);
    }

    public static boolean Canmatch(int x){
        //找到这个男生能够匹配的所有女生
        for(int i=h[x];i!=-1;i=ne[i]){
            int index=e[i];
            //当前这个女的
            //在这次男的选择过程中 是不是已经看过了？
            if(used[index]==false){
                used[index]=true;
                //什么情况下 才可以连呢？
                //1.当前这个女生没有连接
                //2.这个女生连接的男的 可以找到下一个
                if(Match[index]==0||Canmatch(Match[index])){
                    Match[index]=x;
                    return true;
                }
            }
        }
        return false;
    }
}
