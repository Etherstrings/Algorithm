package src.StringExer;

import java.util.ArrayList;
import java.util.List;

public class L434 {
    //统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
    //
    //请注意，你可以假定字符串里不包括任何不可打印的字符。
    //
    //示例:
    //
    //输入: "Hello, my name is John"
    //输出: 5
    //解释: 这里的单词是指连续的不是空格的字符，所以 "Hello," 算作 1 个单词。
    public int countSegments(String s) {
        if(s.equals("")){
            return 0;
        }
        String[] s1 = s.split(" ");
        List<String> Judge=new ArrayList<>();
        for(String a:s1){
            if(a.equals("")){
                continue;
            }else {
                Judge.add(a);
            }
        }
        return Judge.size();
    }
}
