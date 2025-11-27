package AcWing.Base.DFS;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2023-05-09 18:05 AcWing.Base.DFS - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  A846_ACM - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/5/9 - the current system date.  18:05 - the current system time.  2023 - the current year.  05 - the current month.  09 - the current day of the month.  18 - the current hour.  05 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  5月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  五月 - full name of a month. Example: January, February, etc
 */
public class A846_ACM {

    // 无向图,邻接表指针2*(n-1)故令M为2N
    public static int N=100010,M=N*2;

    // h[]存储邻接表各个头结点
    public static int[] h=new int[N];
    //index-Value  这个index对应的值
    public static int[] e=new int[M];
    //index.next  这个index对应的下个节点
    public static int[] ne=new int[M];
    //这个为当前链表可用的插槽指向哪里
    public static int idx;

    /**
     * 头插法
     * e记录当前点的值,ne下一点的地址,h记录指向的第一个点的地址,idx:当前用到了哪个结点(的下标)
     * @param a
     * @param b
     */
    public static void add(int a,int b){
        e[idx]=b;
        ne[idx]=h[a];
        h[a]=idx;
        idx++;
    }

    public static int dfs(int u,boolean[] stl,int n){
        stl[u]=true;

        //这个是比较出来的，哪个子树的值最大或者最小就更新
        int res=0;

        //这个是以当前节点为根节点的所有容量是多少，所以需要初始化为1
        int size=1;

        //当前所对应的单链表的循环遍历
        for(int i=h[u];i!=-1;i=ne[i]){
            int j=e[i];
            //这个点还未用
            if(stl[j]==false){
                //这个子树的是多少？
                int child=dfs(j,stl,n);

                //更新 哪个子树的最大？
                res=Math.max(res,child);

                //当前父子树的Size等于所有子树之和+1
                size+=child;
            }
        }
        //这里遍历的 还少了一个，因为少了一个去掉父节点后的，剩下的一个子数
        res=Math.max(res,n-size);
        ans=Math.min(res,ans);
        return size;
    }

    public static int ans;
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=Integer.parseInt(in.nextLine());
        ans=n+1;
        boolean[] stl=new boolean[N];
        for(int i=0;i<(n-1);i++){
            //a和b之间有联通图
            String[] line=in.nextLine().split(" ");
            int a=Integer.parseInt(line[0]);
            int b=Integer.parseInt(line[1]);
            //无向图 存储两遍
            add(a,b);
            add(b,a);
        }
        //初始化数组
        Arrays.fill(h,-1);
        dfs(1,stl,n);
        System.out.println(ans);
    }
}
