package src.Sword2Job;

import java.util.ArrayList;

/**
 * @author Etherstrings
 * @create 2022-03-10 10:38 Sword2Job - the name of the target package where the new class or interface will be created.  ideaworkplace - the name of the current project.  ${FILE_NAME} - the name of the PHP file that will be created.  L21 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/3/10 - the current system date.  10:38 - the current system time.  2022 - the current year.  03 - the current month.  10 - the current day of the month.  10 - the current hour.  38 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  三月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class L21 {
    public static void main(String[] args) {
        L21 l21=new L21();
        int[] nums=new int[]{1,2,3,4};
        l21.exchange(nums);
    }

    public int[] exchange(int[] nums) {
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        //a 奇数
        //b 偶数
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2==1){
                a.add(nums[i]);
            }else{
                b.add(nums[i]);
            }
        }
        int j=0;
        for(int num:a){
            nums[j]=num;
            j++;
        }

        int k=a.size();
        for(int num:b){
            nums[k]=num;
            k++;
        }

        return nums;
    }
}
