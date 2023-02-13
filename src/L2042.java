import java.util.regex.Pattern;

public class L2042 {
    public boolean areNumbersAscending(String s) {
        Pattern p = Pattern.compile("[0-9]*");
        String[] sa = s.split(" ");
        int pre = -1;
        for (String t : sa) {
            if (p.matcher(t).matches()) {
                int cur = Integer.parseInt(t);
                if (cur <= pre) {
                    return false;
                } else {
                    pre = cur;
                }
            }
        }
        return true;
    }
}
