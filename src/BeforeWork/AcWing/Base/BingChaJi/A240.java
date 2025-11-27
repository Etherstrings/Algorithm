package AcWing.Base.BingChaJi;

/**
 * @author Etherstrings
 * @create 2023-04-22 14:08 AcWing.Base.BingChaJi - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  A240 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/4/22 - the current system date.  14:08 - the current system time.  2023 - the current year.  04 - the current month.  22 - the current day of the month.  14 - the current hour.  08 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  4月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  四月 - full name of a month. Example: January, February, etc
 */
public class A240 {
    //动物王国中有三类动物 A,B,C，这三类动物的食物链构成了有趣的环形。
    //
    //A 吃 B，B 吃 C，C 吃 A。
    //
    //现有 N 个动物，以 1∼N 编号。
    //
    //每个动物都是 A,B,C 中的一种，但是我们并不知道它到底是哪一种。
    //
    //有人用两种说法对这 N 个动物所构成的食物链关系进行描述：
    //
    //第一种说法是 1 X Y，表示 X 和 Y 是同类。
    //
    //第二种说法是 2 X Y，表示 X 吃 Y。
    //
    //此人对 N 个动物，用上述两种说法，一句接一句地说出 K 句话，这 K 句话有的是真的，有的是假的。
    //
    //当一句话满足下列三条之一时，这句话就是假话，否则就是真话。
    //
    //当前的话与前面的某些真的话冲突，就是假话；
    //当前的话中 X 或 Y 比 N 大，就是假话；
    //当前的话表示 X 吃 X，就是假话。
    //你的任务是根据给定的 N 和 K 句话，输出假话的总数。
    //
    //输入格式
    //第一行是两个整数 N 和 K，以一个空格分隔。
    //
    //以下 K 行每行是三个正整数 D，X，Y，两数之间用一个空格隔开，其中 D 表示说法的种类。
    //
    //若 D=1，则表示 X 和 Y 是同类。
    //
    //若 D=2，则表示 X 吃 Y。
    //
    //输出格式
    //只有一个整数，表示假话的数目。
    //
    //数据范围
    //1≤N≤50000,
    //0≤K≤100000
    //输入样例：
    //100 7
    //1 101 1
    //2 1 2
    //2 2 3
    //2 3 3
    //1 1 3
    //2 3 1
    //1 5 5
    //输出样例：
    //3
}
