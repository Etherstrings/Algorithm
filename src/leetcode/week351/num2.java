package leetcode.week351;

public class num2 {
    //6471. 得到整数零需要执行的最少操作数 显示英文描述
    //通过的用户数15
    //尝试过的用户数28
    //用户总通过次数15
    //用户总提交次数46
    //题目难度Medium
    //给你两个整数：num1 和 num2 。
    //
    //在一步操作中，你需要从范围 [0, 60] 中选出一个整数 i ，并从 num1 减去 2i + num2 。
    //
    //请你计算，要想使 num1 等于 0 需要执行的最少操作数，并以整数形式返回。
    //
    //如果无法使 num1 等于 0 ，返回 -1 。
    //
    //
    //
    //示例 1：
    //
    //输入：num1 = 3, num2 = -2
    //输出：3
    //解释：可以执行下述步骤使 3 等于 0 ：
    //- 选择 i = 2 ，并从 3 减去 22 + (-2) ，num1 = 3 - (4 + (-2)) = 1 。
    //- 选择 i = 2 ，并从 1 减去 22 + (-2) ，num1 = 1 - (4 + (-2)) = -1 。
    //- 选择 i = 0 ，并从 -1 减去 20 + (-2) ，num1 = (-1) - (1 + (-2)) = 0 。
    //可以证明 3 是需要执行的最少操作数。
    //示例 2：
    //
    //输入：num1 = 5, num2 = 7
    //输出：-1
    //解释：可以证明，执行操作无法使 5 等于 0

    //num1-num2-2(i)
    //i-[0,60]

    //3 -2 5 4
    //1 -2 3 4
    //-1 -2 1 1
    public static void main(String[] args) {
        System.out.println(makeTheIntegerZero(5,-21));
    }
    public static int makeTheIntegerZero(int num1, int num2) {
        if(num1-num2<0){
            return -1;
        }
        int ans=0;
        if(num1-num2==0){
            return ans;
        }
        //每次减为最贴近的数，当num1-num2<0，就失败
        boolean flag=true;
        while(flag){
            long cha=num1-num2;
            long choose=findsim(cha);
            num1=(int)(cha-choose);
            ans++;
            if(num1==0){
                flag=false;
            }
        }
        return ans;
    }

    //找到最贴近的
    public static long findsim(long n){
        long ans=0;
        long left=0;
        long right=0;
        for(int i=0;i<=60;i++){
            long now= (long) Math.pow(2,i);
            if(now<n){
                left=Math.max(left,now);
            }else if(now==n){
                ans=now;
                return ans;
            }else {
                right=now;
                break;
            }
        }
        if(Math.abs(left-n)<Math.abs(right-n)){
            return left;
        }else {
            return right;
        }
    }
}
