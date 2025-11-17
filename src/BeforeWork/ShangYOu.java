import java.util.ArrayList;
import java.util.List;

/**
 * @author Etherstrings
 * @create 2023-03-25 9:47 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  ShangYOu - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/25 - the current system date.  9:47 - the current system time.  2023 - the current year.  03 - the current month.  25 - the current day of the month.  09 - the current hour.  47 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class ShangYOu {
    public static void main(String[] args) {
        int[] nums={-414,578,18,15,214,21,74,96,78};
        quickSort(nums,0,nums.length-1);
        for(int n:nums){
            System.out.print(n+" ");
        }
    }

    public static void quickSort(int[] nums,int i,int j){
        //递归的终止条件
        //j为nums.length-1;
        if(i>=j){
            return;
        }
        //选择left和right
        int target=nums[j];
        List<Integer> left=new ArrayList<>();
        List<Integer> right=new ArrayList<>();
        for(int k=i;k<j;k++){
            int now=nums[k];
            if(now<=target){
                left.add(now);
            }else {
                right.add(now);
            }
        }
        int index=0;
        for(int k=i;k<i+left.size();k++){
            if(left.size()==0){
                break;
            }
            nums[k]=left.get(index++);
        }
        nums[i+left.size()]=target;
        index=0;
        for(int k=i+left.size()+1;k<i+left.size()+1+right.size();k++){
            if(right.size()==0){
                break;
            }
            nums[k]=right.get(index++);
        }
        quickSort(nums,i,i+left.size()-1);
        quickSort(nums,i+left.size()+1,j);
    }


}
