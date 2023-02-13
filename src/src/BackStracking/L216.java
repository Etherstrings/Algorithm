package src.BackStracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Etherstrings
 * @create 2022-05-10 14:46 BackStracking - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L216 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/5/10 - the current system date.  14:46 - the current system time.  2022 - the current year.  05 - the current month.  10 - the current day of the month.  14 - the current hour.  46 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  5月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  五月 - full name of a month. Example: January, February, etc
 */
public class L216 {

    List<List<Integer>> result=new ArrayList<>();
    LinkedList<Integer> Path=new LinkedList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        BackTarcking(n,k,1,0);
        return result;
    }

    private void BackTarcking(int n,int k,int startindex,int nowsum){

        //确定终止条件
        if(Path.size()==k){
            if(nowsum==n){
                result.add(new ArrayList<>(Path));
            }
            return;
        }


        //单层的循环过程
        for(int i=startindex;i<=k;i++){
            //现在加到多少了？
            nowsum+=i;
            Path.add(i);

            //往深处递归
            BackTarcking(n,k,nowsum,i+1);


            //回溯
            nowsum-=i;
            Path.removeLast();
        }
    }
}
