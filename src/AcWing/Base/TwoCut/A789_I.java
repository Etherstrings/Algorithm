package AcWing.Base.TwoCut;

import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2023-03-21 19:43 AcWing.Base.TwoCut - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  A789_I - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/21 - the current system date.  19:43 - the current system time.  2023 - the current year.  03 - the current month.  21 - the current day of the month.  19 - the current hour.  43 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class A789_I {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // 获取输入值
        int n = in.nextInt();   // 数组大小
        int count = in.nextInt();  // 查询个数

        // 获取完整数组
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = in.nextInt();

        // 查询 count轮
        while (count-- != 0) {
            int target = in.nextInt();  // 本轮查询的目标值

            // 初始化 l和 r, 查找左边界
            int l = 0, r = n - 1;
            while (l < r) {
                int mid = l + r >> 1;
                if (arr[mid] >= target) // 如果 mid满足, 需要向左寻找
                    r = mid;
                else
                    l = mid + 1;
            }
            // 跳出循环时, l == r, 如果数组中不存在 target
            if (arr[l] != target) {
                System.out.println("-1 -1");
            } else {
                System.out.print(l + " ");  // 注意输出值为下标
                // 初始化 l和 r, 查找右边界
                l = 0;
                r = n - 1;
                while (l < r) {
                    int mid = l + r + 1 >> 1;   // 使用第二个模板
                    if (arr[mid] <= target) // 如果 mid满足, 需要向右寻找
                        l = mid;
                    else
                        r = mid - 1;
                }
                System.out.println(l);
            }
        }
    }

}
