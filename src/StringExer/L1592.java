package StringExer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Etherstrings
 * @create 2022-09-10 2:10 StringExer - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L1592 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/10 - the current system date.  2:10 - the current system time.  2022 - the current year.  09 - the current month.  10 - the current day of the month.  02 - the current hour.  10 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class L1592 {
    public String reorderSpaces(String text) {
        int kongge=0;
        for(int i=0;i<text.length();i++){
            if(text.charAt(i)==' '){
                kongge++;
            }
        }
        if(kongge==0){
            return text;
        }
        if(kongge==1){
            if(text.charAt(0)==' '){
                return text.substring(1,text.length())+" ";
            }else {
                return text;
            }
        }
        //拆分字符串---存的都是word
        //先根据空格拆分
        String[] tests=text.split(" ");
        List<String> words=new ArrayList<>();
        for(String temp:tests){
            String now="";
            for(char a:temp.toCharArray()){
                if(a!=' '){
                    now+=a;
                }else {
                    continue;
                }
            }
            if(now!=""){
                words.add(now);
            }
        }
        if(kongge==1){
            return words.get(0)+" ";
        }
        //有多少个空位
        int n=words.size()-1;
        //每个空分多少个空格 剩下多少个?
        int howmany=0;
        int left=0;
        if(kongge!=0&&n!=0){
            if(kongge%n==0){
                howmany=kongge/n;
                left=0;
            }else {
                left=kongge%n;
                howmany=kongge/n;
            }
        }

        String normal="";
        String last="";

        for(int i=0;i<howmany;i++){
            normal+=" ";
        }
        for(int i=0;i<left;i++){
            last+=" ";
        }
        if(n==0){
            last="";
            for(int i=0;i<kongge;i++){
                last+=" ";
            }
        }
        String ans="";
        for(int i=0;i<words.size();i++){
            if(i==words.size()-1){
                ans+= words.get(i);
                ans+=last;
                continue;
            }
            ans+= words.get(i);
            ans+=normal;
        }
        return ans;
    }
}
