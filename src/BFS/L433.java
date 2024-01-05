package BFS;
import java.util.*;
/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2023-11-29
 */
public class L433 {
    //基因序列可以表示为一条由 8 个字符组成的字符串，其中每个字符都是 'A'、'C'、'G' 和 'T' 之一。
    //
    // 假设我们需要调查从基因序列 start 变为 end 所发生的基因变化。一次基因变化就意味着这个基因序列中的一个字符发生了变化。
    //
    //
    // 例如，"AACCGGTT" --> "AACCGGTA" 就是一次基因变化。
    //
    //
    // 另有一个基因库 bank 记录了所有有效的基因变化，只有基因库中的基因才是有效的基因序列。（变化后的基因必须位于基因库 bank 中）
    //
    // 给你两个基因序列 start 和 end ，以及一个基因库 bank ，请你找出并返回能够使 start 变化为 end 所需的最少变化次数。如果无法完成
    //此基因变化，返回 -1 。
    //
    // 注意：起始基因序列 start 默认是有效的，但是它并不一定会出现在基因库中。
    //
    //
    //
    // 示例 1：
    //
    //
    //输入：start = "AACCGGTT", end = "AACCGGTA", bank = ["AACCGGTA"]
    //输出：1
    //
    //
    // 示例 2：
    //
    //
    //输入：start = "AACCGGTT", end = "AAACGGTA", bank = ["AACCGGTA","AACCGCTA",
    //"AAACGGTA"]
    //输出：2
    //
    //
    // 示例 3：
    //
    //
    //输入：start = "AAAAACCC", end = "AACCCCCC", bank = ["AAAACCCC","AAACCCCC",
    //"AACCCCCC"]
    //输出：3
    //
    //
    //
    //
    // 提示：
    //
    //
    // start.length == 8
    // end.length == 8
    // 0 <= bank.length <= 10
    // bank[i].length == 8
    // start、end 和 bank[i] 仅由字符 ['A', 'C', 'G', 'T'] 组成
    //
    //
    // Related Topics 广度优先搜索 哈希表 字符串 👍 272 👎 0
    //> 2023/11/29 20:42:28
    //解答成功:
    //	执行耗时:1 ms,击败了62.12% 的Java用户
    //	内存消耗:39.6 MB,击败了18.85% 的Java用户
    public int minMutation(String startGene, String endGene, String[] bank) {
        //BFS
        //查找不同的地方，将不同的地方作为起点进行变化，直到变化为endGene
        //每次变化需要去bank查询是不是有效变化，如果有效再进行变化
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        if(bank.length==0||startGene.length()!=endGene.length()){
            return -1;
        }
        Set<String> bankSet = new HashSet<>();
        for(String s : bank){
            bankSet.add(s);
        }
        if(!bankSet.contains(endGene)){
            return -1;
        }
        int ans = 0;
        queue.offer(startGene);
        visited.add(startGene);
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-->0){
                String cur = queue.poll();
                if(cur.equals(endGene)){
                    return ans;
                }
                for(int i=0;i<cur.length();i++){
                    char[] chars = cur.toCharArray();
                    //每一个字母都进行转换尝试
                    for(char c : new char[]{'A','C','G','T'}){
                        chars[i] = c;
                        String newGene = new String(chars);
                        if(!visited.contains(newGene)&&bankSet.contains(newGene)){
                            queue.offer(newGene);
                            visited.add(newGene);
                        }
                    }
                }
            }
            ans++;
        }
        return -1;
    }
}
