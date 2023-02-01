package StringExer;

/**
 * @author Justice_wby
 * @create 2023-01-26 16:16
 */
public class L67 {
    //67. 二进制求和
    //给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。
    //
    //
    //
    //示例 1：
    //
    //输入:a = "11", b = "1"
    //输出："100"
    //示例 2：
    //
    //输入：a = "1010", b = "1011"
    //输出："10101"
    public String addBinary(String a, String b) {
        return Integer.toBinaryString(
                Integer.parseInt(a, 2) + Integer.parseInt(b, 2)
        );
    }
}
