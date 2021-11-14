package other;

import java.util.Arrays;

/**
 * 求有序数组的最小k值
 */
public class 最小k值 {
    static int min;

    public static void main(String[] args) {
        最小k值 k = new 最小k值();
        int[] num = {1, 2, 3, 4};
        k.deep(num, 4);
        System.out.println(min);
    }

    public void deep(int[] num, int k) {
        if (k == 0 || k > num.length) {
            return;
        }
        if (k == 1) {
            min = num[0];
            return;
        }
        int index = k / 2;
        if (index < num.length) {
            deep(Arrays.copyOfRange(num, index, num.length), k - index);
        }
    }
}
