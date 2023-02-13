package StringExer;

/**
 * @author Etherstrings
 * @create 2022-02-17 11:32 StringExer - the name of the target package where the new class or interface will be created.  ideaworkplace - the name of the current project.  ${FILE_NAME} - the name of the PHP file that will be created.  L28newstrSTR - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/2/17 - the current system date.  11:32 - the current system time.  2022 - the current year.  02 - the current month.  17 - the current day of the month.  11 - the current hour.  32 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  二月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  二月 - full name of a month. Example: January, February, etc
 */
public class L28newstrSTR {
    //28. 实现 strStr()
    //实现 strStr() 函数。
    //
    //给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。
    //
    // 
    //说明：
    //
    //当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
    //
    //对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。

    public int strStr(String haystack, String needle) {
        if(needle.length()==0){
            return 0;
        }

        int[] next=new int[needle.length()];
        getNext(next,needle);

        int j=0;
        for(int i=0;i<haystack.length();i++){
            while (j > 0 && needle.charAt(j) != haystack.charAt(i))
                j = next[j - 1];
            if (needle.charAt(j) == haystack.charAt(i))
                j++;
            if (j == needle.length())
                return i - needle.length() + 1;
        }
        return -1;

    }

    void getNext(int[] next,String s){
        int j=0;
        next[0]=0;

        for(int i=1;i<s.length();i++){
            while(j>0&&s.charAt(j)!=s.charAt(i)){
                j=next[j-1];
            }
            if(s.charAt(j)==s.charAt(i)){
                j++;
            }
            next[i]=j;
        }
    }
}
