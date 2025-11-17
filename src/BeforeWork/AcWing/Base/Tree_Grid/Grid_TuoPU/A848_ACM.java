package AcWing.Base.Tree_Grid.Grid_TuoPU;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2023-05-10 12:34 AcWing.Base.Tree_Grid.Grid_TuoPU - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  A848_ACM - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/5/10 - the current system date.  12:34 - the current system time.  2023 - the current year.  05 - the current month.  10 - the current day of the month.  12 - the current hour.  34 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  5月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  五月 - full name of a month. Example: January, February, etc
 */
public class A848_ACM {
    public static int N = 100010;
    //下面四个为存图的数组+链表
    static int[] h = new int[N];
    static int[] e = new int[N];
    static int[] ne = new int[N];
    static int idx=0;
    //入度数组
    public static int[] Ru=new int[N];
    //这里为队列
    public static int[] q=new int[N];
    public static int hh=0,tt=-1;//hh是head的缩写，tt->tail，hh指向的是头元素，可以直接取，tt指向的是末尾元素，同样
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int m=in.nextInt();
        //初始化h数组
        Arrays.fill(h,-1);
        for(int i=0;i<m;i++){
            int a=in.nextInt();
            int b=in.nextInt();
            //入度+1
            Ru[b]++;
            //构建图
            add_ACM(a,b);
        }
        if(topsort(n)){
            for(int i=0;i<n;i++){
                System.out.print(q[i]+" ");
            }
        }else {
            System.out.println(-1);
        }
    }
    public static boolean topsort(int n){
        for(int i=1;i<=n;i++){
            if(Ru[i]==0){
                //入队列
                q[++tt]=i;
            }
        }
        while(hh<=tt){
            //这里的意思是 每次都要新取一个入度为0的点
            int t=q[hh++];
            for(int i=h[t];i!=-1;i=ne[i]){
                //取出这个点所能到达的点遍历
                int j=e[i];//i是idx地址，j是节点的代表，需要通过e数组转化
                Ru[j]--;//j节点的入度减一
                if(Ru[j]==0){//j节点如果入度为0的话那么就可以加入queue了（此语句可于上面的语句合并）
                    q[++tt]=j;
                }
            }
        }
        //实际上就是比较是不是所有的点都变成了入度为0的点
        return tt==n-1;
    }
    public static void add_ACM(int a, int b)
    {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }
}
