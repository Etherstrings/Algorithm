package src.SecondTime.BackTarcking.ZuheAndPaixu.Zuhe;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @description:
 * @author： wuboyu
 * @date： 2022-08-19 15:58
 */
public class L131 {
    //拼接字符串 判断是不是回文
    //实际上是连续字串
    //因为是截取
    //从0-s.lenght-1

    //核心思想是改变切的位置
    //分为左边切的和右边切的
    public List<List<String>> partition(String s) {
        BackTarck(s,0);
        return ans;
    }
    LinkedList<String> Path=new LinkedList<>();
    List<List<String>> ans=new ArrayList<>();
    void BackTarck(String s,int index){
        if(index==s.length()){
            ans.add(new ArrayList<>(Path));
            return;
        }

        for(int i=index;i<s.length();i++){
            String temp=s.substring(index, i + 1);
            if(ishuiwen(temp)){
                Path.add(temp);
                BackTarck(s, i + 1);
                Path.removeLast();
            }else {
                continue;
            }
        }
    }

    //判断是否是回文串
    private boolean ishuiwen(String s) {
        int startIndex=0;
        int end=s.length()-1;
        for (int i = startIndex, j = end; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
