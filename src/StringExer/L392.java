package StringExer;

/**
 * @author Etherstrings
 * @create 2022-07-15 19:23 StringExer - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L392 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/7/15 - the current system date.  19:23 - the current system time.  2022 - the current year.  07 - the current month.  15 - the current day of the month.  19 - the current hour.  23 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  7月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  七月 - full name of a month. Example: January, February, etc
 */
public class L392 {
    //392. 判断子序列
    //给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
    //
    //字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
    //
    //进阶：
    //
    //如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
    //
    //致谢：
    //
    //特别感谢 @pbrother 添加此问题并且创建所有测试用例。
    //
    //
    //
    //示例 1：
    //
    //输入：s = "abc", t = "ahbgdc"
    //输出：true
    //示例 2：
    //
    //输入：s = "axc", t = "ahbgdc"
    //输出：false
    public boolean isSubsequence(String s, String t) {
        //s的顺序不可以变
        char[] chars = s.toCharArray();
        boolean flag=true;
        int now=-2;
        for(int i=0;i<chars.length;i++){
            int index=t.indexOf(chars[i]);
            if(index==-1){
                //没找到 已经寄了
                flag=false;
                break;
            }

            //找到了 但是是在上一个字母的位置是1
            // 那么当前的位置就必须在后面
            if(index<now){
                flag=false;
                break;
            }
            now=index;
        }
        return flag;
    }

    public boolean isSubsequence1(String s, String t){
        if(s.length()<t.length()){
            return false;
        }
        if(t.equals("")){
            return false;
        }
        int fast=0;
        boolean Flag=true;
        for(int slow=0;slow<s.length();slow++){
            Character temp=s.charAt(slow);
            while(t.charAt(fast)!=temp){
                fast++;
                if(fast==t.length()){
                    //已经找不到了
                    Flag=false;
                    break;
                }
            }
            fast++;
            if(Flag==false){
                break;
            }
        }
        return Flag;
    }

}
