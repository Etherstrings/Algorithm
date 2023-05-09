package leetcode.week344;

/**
 * @author Etherstrings
 * @create 2023-05-07 12:16 leetcode.week344 - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  FrequencyTracker1 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/5/7 - the current system date.  12:16 - the current system time.  2023 - the current year.  05 - the current month.  07 - the current day of the month.  12 - the current hour.  16 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  5月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  五月 - full name of a month. Example: January, February, etc
 */
public class FrequencyTracker1 {
    public static int N=100001;
    public static int[] ind_v;
    //index-数 ind_v[index]出现的次数
    public static int[] show_v;
    //index-频次 ind_v[index]出现的次数
    public FrequencyTracker1() {
        this.ind_v=new int[N];
        this.show_v=new int[N];
    }

    public void add(int number) {
        //是不是原来已经有了
        int v=ind_v[number];
        show_v[v]-=1;
        //这个数出现的次数+1
        ind_v[number]+=1;
        //出现这个频率次数+1
        v=ind_v[number];
        show_v[v]+=1;
    }

    public void deleteOne(int number) {
        //这个数是不是出现次数为0?
        if(!(ind_v[number]==0)){
            //只有不等于0才可以删除
            //老的频率出现次数-1
            int v=ind_v[number];
            show_v[v]-=1;
            ind_v[number]-=1;
            //新的出现频率次数+1
            v=ind_v[number];
            show_v[v]+=1;
        }
    }

    public boolean hasFrequency(int frequency) {
        return show_v[frequency]>=1;
    }
}
