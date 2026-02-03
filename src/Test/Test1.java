package Test;

import java.util.Arrays;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2026-01-13
 */
public class Test1 {
    //给你提供一个无序的正整数数组
    //请你判断是否存在这样的元素，他出现的次数超过了数组长度的一半
    //如果存在，打印这个元素，如果不存在，打印0
    //要求空间复杂度是o(1) 时间复杂度是o(n)

    // 1-n
    // v 1-n

    //int key int value

    //1 2 3 3 3

    public static void main(String[] args) {
        int[] hasMajority = {1, 2, 3, 3, 3};
        int[] hasMajorityEven = {2, 2, 1, 2};
        int[] noMajority = {1, 2, 3, 4};
        int[] single = {7};

        assert getShowMoreN(hasMajority) == 3 : "should find majority element 3";
        assert getShowMoreN(hasMajorityEven) == 2 : "should find majority element 2";
        assert getShowMoreN(noMajority) == 0 : "should return 0 when no majority exists";
        assert getShowMoreN(single) == 7 : "single element should be the majority";

        System.out.println("All Test1 assertions passed: " + Arrays.toString(hasMajority));
    }

    public static int getShowMoreN(int[] nums){
        int candidate = 0;
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
                count = 1;
            } else if (candidate == num) {
                count++;
            } else {
                count--;
            }
        }
        int occurrence = 0;
        for (int num : nums) {
            if (num == candidate) {
                occurrence++;
            }
        }
        return occurrence > nums.length / 2 ? candidate : 0;
    }

}
