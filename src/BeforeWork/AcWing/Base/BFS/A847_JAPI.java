package AcWing.Base.BFS;

import java.util.*;

/**
 * @author Etherstrings
 * @create 2023-05-09 20:39 AcWing.Base.BFS - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  A847 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/5/9 - the current system date.  20:39 - the current system time.  2023 - the current year.  05 - the current month.  09 - the current day of the month.  20 - the current hour.  39 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  5月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  五月 - full name of a month. Example: January, February, etc
 */
public class A847_JAPI{
    //847. 图中点的层次
    //   题目
    //   提交记录
    //   讨论
    //   题解
    //   视频讲解
    //
    //给定一个 n
    // 个点 m
    // 条边的有向图，图中可能存在重边和自环。
    //
    //所有边的长度都是 1
    //，点的编号为 1∼n
    //。
    //
    //请你求出 1
    // 号点到 n
    // 号点的最短距离，如果从 1
    // 号点无法走到 n
    // 号点，输出 −1
    //。
    //
    //输入格式
    //第一行包含两个整数 n
    // 和 m
    //。
    //
    //接下来 m
    // 行，每行包含两个整数 a
    // 和 b
    //，表示存在一条从 a
    // 走到 b
    // 的长度为 1
    // 的边。
    //
    //输出格式
    //输出一个整数，表示 1
    // 号点到 n
    // 号点的最短距离。
    //
    //数据范围
    //1≤n,m≤105
    //输入样例：
    //4 5
    //1 2
    //2 3
    //3 4
    //1 3
    //1 4
    //输出样例：
    //1
    public static void main(String[] args) {
        //BFS
        //Queue来保存
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int m= in.nextInt();
        boolean[] stl=new boolean[n+1];
        tree=new Object[n+1];
        for(int i=0;i<m;i++){
            int a=in.nextInt();
            int b=in.nextInt();
            add(a,b);
        }
        Arrays.fill(d,-1);
        System.out.println(bfs(1,stl,tree,n));

    }
    public static Object[] tree;
    public static int N = 100010;
    //重点为此数组
    //通过当前的值来进行下一个值的更新
    //而且最后返回的为n的值 这样就可以分辨 是没有找到还是找到了没更新
    public static int[] d = new int[N];
    //此方法为存树的两边
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

    public static int bfs(int root,boolean[] stl,Object[] tree,int n){
        d[1]=0;
        Queue<Integer> jud=new LinkedList<>();
        jud.offer(1);
        stl[root]=true;
        int ans=0;
        while(!jud.isEmpty()){
            int now=jud.poll();
            List<Integer> list=(List<Integer>)tree[now];
            if(list!=null){
                for(int index:list){
                    if(stl[index]==false){
                        //可用
                        stl[index]=true;
                        jud.offer(index);
                        d[index]=d[now]+1;
                    }
                }
            }

        }
        return d[n];
    }
}
