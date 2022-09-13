package KeDa;

import java.util.*;

/**
 * @author Etherstrings
 * @create 2022-09-03 20:00 KeDa - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  Keda2 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/3 - the current system date.  20:00 - the current system time.  2022 - the current year.  09 - the current month.  03 - the current day of the month.  20 - the current hour.  00 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class Keda2 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNextLine()){
            String line1= in.nextLine();
            String[] s1 = line1.split(" ");
            int L=Integer.parseInt(s1[0]);
            int M=Integer.parseInt(s1[1]);
            int[][] Mayi=new int[M][2];
            for(int i=0;i<M;i++){
                String temp=in.nextLine();
                String[] temps = temp.split(" ");
                int[] thisone=new int[2];
                thisone[0]=Integer.parseInt(temps[0]);
                thisone[1]=Integer.parseInt(temps[1]);
                Mayi[i]=thisone;
            }

            Comparator<int[]> com=new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if(o1[0]==o2[0]){
                        return o1[1]-o2[1];
                    }
                    return o1[0]-o2[0];
                }
            };
            Arrays.sort(Mayi,com);
            //根据左边端点排序
            int ans=0;
            int left=Mayi[0][0];
            int right=Mayi[0][1];
            //左边相同的
            int temp=left;
            int finleft=left;
            int finright=-1;
            HashMap<Integer,Integer> lefts_max=new HashMap<>();
            TreeSet<Integer> lefts=new TreeSet<Integer>();
            //当前左边对应的最大值
            for(int i=0;i<Mayi.length;i++){
                lefts.add(Mayi[i][0]);
                lefts_max.put(Mayi[i][0],Mayi[i][1]);
            }
            //从左边开始排序
            int index=1;
            finleft=lefts.first();
            finright=lefts_max.get(finleft);
            for(int a:lefts){
                if(index==1){
                    index++;
                    continue;
                }
                if(a>finright){
                    System.out.println("fail");
                    break;
                }else {
                    finleft=a;
                    finright=lefts_max.get(a);
                    ans++;
                }
            }
            if(finright<L){
                System.out.println("fail");
            }else {
                System.out.println(ans);
            }
        }
    }
}
