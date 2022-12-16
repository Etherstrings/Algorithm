package src.StringExer;

/**
 * @author Etherstrings
 * @create 2022-08-14 10:26 StringExer - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L1422 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/8/14 - the current system date.  10:26 - the current system time.  2022 - the current year.  08 - the current month.  14 - the current day of the month.  10 - the current hour.  26 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  8月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  八月 - full name of a month. Example: January, February, etc
 */
public class L1422 {
    //1422. 分割字符串的最大得分
    //给你一个由若干 0 和 1 组成的字符串 s ，请你计算并返回将该字符串分割成两个 非空 子字符串（即 左 子字符串和 右 子字符串）所能获得的最大得分。
    //
    //「分割字符串的得分」为 左 子字符串中 0 的数量加上 右 子字符串中 1 的数量。
    //
    //
    //
    //示例 1：
    //
    //输入：s = "011101"
    //输出：5
    //解释：
    //将字符串 s 划分为两个非空子字符串的可行方案有：
    //左子字符串 = "0" 且 右子字符串 = "11101"，得分 = 1 + 4 = 5
    //左子字符串 = "01" 且 右子字符串 = "1101"，得分 = 1 + 3 = 4
    //左子字符串 = "011" 且 右子字符串 = "101"，得分 = 1 + 2 = 3
    //左子字符串 = "0111" 且 右子字符串 = "01"，得分 = 1 + 1 = 2
    //左子字符串 = "01110" 且 右子字符串 = "1"，得分 = 2 + 1 = 3
    //示例 2：
    //
    //输入：s = "00111"
    //输出：5
    //解释：当 左子字符串 = "00" 且 右子字符串 = "111" 时，我们得到最大得分 = 2 + 3 = 5
    //示例 3：
    //
    //输入：s = "1111"
    //输出：3
    public int maxScore(String s) {
        if(s.equals("")){
            return 0;
        }
        int max=-1;
        for(int i=1;i<s.length()-1;i++){
            String left=s.substring(0,i);
            String right=s.substring(i,s.length());
            Math.max(max,RightTrans(right)+LeftTrans(left));
        }
        return max;
    }

    int RightTrans(String temp){
        int num=0;
        for(Character i:temp.toCharArray()){
            if(i.equals('1')){
                num++;
            }
        }
        return num;
    }
    int LeftTrans(String temp){
        int num=0;
        for(Character i:temp.toCharArray()){
            if(i.equals('0')){
                num++;
            }
        }
        return num;
    }
}
