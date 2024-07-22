package StringExer;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2024-06-18
 */
public class L2288 {
    //句子 是由若干个单词组成的字符串，单词之间用单个空格分隔，其中每个单词可以包含数字、小写字母、和美元符号 '$' 。如果单词的形式为美元符号后跟着一个非负实数，那么这个单词就表示一个 价格 。
    //
    //例如 "$100"、"$23" 和 "$6" 表示价格，而 "100"、"$" 和 "$1e5 不是。
    //给你一个字符串 sentence 表示一个句子和一个整数 discount 。对于每个表示价格的单词，都在价格的基础上减免 discount% ，并 更新 该单词到句子中。所有更新后的价格应该表示为一个 恰好保留小数点后两位 的数字。
    //
    //返回表示修改后句子的字符串。
    //
    //注意：所有价格 最多 为 10 位数字。
    //
    //示例 1：
    //
    //输入：sentence = "there are $1 $2 and 5$ candies in the shop", discount = 50
    //输出："there are $0.50 $1.00 and 5$ candies in the shop"
    //解释：
    //表示价格的单词是 "$1" 和 "$2" 。
    //- "$1" 减免 50% 为 "$0.50" ，所以 "$1" 替换为 "$0.50" 。
    //- "$2" 减免 50% 为 "$1" ，所以 "$1" 替换为 "$1.00" 。
    public static void main(String[] args) {
        System.out.println(discountPrices("$7651913186 pw2o", 28));
    }
    public static String discountPrices(String sentence, int discount) {
        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            String newWord = isValidPrice(word, discount);
            if (newWord.length() == 0) {
                sb.append(word);
            } else {
                sb.append(newWord);
            }
            sb.append(" ");
        }
        return sb.toString().trim();
    }

    public static String isValidPrice(String word, int discount){
        if (word.charAt(0) != '$') {
            return "";
        }
        String price = word.substring(1);
        if (price.length() == 0) {
            return "";
        }
        if (price.charAt(0) == '0' && price.length() > 1) {
            return "";
        }
        if (price.length() > 10) {
            return "";
        }
        //$7651913186
        //1999999999
        //7651913186
        //这个为什么没有打折
        long p = 0;
        try {
            p = Long.parseLong(price);
        }   catch (NumberFormatException e) {
            return "";
        }
        //保留两位小数
        double newPrice = p * (1 - discount / 100.0);
        return String.format("$%.2f", newPrice);
    }

}
