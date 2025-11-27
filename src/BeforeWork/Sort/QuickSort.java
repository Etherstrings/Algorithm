package Sort;

/**
 * @author Etherstrings
 * @create 2022-08-30 21:46 Sort - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  QuickSort - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/8/30 - the current system date.  21:46 - the current system time.  2022 - the current year.  08 - the current month.  30 - the current day of the month.  21 - the current hour.  46 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  8月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  八月 - full name of a month. Example: January, February, etc
 */
public class QuickSort {
    //核心代码模式
    public static void sort(int[] arr,int begin,int end) {
        //先定义两个参数接收排序起始值和结束值
        int a = begin;
        int b = end;
        //先判断a是否大于b

        if (a >= b) {
            //没必要排序
            return;
        }
        //基准数,默认设置为第一个值
        int x = arr[a];

        //循环
        while (a < b) {
            //从后往前找,找到一个比基准数x小的值,赋给arr[a]
            //如果a和b的逻辑正确--a<b ,并且最后一个值arr[b]>x,就一直往下找,直到找到后面的值大于x
            while (a < b && arr[b] >= x) {
                b--;
            }
            //跳出循环,两种情况,一是a和b的逻辑不对了,a>=b,这时候排序结束.二是在后面找到了比x小的值
            if (a < b) {
                //将这时候找到的arr[b]放到最前面arr[a]
                arr[a] = arr[b];
                //排序的起始位置后移一位
                a++;
            }

            //从前往后找,找到一个比基准数x大的值,放在最后面arr[b]
            while (a < b && arr[a] <= x) {
                a++;
            }
            if (a < b) {
                arr[b] = arr[a];
                //排序的终止位置前移一位
                b--;
            }
        }
        //跳出循环 a < b的逻辑不成立了,a==b重合了,此时将x赋值回去arr[a]
        arr[a] = x;
        //调用递归函数,再细分再排序
        sort(arr,begin,a-1);
        sort(arr,a+1,end);
    }
}
