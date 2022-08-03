package Stack;

/**
 * @description:
 * @author： wuboyu
 * @date： 2022-08-03 09:25
 */
public class L739 {
    //739. 每日温度
    //给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
    //
    //
    //
    //示例 1:
    //
    //输入: temperatures = [73,74,75,71,69,72,76,73]
    //输出: [1,1,4,2,1,1,0,0]
    //示例 2:
    //
    //输入: temperatures = [30,40,50,60]
    //输出: [1,1,1,0]
    //示例 3:
    //
    //输入: temperatures = [30,60,90]
    //输出: [1,1,0]
    public int[] dailyTemperatures(int[] temperatures) {
        int left=0;
        while(left<temperatures.length){
            int now=temperatures[left];
            boolean flag=false;
            for(int right=left+1;right<temperatures.length;right++){
                if(temperatures[right]>now){
                    temperatures[left]=right-left;
                    flag=true;
                    break;
                }
            }
            if(flag==false){
                temperatures[left]=0;
            }
            left++;
        }
        return temperatures;
    }

    public int[] dailyTemperatures1(int[] temperatures){
        //单调栈

        //栈里存的是index

        //result[stack.pop()]=i-stack.pop();
        return new int[5];
    }
}
