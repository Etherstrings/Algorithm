package AcWing.Base.Stack;

import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2023-03-30 20:31 AcWing.Base.Stack - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  A828 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/30 - the current system date.  20:31 - the current system time.  2023 - the current year.  03 - the current month.  30 - the current day of the month.  20 - the current hour.  31 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class A828 {
    public static int N=100010;
    public static int[] stack=new int[N];
    public static int index=1;
    public static void push(int x){
        index++;
        stack[index]=x;
    }
    public static int peek(){
        return stack[index];
    }
    public static int pop(){
        int ans=stack[index];
        index--;
        return ans;
    }

    public static boolean isEmpty(){
        if(index==1){
            return true;
        }else {
            return false;
        }
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        index=1;
        int M=in.nextInt();
        for(int i=1;i<=M;i++){
            String key=in.next();
            if(key.equals("push")){
                index++;
                stack[index]=in.nextInt();
                continue;
            }
            if(key.equals("pop")){
                index--;
                continue;
            }
            if(key.equals("empty")){
                if(index==1){
                    System.out.println("YES");
                }else {
                    System.out.println("NO");
                }
                continue;
            }
            if(key.equals("query")){
                System.out.println(stack[index]);
                continue;
            }
        }
    }
}
