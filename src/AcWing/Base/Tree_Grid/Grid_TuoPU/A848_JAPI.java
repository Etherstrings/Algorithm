package AcWing.Base.Tree_Grid.Grid_TuoPU;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2023-05-10 12:08 AcWing.Base.Tree_Grid.Grid_TuoPU - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  A848 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/5/10 - the current system date.  12:08 - the current system time.  2023 - the current year.  05 - the current month.  10 - the current day of the month.  12 - the current hour.  08 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  5月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  五月 - full name of a month. Example: January, February, etc
 */
public class A848_JAPI {
    //图的存储
    public static Object[] tree;
    public static int N = 100010;
    //入度数组
    public static int[] Ru=new int[N];

    public static Queue<Integer> que;
    public static Queue<Integer> ans;

    public static int size;

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int m=in.nextInt();
        tree=new Object[N];
        for(int i=0;i<m;i++){
            int a=in.nextInt();
            int b=in.nextInt();
            //入度+1
            Ru[b]++;
            //构建图
            add(a,b);
        }
        //记得初始化
        size=0;
        que=new LinkedList<>();
        ans=new LinkedList<>();
        if(topsort(n)){
            while(!ans.isEmpty()){
                System.out.print(ans.poll()+" ");
            }
        }else {
            System.out.println(-1);
        }
    }
    public static boolean topsort(int n){
        //判断是不是可以有有效的拓扑排序
        for(int i=1;i<=n;i++){
            if(Ru[i]==0){
                que.offer(i);
            }
        }
        while(!que.isEmpty()){
            //每次都要换一个入度为0的遍历
            int now=que.poll();
            //因此用另一个链表作为答案
            ans.offer(now);
            List<Integer> list=(List<Integer>)tree[now];
            if(list!=null){
                for(int index:list){
                    Ru[index]--;
                    //如果这个点在消耗后的入度变为0了，那就可以进来
                    if(Ru[index]==0){
                        que.offer(index);
                    }
                }
            }
        }
        //判断答案链表 是不是和所有点的个数一致 一致就相当于走了一遍
        return ans.size()==n;
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
}
