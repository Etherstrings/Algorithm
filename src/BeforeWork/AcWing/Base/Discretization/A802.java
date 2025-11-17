package AcWing.Base.Discretization;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author Etherstrings
 * @create 2023-03-28 17:35 AcWing.Base.Discretization - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  A802 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/28 - the current system date.  17:35 - the current system time.  2023 - the current year.  03 - the current month.  28 - the current day of the month.  17 - the current hour.  35 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class A802 {
    //一种哈希映射
    //转换坐标系

    private static final int N = 300000;

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int m=in.nextInt();
        //用到的数
        List<Integer> alls=new ArrayList<>();
        //转换数组
        int[] A=new int[N];
        //转换数组的前缀和
        int[] S=new int[N];
        List<int[]> add=new ArrayList<>();
        List<int[]> query=new ArrayList<>();
        for(int i=0;i<n;i++){
            int x=in.nextInt();
            int c=in.nextInt();
            add.add(new int[]{x,c});
            //用到了x这个数
            alls.add(x);
        }
        for(int i=0;i<m;i++){
            int l=in.nextInt();
            int r=in.nextInt();
            query.add(new int[]{l,r});
            alls.add(l);
            alls.add(r);
        }
        //去重 排序
        List<Integer> distinctSorterAlls = alls.stream().distinct().sorted().collect(Collectors.toList());


        for (int[] item : add) {
        //当前这个数 映射到排序的位置索引是多少？
        int index = Collections.binarySearch(distinctSorterAlls, item[0]) + 1;
        A[index] += item[1];
        }

        //计算前缀和
        for(int i = 1; i <=distinctSorterAlls.size();i++){
            S[i]=S[i-1]+A[i];
        }
        for (int[] item : query) {
        int l = Collections.binarySearch(distinctSorterAlls, item[0]) + 1;
        int r = Collections.binarySearch(distinctSorterAlls, item[1]) + 1;
        System.out.println(S[r] - S[l - 1]);
        }
    }

    //public static void main(String[] args) {
    //        Scanner in = new Scanner(System.in);
    //        int n = in.nextInt();
    //        int m = in.nextInt();
    //        List<Integer> alls = new ArrayList<>();
    //        int[] a = new int[N];
    //        int[] s = new int[N];
    //        List<int[]> add = new ArrayList<>();
    //        List<int[]> query = new ArrayList<>();
    //        for (int i = 0; i < n; i++) {
    //            int x = in.nextInt();
    //            int c = in.nextInt();
    //            add.add(new int[]{x, c});
    //            alls.add(x);
    //        }
    //
    //        for (int i = 0; i < m; i++) {
    //            int l = in.nextInt();
    //            int r = in.nextInt();
    //            query.add(new int[]{l, r});
    //            alls.add(l);
    //            alls.add(r);
    //        }
    //
    //        // 去重 + 排序
    //        List<Integer> distinctSorterAlls = alls.stream().distinct().sorted()
    //                .collect(Collectors.toList());
    //
    //        // 离散化映射，把离散化的下标映射到连续的数组下标 + 1
    //        for (int[] item : add) {
    //            //当前这个数 映射到排序的位置索引是多少？
    //            int index = Collections.binarySearch(distinctSorterAlls, item[0]) + 1;
    //            a[index] += item[1];
    //        }
    //
    //
    //    // 前缀和
    //      for(int i = 1; i <=distinctSorterAlls.size();i++)
    //      {
    //        s[i] = s[i - 1] + a[i];
    //      }
    //
    //    // 离散化映射，把离散化的下标映射到连续的数组下标 + 1
    //    for (int[] item : query) {
    //        int l = Collections.binarySearch(distinctSorterAlls, item[0]) + 1;
    //        int r = Collections.binarySearch(distinctSorterAlls, item[1]) + 1;
    //        System.out.println(s[r] - s[l - 1]);
    //    }
    //    }


}



