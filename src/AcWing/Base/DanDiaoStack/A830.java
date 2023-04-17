package AcWing.Base.DanDiaoStack;

import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2023-03-30 22:08 AcWing.Base.DanDiaoStack - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  A830 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/30 - the current system date.  22:08 - the current system time.  2023 - the current year.  03 - the current month.  30 - the current day of the month.  22 - the current hour.  08 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class A830 {
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
        int M=Integer.parseInt(in.nextLine());
        String[] nums=in.nextLine().split(" ");
        for(int i=0;i<nums.length;i++){
            int now=Integer.parseInt(nums[i]);
            if(isEmpty()){
                System.out.print(-1+" ");
                push(now);
                continue;
            }
            while(!isEmpty()&&peek()>=now){
                pop();
            }
            if(isEmpty()){
                System.out.print(-1+" ");
                push(now);
                continue;
            }
            System.out.print(peek()+" ");
            push(now);
        }
    }
}
