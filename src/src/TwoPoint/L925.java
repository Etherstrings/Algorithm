package src.TwoPoint;

/**
 * @author Etherstrings
 * @create 2022-08-16 20:55 TwoPoint - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L925 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/8/16 - the current system date.  20:55 - the current system time.  2022 - the current year.  08 - the current month.  16 - the current day of the month.  20 - the current hour.  55 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  8月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  八月 - full name of a month. Example: January, February, etc
 */
public class L925 {
    public boolean isLongPressedName(String name, String typed) {
        int slow=0;
        int fast=0;
        while(slow<name.length()&&fast<typed.length()){
            if(name.charAt(slow)==typed.charAt(fast)){
                slow++;
                fast++;
            }else {
                if(fast==0){
                    return false;
                }
                // j跨越重复项，向后移动，同时防止j越界
                while(fast<typed.length()&&typed.charAt(fast)==typed.charAt(fast-1)){
                    fast++;
                }
                if(name.charAt(slow)==typed.charAt(fast)){
                    slow++;
                    fast++;
                }else{
                    //如果不相同 那就直接不匹配了
                    return false;
                }
            }
        }
        if(slow<name.length()){
            return false;
        }
        // 说明type没有匹配完，例如 name:"alex" type:"alexxrrrrssda"
        while(fast<typed.length()){
            if(typed.charAt(fast) == typed.charAt(fast - 1)){
                fast++;
            }else {
                return false;
            }
        }
        return true;
    }
}
