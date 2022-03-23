package StringExer;

/**
 * @author Etherstrings
 * @create 2022-02-16 20:12 StringExer - the name of the target package where the new class or interface will be created.  ideaworkplace - the name of the current project.  ${FILE_NAME} - the name of the PHP file that will be created.  Try - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/2/16 - the current system date.  20:12 - the current system time.  2022 - the current year.  02 - the current month.  16 - the current day of the month.  20 - the current hour.  12 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  二月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  二月 - full name of a month. Example: January, February, etc
 */
public class Try {
    public static void main(String[] args) {
        String s="Bob    Loves  Alice";
        String[] Temp = s.split(" ");
        for(String str:Temp){
            System.out.println(str);
        }

    }
}
