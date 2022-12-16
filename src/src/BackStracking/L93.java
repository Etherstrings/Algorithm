package src.BackStracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Etherstrings
 * @create 2022-05-23 9:23 BackStracking - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L93 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/5/23 - the current system date.  9:23 - the current system time.  2022 - the current year.  05 - the current month.  23 - the current day of the month.  09 - the current hour.  23 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  5月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  五月 - full name of a month. Example: January, February, etc
 */
public class L93 {
    //终止条件
    //明确说了只会切成四段----那就是三个点----判断最后一段是不是可以用

    List<String> Result=new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        BackTracking(s,0,0);
        return Result;
    }


    private void BackTracking(String s,int startindex,int pointnum){

        //结束条件
        if(pointnum==3){
            //逗点为三 分割结束了
            //判断最后一个分割出来的分割串 是否可用
            if(Isuse(s,startindex,s.length()-1)){
                Result.add(s);
            }
        }

        //每层的条件
        for(int i=startindex;i<s.length();i++){
            //判断[startindex,i]这个区间里的是否合法
            if(Isuse(s,startindex,i)){
                //合法
                pointnum+=1;
                StringBuffer news=new StringBuffer(s);
                news.insert(i+1,'.');
                s= news.toString();
                BackTracking(s,i+2,pointnum);
                pointnum-=1;
                news=new StringBuffer(s);
                news.deleteCharAt(i+1);
                s=news.toString();
            }else {
                break;
            }
        }
    }

    private boolean Isuse(String s,int start,int end){
        if(start>end){
            return false;
        }

        if(s.charAt(start)=='0'&&start!=end){
            return false;
        }
        int num = 0;
        for (int i = start; i <= end; i++) {
            if (s.charAt(i) > '9' || s.charAt(i) < '0') { // 遇到⾮数字字符不合法
                return false;
            }
            num = num * 10 + (s.charAt(i) - '0');
            if (num > 255) { // 如果⼤于255了不合法
                return false;
            }
        }
        return true;

    }

}
