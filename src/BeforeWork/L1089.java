import java.util.ArrayList;

public class L1089 {
    //1089. 复写零
    //难度
    //简单
    //
    //158
    //
    //
    //
    //
    //
    //给你一个长度固定的整数数组 arr，请你将该数组中出现的每个零都复写一遍，并将其余的元素向右平移。
    //
    //注意：请不要在超过该数组长度的位置写入元素。
    //
    //要求：请对输入的数组 就地 进行上述修改，不要从函数返回任何东西。
    //
    //
    //
    //示例 1：
    //
    //输入：[1,0,2,3,0,4,5,0]
    //输出：null
    //解释：调用函数后，输入的数组将被修改为：[1,0,0,2,3,0,0,4]
    //示例 2：
    //
    //输入：[1,2,3]
    //输出：null
    //解释：调用函数后，输入的数组将被修改为：[1,2,3]

    public void duplicateZeros(int[] arr) {
        //思路

        //顺序遍历 然后将后续移动？

        //这样处理量太大了

        //双指针

        //ARR + ANS
        ArrayList<Integer> Ans=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0){
                Ans.add(arr[i]);
                Ans.add(0);
            }else {
                Ans.add(arr[i]);
            }

        }

        for(int i=0;i<arr.length;i++){
            arr[i]=Ans.get(i);
        }
    }
}
