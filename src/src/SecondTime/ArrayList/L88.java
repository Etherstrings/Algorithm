package src.SecondTime.ArrayList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Etherstrings
 * @create 2022-08-10 23:49 SecondTime.ArrayList - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L88 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/8/10 - the current system date.  23:49 - the current system time.  2022 - the current year.  08 - the current month.  10 - the current day of the month.  23 - the current hour.  49 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  8月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  八月 - full name of a month. Example: January, February, etc
 */
public class L88 {
    //88. 合并两个有序数组
    //给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
    //
    //请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
    //
    //注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
    //
    //
    //
    //示例 1：
    //
    //输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
    //输出：[1,2,2,3,5,6]
    //解释：需要合并 [1,2,3] 和 [2,5,6] 。
    //合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
    //示例 2：
    //
    //输入：nums1 = [1], m = 1, nums2 = [], n = 0
    //输出：[1]
    //解释：需要合并 [1] 和 [] 。
    //合并结果是 [1] 。
    //示例 3：
    //
    //输入：nums1 = [0], m = 0, nums2 = [1], n = 1
    //输出：[1]
    //解释：需要合并的数组是 [] 和 [1] 。
    //合并结果是 [1] 。
    //注意，因为 m = 0 ，所以 nums1 中没有元素。nums1 中仅存的 0 仅仅是为了确保合并结果可以顺利存放到 nums1 中。
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        List<Integer> Temp=new ArrayList<>();
        for(int i=0;i<m;i++){
            Temp.add(nums1[i]);
        }
        for(int i=0;i<n;i++){
            Temp.add(nums2[i]);
        }
        Collections.sort(Temp);
        for(int i=0;i<nums1.length;i++){
            nums1[i]=Temp.get(i);
        }
    }
}
