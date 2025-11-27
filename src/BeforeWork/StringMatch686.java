/**
 * @author Etherstrings
 * @create 2021-12-22 23:36 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  project01 - the name of the current project.  ${FILE_NAME} - the name of the PHP file that will be created.  StringMatch686 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2021/12/22 - the current system date.  23:36 - the current system time.  2021 - the current year.  12 - the current month.  22 - the current day of the month.  23 - the current hour.  36 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  十二月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  十二月 - full name of a month. Example: January, February, etc
 */
public class StringMatch686 {
    public static void main(String[] args) {
        StringMatch686 stringMatch686=new StringMatch686();
        String a = "abcd";
        String b = "bcdab";
        stringMatch686.repeatedStringMatch(a,b);
        System.out.println(stringMatch686.repeatedStringMatch(a,b));
    }

    /**
     *
     *
     *
     * @param a 数组a
     * @param b 数组b
     * @return  a重复几次包含b
     *
     *
     *          难点在于
     *          1.a长度>b时
     *              a==b
     *              a+a 包含b
     *          2.a长度<b
     *              我的思路是判断重叠后能否实现包含
     *            正确为：
     *              (a.length()/b.length())+2
     *              为最大重叠次数
     *              ab bababa
     *
     */



    public int repeatedStringMatch(String a, String b){
            int num = -1;
        if(a.length()>=b.length()){

            if(a.indexOf(b)!=(-1)){
                num=1;
                return num;
            }else{
                String stra1=a+a;
                if(stra1.indexOf(b)!=-1){
                    num=2;
                    return num;
                }
            }
        }else{
            boolean Flag=true;
            //if(b.indexOf(a)==(-1)){
             //   num=-1;
            //    return num;
           // }

            String stra2=new String(a);
            int i=1;
            while(Flag){

                if(stra2.indexOf(b)==(-1)){
                    stra2+=a;
                    i++;
                    if(i>(b.length()/a.length()+2)){
                        break;
                    }
                }else{
                    Flag=false;
                    num=i;
                    return num;

                }
            }
        }

        return num;



    }
}

