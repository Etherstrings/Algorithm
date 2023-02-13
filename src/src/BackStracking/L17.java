package src.BackStracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Etherstrings
 * @create 2022-05-10 20:52 BackStracking - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L17 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/5/10 - the current system date.  20:52 - the current system time.  2022 - the current year.  05 - the current month.  10 - the current day of the month.  20 - the current hour.  52 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  5月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  五月 - full name of a month. Example: January, February, etc
 */
public class L17 {
    //17. 电话号码的字母组合
    //给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
    //
    //给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
    //
    //
    //
    //
    //
    //示例 1：
    //
    //输入：digits = "23"
    //输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
    //示例 2：
    //
    //输入：digits = ""
    //输出：[]
    //示例 3：
    //
    //输入：digits = "2"
    //输出：["a","b","c"]
    //
    //
    //提示：
    //
    //0 <= digits.length <= 4
    //digits[i] 是范围 ['2', '9'] 的一个数字。

    /**
     *
     * @param digits
     * @return
     */
    //定义一个对应关系
    //初始对应所有的数字，为了直接对应2-9，新增了两个无效的字符串""
    String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    //定义全局变量  Path
    LinkedList<Character> Path=new LinkedList<>();
    //定义全局变量 Result
    List<String> Result=new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        /**
         * 1.外部先定义数字与字母的联系
         * 2.想想怎么递归
         *      输入数字
         */
        if(digits==null||digits.length()==0){
            return Result;
        }
        BackStracking(digits,numString,0);
        return Result;
    }


    private void BackStracking(String digits, String[] numString, int index){
        //终止条件
        if(Path.size()==digits.length()){
            String Pathnew="";
            for(Character a:Path){
                Pathnew+=a;
            }
            Result.add(Pathnew);
            return;
        }

        //从numString取出digits第一个对应的那几个字母
        //按照index的顺序进行取
        String now = numString[digits.charAt(index) - '0'];

        for(int i=0;i<now.length();i++){
            //进入递归的方法
            Path.add(now.charAt(i));
            //递归开始
                //比如是 2 3
                //这里循环的是2的三个字母
                //递归进入3的三个字母
                BackStracking(digits,numString,index+1);
            //回溯
            Path.removeLast();
        }
    }
}
