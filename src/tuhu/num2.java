package tuhu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Etherstrings
 * @create 2022-09-28 19:20 tuhu - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  num2 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/28 - the current system date.  19:20 - the current system time.  2022 - the current year.  09 - the current month.  28 - the current day of the month.  19 - the current hour.  20 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class num2 {
    public int washCount (int[][] g) {
        // write code here
        //皇后问题
        //多少个用户
        int n=g.length;
        //多少个改装店
        int k=g[0].length;
        boolean[] used=new boolean[k];
        //true为用过了
        for(int i=0;i<used.length;i++){
            used[i]=false;
        }
        Collections.sort(ans);

        return ans.get(ans.size()-1);
    }

    static int sum=0;
    static List<Integer> ans=new ArrayList<>();
    static void dfs(boolean[] used,int[][] g,int level){
        if(level==used.length){
            ans.add(sum);
            return;
        }

        for(int j=0;j<g[0].length;j++){
            //如果这个被用了 以及这个不能放
            if(used[j]==true||g[level][j]==0){
                continue;
            }
            used[j]=true;
            sum++;
            dfs(used,g,level+1);
            used[j]=false;
            sum--;
        }

    }

}
