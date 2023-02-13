package src;

/**
 * @author Etherstrings
 * @create 2021-12-31 12:02 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  project01 - the name of the current project.  ${FILE_NAME} - the name of the PHP file that will be created.  L507PostiveNumber - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2021/12/31 - the current system date.  12:02 - the current system time.  2021 - the current year.  12 - the current month.  31 - the current day of the month.  12 - the current hour.  02 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  十二月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  十二月 - full name of a month. Example: January, February, etc
 */
public class L507PostiveNumber {
    public static void main(String[] args) {
    L507PostiveNumber l507PostiveNumber=new L507PostiveNumber();
        System.out.println(l507PostiveNumber.PerfectNumber(2));

    }

    public boolean PerfectNumber(int num){
        int sum=0;
        for(int i=1;i<num;i++){
            if(num%i==0){
                sum+=i;
            }
        }
        if(sum==num){
            return true;
        }
        return false;
    }


}
