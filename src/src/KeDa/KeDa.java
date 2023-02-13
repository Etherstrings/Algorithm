package src.KeDa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2022-09-03 18:47 KeDa - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  KeDa - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/9/3 - the current system date.  18:47 - the current system time.  2022 - the current year.  09 - the current month.  03 - the current day of the month.  18 - the current hour.  47 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  9月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  九月 - full name of a month. Example: January, February, etc
 */
public class KeDa {

}
 class Main{
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNextLine()){
            String line1=in.nextLine();
            //x(n) 的长度 从0-N
            int N= Integer.parseInt(line1);
            int index=0;
            int[] x_n=new int[N];
            while(index<N){
                String linen=in.nextLine();
                String[] s = linen.split(" ");
                for(int i=0;i<s.length;i++){
                    x_n[index]=Integer.parseInt(s[i]);
                    index++;
                }
            }
            long[] k_n=new long[N];
            for(int i=0;i<N;i++){
                k_n[i]=fillit(i,N,x_n);
            }
            for(int i=0;i<k_n.length;i++){
                if(i==k_n.length-1){
                    System.out.println(k_n[i]);
                }
                System.out.print(k_n[i]+" ");
            }
            List<Long> ans=findall(k_n);
            Collections.sort(ans);
            if(Math.abs(ans.get(0))>Math.abs(ans.get(ans.size()-1))){
                System.out.println(ans.get(0));
            }else {
                System.out.println(ans.get(ans.size()-1));
            }
        }


    }

    static long fillit(int x,int N,int[] x_n){
        //x为k
        //i为n
        long num1=0;
        for(int i=0;i<=N-x-1;i++){
            long temp=x_n[i]*x_n[i+x];
            num1+=temp;
        }
        long num2=0;
        for(int i=N-x;i<=N-1;i++){
            long temp=x_n[i]*(i+x-N);
            num2+=temp;
        }
        return num1+num2;
    }
    static List<Long> findall(long[] k_n){
        List<Long> ans=new ArrayList<>();
        for(int i=0;i<k_n.length;i++){
            if(i==0){
                continue;
            }
            if(i== k_n.length-1){
                if(k_n[i-1]>k_n[i]){
                    ans.add(k_n[i]);
                }else if(k_n[i]>k_n[i-1]){
                    ans.add(k_n[i]);
                }else {
                    ans.add(k_n[i]);
                }
                continue;
            }
            if(k_n[i]>k_n[i-1]&&k_n[i]>k_n[i+1]){
                ans.add(k_n[i]);
                continue;
            }
            if(k_n[i]<k_n[i-1]&&k_n[i]<k_n[i+1]){
                ans.add(k_n[i]);
                continue;
            }
            if(k_n[i]>k_n[i-1]&&k_n[i]==k_n[i+1]){
                ans.add(k_n[i]);
                continue;
            }
            if(k_n[i]<k_n[i-1]&&k_n[i]==k_n[i+1]){
                ans.add(k_n[i]);
                continue;
            }

        }
        return ans;

    }
}
