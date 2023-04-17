package DP;

/**
 * @author Etherstrings
 * @create 2022-09-08 19:35 DP - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  Item - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/8 - the current system date.  19:35 - the current system time.  2022 - the current year.  09 - the current month.  08 - the current day of the month.  19 - the current hour.  35 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public  class Item {
    public final String name;
    public int num;

    public Item(String name,int num) {
        this.name = name;
        this.num = num;
    }

    @Override
    public String toString(){
        return "[" + name + "," + num + "]";
    }
}

