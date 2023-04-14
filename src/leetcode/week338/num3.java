package leetcode.week338;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Etherstrings
 * @create 2023-03-26 11:15 leetcode.week338 - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  num3 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/26 - the current system date.  11:15 - the current system time.  2023 - the current year.  03 - the current month.  26 - the current day of the month.  11 - the current hour.  15 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class num3 {
    public static void main(String[] args) {
        System.out.println(primeSubOperation(new int[]{1,20,7,12,4}));
    }
    static int[] K = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311, 313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409, 419, 421, 431, 433, 439, 443, 449, 457, 461, 463, 467, 479, 487, 491, 499, 503, 509, 521, 523, 541, 547, 557, 563, 569, 571, 577, 587, 593, 599, 601, 607, 613, 617, 619, 631, 641, 643, 647, 653, 659, 661, 673, 677, 683, 691, 701, 709, 719, 727, 733, 739, 743, 751, 757, 761, 769, 773, 787, 797, 809, 811, 821, 823, 827, 829, 839, 853, 857, 859, 863, 877, 881, 883, 887, 907, 911, 919, 929, 937, 941, 947, 953, 967, 971, 977, 983, 991, 997,1000};
    public static boolean primeSubOperation(int[] nums) {
        List<Integer> Indexs=new ArrayList<>();
        if(nums.length<=1){
            return false;
        }
        if(nums.length==2){
            if(nums[0]<nums[1]){
                return true;
            }else if (nums[0]==nums[1]){
                return false;
            }else {
                int now=nums[0];
                for(int i=0;i<K.length;i++){
                    if(K[i]>=now){
                        nums[0]=now-K[i-1];
                        break;
                    }
                }
                if(nums[0]<nums[1]){
                    return true;
                }else {
                    return false;
                }

            }
        }
        boolean[] used=new boolean[nums.length];
        for(int i=1;i<nums.length-1;i++){
            if(nums[i]>=nums[i-1]&&nums[i]>=nums[i+1]){
                Indexs.add(i);
            }
        }
        if(Indexs.size()!=0){
            for(int index:Indexs){
                int now=nums[index];
                int last=nums[index-1];
                if(used[index]==false){
                    for(int i=0;i<K.length;i++){
                        if(K[i]>=now){
                            nums[index]=now-K[i-1];
                            used[index]=true;
                            break;
                        }
                    }
                }
                if(used[index-1]==false){
                    for(int i=0;i<K.length;i++){
                        if(K[i]>=last){
                            if(i==0){
                                used[index-1]=true;
                                break;
                            }
                            nums[index-1]=last-K[i-1];
                            used[index-1]=true;
                            break;
                        }
                    }
                }
            }
        }
        boolean flag=true;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]>=nums[i+1]){
                flag=false;
                break;
            }
        }
        return flag;
    }
}
