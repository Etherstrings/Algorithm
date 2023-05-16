package AcWing.Base.DFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2023-05-16 22:15 AcWing.Base.DFS - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  A860_JAPI - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/5/16 - the current system date.  22:15 - the current system time.  2023 - the current year.  05 - the current month.  16 - the current day of the month.  22 - the current hour.  15 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  5月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  五月 - full name of a month. Example: January, February, etc
 */
public class A860_JAPI {
    //860. 染色法判定二分图
    //   题目
    //   提交记录
    //   讨论
    //   题解
    //   视频讲解
    //
    //给定一个 n
    // 个点 m
    // 条边的无向图，图中可能存在重边和自环。
    //
    //请你判断这个图是否是二分图。
    //
    //输入格式
    //第一行包含两个整数 n
    // 和 m
    //。
    //
    //接下来 m
    // 行，每行包含两个整数 u
    // 和 v
    //，表示点 u
    // 和点 v
    // 之间存在一条边。
    //
    //输出格式
    //如果给定图是二分图，则输出 Yes，否则输出 No。
    //
    //数据范围
    //1≤n,m≤105
    //输入样例：
    //4 4
    //1 3
    //1 4
    //2 3
    //2 4
    //输出样例：
    //Yes

    //1.二分图什么意思？所有的节点可以被划分为两个集合
    //2.什么出现就一定不是二分图？出现奇数数目节点的负环
    //3.通过什么判断？
    //4.DFS BFS
    public static int N=100010;
    public static Object[] tree=new Object[N];
    public static int[] Color=new int[N];
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int m=in.nextInt();
        Arrays.fill(tree,null);
        for(int i=0;i<m;i++){
            int a=in.nextInt();
            int b=in.nextInt();
            add(a,b);
            add(b,a);
        }
        boolean flag=true;
        for(int i=1;i<=n;i++){
            //这个判断有点意思
            //为什么要判断这个点是不是被染色过？
            //因为：一旦被染色了，那说明这个点是子集
            //子集的结果存在于父集中
            //不可再看子集--因为重复判断
            if(Color[i]==0){
                if(dfs(i,1)==false){
                    flag=false;
                    break;
                }
            }
        }
        if(flag){
            System.out.println("Yes");
        }else {
            System.out.println("No");
        }
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

    public static boolean dfs(int index,int color){
        Color[index]=color;
        //当前这个index能到哪些点？
        List<Integer> list=(List<Integer>) tree[index];
        if(list!=null){
            for(int now:list){
                //如果当前的未染色，即为0
                if(Color[now]==0){
                    //那当前这一层就用另外一种颜色染色
                    if(dfs(now,3-color)==false){
                        return false;
                    }
                }else {
                    if(Color[now]==color){
                        //子层与当前层颜色相同了
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
