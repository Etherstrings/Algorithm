package src;

import java.util.ArrayList;

/**
 * @author Etherstrings
 * @create 2021-12-28 0:34 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  project01 - the name of the current project.  ${FILE_NAME} - the name of the PHP file that will be created.  Leetcodenum3 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2021/12/28 - the current system date.  0:34 - the current system time.  2021 - the current year.  12 - the current month.  28 - the current day of the month.  00 - the current hour.  34 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  十二月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  十二月 - full name of a month. Example: January, February, etc
 */
public class Leetcodenum3 {
    public static void main(String[] args) {
        Leetcodenum3 a=new Leetcodenum3();
        System.out.println(a.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(a.lengthOfLongestSubstring("pwwkew"));

    }
    /**
     *
     abcde
     首先输入num作为最长子串长度
     a开始，逐步加长string，每加一个，判断是否与前边重复，
     不重复增加i，继续叠加，如果重复判断此时的i是否大于num，大于赋值给num break或者跳出此时循环
     删掉a 从b开始 继续上面步骤

     如果到n之后，剩下的长度，小于以有的num 停止
     */

    public static int lengthOfLongestSubstring(String s){
        char[] chars=s.toCharArray();
        //s转换为arraylist
        ArrayList list=new ArrayList();
        //作为存放已筛查过的
        ArrayList list2=new ArrayList();
        for(int i=0;i<chars.length;i++){
            list.add(chars[i]);
        }

        int max=0;

        for(int i=0;i<list.size();i++){

            for(int j=0;j<=list.size();j++){
                list2.add(list.subList(j,j+1));

                if(list2.contains(list.subList(j+1,j+2))){

                    break;
                }else{
                    if((list2.size())+1>max){
                        max=list2.size()+1;
                    }
                }
            }
            list.remove(i);
        }

        return max;






    }
}
