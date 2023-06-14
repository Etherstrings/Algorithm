package AcWing.Base.Tree_Grid.XiongYaLi;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2023-05-18 10:47 AcWing.Base.Tree_Grid.XiongYaLi - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  A861_API - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/5/18 - the current system date.  10:47 - the current system time.  2023 - the current year.  05 - the current month.  18 - the current day of the month.  10 - the current hour.  47 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  5月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  五月 - full name of a month. Example: January, February, etc
 */
public class A861_API {
    //861. 二分图的最大匹配
    //   题目
    //   提交记录
    //   讨论
    //   题解
    //   视频讲解
    //
    //给定一个二分图，其中左半部包含 n1
    // 个点（编号 1∼n1
    //），右半部包含 n2
    // 个点（编号 1∼n2
    //），二分图共包含 m
    // 条边。
    //
    //数据保证任意一条边的两个端点都不可能在同一部分中。
    //
    //请你求出二分图的最大匹配数。
    //
    //二分图的匹配：给定一个二分图 G
    //，在 G
    // 的一个子图 M
    // 中，M
    // 的边集 {E}
    // 中的任意两条边都不依附于同一个顶点，则称 M
    // 是一个匹配。
    //
    //二分图的最大匹配：所有匹配中包含边数最多的一组匹配被称为二分图的最大匹配，其边数即为最大匹配数。
    //
    //输入格式
    //第一行包含三个整数 n1
    //、 n2
    // 和 m
    //。
    //
    //接下来 m
    // 行，每行包含两个整数 u
    // 和 v
    //，表示左半部点集中的点 u
    // 和右半部点集中的点 v
    // 之间存在一条边。
    //
    //输出格式
    //输出一个整数，表示二分图的最大匹配数。
    //
    //数据范围
    //1≤n1,n2≤500
    //,
    //1≤u≤n1
    //,
    //1≤v≤n2
    //,
    //1≤m≤105
    //输入样例：
    //2 2 4
    //1 1
    //1 2
    //2 1
    //2 2
    //输出样例：
    //2
    public static int N=510;
    public static Object[] tree;

    //存储当前这个女生匹配的是谁？
    public static int[] Match;
    //判断这个女生是不是已经看过了
    public static boolean[] used;
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        tree=new Object[N];
        Arrays.fill(tree,null);
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
    public static void add(int a,int b){
        List<Integer> list;
        if(tree[a]==null){
            //当前a这个地方还没有初始化可以到哪些点
            list=new LinkedList<>();
            list.add(b);
            tree[a]=list;
        }else {
            //当前已经存了其中可以到哪些点
            //需要再假如一个点
            list = (List<Integer>) tree[a];
            //这里直接取出的是带指针的数组，不用再度赋值
            list.add(b);
        }
    }

    public static boolean Canmatch(int x){
        //找到这个男生能够匹配的所有女生
        List<Integer> list=(List<Integer>) tree[x];
        if(list!=null){
            for(int index:list){
                //当前这个女的
                //在这次男的选择过程中 是不是已经看过了？
                if(used[index]==false){
                    used[index]=true;
                    //什么情况下 才可以连呢？
                    //1.当前这个女生没有连接
                    //2.这个女生连接的男的 可以找到下一个
                    if(Match[index]==0||Canmatch(Match[index])){
                        //连接
                        Match[index]=x;
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
