package StringExer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Etherstrings
 * @create 2022-11-08 18:26 StringExer - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L816 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/11/8 - the current system date.  18:26 - the current system time.  2022 - the current year.  11 - the current month.  08 - the current day of the month.  18 - the current hour.  26 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  11月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  十一月 - full name of a month. Example: January, February, etc
 */
public class L816 {
    public static void main(String[] args) {
        List<String> ans=ambiguousCoordinates("(123)");
        for(String a:ans){
            System.out.println(a);
        }
    }
    public static List<String> ambiguousCoordinates(String s) {
        //拆分测试
        //先去除s中的逗号、小数点和空格
        String nums="";
        for(char a:s.toCharArray()){
            if(a==' '||a==','||a=='.'||a=='('||a==')'){
                continue;
            }
            nums+=a;
        }
        //针对a进行拆分
        List<String> ans=new ArrayList<>();
        for(int i=1;i< nums.length();i++){
            String left=nums.substring(0,i);
            String right=nums.substring(i,nums.length());
            List<String> tl=trans(left);
            List<String> tr=trans(right);
            if(tr.size()==0||tl.size()==0){
                continue;
            }
            if(tr==null||tl==null){
                continue;
            }
            for(String a:tl){
                for(String b:tr){
                    String temp="(";
                    temp+=a;
                    temp+=",";
                    temp+=" ";
                    temp+=b;
                    temp+=")";
                    ans.add(temp);
                }
            }
        }
        return ans;
    }

    public static List<String> trans(String str){
        //0
        //00
        //0000001
        //1111110
        //1.0 不被允许
        List<String> ans=new ArrayList<>();
        if(str.length()==1){
            ans.add(str);
            return ans;
        }
        if(str.indexOf("0")==0&&str.endsWith("0")){
            //以0开头的并且以0结尾
            return ans;
        }

        if(str.endsWith("0")){
            ans.add(str);
            return ans;
        }

        if(str.startsWith("0")){
            ans.add("0."+str.substring(1));
            return ans;
        }
        ans.add(str);
        for(int i=1;i<=str.length()-1;i++){
            String left=str.substring(0,i);
            String right=str.substring(i);
            ans.add(left+"."+right);
        }
        return ans;
    }
}
