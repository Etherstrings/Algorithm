package xiaohongshu;

import java.util.Scanner;

public class num1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Integer n = Integer.parseInt(in.nextLine());
        //计算一个分数，保留十位
        Long all = (long) (n*(n-1));
        //让结果保留小数点后10位
        System.out.println(String.format("%.10f", 2.0/all));
    }
}
