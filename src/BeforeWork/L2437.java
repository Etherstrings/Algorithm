/**
 * @author Etherstrings
 * @create 2023-05-09 11:03 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L2437 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/5/9 - the current system date.  11:03 - the current system time.  2023 - the current year.  05 - the current month.  09 - the current day of the month.  11 - the current hour.  03 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  5月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  五月 - full name of a month. Example: January, February, etc
 */
public class L2437 {
    public int countTime(String time) {
        int[] show=new int[5];
        //01234
        int times=0;
        for(int i=0;i<time.length();i++){
            if(time.charAt(i)=='?'){
                show[i]=1;
                times++;
            }
        }
        if(times==4){
            return 1440;
        }
        int left=1;
        if(show[0]==1&&show[1]==1){
            left=24;
        }
        if(show[0]==1&&show[1]==0){
            if(Integer.parseInt(time.charAt(1)+"")<4){
                left=3;
            }else {
                left=2;
            }
        }
        if(show[0]==0&&show[1]==1){
            if(Integer.parseInt(time.charAt(0)+"")==2){
                left=4;
            }else {
                left=10;
            }
        }

        int right=1;
        if(show[3]==1&&show[4]==1){
            right=60;
        }
        if(show[3]==0&&show[4]==1){
            right=10;
        }
        if(show[3]==1&&show[4]==0){
            right=6;
        }

        return left*right;
    }
}
