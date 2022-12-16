package src.Tulun;

import java.util.Arrays;
import java.util.List;

/**
 * @author Etherstrings
 * @create 2022-09-14 11:38 Tulun - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L841_DFS - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/14 - the current system date.  11:38 - the current system time.  2022 - the current year.  09 - the current month.  14 - the current day of the month.  11 - the current hour.  38 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class L841_DFS {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited=new boolean[rooms.size()];
        //深度优先遍历
        //通过当前的key能到的房间--往深层次寻找
        Arrays.fill(visited,false);
        //首先可以不用钥匙进入到0
        DFS(0,visited,rooms);
        boolean flag=true;
        for(boolean temp:visited){
            if(temp==false){
                //存在没有进入的房间
                flag=false;
                break;
            }
        }
        return flag;

    }

    void DFS(int key,boolean[] visited,List<List<Integer>> rooms){
        //两种方式
        //第一种是我当前进入这个 我当前判断
        //第二种是考虑 我进入的下一个能不能进
        if(visited[key]){
            return;
        }
        visited[key]=true;
        for(int k:rooms.get(key)){
            //取出当前房间的每一把钥匙
            //进行各自的分支
            DFS(k,visited,rooms);
        }
    }


}
