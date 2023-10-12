package KeepLive;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2023-10-10
 */
public class TryACM {
    public static void main(String[] args) {
        getNormal();
    }

    public static void getNormal(){
        Scanner scanner = new Scanner(System.in);
        //比如第一行输入 n m
        //接下来n行，每一行会输入m个数
        //构成一个n行m列的数字矩阵
        //现在让你找到每一行中的最大值，将每一行的最大值输出
        List<Integer> ans=new ArrayList<>();
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        for(int i=0;i<n;i++){
            int max=Integer.MIN_VALUE;
            for(int j=0;j<m;j++){
                int now=scanner.nextInt();
                max=Math.max(max,now);
            }
            ans.add(max);
        }
        for(int i=0;i<ans.size();i++){
            System.out.print(ans.get(i)+" ");
        }
        System.out.println();
    }
}
