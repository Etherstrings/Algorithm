package WorkReview.CralBook.ArraysView.TwoPoint;

import java.util.Scanner;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2025-11-12
 */
public class Test {
    public static void main(String[] args) {
        String input = "客服 : 您好，点击下方免费咨询，我们将第一时间为您服务 客服 : wenba2;自动化添加-问题列表 用户 : 18101315096 用户 : 自动化添加-问题列表 客服 : 问题列表回复内容 用户 : 18101315096 用户 : 现在是高三学生，目前能考587分，大概能去哪些学校啊 用户 : 15637432061";

        // 格式化处理
        String formatted = formatDialogue(input);

        System.out.println("格式化结果：");
        System.out.println(formatted);

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            //换行
            System.out.println();
            System.out.println(line);
        }

    }

    public static String formatDialogue(String input) {
        // 1. 在角色标识前添加换行符
        String withNewlines = input.replaceAll("(用户 : |客服 : )", "\n$1");

        // 2. 移除开头的空白行
        String trimmed = withNewlines.trim();

        // 3. 保留逗号后的空格（但移除逗号本身）
        return trimmed.replaceAll(", ", "\n").replaceAll(",", "");
    }
}
