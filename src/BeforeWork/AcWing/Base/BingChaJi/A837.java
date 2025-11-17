package AcWing.Base.BingChaJi;

import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2023-04-22 13:53 AcWing.Base.BingChaJi - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  A837 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/4/22 - the current system date.  13:53 - the current system time.  2023 - the current year.  04 - the current month.  22 - the current day of the month.  13 - the current hour.  53 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  4月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  四月 - full name of a month. Example: January, February, etc
 */
public class A837 {
    public static int n=100010;
    public static int[] P=new int[n];
    public static int[] Size=new int[n];
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        //初始化 将每一个集合指向自己
        for(int i=0;i<P.length;i++){
            P[i]=i;
            Size[i]=1;
        }
        while(in.hasNextLine()){
            String[] line1=in.nextLine().split(" ");
            int N=Integer.parseInt(line1[0]);
            int M=Integer.parseInt(line1[1]);
            for(int i=0;i<M;i++){
                String[] line=in.nextLine().split(" ");
                String opt =line[0]+"";
                if(opt.equals("C")){
                    int a=Integer.parseInt(line[1]);
                    int b=Integer.parseInt(line[2]);
                    if(a==b){
                        continue;
                    }
                    merge(a,b);
                }
                if(opt.equals("Q1")){
                    int a=Integer.parseInt(line[1]);
                    int b=Integer.parseInt(line[2]);
                    System.out.println(query(a,b));
                }
                if(opt.equals("Q2")){
                    int a=Integer.parseInt(line[1]);
                    System.out.println(query1(a));
                }
            }
        }

    }

    public static void merge(int a,int b){
        //将a的祖先点的父节点置为b的祖先节点
        int roota=find(a);
        int rootb=find(b);
        if(rootb==roota){

        }else {
            Size[rootb]+=Size[roota];
            P[find(a)] = find(b);
        }

    }

    public static String query(int a,int b){
        if(find(a)==find(b)){
            return "Yes";
        }
        return "No";
    }

    public static int query1(int a){
        return Size[find(a)];
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
}
