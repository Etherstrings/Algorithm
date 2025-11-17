package AcWing.Base.TwoCut;



import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2023-03-21 16:09 AcWing - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  A789 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/21 - the current system date.  16:09 - the current system time.  2023 - the current year.  03 - the current month.  21 - the current day of the month.  16 - the current hour.  09 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class A789 {

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String[] line1=in.nextLine().split(" ");
        int n=Integer.parseInt(line1[0]);
        int q=Integer.parseInt(line1[1]);
        int[] nums=new int[n];
        String[] words=in.nextLine().split(" ");
        for(int i=0;i<n;i++){
            nums[i]=Integer.parseInt(words[i]);
        }
        int[] todo=new int[q];
        for(int i=0;i<q;i++){
            todo[i]=Integer.parseInt(in.nextLine());
        }
        for(String t:getans(nums,todo)){
            System.out.println(t);
        }
    }

    public static String[] getans(int[] nums,int[] todo){
        String[] ans=new String[todo.length];


        for(int i=0;i<todo.length;i++){
            int target=todo[i];
            boolean canfind=false;
            boolean[] used=new boolean[nums.length];
            int first=-1;
            int last=-1;
            //左闭右开
            int left=0;
            int right=nums.length;

            while(left<right){
                int index=left+(right-left)/2;
                //那么第一个出现的一定在左边
                if(nums[index]>=target){
                    right=index;
                }else {
                    left=index+1;
                }
            }
            if(left>nums.length-1){
                first=-1;
            }else if(nums[left]!=target){
                first=-1;
            }else {
                first=left;
            }

            if(first==-1){
                last=-1;
            }else {
                left=0;
                right=nums.length-1;
                while(left<right){
                    int mid = left + right + 1 >> 1;   // 使用第二个模板
                    if (nums[mid] <= target) // 如果 mid满足, 需要向右寻找
                        left = mid;
                    else
                        right = mid - 1;
                }
                last=left;
            }
            String temp=first+" "+last;
            ans[i]=temp;

        }
        return ans;
    }

}
