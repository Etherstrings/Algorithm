package leetcode.week289;

import java.util.Arrays;

/**
 * @author Etherstrings
 * @create 2022-04-17 11:02 leetcode.week289 - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  Lweek289_2 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/4/17 - the current system date.  11:02 - the current system time.  2022 - the current year.  04 - the current month.  17 - the current day of the month.  11 - the current hour.  02 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  4月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  四月 - full name of a month. Example: January, February, etc
 */
public class Lweek289_2 {
    //双指针
    public int minimumRounds(int[] tasks) {
        if(tasks.length==1){
            return -1;
        }
        Arrays.sort(tasks);
        int slow=0;

        int round=0;
        for(int fast=0;fast<tasks.length;fast++){
            if(tasks[fast]!=tasks[slow]){

                int length=fast-slow;
                if(length==1){

                    return -1;

                }
                round+=length/2;
                slow=fast;
            }
            if(fast==tasks.length-1){
                int length=fast-slow+1;
                if (length%3==0){
                    round+=length/3;
                }
                if(length%3==2){
                    round+=length/3+1;
                }
                if(length%3==1){
                    round+=(length/3-1)+(length-(length/3-1)*3)/2;
                }


            }



        }
        return round;

    }
}
