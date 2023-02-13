package src;

/**
 * @author Etherstrings
 * @create 2021-12-22 20:54 daliyExer - the name of the target package where the new class or interface will be created.  project01 - the name of the current project.  ${FILE_NAME} - the name of the PHP file that will be created.  StringTest1 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2021/12/22 - the current system date.  20:54 - the current system time.  2021 - the current year.  12 - the current month.  22 - the current day of the month.  20 - the current hour.  54 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  十二月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  十二月 - full name of a month. Example: January, February, etc
 */
public class StringTest1 {

    public static void main(String[] args) {
        StringTest1 a=new StringTest1();
        String str="      894464684 ";
        System.out.println(a.Remove(str));

    }
//仿写 trim 删掉前后的空格


    public String Remove(String str){
        char[] chars=str.toCharArray();
        boolean Flag=true;
        int start=0;
        for(int i=0;Flag;i++){
            if(chars[i]==' '){
                Flag=true;
            }else{
                 start=i;
                Flag=false;
            }
        }
        int end=0;
        Flag=true;
        for(int i=chars.length-1;Flag;i--){
            if(chars[i]==' '){
                Flag=true;
            }else{
                end=i;
                Flag=false;
            }
        }

        String newstr=str.substring(start,end);
        return newstr;
    }

}
