package src.BackStracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Etherstrings
 * @create 2022-05-31 13:59 BackStracking - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L5 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/5/31 - the current system date.  13:59 - the current system time.  2022 - the current year.  05 - the current month.  31 - the current day of the month.  13 - the current hour.  59 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  5月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  五月 - full name of a month. Example: January, February, etc
 */
public class L5 {
    List<List<String>> Asnwer=new ArrayList<>();
    LinkedList<String> Path=new LinkedList<>();
    public String longestPalindrome(String s) {
        //找所有的回文子串
        BackTarcking(s,0);
        int max=0;
        List<String> RelAsnwer=new ArrayList<>();
        for(List<String> a:Asnwer){
            for(String b:a){
                if(b.length()>=max){
                    max=Math.max(max,b.length());
                    RelAsnwer.add(b);
                }

            }
        }
        String d="";
        for(String c:RelAsnwer){
            if(c.length()==max){
                d=c;
            }
        }

        return d;
    }

    void BackTarcking(String s,int index){
        if(index==s.length()){
            Asnwer.add(new ArrayList<>(Path));
            return;
        }
        for(int i=1;i<s.length()-1;i++){
            String temp=s.substring(index,i);
            if(isHuiwen(temp)){
                Path.add(temp);
                BackTarcking(s,index+i);
                Path.removeLast();
            }
        }
    }




    boolean isHuiwen(String s){
        if(s.length()==0){
            return false;
        }
        if(s.length()==1){
            return true;
        }
        if(s.length()==2){
            if(s.charAt(0)==s.charAt(1)){
                return true;
            }else {
                return false;
            }
        }
        for(int i=0;i<s.length()/2;i++){
            if(s.charAt(i)!=s.charAt(s.length()-1-i)){
                return false;
            }
        }
        return true;
    }
}
