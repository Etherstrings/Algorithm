package AcWing.Base.Tree_Grid.SPFA;

import java.util.*;

/**
 * @author Etherstrings
 * @create 2023-05-12 17:26 AcWing.Base.Tree_Grid.SPFA - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  A851 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/5/12 - the current system date.  17:26 - the current system time.  2023 - the current year.  05 - the current month.  12 - the current day of the month.  17 - the current hour.  26 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  5月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  五月 - full name of a month. Example: January, February, etc
 */
public class A851 {
    //Java_API实现
    //SPFA算法仅仅只是对BF算法的一个优化。
    //只更新我自己更新的点 其他的不使用
    public static int N=100010;
    //邻接表-数组+List<int[]>实现
    public static Object[] tree;
    public static int[] dist=new int[N];

    public static boolean[] used=new boolean[N];
    public static void main(String[] args) {
        tree=new Object[N];
        Arrays.fill(tree,null);
        Arrays.fill(dist,Integer.MAX_VALUE);
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int m=in.nextInt();
        for(int i=0;i<m;i++){
            int a=in.nextInt();
            int b=in.nextInt();
            int c=in.nextInt();
            add(a,b,c);
        }
        if(spfa(n)){
            System.out.println(dist[n]);
        }else {
            System.out.println("impossible");
        }

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

    //spfa算法
    public static boolean spfa(int n){
        Queue<Integer> que=new LinkedList<>();
        dist[1]=0;
        que.offer(1);
        used[1]=true;

        while(!que.isEmpty()){
            int now=que.poll();
            used[now]=false;

            List<int[]> list=(List<int[]>)tree[now];
            if(list!=null){
                for(int[] temp:list){
                    //从now能到的点-index
                    int index=temp[0];
                    //从now到点index的权重
                    int now_index_v=temp[1];
                    if(dist[index]>dist[now]+now_index_v){
                        dist[index]=dist[now]+now_index_v;
                        //这里我更新了index，那么就要判断，index是不是已经在更新队列里？
                        if(used[index]==false){
                            //没在的话 我就需要标记一下
                            que.offer(index);
                            used[index]=true;
                        }
                    }
                }
            }

        }
        if(dist[n]==Integer.MAX_VALUE){
            return false;
        }else {
            return true;
        }
    }
}
