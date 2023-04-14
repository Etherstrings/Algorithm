package AcWing.Base.TrieTree;

import java.util.Scanner;

/**
 * @author Etherstrings
 * @create 2023-04-09 14:53 AcWing.Base.TrieTree - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  A835 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/4/9 - the current system date.  14:53 - the current system time.  2023 - the current year.  04 - the current month.  09 - the current day of the month.  14 - the current hour.  53 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  4月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  四月 - full name of a month. Example: January, February, etc
 */
public class A835 {

    private static int N=100010;
    private static int son[][]=new int[N][26];//Trie树中每个节点的所有儿子
    private static int cnt[]=new int[N];//以当前这个点结尾的单词有多少个
    private static char str[]=new char[N];
    private static int idx;//当前用的的哪个下标，下标0：既是根节点又是空节点

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int N=Integer.parseInt(in.nextLine());
        for(int i=1;i<=N;i++){
            String[] line=in.nextLine().split(" ");
            if(line[0].equals("I")){
                insert(line[1]);
            }else {
                System.out.println(query(line[1]));
            }
        }
    }

    public static void insert(String words){
        int p=0;//根节点是0
        //从根节点开始，从前向后遍历字符串
        for(char now:words.toCharArray()){
            //当前字母对应的位置
            int u=now-'a';
            //如果当前这个点上不存在对应的字母的话，创建出来
            if(son[p][u]==0){
                son[p][u]=++idx;
            }
            p=son[p][u];//走到下一个点
        }
        cnt[p]++;//p对应的点就是最后一个点，cnt[p]++表示以这个点结尾的单词数量加1
    }

    //查找字符串出现的次数
    public static int query(String words){
        int p=0;
        for(char now:words.toCharArray()){
            //当前字母对应的位置
            int u=now-'a';
            //如果当前这个点上不存在对应的字母的话，创建出来
            if(son[p][u]==0){
                return 0;
            }
            //否则的话走过去
            p=son[p][u];
        }
        return cnt[p];
    }

}
