/**
 * @author Etherstrings
 * @create 2021-12-23 11:00 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  project01 - the name of the current project.  ${FILE_NAME} - the name of the PHP file that will be created.  StringTest3 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2021/12/23 - the current system date.  11:00 - the current system time.  2021 - the current year.  12 - the current month.  23 - the current day of the month.  11 - the current hour.  00 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  十二月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  十二月 - full name of a month. Example: January, February, etc
 */

        //一个字符串在另一个字符串中出现的次数
public class StringTest3 {
    public static void main(String[] args) {
        String a="c";
        String b="abbbbccaaaaaaddddd";
        StringTest3 stringTest3=new StringTest3();
        System.out.println(stringTest3.HowTimes(a,b));

    }



    public int HowTimes(String a,String b){
        StringBuffer a1=new StringBuffer(a);

        boolean Flag=true;
        int num=0;
        if(a.length()<b.length()){

        if(b.indexOf(a)==-1){

            return 0;
        }else{
            for(;Flag;){
                if(b.indexOf(a)!=-1){
                    b=b.substring((b.indexOf(a)+a1.length()));
                    num+=1;

                }else{
                    Flag=false;
                    return num;
                }
            }
        }}
        else{return 0;}
        return num;




    }




}
