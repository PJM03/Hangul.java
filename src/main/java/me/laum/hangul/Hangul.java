package me.laum.hangul;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Hangul {
    private static final char[] EMPTY_ARR = new char[] {};
    private static final char[] CHO = {'ㄱ', 'ㄲ', 'ㄴ', 'ㄷ', 'ㄸ', 'ㄹ', 'ㅁ', 'ㅂ', 'ㅃ', 'ㅅ', 'ㅆ', 'ㅇ' , 'ㅈ', 'ㅉ', 'ㅊ', 'ㅋ', 'ㅌ', 'ㅍ', 'ㅎ'};
    private static final char[] JUNG = {'ㅏ', 'ㅐ', 'ㅑ', 'ㅒ', 'ㅓ', 'ㅔ', 'ㅕ', 'ㅖ', 'ㅗ', 'ㅘ', 'ㅙ', 'ㅚ', 'ㅛ', 'ㅜ', 'ㅝ', 'ㅞ', 'ㅟ', 'ㅠ', 'ㅡ', 'ㅢ', 'ㅣ'};
    private static final Map<Character, char[]> JUNG_MAP = Collections.unmodifiableMap(new HashMap<>() {{
        put('ㅘ', new char[] {'ㅗ', 'ㅏ'});
        put('ㅙ', new char[] {'ㅗ', 'ㅐ'});
        put('ㅚ', new char[] {'ㅗ', 'ㅣ'});
        put('ㅝ', new char[] {'ㅜ', 'ㅓ'});
        put('ㅞ', new char[] {'ㅜ', 'ㅔ'});
        put('ㅟ', new char[] {'ㅜ', 'ㅣ'});
        put('ㅢ', new char[] {'ㅡ', 'ㅣ'});
    }});
    private static final char[] JONG = {0, 'ㄱ', 'ㄲ', 'ㄳ', 'ㄴ', 'ㄵ', 'ㄶ', 'ㄷ', 'ㄹ', 'ㄺ', 'ㄻ', 'ㄼ', 'ㄽ', 'ㄾ', 'ㄿ', 'ㅀ', 'ㅁ', 'ㅂ', 'ㅄ', 'ㅅ', 'ㅆ', 'ㅇ', 'ㅈ', 'ㅊ', 'ㅋ', 'ㅌ', 'ㅍ', 'ㅎ'};
    private static final Map<Character, char[]> JONG_MAP = Collections.unmodifiableMap(new HashMap<>() {{
        put('ㄳ', new char[] {'ㄱ', 'ㅅ'});
        put('ㄵ', new char[] {'ㄴ', 'ㅈ'});
        put('ㄶ', new char[] {'ㄴ', 'ㅎ'});
        put('ㄺ', new char[] {'ㄹ', 'ㄱ'});
        put('ㄻ', new char[] {'ㄹ', 'ㅁ'});
        put('ㄼ', new char[] {'ㄹ', 'ㅂ'});
        put('ㄽ', new char[] {'ㄹ', 'ㅅ'});
        put('ㄾ', new char[] {'ㄹ', 'ㅌ'});
        put('ㅀ', new char[] {'ㄹ', 'ㅎ'});
        put('ㅄ', new char[] {'ㅂ', 'ㅅ'});
    }});

    public static char[] disassemble(String string) {
        char[] result = new char[0];
        for (char c : string.toCharArray()) {
            char[] charArray = disassembleChar(c, false, false);
            result = HJUtil.mergeCharArray(result, charArray);
        }
        return result;
    }

    public static char[] disassemble(String string, boolean jungDisassemble, boolean jongDisassemble) {
        char[] result = new char[0];
        for (char c : string.toCharArray()) {
            char[] charArray = disassembleChar(c, jungDisassemble, jongDisassemble);
            result = HJUtil.mergeCharArray(result, charArray);
        }
        return result;
    }



    public static char[] disassembleChar(char c, boolean jungDisassemble, boolean jongDisassemble) {
        int checkResult = hangulCheck(c);
        if (checkResult != -1) {
            if (JUNG_MAP.containsKey(c)) {
                if (jungDisassemble) return getArray(JUNG_MAP, c);
                else return new char[] {c};
            }
            if (JONG_MAP.containsKey(c)) {
                if (jongDisassemble) return getArray(JONG_MAP, c);
                else return new char[] {c};
            }
            if (checkResult >= 1) return new char[] {c};
            int ch = c - 0xAC00;
            char cho = CHO[ch / 28 / 21];
            char jung = JUNG[ch / 28 % 21];
            char jong = JONG[ch % 28];

            char[] jungs = jungDisassemble ? getArray(JUNG_MAP, jung, new char[]{jung}) : new char[]{jung};
            char[] jongs = jong == 0 ? EMPTY_ARR : (jongDisassemble ? getArray(JONG_MAP, jong, new char[]{jong}) : new char[]{jong});

            return HJUtil.mergeCharArray(new char[]{cho}, jungs, jongs);
        } else return new char[]{c};
    }

    private static char[] getArray(Map<Character, char[]> map, char key) {
        return getArray(map, key, EMPTY_ARR);
    }

    private static char[] getArray(Map<Character, char[]> map, char key, char[] def) {
        char[] arr = map.getOrDefault(key, def);
        return Arrays.copyOf(arr, arr.length);
    }

    private static int hangulCheck(char c) {
        if (c >= '가' && c <= '힣') return 0;
        else if (c >= 'ㄱ' && c <= 'ㅎ') return 1;
        else if (c >= 'ㅏ' && c <= 'ㅣ') return 2;
        else return -1;
    }
}

