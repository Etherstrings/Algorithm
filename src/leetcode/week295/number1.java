package leetcode.week295;

/**
 * @author Etherstrings
 * @create 2022-05-29 11:12 leetcode.week295 - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  number1 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/5/29 - the current system date.  11:12 - the current system time.  2022 - the current year.  05 - the current month.  29 - the current day of the month.  11 - the current hour.  12 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  5月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  五月 - full name of a month. Example: January, February, etc
 */
public class number1 {
    public int rearrangeCharacters(String s, String target) {
        // abcd bdca abcd cba
        // abcd
        // 3
        // 4

        if(target.length()==0){
            return 0;
        }
        if(s.length()<target.length()){
            return 0;
        }
        //每次取target的长度
        //用HashMap判断是不是都是相同的
        char[] chars = target.toCharArray();
        //这样吧 用一个26的字符串 来判断每个单词出现了几次 如果相同位置相同
        //ok
        int[] Judge=new int[26];
        int all=0;
        for(int i=0;i<chars.length;i++){

            Judge[chars[i]-'a']+=1;
        }
        int slow=0;
        int fast=(slow+target.length()-1);
        while(fast<s.length()){
            char[] Temp=s.substring(slow,fast+1).toCharArray();
            int[] NJudge=new int[26];
            for(int i=0;i<target.length();i++){
                NJudge[Temp[i]-'a']+=1;
            }
            boolean flag=true;
            for(int i=0;i<Judge.length;i++){
                if(Judge[i]!=NJudge[i]){
                    flag=false;
                }
            }
            if(flag){
                all+=1;
            }
            slow++;
            fast++;
        }

        return all;
    }
}
