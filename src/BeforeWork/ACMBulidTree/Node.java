package ACMBulidTree;

import java.util.ArrayList;

/**
 * @author Etherstrings
 * @create 2022-10-22 19:30 ACMBulidTree - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  Node - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/10/22 - the current system date.  19:30 - the current system time.  2022 - the current year.  10 - the current month.  22 - the current day of the month.  19 - the current hour.  30 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  10月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  十月 - full name of a month. Example: January, February, etc
 */
public class Node {

    int val;
    ArrayList<Node> children;

    public Node(int val) {
        this.val = val;
        this.children = new ArrayList<>();
    }
}
