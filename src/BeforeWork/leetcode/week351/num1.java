package leetcode.week351;

public class num1 {
    public static void main(String[] args) {
        int[] nums={2,5,1,4};
        System.out.println(countBeautifulPairs(nums));
    }
    public static int countBeautifulPairs(int[] nums) {
        int ans=0;
        for(int i=0;i<nums.length;i++){
            if(i==nums.length-1){
                continue;
            }
            for(int j=i+1;j<nums.length;j++){
                String temp=nums[i]+"";
                int a=Integer.parseInt(temp.substring(0,1));
                int b=nums[j]%10;
                if(isgcd(a,b)){
                    ans++;
                }
            }
        }
        return ans;
    }

    public static boolean isgcd(int a,int b){

        if(a < b) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        int c;
        while((c = a % b) != 0) {
            a = b;
            b = c;

        }
        if(b==1){
            return true;
        }
        return false;
    }
}
