import java.util.HashMap;
import java.util.Map;

/**
 * @author Etherstrings
 * @create 2023-05-06 15:08 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L1419 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/5/6 - the current system date.  15:08 - the current system time.  2023 - the current year.  05 - the current month.  06 - the current day of the month.  15 - the current hour.  08 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  5月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  五月 - full name of a month. Example: January, February, etc
 */
public class L1419 {
    //1419. 数青蛙
    //给你一个字符串 croakOfFrogs，它表示不同青蛙发出的蛙鸣声（字符串 "croak" ）的组合。由于同一时间可以有多只青蛙呱呱作响，所以 croakOfFrogs 中会混合多个 “croak” 。
    //
    //请你返回模拟字符串中所有蛙鸣所需不同青蛙的最少数目。
    //
    //要想发出蛙鸣 "croak"，青蛙必须 依序 输出 ‘c’, ’r’, ’o’, ’a’, ’k’ 这 5 个字母。如果没有输出全部五个字母，那么它就不会发出声音。如果字符串 croakOfFrogs 不是由若干有效的 "croak" 字符混合而成，请返回 -1 。
    //
    //
    //
    //示例 1：
    //
    //输入：croakOfFrogs = "croakcroak"
    //输出：1
    //解释：一只青蛙 “呱呱” 两次
    //示例 2：
    //
    //输入：croakOfFrogs = "crcoakroak"
    //输出：2
    //解释：最少需要两只青蛙，“呱呱” 声用黑体标注
    //第一只青蛙 "crcoakroak"
    //第二只青蛙 "crcoakroak"
    //示例 3：
    //
    //输入：croakOfFrogs = "croakcrook"
    //输出：-1
    //解释：给出的字符串不是 "croak" 的有效组合。
    //将青蛙分成
    //5
    //5 种：
    //
    //刚才发出了
    //c
    //c 的声音。
    //刚才发出了
    //r
    //r 的声音。
    //刚才发出了
    //o
    //o 的声音。
    //刚才发出了
    //a
    //a 的声音。
    //刚才发出了
    //k
    //k 的声音。
    //
    public int minNumberOfFrogs(String croakOfFrogs) {
        //分为5种  刚刚发出了什么的声音
        //使用数组来作为模拟哈希表
        int[] previous=new int[26];
        Map<Character,Character> getPre=new HashMap<>();
        //croak
        getPre.put('c','k');
        getPre.put('r','c');
        getPre.put('o','r');
        getPre.put('a','o');
        getPre.put('k','a');
        for(char now:croakOfFrogs.toCharArray()){
            char pre= getPre.get(now);
            if(previous[pre-'a']>0){
                //如果之前有个青蛙
                previous[pre-'a']--;
            }else if(now!='c'){
                //如果当前的这个不是从c开始叫，那就不能加青蛙
                return -1;
            }
            //当前叫的青蛙加一
            previous[now-'a']++;
        }
        if(previous['c'-'a']>0||previous['r'-'a']>0||previous['o'-'a']>0||previous['a'-'a']>0){
            return -1;
        }
        return previous['k'-'a'];
    }
}
