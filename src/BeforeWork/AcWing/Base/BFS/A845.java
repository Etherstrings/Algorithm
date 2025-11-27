package AcWing.Base.BFS;

import java.util.*;

/**
 * @author Etherstrings
 * @create 2023-05-06 16:06 AcWing.Base.BFS - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  A845 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/5/6 - the current system date.  16:06 - the current system time.  2023 - the current year.  05 - the current month.  06 - the current day of the month.  16 - the current hour.  06 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  5月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  五月 - full name of a month. Example: January, February, etc
 */
public class A845 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String[] line=in.nextLine().split(" ");
        String start="";
        for(String N:line){
            start+=N;
        }
        System.out.println(bfs(start));
    }

    public static int bfs(String start){
        String end="12345678x";
        Queue<String> Judge=new LinkedList<>();
        Map<String,Integer> map=new HashMap<>();
        int dx[]={0,1,0,-1}; int dy[]={1,0,-1,0};//四个方向
        Judge.offer(start);
        map.put(start,0);//存初始状态
        while(!Judge.isEmpty()){
            String t=Judge.poll();//取出头一个状态并向前寻找（t过程中不能修改，因为有四次变化 而位置都是map[t]+1）
            if(t.equals(end)) return map.get(t);//直到找到结束状态为止，此时因为临近扩散原理所以一定是最小值；
            int k=t.indexOf('x');//找到x的坐标
            int x=k/3,y=k%3;//将一维下标转二维坐标利于上下左右改变状态

            //上下左右四个方向变换
            for(int i=0;i<4;i++){
                int a=x+dx[i],b=y+dy[i];

                if(a>=0&&a<3&&b>=0&b<3){

                    char arr[]=t.toCharArray();//字符串里面不能交换所以就到字符数组里,不直接修改t（以便后续的次数存储直接+1）
                    swap(arr,k,a*3+b);//交换值&变状态（因为前面是一维存储字符串，所以二维坐标转一维下标）
                    String s=new String(arr);//转成字符串，因为定义队列和map是用String的

                    if(map.get(s)==null){//如果这个状态没出现过就存储这个状态
                        Judge.offer(s);
                        map.put(s,map.get(t)+1);//变化前的次数值加一，因为是+1所以保证四个方向变化的值都是一样的；
                    }
                }
            }

        }
        return -1;
    }

    static void swap(char c[],int a,int b){//用于交换值来变换状态
        char s=c[a];
        c[a]=c[b];
        c[b]=s;
    }
}
