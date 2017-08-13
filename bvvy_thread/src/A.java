import java.util.ArrayList;
import java.util.List;

/**
 * Created by bvvy on 2017/8/13.
 */
public class A {

    static String get(String num) {

        for (int i = 0; i < num.length() - 1; i++) {
            if (num.charAt(i) > num.charAt(i + 1)) {
                return num.substring(0, i) + num.charAt(i) + num.substring(i);
            }
        }
        return num + num.charAt(num.length() - 1);
    }

    public static void main(String[] args) {
        System.out.println(get("745655"));
    }

    static int verifyItems(String[] origItems, float[] origPrices, String[] items, float[] prices) {
        int count = 0;
        for (int i = 0; i < origItems.length; i++) {
            for (int j = 0; j < items.length; j++) {
                if (origItems[i].equals(items[j])) {
                    if (origPrices[i] != prices[j]) count++;
                }
            }
        }
        return count;
    }
}
