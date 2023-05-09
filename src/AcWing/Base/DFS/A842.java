package AcWing.Base.DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2023-05-02 13:01 AcWing.Base.DFS - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  A842 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/5/2 - the current system date.  13:01 - the current system time.  2023 - the current year.  05 - the current month.  02 - the current day of the month.  13 - the current hour.  01 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  5月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  五月 - full name of a month. Example: January, February, etc
 */
public class A842 {
    //842. 排列数字
    //   题目
    //   提交记录
    //   讨论
    //   题解
    //   视频讲解
    //
    //给定一个整数 n
    //，将数字 1∼n
    // 排成一排，将会有很多种排列方法。
    //
    //现在，请你按照字典序将所有的排列方法输出。
    //
    //输入格式
    //共一行，包含一个整数 n
    //。
    //
    //输出格式
    //按字典序输出所有排列方案，每个方案占一行。
    //
    //数据范围
    //1≤n≤7
    //输入样例：
    //3
    //输出样例：
    //1 2 3
    //1 3 2
    //2 1 3
    //2 3 1
    //3 1 2
    //3 2 1
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        boolean[] used=new boolean[n+1];
        dfs(n,used);
    }
    public static LinkedList<Integer> Path=new LinkedList<>();
    public static void dfs(int n,boolean[] used){
        if(Path.size()==n){
            ArrayList<Integer> ans = new ArrayList<>(Path);
            for(int i=0;i<ans.size();i++){
                if(i==ans.size()-1){
                    System.out.println(ans.get(i));
                    continue;
                }
                System.out.print(ans.get(i)+" ");
            }
        }
        for(int i=1;i<=n;i++){
            if(used[i]){
                continue;
            }
            if(used[i]==false){
                //当前可以用
                used[i]=true;
                Path.add(i);
                dfs(n,used);
                Path.removeLast();
                used[i]=false;
            }
        }
    }
}
