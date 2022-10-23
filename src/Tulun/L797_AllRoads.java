package Tulun;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Etherstrings
 * @create 2022-09-14 12:03 Tulun - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L797_AllRoads - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/14 - the current system date.  12:03 - the current system time.  2022 - the current year.  09 - the current month.  14 - the current day of the month.  12 - the current hour.  03 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class L797_AllRoads {
    static List<Integer> Path=new ArrayList<>();
    static List<List<Integer>> res=new ArrayList<>();
    static public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        Path.add(0);
        DFS(0,graph);
        return res;
    }

    static void DFS(int now,int[][] graph){
        if(now== graph.length-1){
            res.add(new ArrayList<>(Path));
            return;
        }
        //走当前房间可以走的每一条路
        for(int temp:graph[now]){
            Path.add(temp);
            DFS(temp,graph);
            Path.remove(Path.size()-1);
        }

    }
}
