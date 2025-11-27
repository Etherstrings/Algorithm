package TwoPoint;

import java.util.*;

/**
 * @author Etherstrings
 * @create 2022-01-10 10:42 TwoPoint - the name of the target package where the new class or interface will be created.  project01 - the name of the current project.  ${FILE_NAME} - the name of the PHP file that will be created.  L2019Window - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/1/10 - the current system date.  10:42 - the current system time.  2022 - the current year.  01 - the current month.  10 - the current day of the month.  10 - the current hour.  42 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  一月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  一月 - full name of a month. Example: January, February, etc
 */
public class L209Window {

    /**
     *  209. 长度最小的子数组
     * 给定一个含有 n 个正整数的数组和一个正整数 target 。
     *
     * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int minSubArrayLen(int target, int[] nums) {
        int slow=0;
        int sum=0;
        ArrayList answer = new ArrayList();
        for(int fast=0;fast<nums.length;fast++){
            sum+=nums[fast];
            while (sum>=target){
                answer.add((fast-slow+1));
                sum-=nums[slow];
                slow+=1;
            }
        }
        if(answer.isEmpty()){
            return 0;
        }
        Comparator com=new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Integer t1=(Integer)o1;
                Integer t2=(Integer)o2;
                return t1.compareTo(t2);
            }
        };
        answer.sort(com);
        int answer1= (int) answer.get(0);

        return answer1;
    }

}
