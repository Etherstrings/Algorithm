import java.util.ArrayList;
import java.util.List;

/**
 * @author Etherstrings
 * @create 2021-12-27 0:00 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  project01 - the name of the current project.  ${FILE_NAME} - the name of the PHP file that will be created.  Leetcode3Bigram - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2021/12/27 - the current system date.  0:00 - the current system time.  2021 - the current year.  12 - the current month.  27 - the current day of the month.  00 - the current hour.  00 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  十二月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  十二月 - full name of a month. Example: January, February, etc
 */
public class Leetcode3Bigram {
    public static void main(String[] args) {
    String str="alice is a good girl she is a good student";
    Leetcode3Bigram leetcode3Bigram=new Leetcode3Bigram();

        System.out.println(leetcode3Bigram.findOcurrences1(str,"a","good").toString());



    }


    public String[] findOcurrences(String text,String first,String second){
        boolean Flag=true;
        String[] ansewer=new String[text.length()];
        if(text.indexOf(first+" "+second)==-1){
            return new String[1];
        }
        String num12=first+" "+second;
        String num121=first+" "+second+" ";
        int num1=num12.length();
        int num2=num121.length();
        int index=0;
        //一二词直接仅仅在末尾出现一次
            if(text.indexOf(num12)+num1==text.length()){
                return new String[1];
                //中间存在12词
            }else{
                //第一次空格出现位置
                int qian=text.indexOf(num12)+num1;
                for(;Flag;){
                    if(text.indexOf(" ",qian+1)!=-1){
                        ansewer[index]=text.substring(qian+1,text.indexOf(" ",qian+1));
                        index+=1;
                        qian=text.indexOf(" ",qian+1);
                    }else{
                        Flag=false;
                    }
                }
        }
        String[] reallyansewer=new String[index];
            for(int i=0;i<=index;i++){
                reallyansewer[i]=ansewer[i];
            }
            return reallyansewer;




    }

    public String[] findOcurrences1(String text,String first,String second){
        String[] str=text.split(" ");
        List<String> answerlist=new ArrayList<>();

        for(int i=0;i<str.length-2;i++){
            if(str[i].equals(first)&&str[i+1].equals(second)){
                answerlist.add(str[i+2]);
            }
        }
        String[] answer=new String[answerlist.size()];
        int num=0;
        for(String s:answerlist){
            answer[num]=s;
            num++;
        }
        return answer;
    }
}
