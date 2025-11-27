package TwoPoint;

/**
 * @author Etherstrings
 * @create 2022-01-09 11:46 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  project01 - the name of the current project.  ${FILE_NAME} - the name of the PHP file that will be created.  TwoPoint.L27Remove - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/1/9 - the current system date.  11:46 - the current system time.  2022 - the current year.  01 - the current month.  09 - the current day of the month.  11 - the current hour.  46 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  一月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  一月 - full name of a month. Example: January, February, etc
 */
public class L27Remove {
    /**

     *
     *
     * @param nums
     * @param val
     * @return
     *
     *
     *      * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
     *      *
     *      * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
     *      *
     *      * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
     */
    public static void main(String[] args) {

        L27Remove l27Remove=new L27Remove();
        int[] nums={4,4,0,1,0,2};
        System.out.println(l27Remove.removeElement(nums,0));
    }

    //一旦出现0，就失败！
    public int removeElement(int[] nums, int val) {
            int Olength=nums.length;
            int Nlength;
            int Times=0;

            for(int i=0;i<nums.length;i++){
                if(nums[i]==val){
                    Nlength=nums.length-1;
                    Times+=1;
                    for(int j=i;j<nums.length-1;j++){
                        nums[j]=nums[j+1];
                    }
                    nums[nums.length-1]=0;
                    while(nums[i]==val){
                        Nlength=nums.length-1;
                        Times+=1;
                        for(int j=i;j<nums.length-1;j++){
                            nums[j]=nums[j+1];
                        }

                        nums[nums.length-1]=0;
                    }
                }


            }
            int[] Newnums=new int[nums.length-Times];
            for(int i=0;i<Newnums.length;i++){
                Newnums[i]=nums[i];

            }
            return Newnums.length;
    }

    public int removeElement1(int[] nums, int val){
        int size=nums.length;
        for(int i=0;i<size;i++){
            if(nums[i]==val){
                for(int j=i+1;j<size;j++){
                    nums[j=1]=nums[j];
                }
                //这两步 很重要
                //这一步和我上面判断 是否有重复元素是一个思想
                i-=1;
                //这一步是为了删除末尾的重复元素
                size-=1;
            }
        }
        return size;
    }

    public int removeElement2(int[] nums, int val){
        int slow=0;

        for(int fast=0;fast<nums.length;fast++){
            //fast不管不顾 自己遍历
            //fast增加后 判断这个是不是和目标值相同
            //如果不同
            //快指针的值赋给慢指针
            if(nums[fast]!=val){
                nums[slow]=nums[fast];
                slow+=1;
            }
            //相同
            //慢指针不加 停在此处 说明原数组下一个位置就有问题
            //假如快指针=4 慢=4
            //快进入5 判断有问题 慢不加 还是4
            //此时5的操作已经结束
            //快进入6 6的值赋给4 4之前都没问题

        }
        return slow;
    }
}
