package src;

/**
 * @description:
 * @author： wuboyu
 * @date： 2022-07-18 09:22
 */
public class L565 {
    //565. 数组嵌套
    //索引从0开始长度为N的数组A，包含0到N - 1的所有整数。找到最大的集合S并返回其大小，其中 S[i] = {A[i], A[A[i]], A[A[A[i]]], ... }且遵守以下的规则。
    //
    //假设选择索引为i的元素A[i]为S的第一个元素，S的下一个元素应该是A[A[i]]，之后是A[A[A[i]]]... 以此类推，不断添加直到S出现重复的元素。
    //
    //
    //
    //示例 1:
    //
    //输入: A = [5,4,0,3,1,6,2]
    //输出: 4
    //解释:
    //A[0] = 5, A[1] = 4, A[2] = 0, A[3] = 3, A[4] = 1, A[5] = 6, A[6] = 2.
    //
    //其中一种最长的 S[K]:
    //S[0] = {A[0], A[5], A[6], A[2]} = {5, 6, 2, 0}
    //
    //
    //提示：
    //
    //N是[1, 20,000]之间的整数。
    //A中不含有重复的元素。
    //A中的元素大小在[0, N-1]之间。
    public int arrayNesting(int[] nums) {
        //每次按照成环的入口查找
        //1.维护一个环长度
        //2.如果看到过当前环---将此环节点设置为-1
        //3.当当前的值--为最开始的值--循环了
        int ans=1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==-1){
                continue;
            }
            int size=1;
            int next=nums[i];
            while(next!=i){
                int temp=nums[next];
                nums[next]=-1;
                size++;
                next=temp;
            }
            ans=Math.max(size,ans);
        }
        return ans;
    }
}
