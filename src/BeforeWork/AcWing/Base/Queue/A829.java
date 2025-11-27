package AcWing.Base.Queue;

import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2023-03-30 21:18 AcWing.Base.Queue - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  A829 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/30 - the current system date.  21:18 - the current system time.  2023 - the current year.  03 - the current month.  30 - the current day of the month.  21 - the current hour.  18 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class A829 {
    //数组来模拟队列
    public static int N=100010;
    public static int[] que=new int[N];
    //hh头
    //tt尾
    public static int hh = 0, tt = -1;

    //在尾插入元素
    public static void offer(int x){
        tt++;
        que[tt]=x;
    }
    //在头弹出元素
    public static void pop(){
        hh++;
    }

    public static boolean isEmpty(){
        if(hh<=tt){
            return false;
        }else {
            return true;
        }
    }

    public static int peek(){
        return que[hh];
    }

    public static int size(){
        return tt-hh+1;
    }

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int M=in.nextInt();
        for(int i=1;i<=M;i++){
            String key=in.next();
            if(key.equals("push")){
                offer(in.nextInt());
                continue;
            }
            if(key.equals("pop")){
                pop();
                continue;
            }
            if(key.equals("empty")){
                if(isEmpty()){
                    System.out.println("YES");
                }else {
                    System.out.println("NO");
                }
                continue;
            }
            if(key.equals("query")){
                System.out.println(peek());
            }
        }
    }
}
