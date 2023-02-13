package src.GuangLianDa;

/**
 * @author Etherstrings
 * @create 2022-08-31 17:25 GuangLianDa - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  Single - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/8/31 - the current system date.  17:25 - the current system time.  2022 - the current year.  08 - the current month.  31 - the current day of the month.  17 - the current hour.  25 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  8月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  八月 - full name of a month. Example: January, February, etc
 */
public class Single {
    private static Single instance=null;

    private Single(){

    }

    public static Single getInstance(){
        if(instance==null){
            synchronized (Single.class){
                if(instance==null){
                    instance=new Single();
                }
            }
        }
        return instance;
    }
}
