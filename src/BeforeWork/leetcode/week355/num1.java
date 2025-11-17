package leetcode.week355;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Etherstrings
 * @create 2023-07-23 10:33 leetcode.week355 - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  num1 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/7/23 - the current system date.  10:33 - the current system time.  2023 - the current year.  07 - the current month.  23 - the current day of the month.  10 - the current hour.  33 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  7月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  七月 - full name of a month. Example: January, February, etc
 */
public class num1 {
    public static void main(String[] args) {

        List<String> words=new ArrayList<>();
        words.add("#@");
        List<String> t=splitWordsBySeparator(words,'@');
        for(String n:t){
            System.out.print(n+" ");
        }
    }
    public static List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> ans=new ArrayList<>();

        for(String todo:words){
            if(!todo.contains(separator+"")){
                ans.add(todo);
                continue;
            }
            int start=0;
            for(int i=0;i<todo.length();i++){
                if(i==0&&todo.charAt(i)==separator){
                    start=1;
                    continue;
                }
                if(i==todo.length()-1){
                    if(todo.charAt(i)==separator){
                        if(i-start>=1){
                            if(start<= todo.length()-1&&todo.charAt(start)!=separator){
                                ans.add(todo.substring(start,i));
                            }
                        }
                        start=i+1;
                        continue;
                    }else {
                        ans.add(todo.substring(start,todo.length()));
                    }
                }
                if(todo.charAt(i)==separator){
                    if(i-start>=1){
                        if(start<= todo.length()-1&&todo.charAt(start)!=separator){
                            ans.add(todo.substring(start,i));
                        }
                    }
                    start=i+1;
                    continue;
                }
            }
        }
        return ans;
    }

}
