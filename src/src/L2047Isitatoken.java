package src;

/**
 * @author Etherstrings
 * @create 2022-01-27 16:36
 */
public class L2047Isitatoken {


    //分割
        //快慢指针法
    public int countValidWords(String sentence) {
        //sentence
        int left=0;
        //ans
        int ans=0;
        for(int right=0;right<sentence.length();){
            if(sentence.charAt(right)==' '){
                int firstright=right-1;
                while(sentence.charAt(right+1)==' '){
                    right+=1;

                }
                right+=1;
                if(check(sentence.substring(left,firstright+1))){
                    ans+=1;
                }
                left=right;
            }else{
                right++;
            }
        }

        return ans;

    }

    boolean check(String s) {
        int n = s.length();
        if (n == 0) return false;
        for (int i = 0, c1 = 0, c2 = 0; i < n; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) return false;
            if (c == ' ') return false;
            if (c == '-' && ++c1 >= 0) {
                if (c1 > 1 || (i == 0 || i == n - 1)) return false;
                if (!Character.isLetter(s.charAt(i - 1)) || !Character.isLetter(s.charAt(i + 1))) return false;
            }
            if ((c == '!' || c == '.' || c == ',') && ++c2 >= 0) {
                if (c2 > 1 || (i != n - 1)) return false;
            }
        }
        return true;
    }





}
