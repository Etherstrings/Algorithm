import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/**
 * @author Etherstrings
 * @create 2022-07-13 20:16 PACKAGE_NAME - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L735 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/7/13 - the current system date.  20:16 - the current system time.  2022 - the current year.  07 - the current month.  13 - the current day of the month.  20 - the current hour.  16 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  7月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  七月 - full name of a month. Example: January, February, etc
 */
public class L735 {
    //735. 行星碰撞
    //给定一个整数数组 asteroids，表示在同一行的行星。
    //
    //对于数组中的每一个元素，其绝对值表示行星的大小，正负表示行星的移动方向（正表示向右移动，负表示向左移动）。每一颗行星以相同的速度移动。
    //
    //找出碰撞后剩下的所有行星。碰撞规则：两个行星相互碰撞，较小的行星会爆炸。如果两颗行星大小相同，则两颗行星都会爆炸。两颗移动方向相同的行星，永远不会发生碰撞。
    //
    //
    //
    //示例 1：
    //
    //输入：asteroids = [5,10,-5]
    //输出：[5,10]
    //解释：10 和 -5 碰撞后只剩下 10 。 5 和 10 永远不会发生碰撞。
    //示例 2：
    //
    //输入：asteroids = [8,-8]
    //输出：[]
    //解释：8 和 -8 碰撞后，两者都发生爆炸。
    //示例 3：
    //
    //输入：asteroids = [10,2,-5]
    //输出：[10]
    //解释：2 和 -5 发生碰撞后剩下 -5 。10 和 -5 发生碰撞后剩下 10 。
    public int[] asteroidCollision(int[] asteroids) {
        //有一点比较好
        //那就是左边都是正 右边的都是负
        int left=Integer.MIN_VALUE;
        int right=Integer.MIN_VALUE;
        //遍历查找左边什么时候开始 右边什么时候开始
        ArrayList<Integer> Judge=new ArrayList<>();
        for(int i=0;i<asteroids.length;i++){
            if(asteroids[i]<0){
                //找到当前为负的了
                if(i>0){
                    left=i-1;
                    right=i;
                }
                if(i==0){
                    return asteroids;
                }
                if(i==asteroids.length-1){
                    return asteroids;
                }
            }
            Judge.add(asteroids[i]);
        }
        int leftsize=left+1;
        int rightsize=asteroids.length-leftsize;
        while(leftsize!=0||rightsize!=0){
            if(Judge.get(left)== Judge.get(right)){
                Judge.remove(left);
                left--;
                Judge.remove(left+1);
                right=left+1;
                leftsize--;
                rightsize--;

            }else if(Judge.get(left)>Judge.get(right)){
                //左边留 右边没有
                rightsize--;

                //左边不变

                //右边变为下一个
                Judge.remove(right);
            }else {
                //右边留 左边消失一个
                leftsize--;
                Judge.remove(left);
                left=left+1;
                right=left+1;

            }
        }
        //是不是可以贪心
        int[] ans=new int[Judge.size()];
        for(int i=0;i<Judge.size();i++){
            ans[i]=Judge.get(i);
        }
        return ans;
    }

    //想简单了 这个是可以并行的！
    //就是左边不一定都是正数 可能随时随地都在碰撞
    public int[] asteroidCollision(int[] asteroids){
        Stack<Integer> Judge=new Stack<>();
        //从左往右遍历
        for(int i=0;i<asteroids.length;i++){
            boolean flag=true;
            if(asteroids[i]>0){
                Judge.push(asteroids[i]);
            }
            if(asteroids[i]<0){
                if(Judge.isEmpty()||Judge.peek()<0){
                    Judge.push(asteroids[i]);
                }
                while(!Judge.isEmpty()){
                        //当这个栈空了 或者 这个栈的最后一个是负的时候 停止
                        if(Judge.peek()>asteroids[i]){
                            flag=false;
                            break;
                        }else if(Judge.peek()==asteroids[i]){
                            Judge.pop();
                            flag=false;
                            break;
                        }else if(Judge.peek()<0){
                            break;
                        }else {
                            Judge.pop();
                        }
                    }
                if(flag){
                    Judge.push(asteroids[i]);
                }

            }

        }
        ArrayList<Integer> ansList=new ArrayList<>();
        while(!Judge.isEmpty()){
            ansList.add(Judge.pop());
        }
        Collections.reverse(ansList);
        int[] ans=new int[ansList.size()];
        for(int i=0;i<ansList.size();i++){
            ans[i]=ansList.get(i);
        }
        return ans;
    }
}
