package AcWing.Base.DFS;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2023-05-09 17:28 AcWing.Base.DFS - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  A846_JAPI - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/5/9 - the current system date.  17:28 - the current system time.  2023 - the current year.  05 - the current month.  09 - the current day of the month.  17 - the current hour.  28 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  5月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  五月 - full name of a month. Example: January, February, etc
 */
public class A846_JAPI {
    //846. 树的重心
    //   题目
    //   提交记录
    //   讨论
    //   题解
    //   视频讲解
    //
    //给定一颗树，树中包含 n
    // 个结点（编号 1∼n
    //）和 n−1
    // 条无向边。
    //
    //请你找到树的重心，并输出将重心删除后，剩余各个连通块中点数的最大值。
    //
    //重心定义：重心是指树中的一个结点，如果将这个点删除后，剩余各个连通块中点数的最大值最小，那么这个节点被称为树的重心。
    //
    //输入格式
    //第一行包含整数 n
    //，表示树的结点数。
    //
    //接下来 n−1
    // 行，每行包含两个整数 a
    // 和 b
    //，表示点 a
    // 和点 b
    // 之间存在一条边。
    //
    //输出格式
    //输出一个整数 m
    //，表示将重心删除后，剩余各个连通块中点数的最大值。
    //
    //数据范围
    //1≤n≤105
    //输入样例
    //9
    //1 2
    //1 7
    //1 4
    //2 8
    //2 5
    //4 3
    //3 9
    //4 6
    //输出样例：
    //4
    public static void main(String[] args) {
        //使用Java提供的API来保存图
        //主要使用的为 object[] Tree数组 + LinkedList<Integer> 来保存图
        //意思为：当前节点为n的父节点，可以到达哪些节点
        Scanner in=new Scanner(System.in);
        int n=Integer.parseInt(in.nextLine());
        //[0,n]
        tree=new Object[n+1];
        for(int i=0;i<(n-1);i++){
            //a和b之间有联通图
            String[] line=in.nextLine().split(" ");
            int a=Integer.parseInt(line[0]);
            int b=Integer.parseInt(line[1]);
            //无向图 存储两遍
            add(a,b);
            add(b,a);
        }
        ans=n+1;
        boolean[] state=new boolean[n+1];
        dfs(1,n,tree,state);
        System.out.println(ans);
    }
    public static int ans;
    public static Object[] tree;

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

    /**
     * 深搜返回以u为根的子树的大小
     * @param u:这个节点的编号，几号节点
     * @param n:总节点的个数
     * @param tree:无向图
     * @param state:当前的一个状态，判断这个节点是不是看过
     * @return 返回以u为根的子树的大小
     */
    public static int dfs(int u,int n,Object[] tree,boolean[] state){
        //这个点看过了
        state[u]=true;
        //取出这个点可以到达的所有路
        List<Integer> list=(List<Integer>)tree[u];
        if(list==null){
            return 1;
        }
        //统计当前节点子树的所有节点
        //设置为1的原因是因为当前的节点值为1
        int cont=1;

        //统计最大连通块的大小
        //最大连通块的大小，其实就是其中子树的大小
        int res=0;
        for(int index:list){
            if(!state[index]){
                int child=dfs(index,n,tree,state);

                //保证res中存的是最大的那颗子树结点数目
                res=Math.max(res,child);

                cont+=child;
            }
        }
        //看看是上图二中红色部分大还是蓝色部分大
        res=Math.max(res,n-cont);

        ans=Math.min(ans,res);

        return cont;
    }
}
