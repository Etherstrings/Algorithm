package ZhongXing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2022-08-29 19:24 ZhongXing - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  ZhongXing - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/8/29 - the current system date.  19:24 - the current system time.  2022 - the current year.  08 - the current month.  29 - the current day of the month.  19 - the current hour.  24 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  8月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  八月 - full name of a month. Example: January, February, etc
 */
public class ZhongXing {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNextLine()){
            String word=in.nextLine();
            String[] words = word.split(" ");
            String first=words[0];
            String end=words[1];
            //哪个列最大
            int col=Math.max(Integer.valueOf(first.charAt(1)),Integer.valueOf(end.charAt(1)));

            Character start=first.charAt(0);
            Character End=end.charAt(0);
            List<String> ans=new ArrayList<>();
            int index=1;
            for(int i=End;i<=start;i++){
                if(index==1){
                    for(int j=Integer.valueOf(first.charAt(1));j<=col;j++){
                        String now=Integer.toString(i)+j;
                        ans.add(now);
                    }
                    index++;
                    continue;
                }else {
                    for(int j=0;j<=col;j++){
                        String now=Integer.toString(i)+j;
                        ans.add(now);
                    }
                }
            }
            System.out.print("[");
            for(int i=0;i<ans.size();i++){
                if(i==ans.size()-1){
                    System.out.print(ans.get(i));
                    continue;
                }
                System.out.print(ans.get(i)+",");
            }
            System.out.print("]");
        }
    }
}
