package StringExer;

public class L2011 {
    //2011. 执行操作后的变量值
    //存在一种仅支持 4 种操作和 1 个变量 X 的编程语言：
    //
    //++X 和 X++ 使变量 X 的值 加 1
    //--X 和 X-- 使变量 X 的值 减 1
    //最初，X 的值是 0
    //
    //给你一个字符串数组 operations ，这是由操作组成的一个列表，返回执行所有操作后， X 的 最终值 。
    public int finalValueAfterOperations(String[] operations) {
        int ans=0;
        for(String now:operations){
            if(now.equals("++X")||now.equals("X++")){
                ans++;
                continue;
            }
            if(now.equals("--X")||now.equals("X--")){
                ans--;
                continue;
            }
        }
        return ans;
    }
}
