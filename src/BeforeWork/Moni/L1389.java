package Moni;

import java.util.LinkedList;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2023-12-04
 */
public class L1389 {
    //给你两个整数数组 nums 和 index。你需要按照以下规则创建目标数组：
    //
    //
    // 目标数组 target 最初为空。
    // 按从左到右的顺序依次读取 nums[i] 和 index[i]，在 target 数组中的下标 index[i] 处插入值 nums[i] 。
    // 重复上一步，直到在 nums 和 index 中都没有要读取的元素。
    //
    //
    // 请你返回目标数组。
    //
    // 题目保证数字插入位置总是存在。
    //
    //
    //
    // 示例 1：
    //
    // 输入：nums = [0,1,2,3,4], index = [0,1,2,2,1]
    //输出：[0,4,1,3,2]
    //解释：
    //nums       index     target
    //0            0        [0]
    //1            1        [0,1]
    //2            2        [0,1,2]
    //3            2        [0,1,3,2]
    //4            1        [0,4,1,3,2]
    //
    //
    // 示例 2：
    //
    // 输入：nums = [1,2,3,4,0], index = [0,1,2,3,0]
    //输出：[0,1,2,3,4]
    //解释：
    //nums       index     target
    //1            0        [1]
    //2            1        [1,2]
    //3            2        [1,2,3]
    //4            3        [1,2,3,4]
    //0            0        [0,1,2,3,4]
    //
    //
    // 示例 3：
    //
    // 输入：nums = [1], index = [0]
    //输出：[1]
    //
    //
    //
    //
    // 提示：
    //
    //
    // 1 <= nums.length, index.length <= 100
    // nums.length == index.length
    // 0 <= nums[i] <= 100
    // 0 <= index[i] <= i
    //
    //
    // Related Topics 数组 模拟 👍 70 👎 0
    //> 2023/12/04 20:21:49
    //解答成功:
    //	执行耗时:3 ms,击败了6.28% 的Java用户
    //	内存消耗:40.3 MB,击败了5.23% 的Java用户
    public int[] createTargetArray(int[] nums, int[] index) {
        LinkedList<Integer> linkedList=new LinkedList<>();
        for(int i=0;i<nums.length;i++){
            linkedList.add(index[i],nums[i]);
        }
        return linkedList.stream().mapToInt(Integer::valueOf).toArray();
    }
}
