package src;

/**
 * @author Etherstrings
 * @create 2022-09-01 17:46 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  Main - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/1 - the current system date.  17:46 - the current system time.  2022 - the current year.  09 - the current month.  01 - the current day of the month.  17 - the current hour.  46 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class Main {
    public static void main(String[] args) {
        int a=10;
        new Main().fun(a);
        System.out.println(a);
    }
    public void fun(int a){
        int b=10;
        Person p=new Person();
        p.id=1;
        p.name="Liming";
        System.out.println(a+b);
    }
    class Person{
        int id;
        String name;
    }
}
