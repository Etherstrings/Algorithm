package BackStracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Etherstrings
 * @create 2022-06-07 22:45 BackStracking - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  SII020II - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/6/7 - the current system date.  22:45 - the current system time.  2022 - the current year.  06 - the current month.  07 - the current day of the month.  22 - the current hour.  45 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  6月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  六月 - full name of a month. Example: January, February, etc
 */
public class SII020II {
    LinkedList<String> Path=new LinkedList<>();
    List<List<String>> Result=new ArrayList<>();
    public int countSubstrings(String s){
        BackTracking(s,0);
        int answer=0;
        for(int i=0;i<Result.size();i++){
            for(int j=0;i<Result.get(i).size();j++){
                answer+=1;
            }
        }
        return answer;
    }

    public void BackTracking(String s,int startIndex) {
        //终止条件是什么？
        //查找所有的字串
        //所以必须到最底层才能停止
        if(startIndex>=s.length()){
            Result.add(new ArrayList<>(Path));
            return;
        }

        for(int i=startIndex;i<s.length();i++){
            //如果是回文串 添加
            if(isNot(s,startIndex,i)){
                Path.add(s.substring(startIndex,i+1));
            }else {
                continue;
            }

            //回溯
            BackTracking(s,i+1);
            Path.removeLast();
        }


    }

    //判断是不是回文串的方法
    private boolean isNot(String s,int startindex,int end){
        for(int i=startindex,j=end;i<j;i++,j--){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
        }
        return true;
    }
}
