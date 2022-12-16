package src.StringExer;

/**
 * @author Etherstrings
 * @create 2022-10-23 13:32 StringExer - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L1768 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/10/23 - the current system date.  13:32 - the current system time.  2022 - the current year.  10 - the current month.  23 - the current day of the month.  13 - the current hour.  32 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  10月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  十月 - full name of a month. Example: January, February, etc
 */
public class L1768 {
    public String mergeAlternately(String word1, String word2) {
        //a b交替打印
        int len1=word1.length();
        int len2=word2.length();
        String ans="";
        if(len1==len2){
            for(int i=0;i<len1;i++){
                char a=word1.charAt(i);
                char b=word2.charAt(i);
                ans+=a;
                ans+=b;
            }
        }else if(len1>len2){
            for(int i=0;i<len2;i++){
                char a=word1.charAt(i);
                char b=word2.charAt(i);
                ans+=a;
                ans+=b;
            }
            for(int i=len2;i<len1;i++){
                char a=word1.charAt(i);
                ans+=a;
            }
        }else {
            for(int i=0;i<len1;i++){
                char a=word1.charAt(i);
                char b=word2.charAt(i);
                ans+=a;
                ans+=b;
            }
            for(int i=len1;i<len2;i++){
                char a=word2.charAt(i);
                ans+=a;
            }
        }
        return ans;
    }
}
