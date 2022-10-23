package StringExer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Etherstrings
 * @create 2022-10-01 21:20 StringExer - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L1694 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/10/1 - the current system date.  21:20 - the current system time.  2022 - the current year.  10 - the current month.  01 - the current day of the month.  21 - the current hour.  20 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  10月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  十月 - full name of a month. Example: January, February, etc
 */
public class L1694 {
    public static String reformatNumber(String number) {
        //1694. 重新格式化电话号码
        //给你一个字符串形式的电话号码 number 。number 由数字、空格 ' '、和破折号 '-' 组成。
        //
        //请你按下述方式重新格式化电话号码。
        //
        //首先，删除 所有的空格和破折号。
        //其次，将数组从左到右 每 3 个一组 分块，直到 剩下 4 个或更少数字。剩下的数字将按下述规定再分块：
        //2 个数字：单个含 2 个数字的块。
        //3 个数字：单个含 3 个数字的块。
        //4 个数字：两个分别含 2 个数字的块。
        //最后用破折号将这些块连接起来。注意，重新格式化过程中 不应该 生成仅含 1 个数字的块，并且 最多 生成两个含 2 个数字的块。
        //
        //返回格式化后的电话号码。
        List<Integer> nums=new ArrayList<>();
        for(Character c:number.toCharArray()){
            if(Character.isDigit(c)){
                nums.add(Integer.parseInt(c+""));
            }
        }
        //更新后的数字串
        int left=nums.size()%3;
        String ans="";
        if(left==0){
            //全部分好
            String temp="";
            int index=1;
            for(int num:nums){
                if(index==3){
                    temp+=num;
                    temp+="-";
                    index=1;
                }else {
                    temp+=num;
                    index++;
                }
            }
            temp=temp.substring(0,temp.length()-1);
            ans=temp;
        }else if(left==1){
            //剩4个
            String four="";
            for(int i=nums.size()-4;i<nums.size();i++){
                four+=nums.get(i);
            }

            String temp="";
            int index=1;
            for(int i=0;i<nums.size()-4;i++){
                if(index==3){
                    temp+=nums.get(i);
                    temp+="-";
                    index=1;
                }else {
                    temp+=nums.get(i);
                    index++;
                }

            }
            temp+=four.substring(0,2);
            temp+="-";
            temp+=four.substring(2,four.length());
            ans=temp;
        }else if(left==2){
            //剩两个
            //剩两个
            String two="";
            for(int i=nums.size()-2;i<nums.size();i++){
                two+=nums.get(i);
            }

            String temp="";
            int index=1;
            for(int i=0;i<nums.size()-2;i++){
                if(index==3){
                    temp+=nums.get(i);
                    temp+="-";
                    index=1;
                }else {
                    temp+=nums.get(i);
                    index++;
                }

            }
            temp+=two;
            ans=temp;
        }
        return ans;
    }
}
