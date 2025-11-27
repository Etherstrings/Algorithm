package AcWing.Base.Tree_Grid.Dijkstra;

import java.util.*;

/**
 * @author Etherstrings
 * @create 2023-05-11 10:37 AcWing.Base.Tree_Grid.Dijkstra - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  A850_JAPI - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/5/11 - the current system date.  10:37 - the current system time.  2023 - the current year.  05 - the current month.  11 - the current day of the month.  10 - the current hour.  37 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  5月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  五月 - full name of a month. Example: January, February, etc
 */
public class A850_JAPI {
    //850. Dijkstra求最短路 II
    //   题目
    //   提交记录
    //   讨论
    //   题解
    //   视频讲解
    //
    //给定一个 n
    // 个点 m
    // 条边的有向图，图中可能存在重边和自环，所有边权均为非负值。
    //
    //请你求出 1
    // 号点到 n
    // 号点的最短距离，如果无法从 1
    // 号点走到 n
    // 号点，则输出 −1
    //。
    //
    //输入格式
    //第一行包含整数 n
    // 和 m
    //。
    //
    //接下来 m
    // 行每行包含三个整数 x,y,z
    //，表示存在一条从点 x
    // 到点 y
    // 的有向边，边长为 z
    //。
    //
    //输出格式
    //输出一个整数，表示 1
    // 号点到 n
    // 号点的最短距离。
    //
    //如果路径不存在，则输出 −1
    //。
    //
    //数据范围
    //1≤n,m≤1.5×105
    //,
    //图中涉及边长均不小于 0
    //，且不超过 10000
    //。
    //数据保证：如果最短路存在，则最短路的长度不超过 109
    //。
    //
    //输入样例：
    //3 3
    //1 2 2
    //2 3 1
    //1 3 4
    //输出样例：
    //3
    public static int N=100010;
    //邻接表-数组+List<int[]>实现
    public static Object[] tree;
    //状态数组
    public static boolean[] state;
    //最终的答案 距离数组
    public static int[] dist;
    //优先队列-小顶堆-因为每次要选距离最近的作为更新点
    public static Queue<int[]> Small;

    public static int n,m;
    public static void main(String[] args) {
        //初始化
        tree=new Object[N];
        state=new boolean[N];
        dist=new int[N];
        Arrays.fill(tree,null);
        Arrays.fill(dist,Integer.MAX_VALUE);
        Scanner in=new Scanner(System.in);
        n=in.nextInt();
        m=in.nextInt();
        for(int i=0;i<m;i++){
            int a=in.nextInt();
            int b=in.nextInt();
            int c=in.nextInt();
            add(a,b,c);
        }
        System.out.println(Dijkstra());
    }
    public static int Dijkstra(){
        Small = new PriorityQueue<>((x, y) -> (x[1] - y[1]));
        //找距离1号点的位置
        //因此确定了1号点出发到1号点的距离为0
        dist[1]=0;
        Small.offer(new int[]{1,0});
        while(Small.size()!=0){
            //拉出来当前距离最近的一个点
            int[] now=Small.poll();
            //这个点是哪个点
            int t=now[0];
            //这个点当前到1号点的距离是多少
            int distance=now[1];
            //如果看过了，就是已经确定了 可以直接省略这个点
            if(state[t]==true){
                continue;
            }
            state[t]=true;
            List<int[]> list=(List<int[]>)tree[t];
            if(list!=null){
                //更新从这个点可以到的所有点的距离
                for(int[] pair:list){
                    //这个是从t出发可以到达的其中一个点是哪个点
                    int index=pair[0];
                    //从t出发到这个index点的距离是多少
                    int t_index_value=pair[1];

                    //比如说1可以到2 1_2=2
                    //未更新前 dist[2]=Max
                    //和右边的比较 当前的为左边距离0 右边距离为1_2=2
                    //所以更新为2
                    if(dist[index]>distance+t_index_value){
                        dist[index]=distance+t_index_value;
                        Small.offer(new int[]{index,dist[index]});
                    }
                }
            }
        }
        if(dist[n]!=Integer.MAX_VALUE){
            return dist[n];
        }
        return -1;
    }
    //带权重的图
    public static void add(int a,int b,int c){
        List<int[]> list;
        if(tree[a]==null){
            //当前a这个地方还没有初始化可以到哪些点
            list=new LinkedList<>();
            list.add(new int[]{b,c});
            tree[a]=list;
        }else {
            //当前已经存了其中可以到哪些点
            //需要再假如一个点
            list = (List<int[]>) tree[a];
            //这里直接取出的是带指针的数组，不用再度赋值
            list.add(new int[]{b,c});
        }

    }

}
