package StringExer;

public class L1750 {
    public int minimumLength(String s) {
        int left=0;
        int right=s.length()-1;
        char[] c=s.toCharArray();
        while(left<right&&c[left]==c[right]){
            char l=c[left];
            char r=c[right];
            while(left<=right&&c[left]==l){
                left++;
            }
            while(left<=right&&c[right]==r){
                right--;
            }
        }
        return right-left+1;
    }
}
