package Moni;

/**
 * @author Etherstrings
 * @create 2022-08-10 22:42 Moni - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L640 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/8/10 - the current system date.  22:42 - the current system time.  2022 - the current year.  08 - the current month.  10 - the current day of the month.  22 - the current hour.  42 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  8月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  八月 - full name of a month. Example: January, February, etc
 */
public class L640 {
    //640. 求解方程
    //求解一个给定的方程，将x以字符串 "x=#value" 的形式返回。该方程仅包含 '+' ， '-' 操作，变量 x 和其对应系数。
    //
    //如果方程没有解，请返回 "No solution" 。如果方程有无限解，则返回 “Infinite solutions” 。
    //
    //题目保证，如果方程中只有一个解，则 'x' 的值是一个整数。
    //
    //
    //
    //示例 1：
    //
    //输入: equation = "x+5-3+x=6+x-2"
    //输出: "x=2"
    //示例 2:
    //
    //输入: equation = "x=x"
    //输出: "Infinite solutions"
    //示例 3:
    //
    //输入: equation = "2x=x"
    //输出: "x=0"
    public String solveEquation(String equation) {
        int index = equation.indexOf("=");
        String left=equation.substring(0,index);
        String right=equation.substring(index+1,equation.length());

        String[] splitleft = left.replace("-", "+-").split("\\\\+");
        String[] splitright = right.replace("-", "+-").split("\\\\+");
        int leftsize=0;
        int rightsize=0;
        for(String s:splitleft){
            if(s.equals("x")){
                leftsize++;
            }else if(s.equals("-x")){
                leftsize--;
            }else if(s.contains("x")){
                leftsize += Integer.parseInt(s.substring(0, s.length() - 1));
            }else if(!s.equals("")){
                rightsize-=Integer.parseInt(s);
            }
        }

        // 等式右边的处理
        for (String s : splitright) {
            if (s.equals("x")) {
                leftsize -= 1;
            } else if (s.equals("-x")) {
                leftsize -= -1;
            } else if (s.contains("x")) {
                leftsize -= Integer.parseInt(s.substring(0, s.length() - 1));
            } else if (!s.equals("")) {
                rightsize += Integer.parseInt(s);
            }
        }

        if(leftsize==0){
            if(rightsize==0){
                return "Infinite solutions";
            }else {
                return "No solution";
            }
        }else {
            return "x="+rightsize/leftsize;
        }

    }
}
