package BackStracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Etherstrings
 * @create 2022-05-13 0:25 BackStracking - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L131 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/5/13 - the current system date.  0:25 - the current system time.  2022 - the current year.  05 - the current month.  13 - the current day of the month.  00 - the current hour.  25 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  5月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  五月 - full name of a month. Example: January, February, etc
 */
public class L131 {
    //131. 分割回文串
    //给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
    //
    //回文串 是正着读和反着读都一样的字符串。
    //
    //
    //
    //示例 1：
    //
    //输入：s = "aab"
    //输出：[["a","a","b"],["aa","b"]]
    //示例 2：
    //
    //输入：s = "a"
    //输出：[["a"]]
    //
    //
    //提示：
    //
    //1 <= s.length <= 16
    //s 仅由小写英文字母组成
    LinkedList<String> Path=new LinkedList<>();
    List<List<String>> Result=new ArrayList<>();
    public List<List<String>> partition(String s) {
        BackTracking(s,0);
        return Result;
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
