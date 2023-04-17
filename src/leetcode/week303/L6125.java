package leetcode.week303;

import java.util.HashMap;

/**
 * @author Etherstrings
 * @create 2022-07-24 11:05 leetcode.week303 - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L6125 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/7/24 - the current system date.  11:05 - the current system time.  2022 - the current year.  07 - the current month.  24 - the current day of the month.  11 - the current hour.  05 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  7月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  七月 - full name of a month. Example: January, February, etc
 */
public class L6125 {
    public static int ans=0;
    public static int equalPairs(int[][] grid) {
        //行
        int level=grid.length;
        //列
        int row=grid[0].length;
        backtarcking(grid,0,level,row);
        return ans;
    }

    static void backtarcking(int[][] grid,int start,int level,int row){
        if(start== grid.length){
            return;
        }
        String temp="";
        //拼行
        for(int i=0;i<row-1;i++){
            temp+=grid[start][i];
        }
        for(int i=0;i<row-1;i++){
            //拼列
            String tempcow="";
            for(int j=0;j<level-1;j++){
                tempcow+=grid[j][i];
            }
            if(tempcow.equals(temp)){
                ans++;
            }

        }
        backtarcking(grid,start+1,level,row);

    }


    public static int equalPairs1(int[][] grid){
        //将所有的列拼出来
        int level=grid.length;
        int row=grid[0].length;

        //String 次数
        HashMap<String,Integer> Judge=new HashMap<>();

        for(int i=0;i<row-1;i++){
            String temp="";
            for(int j=0;j<level-1;j++){
                temp+=grid[j][i];
            }
            if(Judge.containsKey(temp)){
                Judge.put(temp,Judge.get(temp)+1);
            }else {
                Judge.put(temp,1);
            }
        }
        int ans=0;
        //循环判断拼行
        for(int i=0;i<level-1;i++){
            String temp="";
            for(int j=0;j<row-1;j++){
                temp+=grid[i][j];
            }
            if(Judge.containsKey(temp)){
                ans+=Judge.get(temp);
            }
        }
        return ans;
    }
}
