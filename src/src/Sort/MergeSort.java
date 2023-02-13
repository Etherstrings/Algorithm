package src.Sort;

/**
 * @author Etherstrings
 * @create 2022-08-30 22:28 Sort - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  MergeSort - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/8/30 - the current system date.  22:28 - the current system time.  2022 - the current year.  08 - the current month.  30 - the current day of the month.  22 - the current hour.  28 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  8月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  八月 - full name of a month. Example: January, February, etc
 */
public class MergeSort {
    public static void sort(int[] a,int s,int e) {
        int m = (s + e) / 2;
        if (s < e){
            sort(a,s,m);
            sort(a,m+1,e);
            //归并
            merge(a,s,m,e);
        }
    }
    private static void merge(int[] a, int s, int m, int e) {
        //初始化一个从起始s到终止e的一个数组
        int[] temp = new int[(e - s) + 1];
        //左起始指针
        int l = s;
        //右起始指针
        int r = m+1;
        int i = 0;
        //将s-e这段数据在逻辑上一分为二,l-m为一个左边的数组,r-e为一个右边的数组,两边都是有序的
        //从两边的第一个指针开始遍历,将其中小的那个值放在temp数组中
        while (l <= m && r <= e){
            if (a[l] < a[r]){
                temp[i++] = a[l++];
            }else{
                temp[i++] = a[r++];
            }
        }

        //将两个数组剩余的数放到temp中
        while (l <= m){
            temp[i++] = a[l++];
        }
        while (r <= e){
            temp[i++] = a[r++];
        }

        //将temp数组覆盖原数组
        for (int n = 0; n < temp.length; n++) {
            a[s+n] = temp[n];
        }

    }
}

}