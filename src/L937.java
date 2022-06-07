import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Etherstrings
 * @create 2022-05-25 21:08 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L937 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/5/25 - the current system date.  21:08 - the current system time.  2022 - the current year.  05 - the current month.  25 - the current day of the month.  21 - the current hour.  08 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  5月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  五月 - full name of a month. Example: January, February, etc
 */
public class L937 {
    //937. 重新排列日志文件
    //给你一个日志数组 logs。每条日志都是以空格分隔的字串，其第一个字为字母与数字混合的 标识符 。
    //
    //有两种不同类型的日志：
    //
    //字母日志：除标识符之外，所有字均由小写字母组成
    //数字日志：除标识符之外，所有字均由数字组成
    //请按下述规则将日志重新排序：
    //
    //所有 字母日志 都排在 数字日志 之前。
    //字母日志 在内容不同时，忽略标识符后，按内容字母顺序排序；在内容相同时，按标识符排序。
    //数字日志 应该保留原来的相对顺序。
    //返回日志的最终顺序。
    public String[] reorderLogFiles(String[] logs) {


        Arrays.sort(logs,(log1,log2)->{
           //重写比较器
           String[] spit1=log1.split(" ",2);
            String[] spit2=log2.split(" ",2);

            boolean isD1=Character.isDigit(spit1[1].charAt(0));
            boolean isD2=Character.isDigit(spit2[1].charAt(0));

            if(!isD1&&!isD2){
                //俩都是字母日志
                int cmp=spit1[1].compareTo(spit2[1]);
                if(cmp!=0){
                    return cmp;
                }
                return spit1[0].compareTo(spit2[0]);
            }
            return isD1?(isD2?0:1):-1;
        });
        return logs;
    }

}
