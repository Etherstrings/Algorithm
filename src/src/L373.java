package src;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Etherstrings
 * @create 2022-01-14 12:22 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  project01 - the name of the current project.  ${FILE_NAME} - the name of the PHP file that will be created.  L373 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/1/14 - the current system date.  12:22 - the current system time.  2022 - the current year.  01 - the current month.  14 - the current day of the month.  12 - the current hour.  22 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  一月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  一月 - full name of a month. Example: January, February, etc
 */
public class L373 {

    /**
     *  373. 查找和最小的K对数字
     *  　给定两个以 升序排列 的整数数组 nums1 和 nums2 , 以及一个整数 k 。
     *
     * 　定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2 。
     *
     * 　请找到和最小的 k 个数对 (u1,v1),  (u2,v2)  ...  (uk,vk) 。

     */
    public static void main(String[] args) {
        L373 l373=new L373();
        l373.kSmallestPairs(new int[] {1,7,11},new int[] {2,4,6},3);

    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        temp.add(nums1[0]);
        temp.add(nums2[0]);
        ans.add(0,temp);
        for(int i=1;i<=k;i++){
            if(nums1[i]==nums1[i-1]){
                List<Integer> temp1=new ArrayList<>();
                temp1.add(nums1[i]);
                temp1.add(nums2[0]);
                ans.add(i,temp1);
            }else{
                List<Integer> temp2=new ArrayList<>();
                temp2.add(nums1[i]);
                temp2.add(nums2[0]);
                ans.add(i,temp2);
            }
        }
        return ans;
    }
}
