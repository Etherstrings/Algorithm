package AcWing.Base.BFS;

import java.util.*;

/**
 * @author Etherstrings
 * @create 2023-05-16 22:50 AcWing.Base.BFS - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  A860_JAPI - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/5/16 - the current system date.  22:50 - the current system time.  2023 - the current year.  05 - the current month.  16 - the current day of the month.  22 - the current hour.  50 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  5月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  五月 - full name of a month. Example: January, February, etc
 */
public class A860_JAPI {
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
                if(bfs(i,1)==false){
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

    public static boolean bfs(int index,int color){
        Queue<int[]> Jud=new LinkedList<>();
        Jud.offer(new int[]{index,color});
        boolean flag=true;
        while(!Jud.isEmpty()){
            int[] node=Jud.poll();
            int nindex=node[0];
            int ncolor=node[1];
            //这个点所有的往下染色
            List<Integer> list=(List<Integer>)tree[nindex];
            if(list!=null){
                for(int now:list){
                    if(Color[now]==0){
                        //可以染色
                        Color[now]=3-ncolor;
                        Jud.offer(new int[]{now,Color[now]});
                    }else {
                        if(Color[now]==ncolor){
                            return false;
                        }
                    }
                }
            }
        }
        return flag;
    }
}
