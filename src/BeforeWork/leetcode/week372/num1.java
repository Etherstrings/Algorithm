package leetcode.week372;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2023-11-24
 */
public class num1 {
    public int findMinimumOperations(String s1, String s2, String s3) {
        int same = 0;
        int n = Math.min(Math.min(s1.length(),s2.length()),s3.length());
        for(int i=0;i<n;i++){
            if(s1.charAt(i)==s2.charAt(i)&&s2.charAt(i)==s3.charAt(i)){
                same++;
            }else {
                break;
            }
        }
        if(same==0){
            return -1;
        }
        return s1.length()+s2.length()+s3.length()-3*same;
    }
}
