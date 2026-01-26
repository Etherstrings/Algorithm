package Test;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2026-01-09
 */
public class arrays {
    public static void main(String[] args) {
        //输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
        //输出：[1,2,2,3,5,6]
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;
        new arrays().merge(nums1, m, nums2, n);
        //打印数组1
        for (int num : nums1) {
            System.out.println(num);
        }
    }


    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[m+n];
        int i =0;
        int j =0;
        int index = 0;



        // 1 2 3 0 0 0
        // 2 5 6

        // 1 0
        // 1 1
        // 2 1
        while (i<m || j<n) {
            if (i==m && j!=n) {
                temp[index] = nums2[j];
                j++;
                index++;
                continue;
            }
            if (j==n && i!=m) {
                temp[index] = nums1[i];
                i++;
                index++;
                continue;
            }
            if (nums1[i] < nums2[j]) {
                temp[index] = nums1[i];
                i++;
                index++;
            } else {
                temp[index] = nums2[j];
                j++;
                index++;
            }
        }
        for (index=0;index<m+n;index++) {
            nums1[index] = temp[index];
        }
    }
}
