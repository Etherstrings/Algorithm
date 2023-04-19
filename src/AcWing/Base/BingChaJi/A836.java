package AcWing.Base.BingChaJi;

import java.util.Scanner;

public class A836 {
    public static int n=100010;
    public static int[] P=new int[n];
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        //初始化 将每一个集合指向自己
        for(int i=0;i<P.length;i++){
            P[i]=i;
        }
        while(in.hasNextLine()){
            String[] line1=in.nextLine().split(" ");
            int N=Integer.parseInt(line1[0]);
            int M=Integer.parseInt(line1[1]);
            for(int i=0;i<M;i++){
                String[] line=in.nextLine().split(" ");
                String opt =line[0]+"";
                int a=Integer.parseInt(line[1]);
                int b=Integer.parseInt(line[2]);
                if(opt.equals("M")){
                    merge(a,b);
                }
                if(opt.equals("Q")){
                    System.out.println(query(a,b));
                }
            }
        }

    }

    public static void merge(int a,int b){
        //将a的祖先点的父节点置为b的祖先节点
        P[find(a)] = find(b);
    }

    public static String query(int a,int b){
        if(find(a)==find(b)){
            return "Yes";
        }
        return "No";
    }

    //返回x的祖宗节点
    public static int find(int x){ //返回x的祖先节点 + 路径压缩
        //祖先节点的父节点是自己本身
        if(P[x] != x){
            //将x的父亲置为x父亲的祖先节点,实现路径的压缩
            P[x] = find(P[x]);
        }
        return P[x];
    }
    /**
     *     //1.路径分裂的压缩方式
     *     public static int findroot(int x){
     *         while(x!=P[x]){
     *             int parent=P[x];
     *             P[x]=P[P[x]];
     *             x=parent;
     *         }
     *         return x;
     *     }
     *     //2.路径减半的压缩方式
     *     public static int findroot(int x){
     *         while(x!=P[x]){
     *             //将当前的P指向自己的子节点指向的地方
     *             P[x]=P[P[x]];
     *             //换指针
     *             x=P[x];
     *         }
     *     }
     *
     *
     *
     */

}
