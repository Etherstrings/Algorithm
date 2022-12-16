package src.Mianshi.Dajiang;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2022-08-14 18:53 Mianshi.Dajiang - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  Main - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/8/14 - the current system date.  18:53 - the current system time.  2022 - the current year.  08 - the current month.  14 - the current day of the month.  18 - the current hour.  53 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  8月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  八月 - full name of a month. Example: January, February, etc
 */
public class Main {
    public static void main(String[] args){
        //控制台的输入数据
        Scanner reader = new Scanner(System.in);
        System.out.println("打印的输出结果");
        while (reader.hasNextInt()) { // 注意 while 处理多个 case
            int a = reader.nextInt();
            int b = reader.nextInt();
            //处理
        }

        //第一行个数第二行字符串
        int n = reader.nextInt();
        reader.nextLine();
        while (reader.hasNext()) { // 注意 while 处理多个 case
            String[] s = reader.nextLine().split(" ");
            //处理
        }


        //1.数据输入
        Scanner in = new Scanner(System.in);
        //读数字
        int numLen = in.nextInt();
        int[] numArr = new int[numLen];
        int i = 0;
        while(in.hasNextInt() && i < numLen){
            numArr[i] = in.nextInt();
            i++;
        }
        //读字符串
        int strLen = in.nextInt();
        in.nextLine(); //数字到字符串要换行
        String[] strArr = new String[strLen];
        //或者 strArr[] = in.nextLine().split(" ");
        int j = 0;
        while(in.hasNextLine() && j < strLen){
            strArr[j] = in.nextLine();
            j++;
        }

        //2. 处理
        Solution solution = new Solution();
        String result = solution.process(numArr, strArr);

        //3. 输出
        System.out.println(result);
        //四舍五入输出小数
        String str = String.format("%.2f",3.555);
        System.out.println(str);
    }

    //下面类似 LeetCode 的核心代码模式
    class Solution {
        public String process(int[] nums, String[] strs) {
            StringBuilder sb = new StringBuilder();
            sb.append(Arrays.toString(nums));
            sb.append(" && ");
            sb.append(Arrays.toString(strs));
            return sb.toString();
        }
}
