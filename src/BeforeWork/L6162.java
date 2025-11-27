/**
 * @author Etherstrings
 * @create 2022-08-29 17:46 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L6162 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/8/29 - the current system date.  17:46 - the current system time.  2022 - the current year.  08 - the current month.  29 - the current day of the month.  17 - the current hour.  46 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  8月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  八月 - full name of a month. Example: January, February, etc
 */
public class L6162 {
    public int garbageCollection(String[] garbage, int[] travel) {
        //每个垃圾要耗一分钟
        int shouji=0;
        //M
        int firstM=-1;
        int lastM=travel.length;
        //P
        int firstP=-1;
        //G
        int firstG=-1;
        for(String gar:garbage){
            shouji+=garbage.length;
        }
        //如果有这个垃圾 才需要经过这些
        //M
        //记录垃圾第一次出现位置和最后一次出现位置
        for(int i=0;i<garbage.length;i++){
            String temp=garbage[i];
            if(temp.contains("M")){
                firstM=i;
                break;
            }
        }
        for(int i=garbage.length-1;i>=0;i--){
            String temp=garbage[i];
            if(temp.contains("M")){
                lastM=i;
                break;
            }
        }
        //没有M
        if(firstM==-1){
            shouji+=0;
        }
        if(firstM==lastM){
            //只有一次出现
            for(int i=0;i<firstM-1;i++){
                shouji+=travel[i];
            }
        }
        if(firstM!=-1&&firstM!=lastM){
            //到最后一栋即可
            for(int i=0;i<lastM-1;i++){
                shouji+=travel[i];
            }
        }
        return 1;
    }
}
