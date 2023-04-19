package TwoPoint;

public class L1234 {
    //1234. 替换子串得到平衡字符串
    //有一个只含有 'Q', 'W', 'E', 'R' 四种字符，且长度为 n 的字符串。
    //
    //假如在该字符串中，这四个字符都恰好出现 n/4 次，那么它就是一个「平衡字符串」。
    //
    //
    //
    //给你一个这样的字符串 s，请通过「替换一个子串」的方式，使原字符串 s 变成一个「平衡字符串」。
    //
    //你可以用和「待替换子串」长度相同的 任何 其他字符串来完成替换。
    //
    //请返回待替换子串的最小可能长度。
    //
    //如果原字符串自身就是一个平衡字符串，则返回 0。
    public int balancedString(String s) {
        int target=s.length()/4;
        int[] showtime=new int[4];
        String qwer="QWER";
        for(char now:s.toCharArray()){
            showtime[qwer.indexOf(now)]++;
        }
        //如果当前四个字母的个数都和target相同 那就是平衡的
        if(showtime[0]<=target&&showtime[1]<=target&&showtime[2]<=target&&showtime[3]<=target){
            return 0;
        }
        int left=0;
        int right=0;
        int ans=Integer.MAX_VALUE;
        //此时不相同
        //怎么进行替换呢？
        //比如当前进来一个Q
        //外边都已经满足条件了
        for(;right<s.length();right++){
            char now=s.charAt(right);
            showtime[qwer.indexOf(now)]--;
            //满足条件的时候一直记录 并且移动左边
            while(left<=right&&showtime[0]<=target&&showtime[1]<=target&&showtime[2]<=target&&showtime[3]<=target){
                ans=Math.min(right-left+1,ans);
                char leftn=s.charAt(left);
                showtime[qwer.charAt(leftn)]++;
                left++;
            }
        }
        return ans;
    }
}
