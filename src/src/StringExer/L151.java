package src.StringExer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Etherstrings
 * @create 2022-02-16 19:54 StringExer - the name of the target package where the new class or interface will be created.  ideaworkplace - the name of the current project.  ${FILE_NAME} - the name of the PHP file that will be created.  L151 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/2/16 - the current system date.  19:54 - the current system time.  2022 - the current year.  02 - the current month.  16 - the current day of the month.  19 - the current hour.  54 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  二月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  二月 - full name of a month. Example: January, February, etc
 */
public class L151 {
    //151. 翻转字符串里的单词
    //给你一个字符串 s ，逐个翻转字符串中的所有 单词 。
    //
    //单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
    //
    //请你返回一个翻转 s 中单词顺序并用单个空格相连的字符串。
    //
    //说明：
    //
    //输入字符串 s 可以在前面、后面或者单词间包含多余的空格。
    //翻转后单词间应当仅用一个空格分隔。
    //翻转后的字符串中不应包含额外的空格。
    public static void main(String[] args) {
        L151 l151=new L151();
        System.out.println(l151.reverseWords("  hello world  "));
    }

    public String reverseWords(String s) {
        //分割
        String[] Temp = s.split(" ");
        //此处切完 里面有很多空格
        //只要有空格 都删掉
        int newlength=Temp.length;
        //遍历 如果为空格 删除
        List<String> Answer=new ArrayList<>();
        for(int i=0;i<Temp.length;i++){
            if(Temp[i].equals(" ")||Temp[i].equals("")||Temp[i]==null){
                continue;
            }else {
                Answer.add(Temp[i]);
            }
        }


        //翻转数组就行
        //删除多余的空格
        String[] newTemp=new String[Answer.size()];
        int index=0;
        for(String str:Answer){
            newTemp[index]=str;
            index++;
        }
        for(int i=0;i<(newTemp.length)/2;i++){
            int last=newTemp.length-1-i;
            String useTemp=newTemp[i];
            newTemp[i]=newTemp[last];
            newTemp[last]=useTemp;
        }
        //拼接
        String relanswer=" ";
        for(int i=0;i<newTemp.length;i++){
            if(i!=newTemp.length-1){
                relanswer=relanswer+newTemp[i]+" ";
            }else{
                relanswer=relanswer+newTemp[i];
            }
        }

        return relanswer.substring(1);
    }


}
