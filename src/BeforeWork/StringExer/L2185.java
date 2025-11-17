package StringExer;

public class L2185 {
    public int prefixCount(String[] words, String pref) {
        int ans=0;
        for(String word:words){
            if(word.indexOf(pref)==0){
                ans++;
            }
        }
        return ans;
    }
}
