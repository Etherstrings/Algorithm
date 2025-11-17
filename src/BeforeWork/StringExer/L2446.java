package StringExer;

/**
 * @author Etherstrings
 * @create 2023-05-17 11:22 StringExer - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L2446 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/5/17 - the current system date.  11:22 - the current system time.  2023 - the current year.  05 - the current month.  17 - the current day of the month.  11 - the current hour.  22 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  5月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  五月 - full name of a month. Example: January, February, etc
 */
public class L2446 {
    //2446. 判断两个事件是否存在冲突
    //给你两个字符串数组 event1 和 event2 ，表示发生在同一天的两个闭区间时间段事件，其中：
    //
    //event1 = [startTime1, endTime1] 且
    //event2 = [startTime2, endTime2]
    //事件的时间为有效的 24 小时制且按 HH:MM 格式给出。
    //
    //当两个事件存在某个非空的交集时（即，某些时刻是两个事件都包含的），则认为出现 冲突 。
    //
    //如果两个事件之间存在冲突，返回 true ；否则，返回 false 。
    //
    //
    //
    //示例 1：
    //
    //输入：event1 = ["01:15","02:00"], event2 = ["02:00","03:00"]
    //输出：true
    //解释：两个事件在 2:00 出现交集。
    //示例 2：
    //
    //输入：event1 = ["01:00","02:00"], event2 = ["01:20","03:00"]
    //输出：true
    //解释：两个事件的交集从 01:20 开始，到 02:00 结束。
    //示例 3：
    //
    //输入：event1 = ["10:00","11:00"], event2 = ["14:00","15:00"]
    //输出：false
    //解释：两个事件不存在交集。
    public boolean haveConflict(String[] event1, String[] event2) {
        return !(event1[1].compareTo(event2[0]) < 0 || event2[1].compareTo(event1[0]) < 0);
    }

}
