package me.laum.hangul;

public class HJUtil {
    public static char[] mergeCharArray(char[]... arrays) {
        int len = 0;
        for (char[] array : arrays) len += array.length;

        @SuppressWarnings("unchecked")
        char[] result = new char[len];
        int lastIdx = 0;
        for (char[] array : arrays) {
            for (int i = 0; i < array.length; i++) {
                result[lastIdx++] = array[i];
            }
        }
        return result;
    }
}
