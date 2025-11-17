package TanXin;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Etherstrings
 * @create 2023-05-23 14:06 TanXin - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L1090 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/5/23 - the current system date.  14:06 - the current system time.  2023 - the current year.  05 - the current month.  23 - the current day of the month.  14 - the current hour.  06 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  5月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  五月 - full name of a month. Example: January, February, etc
 */
public class L1090 {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        //选了哪些？
        int[] good_times=new int[100050];
        boolean[] used=new boolean[values.length];

        int[][] v_labels=new int[values.length][values.length];
        for(int i=0;i<values.length;i++){
            v_labels[i]=new int[]{values[i],labels[i]};
        }
        Comparator<int[]> com=new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0]-o1[0];
            }
        };
        Arrays.sort(v_labels,com);
        //按照价值从大向小排列
        boolean flag=true;
        int sum=0;
        int size=0;
        for(int i=0;i<v_labels.length;i++){
            int v=v_labels[i][0];
            int index=v_labels[i][1];
            if(used[i]){
                continue;
            }
            if(good_times[index]==useLimit){
                continue;
            }
            if(size==numWanted){
                break;
            }
            size++;
            sum+=v;
            used[i]=true;
            good_times[index]++;
        }
        return sum;
    }
}
