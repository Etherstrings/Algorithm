package KeDa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2022-09-03 20:36 KeDa - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  Keda3 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/3 - the current system date.  20:36 - the current system time.  2022 - the current year.  09 - the current month.  03 - the current day of the month.  20 - the current hour.  36 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class Keda3 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNextLine()){
            String line1= in.nextLine();
            List<Integer> tri=new ArrayList<>();
            String[] s1 = line1.split(" ");
            for(int i=0;i<s1.length;i++){
                tri.add(Integer.parseInt(s1[i]));
            }
            int K=Integer.parseInt(in.nextLine());
            List<List<Integer>> tris=new ArrayList<>();
            for(int i=0;i<K;i++){
                String temp= in.nextLine();
                List<Integer> ttri=new ArrayList<>();
                String[] s2 = temp.split(" ");
                for(int j=0;j<s2.length;j++){
                    ttri.add(Integer.parseInt(s2[j]));
                }
                tris.add(ttri);
            }
            //判断是不是被覆盖
            //一旦被覆盖 计算面积然后存HashMap
            List<List<Integer>> ans=new ArrayList<>();
            for(List<Integer> a:tris){
                if(a.equals(tri)){
                    for(int b:a){
                        System.out.print(b+" ");
                    }
                    break;
                }else {
                    boolean flag=true;
                    if(a.get(0)>tri.get(0)){
                        flag=false;
                        continue;
                    }
                    if(a.get(1)>tri.get(1)){
                        flag=false;
                        continue;
                    }



                }
            }
        }
    }
}
