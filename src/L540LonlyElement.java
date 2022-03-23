import java.util.HashMap;
import java.util.Map;

/**
 * @author Etherstrings
 * @create 2022-02-14 16:43 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  ideaworkplace - the name of the current project.  ${FILE_NAME} - the name of the PHP file that will be created.  L540LonlyElement - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/2/14 - the current system date.  16:43 - the current system time.  2022 - the current year.  02 - the current month.  14 - the current day of the month.  16 - the current hour.  43 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  二月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  二月 - full name of a month. Example: January, February, etc
 */
public class L540LonlyElement {
    //540. 有序数组中的单一元素
    //给你一个仅由整数组成的有序数组，其中每个元素都会出现两次，唯有一个数只会出现一次。
    //
    //请你找出并返回只出现一次的那个数。
    //
    //你设计的解决方案必须满足 O(log n) 时间复杂度和 O(1) 空间复杂度。
    public int singleNonDuplicate(int[] nums) {
        Map<Integer,Integer> answer=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int key=nums[i];
            if(answer.containsKey(key)){
                answer.put(key,answer.get(key)+1);
            }else{
                answer.put(key,1);
            }
        }
        int Relanswer=-1;
        for(int i=0;i<nums.length;i++){
            if(answer.get(nums[i])==1){
                Relanswer=nums[i];
                break;
            }

        }
        return Relanswer;
    }
}
