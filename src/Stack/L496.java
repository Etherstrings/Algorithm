package Stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

/**
 * @description:
 * @author： wuboyu
 * @date： 2022-08-03 09:49
 */
public class L496 {
    //496. 下一个更大元素 I
    //nums1 中数字 x 的 下一个更大元素 是指 x 在 nums2 中对应位置 右侧 的 第一个 比 x 大的元素。
    //
    //给你两个 没有重复元素 的数组 nums1 和 nums2 ，下标从 0 开始计数，其中nums1 是 nums2 的子集。
    //
    //对于每个 0 <= i < nums1.length ，找出满足 nums1[i] == nums2[j] 的下标 j ，并且在 nums2 确定 nums2[j] 的 下一个更大元素 。如果不存在下一个更大元素，那么本次查询的答案是 -1 。
    //
    //返回一个长度为 nums1.length 的数组 ans 作为答案，满足 ans[i] 是如上所述的 下一个更大元素 。
    //
    //
    //
    //示例 1：
    //
    //输入：nums1 = [4,1,2], nums2 = [1,3,4,2].
    //输出：[-1,3,-1]
    //解释：nums1 中每个值的下一个更大元素如下所述：
    //- 4 ，用加粗斜体标识，nums2 = [1,3,4,2]。不存在下一个更大元素，所以答案是 -1 。
    //- 1 ，用加粗斜体标识，nums2 = [1,3,4,2]。下一个更大元素是 3 。
    //- 2 ，用加粗斜体标识，nums2 = [1,3,4,2]。不存在下一个更大元素，所以答案是 -1 。
    //示例 2：
    //
    //输入：nums1 = [2,4], nums2 = [1,2,3,4].
    //输出：[3,-1]
    //解释：nums1 中每个值的下一个更大元素如下所述：
    //- 2 ，用加粗斜体标识，nums2 = [1,2,3,4]。下一个更大元素是 3 。
    //- 4 ，用加粗斜体标识，nums2 = [1,2,3,4]。不存在下一个更大元素，所以答案是 -1 。
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        //首先从nums1挨个取值
        //在nums2里挨个查找

        //从nums1中取值
        //先找到nums1的各个对应值在nums2中的位置
        HashMap<Integer,Integer> Judege2=new HashMap<>();
        for(int i=0;i<nums2.length;i++){
            Judege2.put(nums2[i],i);
        }

        for(int i=0;i<nums1.length;i++){
            int temp=nums1[i];
            //当前的位置
            int index=Judege2.get(temp);
            if(index==nums2.length-1){
                nums1[i]=-1;
                continue;
            }
            boolean flag=false;
            for(int j=index;j<nums2.length;j++){
                if(nums2[j]>temp){
                    nums1[i]=nums2[j];
                    flag=true;
                    break;
                }
            }
            if(flag==false){
                nums1[i]=-1;
            }
        }
        return nums1;
    }

    public int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        Stack<Integer> temp = new Stack<>();
        int[] res = new int[nums1.length];
        Arrays.fill(res,-1);
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0 ; i< nums1.length ; i++){
            hashMap.put(nums1[i],i);
        }
        temp.add(0);
        for (int i = 1; i < nums2.length; i++) {
            if (nums2[i] <= nums2[temp.peek()]) {
                temp.add(i);
            } else {
                while (!temp.isEmpty() && nums2[temp.peek()] < nums2[i]) {
                    if (hashMap.containsKey(nums2[temp.peek()])){
                        Integer index = hashMap.get(nums2[temp.peek()]);
                        res[index] = nums2[i];
                    }
                    temp.pop();
                }
                temp.add(i);
            }
        }

        return res;
    }
}
