package zhenghao;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author Etherstrings
 * @create 2023-07-25 20:23 zhenghao - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  num2 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/7/25 - the current system date.  20:23 - the current system time.  2023 - the current year.  07 - the current month.  25 - the current day of the month.  20 - the current hour.  23 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  7月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  七月 - full name of a month. Example: January, February, etc
 */
public class num2 {
    public static void main(String[] args) {
        System.out.println(canused("(()())"));
        List<String> temp=getAll(3);
        for(String n:temp){
            System.out.print(n+" ");
        }
    }
    public static List<String> getAll(int n){
        int[] left=new int[]{n,n};
        List<String> tans=new ArrayList<>();
        ans=new ArrayList<>();
        Path=new LinkedList<>();
        backtarcking(left,2*n,0);
        for(String now:ans){
            if(canused(now)){
                tans.add(now);
            }
        }
        return tans;
    }
    public static List<String> ans;
    public static LinkedList<String> Path;
    public static void backtarcking(int[] left,int len,int index){
        if(left[0]==0&&left[1]==0){
            String temp="";
            for(String n:Path){
                temp+=n;
            }
            ans.add(temp);
            return;
        }
        for(int i=index;i<len;i++){
            if(left[0]!=0){
                Path.add(")");
                left[0]-=1;
                backtarcking(left,len,i+1);
                left[0]+=1;
                Path.removeLast();
            }
            if(left[1]!=0){
                Path.add("(");
                left[1]-=1;
                backtarcking(left,len,i+1);
                left[1]+=1;
                Path.removeLast();
            }
        }

    }

    public static boolean canused(String word){
        Stack<String> stack=new Stack<>();
        boolean flag=true;
        for(Character n:word.toCharArray()){
            if(n=='('){
                stack.push(")");
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                //这里我原来写的是pop()
                //我太慌了 一直没看到这里
                if(!")".equals(stack.peek())){
                    return false;
                }
                stack.pop();
            }
        }

        if(!stack.isEmpty()){
            return false;
        }else {
            return true;
        }
    }
}
