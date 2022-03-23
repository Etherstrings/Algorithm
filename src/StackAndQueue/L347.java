package StackAndQueue;

import java.util.*;

/**
 * @author Etherstrings
 * @create 2022-03-09 0:33 StackAndQueue - the name of the target package where the new class or interface will be created.  ideaworkplace - the name of the current project.  ${FILE_NAME} - the name of the PHP file that will be created.  L347 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/3/9 - the current system date.  0:33 - the current system time.  2022 - the current year.  03 - the current month.  09 - the current day of the month.  00 - the current hour.  33 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  三月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class L347 {
    //347. 前 K 个高频元素
    //给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
    //
    //
    //
    //示例 1:
    //
    //输入: nums = [1,1,1,2,2,3], k = 2
    //输出: [1,2]
    //示例 2:
    //
    //输入: nums = [1], k = 1
    //输出: [1]
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> answer=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(answer.containsKey(nums[i])){
                answer.put(nums[i],answer.get(nums[i])+1);
            }else{
                answer.put(nums[i],1);
            }
        }
        List<Map.Entry<Integer, Integer>> infoIds = new ArrayList<Map.Entry<Integer, Integer>>(answer.entrySet());
        Collections.sort(infoIds, new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return (o2.getValue() - o1.getValue());
                //return (o1.getKey()).toString().compareTo(o2.getKey());
            }
        });
        int[] relanswer=new int[k];
        for(int i=0;i<k;i++){
            relanswer[i]=infoIds.get(i).getKey();

        }
        return relanswer;
    }

}
