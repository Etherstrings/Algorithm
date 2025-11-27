package AcWing.Base.Tree_Grid.Kruskal;

import java.util.*;

/**
 * @author Etherstrings
 * @create 2023-05-16 18:23 AcWing.Base.Tree_Grid.Kruskal - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  A859 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/5/16 - the current system date.  18:23 - the current system time.  2023 - the current year.  05 - the current month.  16 - the current day of the month.  18 - the current hour.  23 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  5月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  五月 - full name of a month. Example: January, February, etc
 */
public class A859 {
    //859. Kruskal算法求最小生成树
    //   题目
    //   提交记录
    //   讨论
    //   题解
    //   视频讲解
    //
    //给定一个 n
    // 个点 m
    // 条边的无向图，图中可能存在重边和自环，边权可能为负数。
    //
    //求最小生成树的树边权重之和，如果最小生成树不存在则输出 impossible。
    //
    //给定一张边带权的无向图 G=(V,E)
    //，其中 V
    // 表示图中点的集合，E
    // 表示图中边的集合，n=|V|
    //，m=|E|
    //。
    //
    //由 V
    // 中的全部 n
    // 个顶点和 E
    // 中 n−1
    // 条边构成的无向连通子图被称为 G
    // 的一棵生成树，其中边的权值之和最小的生成树被称为无向图 G
    // 的最小生成树。
    //
    //输入格式
    //第一行包含两个整数 n
    // 和 m
    //。
    //
    //接下来 m
    // 行，每行包含三个整数 u,v,w
    //，表示点 u
    // 和点 v
    // 之间存在一条权值为 w
    // 的边。
    //
    //输出格式
    //共一行，若存在最小生成树，则输出一个整数，表示最小生成树的树边权重之和，如果最小生成树不存在则输出 impossible。
    //
    //数据范围
    //1≤n≤105
    //,
    //1≤m≤2∗105
    //,
    //图中涉及边的边权的绝对值均不超过 1000
    //。
    //
    //输入样例：
    //4 5
    //1 2 1
    //1 3 2
    //1 4 3
    //2 3 2
    //3 4 4
    //输出样例：
    //6

    //思路
    //1.先对所有的边，按照权重进行从小到大排序
    //2.遍历所有的边，如果a-b不属于一个集合，那就把他们放到一个集合中去
    public static int INF=0x3f3f3f3f;
    public static void main(String[] args) {
        List<int[]> Edges=new ArrayList<>();
        Comparator<int[]> com=new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2]-o2[2];
            }
        };
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int m=in.nextInt();
        for(int i=0;i<m;i++){
            int[] temp=new int[3];
            temp[0]=in.nextInt();
            temp[1]=in.nextInt();
            temp[2]=in.nextInt();
            Edges.add(temp);
        }
        //1.排序所有边
        Collections.sort(Edges,com);
        //2.初始化并查集
        init();
        //3.Kruskal
        int ans=Kruskal(Edges,n);
        if(ans==INF){
            System.out.println("impossible");
        }else {
            System.out.println(ans);
        }
    }
    public static int Kruskal(List<int[]> Edges,int n){
        //整个树的权重总值
        int res=0;
        //总共的边
        int cont=0;
        for(int[] now:Edges){
            int a=now[0];
            int b=now[1];
            int c=now[2];
            int root1=find(a);
            int root2=find(b);
            if(root1!=root2){
                merge(a,b);
                res+=c;
                cont++;
            }
        }
        if(cont<n-1){
            return INF;
        }
        return res;
    }

    public static int N=100010;
    public static int[] P=new int[N];
    public static void init(){
        //初始化 将每一个集合指向自己
        for(int i=0;i<P.length;i++){
            P[i]=i;
        }
    }
    public static void merge(int a,int b){
        //将a的祖先点的父节点置为b的祖先节点
        P[find(a)] = find(b);
    }

    public static int find(int x){ //返回x的祖先节点 + 路径压缩
        //祖先节点的父节点是自己本身
        if(P[x] != x){
            //将x的父亲置为x父亲的祖先节点,实现路径的压缩
            P[x] = find(P[x]);
        }
        return P[x];
    }
}
