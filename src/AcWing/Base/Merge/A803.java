package AcWing.Base.Merge;

import java.util.*;

/**
 * @author Etherstrings
 * @create 2023-03-28 18:06 AcWing.Base.Merge - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  A803 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/28 - the current system date.  18:06 - the current system time.  2023 - the current year.  03 - the current month.  28 - the current day of the month.  18 - the current hour.  06 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class A803 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        List<int[]> QuJian=new ArrayList<>();
        for(int i=0;i<n;i++){
            int l=in.nextInt();
            int r=in.nextInt();
            QuJian.add(new int[]{l,r});
        }
        Comparator<int[]> com=new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        };
        Collections.sort(QuJian,com);
        //按照左边的端点排序
        int size=1;
        int nowleft=QuJian.get(0)[0];
        int nowright=QuJian.get(0)[1];
        for(int i=1;i<QuJian.size();i++){
            int l=QuJian.get(i)[0];
            int r=QuJian.get(i)[1];
            if(l>nowright){
                size++;
                nowright=r;
            }else {
                nowright=Math.max(nowright,r);
            }

        }
        System.out.println(size);
    }
}
