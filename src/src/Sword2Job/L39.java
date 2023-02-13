package src.Sword2Job;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Etherstrings
 * @create 2022-03-11 9:10 Sword2Job - the name of the target package where the new class or interface will be created.  ideaworkplace - the name of the current project.  ${FILE_NAME} - the name of the PHP file that will be created.  L39 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/3/11 - the current system date.  9:10 - the current system time.  2022 - the current year.  03 - the current month.  11 - the current day of the month.  09 - the current hour.  10 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  三月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class L39 {
    public int majorityElement(int[] nums) {
        int num=nums.length/2+0;
        int answer=-1;
        Map<Integer,Integer> judge=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(judge.containsKey(nums[i])){
                judge.put(nums[i],judge.get(nums[i])+1);
            }else {
                judge.put(nums[i],1 );
            }
        }
        Set<Integer> keys = judge.keySet();

        for(int i:keys){
            if(judge.get(i)>num){
                answer=i;
                break;
            }
        }
        return answer;
    }
}
