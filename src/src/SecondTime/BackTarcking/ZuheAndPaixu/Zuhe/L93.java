package src.SecondTime.BackTarcking.ZuheAndPaixu.Zuhe;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @description:
 * @author： wuboyu
 * @date： 2022-08-19 16:53
 */
public class L93 {
    //切割问题
    //93. 复原 IP 地址
    //有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
    //
    //例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
    //给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
    //
    //
    //
    //示例 1：
    //
    //输入：s = "25525511135"
    //输出：["255.255.11.135","255.255.111.35"]
    //示例 2：
    //
    //输入：s = "0000"
    //输出：["0.0.0.0"]
    public List<String> restoreIpAddresses(String s) {
        //
    }
    LinkedList<String> Path=new LinkedList<>();
    List<List<String>> ans=new ArrayList<>();
    void Backtarcking(String s,int startindex,int point){
        //返回条件
        //如果切成第四段之后
        //第四段合法
        if(point==3){
            if(HeFa(s.substring(startindex,s.length()))){
                ans.add(new ArrayList<>(Path));
            }
            return;
        }


        for(int i=startindex;i<s.length();i++){
            //当前的字串
            //是否满足？
            String temp=s.substring(startindex,i+1);
            if(HeFa(temp)){
                Path.add(temp)
            }
        }
    }
}
