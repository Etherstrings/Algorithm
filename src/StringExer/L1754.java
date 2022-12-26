package StringExer;

public class L1754 {
    //1754. 构造字典序最大的合并字符串
    //给你两个字符串 word1 和 word2 。你需要按下述方式构造一个新字符串 merge ：如果 word1 或 word2 非空，选择 下面选项之一 继续操作：
    //
    //如果 word1 非空，将 word1 中的第一个字符附加到 merge 的末尾，并将其从 word1 中移除。
    //例如，word1 = "abc" 且 merge = "dv" ，在执行此选项操作之后，word1 = "bc" ，同时 merge = "dva" 。
    //如果 word2 非空，将 word2 中的第一个字符附加到 merge 的末尾，并将其从 word2 中移除。
    //例如，word2 = "abc" 且 merge = "" ，在执行此选项操作之后，word2 = "bc" ，同时 merge = "a" 。
    //返回你可以构造的字典序 最大 的合并字符串 merge 。
    //
    //长度相同的两个字符串 a 和 b 比较字典序大小，如果在 a 和 b 出现不同的第一个位置，a 中字符在字母表中的出现顺序位于 b 中相应字符之后，就认为字符串 a 按字典序比字符串 b 更大。例如，"abcd" 按字典序比 "abcc" 更大，因为两个字符串出现不同的第一个位置是第四个字符，而 d 在字母表中的出现顺序位于 c 之后。
    public String largestMerge(String word1, String word2) {
        String ans="";
        boolean flag=true;
        if(word1.equals("")||word2.equals("")){
            return ans;
        }
        while(flag){
            char a=word1.charAt(0);
            char b=word2.charAt(0);
            if(word1.compareTo(word2)>0){
                word1=word1.substring(1,word1.length());
                if(word1.equals("")){
                    flag=false;
                }
                ans+=a;
            }else {
                word2=word2.substring(1,word2.length());
                if(word2.equals("")){
                    flag=false;
                }
                ans+=b;
            }
        }
        if(word1.equals("")&&word2.equals("")){
            return ans;
        }else if(word1.equals("")){
            return ans+word2;
        }else if(word2.equals("")){
            return ans+word1;
        }
        return ans;
    }
}
