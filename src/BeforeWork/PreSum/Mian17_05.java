package PreSum;

import java.util.HashMap;

/**
 * @author Etherstrings
 * @create 2023-03-11 11:35 PreSum - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  Mian17_05 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/11 - the current system date.  11:35 - the current system time.  2023 - the current year.  03 - the current month.  11 - the current day of the month.  11 - the current hour.  35 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class Mian17_05 {
    public String[] findLongestSubarray(String[] array) {
        //找到数组and字母数量一样 并且最长的
        //如果有多个最长的 找第一个

        //1.转换
        //数字-1
        //字母--1
        int[] nums=new int[array.length];
        for(int i=0;i<array.length;i++){
            for(char n:array[i].toCharArray()){
                if(Character.isDigit(n)){
                    nums[i]=1;
                }else {
                    nums[i]=-1;
                }
                break;
            }
        }
        //计算前缀和
        //原数组从0-n-1
        //前缀和为0 - n
        // 想一想 什么样的情况下 数字和字母的大小是一样的？
        // Presum[left]==Presum[right]
        // 那么当前的字符长度就是right-left
        // (left,right]
        // 原数组话，如果left为0，那么就是[0,right-1]
        // 不为0 ---(left-1,right-1]
        int[] Presum=new int[nums.length+1];
        Presum[0]=0;
        for(int i=1;i<Presum.length;i++){
            Presum[i]=Presum[i-1]+nums[i-1];
        }
        //找出相同的最大长度
        //int[] 0-len 1-left
        HashMap<Integer, int[]> map=new HashMap<>();
        //如果有多个最大长度 找第一个
        //全局最长长度
        int temp=-1;
        for(int i=0;i<Presum.length-1;i++){
            int key=Presum[i];
            if(map.containsKey(key)){
                continue;
            }
            for(int j=i+1;j<Presum.length;j++){
                if(key==Presum[j]){
                    //找到了
                    temp=Math.max(j-i,temp);
                    map.put(key,new int[]{j-i,i});
                }
            }
        }

        String[] ans=new String[temp];
        for(int i=0;i<Presum.length;i++){
            int key=Presum[i];
            if(!map.containsKey(key)){
                continue;
            }
            if(map.get(key)[0]==temp){
                //就是你了
                int left=map.get(key)[1];
                if(left==0){
                    for(int j=left;j<temp;j++){
                        ans[j]=array[j];
                    }
                }else {
                    int right=left+temp;
                    int x=0;
                    for(int j=left+2;j<=right+1;j++){
                        ans[x]=array[j];
                        x++;
                    }
                }
                break;
            }
        }
        return ans;
    }
}
