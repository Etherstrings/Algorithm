package TwoPoint;

/**
 * @author Justice_wby
 * @create 2023-01-16 2:49
 */
public class L1813 {
    //1813. 句子相似性 III
    //一个句子是由一些单词与它们之间的单个空格组成，且句子的开头和结尾没有多余空格。比方说，"Hello World" ，"HELLO" ，"hello world hello world" 都是句子。每个单词都 只 包含大写和小写英文字母。
    //
    //如果两个句子 sentence1 和 sentence2 ，可以通过往其中一个句子插入一个任意的句子（可以是空句子）而得到另一个句子，那么我们称这两个句子是 相似的 。比方说，sentence1 = "Hello my name is Jane" 且 sentence2 = "Hello Jane" ，我们可以往 sentence2 中 "Hello" 和 "Jane" 之间插入 "my name is" 得到 sentence1 。
    //
    //给你两个句子 sentence1 和 sentence2 ，如果 sentence1 和 sentence2 是相似的，请你返回 true ，否则返回 false 。
    //
    //
    //
    //示例 1：
    //
    //输入：sentence1 = "My name is Haley", sentence2 = "My Haley"
    //输出：true
    //解释：可以往 sentence2 中 "My" 和 "Haley" 之间插入 "name is" ，得到 sentence1 。
    //示例 2：
    //
    //输入：sentence1 = "of", sentence2 = "A lot of words"
    //输出：false
    //解释：没法往这两个句子中的一个句子只插入一个句子就得到另一个句子。
    //示例 3：
    //
    //输入：sentence1 = "Eating right now", sentence2 = "Eating"
    //输出：true
    //解释：可以往 sentence2 的结尾插入 "right now" 得到 sentence1 。
    //示例 4：
    //
    //输入：sentence1 = "Luky", sentence2 = "Lucccky"
    //输出：false
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        //尝试1中有2
        if(sentence1.equals(sentence2)){
            return true;
        }
        int len1=sentence1.length();
        int len2=sentence2.length();
        if(len1==len2){
            return false;
        }
        String mother="";
        String son="";
        if(len1>len2){
            mother=sentence1;
            son=sentence2;
        }else {
            mother=sentence2;
            son=sentence1;
        }
        boolean flag=false;
        String[] mo=mother.split(" ");
        String[] so=son.split(" ");
        int l1=0,l2=0;
        int r1=mo.length-1;
        int r2=so.length-1;
        while(l1<=r1&&l2<=r2){
            if(mo[l1].equals(so[l2])){
                l1++;
                l2++;
            }else if(mo[r1].equals(so[r2])){
                r1--;
                r2--;
            }else {
                return false;
            }
        }
        return l1>r1||l2>r2;

    }
}
