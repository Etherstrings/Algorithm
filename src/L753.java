import java.util.BitSet;
import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2022-09-28 18:11 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L753 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/28 - the current system date.  18:11 - the current system time.  2022 - the current year.  09 - the current month.  28 - the current day of the month.  18 - the current hour.  11 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class L753 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNextLine()){
            String[] line1=in.nextLine().split(",");
            int n=Integer.parseInt(line1[0]);
            int k=Integer.parseInt(line1[1]);
            System.out.println(crackSafe(n,k));


        }
    }
    public static  final int[] Mask={0,1,10,100,1000};
    public static int M;
    public static String crackSafe(int n,int k){
        M=Mask[n];
        StringBuilder sb=new StringBuilder();
        Hierholzer(0,k,new BitSet(),sb);
        for(int i=0;i<n-1;i++){
            sb.append(0);
        }
        return sb.toString();
    }

    public static void Hierholzer(int n,int k,BitSet bs,StringBuilder sb){
        bs.set(n);
        int tail=n%10;
        n=(n%M)*10;
        for(int i=0;i<k;i++,n++){
            if(!bs.get(n)){
                Hierholzer(n,k,bs,sb);
            }
        }
        sb.append(tail);
    }
}
