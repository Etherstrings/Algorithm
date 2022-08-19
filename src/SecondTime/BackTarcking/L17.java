package SecondTime.BackTarcking;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author： wuboyu
 * @date： 2022-08-19 14:26
 */
public class L17 {
    List<String> ans=new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return ans;
        }
        //初始对应所有的数字，为了直接对应2-9，新增了两个无效的字符串""
        String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        BackTarcking(digits,numString,0);
        return ans;
    }
    //每次迭代获取一个字符串，所以会设计大量的字符串拼接，所以这里选择更为高效的 StringBuild
    StringBuilder temp = new StringBuilder();
    void BackTarcking(String digits, String[] numString,int num){
        //当前第几个数字？
        if(num==digits.length()){
            ans.add(temp.toString());
            return;
        }
        //当前这个数字对应的几个字母
        String str=numString[digits.charAt(num)-'0'];
        for(int i=0;i<str.length();i++){
            //当前的三个都要拼
            //每拼一次都要发展自己的分支
            temp.append(str.charAt(i));
            BackTarcking(digits,numString,num+1);
            temp.deleteCharAt(temp.length()-1);
        }
    }

}
