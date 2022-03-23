/**
 * @author Etherstrings
 * @create 2021-12-22 21:15 daliyExer - the name of the target package where the new class or interface will be created.  project01 - the name of the current project.  ${FILE_NAME} - the name of the PHP file that will be created.  StringTest2 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2021/12/22 - the current system date.  21:15 - the current system time.  2021 - the current year.  12 - the current month.  22 - the current day of the month.  21 - the current hour.  15 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  十二月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  十二月 - full name of a month. Example: January, February, etc
 */

//给定一个String 换从x-n位
public class StringTest2 {
    public static void main(String[] args) {
        StringTest2 a=new StringTest2();
        String strtest="123456789";
        System.out.println(a.resort(strtest,3,6));

    }


    public String resort(String str,int start,int end){
        char[] chars=str.toCharArray();
        char[] chars1=str.substring(start-1,end).toCharArray();
        char tem;
        for(int i=0;i<(chars1.length/2);i++){
            tem=chars1[i];
            chars1[i]=chars1[(chars1.length)-i-1];
            chars1[(chars1.length)-i-1]=tem;

        }
        String strnew=new String(chars1);

        return str.replace(str.substring(start-1,end),strnew);


    }
}
