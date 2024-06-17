package MeiTuan2025;

import java.util.Scanner;

public class num2 {
    //小美拿到了一个字符矩阵，她定义一个矩形区域是“特殊的”，当且仅当这个矩形区域中没有两个相同的字符。
    //现在小美想知道，有多少个2行2列的矩阵区域是特殊的？
    //〕输入描述
    //第一行输入两个正整数n，m，代表矩阵的行数和列数。
    //接下来的n行，每行输入一个长度为m的、仅由小写字母组成的字符串，代表小美拿到的字符矩阵。
    //1≤n,m≤ 200
    //〕输出描述
    //一个整数，代表"特殊的“矩形区域的数量。
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n,m;
        String[] line1 = in.nextLine().split(" ");
        n = Integer.parseInt(line1[0]);
        m = Integer.parseInt(line1[1]);
        char[][] grid = new char[n][m];
        for(int i=0;i<n;i++){
            String line = in.nextLine();
            for(int j=0;j<m;j++){
                grid[i][j]=line.charAt(j);
            }
        }
        System.out.println(pritucty(grid));
    }

    public static int pritucty(char[][] grid){
        int res = 0;
        for(int i=0;i<grid.length-1;i++){
            for(int j=0;j<grid[0].length-1;j++){
                if(grid[i][j]!=grid[i+1][j]&&grid[i][j]!=grid[i][j+1]&&grid[i][j+1]!=grid[i+1][j]&&grid[i][j+1]!=grid[i+1][j+1]&&grid[i+1][j]!=grid[i+1][j+1]){
                    res++;
                }
            }
        }
        return res;
    }

}



