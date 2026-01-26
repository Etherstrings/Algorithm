package WorkReview.CralBook.Thread;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2025-12-29
 */
public class SwtichPrint {
    private static int num;
    private static final Object obj = new Object();
    public static void main(String[] args) {
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        synchronized (obj) {
                            if (num%2==0) {
                                System.out.println(num);
                                num++;
                            }
                        }
                    }
                }
        ).start();
    }
}
