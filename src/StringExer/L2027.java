package StringExer;

public class L2027 {
    public int minimumMoves(String s) {
        int ans=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='X'){
                ans++;
                i+=2;
            }
        }
        return ans;
    }
}
