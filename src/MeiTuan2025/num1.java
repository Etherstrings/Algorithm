package MeiTuan2025;

import java.util.Scanner;

public class num1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String word = in.nextLine();
        System.out.println(replace(word));
    }

    public static String replace(String word) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == 'a' || word.charAt(i) == 'e' || word.charAt(i) == 'i' || word.charAt(i) == 'o' || word.charAt(i) == 'u') {
                sb.append("!");
            } else {
                sb.append(word.charAt(i));
            }
        }
        return sb.toString();
    }
}
