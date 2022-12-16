package src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Etherstrings
 * @create 2022-08-25 22:35 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L658 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/8/25 - the current system date.  22:35 - the current system time.  2022 - the current year.  08 - the current month.  25 - the current day of the month.  22 - the current hour.  35 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  8月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  八月 - full name of a month. Example: January, February, etc
 */
public class L658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if(x<=arr[0]){
            //在左边
            List<Integer> ans=new ArrayList<>();
            for(int i=0;i<k;i++){
                ans.add(arr[i]);
            }
            return ans;
        }

        if(x>=arr[arr.length-1]){
            //在最右边
            List<Integer> ans=new ArrayList<>();
            for(int i=arr.length-k;i<arr.length;i++){
                ans.add(arr[i]);
            }
            return ans;
        }
        int left=0;
        int right=0;
        int mid=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==x){
                mid=i;
                break;
            }
            if(i>1&&arr[i]>x&&arr[i-1]<x){
                if(Math.abs(arr[i]-x)>Math.abs(arr[i-1]-x)){
                    //i-1离的更近
                    mid=i-1;
                    break;
                }
            }
        }
        left=mid-1;
        right=mid+1;
        List<Integer> ans=new ArrayList<>();
        ans.add(arr[mid]);
        k--;
        while(left>=0&&right<=arr.length-1&&k>=0){
            int nowleft=arr[left];
            int nowright=arr[right];
            if(nowright-arr[mid]==arr[mid]-nowleft){
                ans.add(nowleft);
                ans.add(nowright);
                left--;
                right++;
                k--;
                k--;
            }else if(nowright-arr[mid]<arr[mid]-nowleft){
                ans.add(nowright);
                right++;
                k--;
            }else {
                ans.add(nowleft);
                left--;
                k--;
            }
        }
        if(k==0){
            Collections.sort(ans);
            return ans;
        }else {
            if(left==-1){
                while(k>0){
                    ans.add(arr[right]);
                    right++;
                    k--;
                }
                Collections.sort(ans);
                return ans;
            }
            if(right==arr.length){
                while(k>0){
                    ans.add(arr[left]);
                    left++;
                    k--;
                }
                Collections.sort(ans);
                return ans;
            }
        }
        return ans;
    }

    public List<Integer> findClosestElements1(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<Integer>();
        for (int num : arr) {
            list.add(num);
        }
        Collections.sort(list, (a, b) -> {
            if (Math.abs(a - x) != Math.abs(b - x)) {
                return Math.abs(a - x) - Math.abs(b - x);
            } else {
                return a - b;
            }
        });
        List<Integer> ans = list.subList(0, k);
        Collections.sort(ans);
        return ans;
    }

}
