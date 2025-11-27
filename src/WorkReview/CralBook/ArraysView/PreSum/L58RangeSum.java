package WorkReview.CralBook.ArraysView.PreSum;

import java.util.Scanner;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2025-11-18
 */
public class L58RangeSum {
    //输入n代表数组的长度
    //接下来每一行为数组的值
    //接下来输入为需要查询的区间,未知行，每一行都是两个整数 用空格隔开
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        int[] nums = new int[n];
        int[] pre = new int[n+1];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
            pre[i+1] = pre[i] + nums[i];
        }
        while (in.hasNextInt()) {
            int left = in.nextInt();
            int right = in.nextInt();
            System.out.println(pre[right+1] - pre[left]);
        }

    }
}
