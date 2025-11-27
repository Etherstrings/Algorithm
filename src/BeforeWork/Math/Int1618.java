package Math;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2023-11-30
 */
public class Int1618 {
    //你有两个字符串，即pattern和value。 pattern字符串由字母"a"和"b"组成，用于描述字符串中的模式。例如，字符串
    //"catcatgocatgo"匹配模式"aabab"（其中"cat"是"a"，"go"是"b"），该字符串也匹配像"a"、"ab"和"b"这样的模式。但需注意"a"和"b"不能同时表示相
    //同的字符串。编写一个方法判断value字符串是否匹配pattern字符串。
    //
    // 示例 1：
    //
    // 输入： pattern = "abba", value = "dogcatcatdog"
    //输出： true
    //
    //
    // 示例 2：
    //
    // 输入： pattern = "abba", value = "dogcatcatfish"
    //输出： false
    //
    //
    // 示例 3：
    //
    // 输入： pattern = "aaaa", value = "dogcatcatdog"
    //输出： false
    //
    //
    // 示例 4：
    //
    // 输入： pattern = "abba", value = "dogdogdogdog"
    //输出： true
    //解释： "a"="dogdog",b=""，反之也符合规则
    //
    //
    // 提示：
    //
    //
    // 1 <= len(pattern) <= 1000
    // 0 <= len(value) <= 1000
    // 你可以假设pattern只包含字母"a"和"b"，value仅包含小写字母。
    //
    //
    // Related Topics 数学 字符串 回溯 枚举 👍 144 👎 0
    //> 2023/11/30 11:42:34
    //已提交,请稍等
    //
    //> 2023/11/30 11:42:35
    //解答成功:
    //	执行耗时:1 ms,击败了66.06% 的Java用户
    //	内存消耗:39.6 MB,击败了54.13% 的Java用户
    public static void main(String[] args) {
        System.out.println(patternMatching("abbaa", "dogdogdogdogdog"));
    }
    public static boolean patternMatching(String pattern, String value) {
        //	测试用例:"abbaa"
        //			"dogdogdogdogdog"

        //思路:a*alen+b*blen=value.length()
        //a b 已经知道了，那么a的长度和b的长度也就确定了
        int aCount = 0, bCount = 0;
        for (char ch : pattern.toCharArray()) {
            if (ch == 'a') {
                aCount++;
            } else {
                bCount++;
            }
        }
        //a=0 或者 b=0
        if (aCount == 0) {
            return shelper(value, bCount);
        }
        if (bCount == 0) {
            return shelper(value, aCount);
        }

        //枚举a的长度
        for (int aLen = 0; aLen * aCount <= value.length(); aLen++) {
            //剩余的长度
            int rest = value.length() - aLen * aCount;
            //b的长度
            if (rest % bCount != 0) {
                continue;
            }
            int bLen = rest / bCount;
            if (helper(pattern, value, aLen, bLen)) {
                return true;
            }
        }
        return false;
    }

    public static boolean shelper(String value, int len) {
        if (value.length() % len != 0) {
            return false;
        }
        int subLen = value.length() / len;
        String sub = value.substring(0, subLen);
        for (int i = subLen; i < value.length(); i += subLen) {
            if (!sub.equals(value.substring(i, i + subLen))) {
                return false;
            }
        }
        return true;
    }

    public static boolean helper(String pattern, String value, int aLen, int bLen) {
        String a = "", b = "";
        int index = 0;
        for (char ch : pattern.toCharArray()) {
            if (ch == 'a') {
                String sub = value.substring(index, index + aLen);
                if (a.length() == 0) {
                    a = sub;
                } else if (!a.equals(sub)) {
                    return false;
                }
                index += aLen;
            } else {
                String sub = value.substring(index, index + bLen);
                if (b.length() == 0) {
                    b = sub;
                } else if (!b.equals(sub)) {
                    return false;
                }
                index += bLen;
            }
        }
        if(a.equals(b)) return false;
        return true;
    }
}
