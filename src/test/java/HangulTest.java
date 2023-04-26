import me.laum.hangul.Hangul;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.StringJoiner;

public class HangulTest {
    @Test
    void 기본_자모분리_테스트() {
        char[] a = Hangul.disassemble("안a녕1하2세3요뷁ㄺㅘ");
        Assertions.assertEquals(joinChars(a), "ㅇㅏㄴaㄴㅕㅇ1ㅎㅏ2ㅅㅔ3ㅇㅛㅂㅞㄺㄺㅘ");
        char[] b = Hangul.disassemble("안a녕1하2세3요뷁ㄺㅘ", true, false);
        Assertions.assertEquals(joinChars(b), "ㅇㅏㄴaㄴㅕㅇ1ㅎㅏ2ㅅㅔ3ㅇㅛㅂㅜㅔㄺㄺㅗㅏ");
        char[] c = Hangul.disassemble("안a녕1하2세3요뷁ㄺㅘ", false, true);
        Assertions.assertEquals(joinChars(c), "ㅇㅏㄴaㄴㅕㅇ1ㅎㅏ2ㅅㅔ3ㅇㅛㅂㅞㄹㄱㄹㄱㅘ");
        char[] d = Hangul.disassemble("안a녕1하2세3요뷁ㄺㅘ", true, true);
        Assertions.assertEquals(joinChars(d), "ㅇㅏㄴaㄴㅕㅇ1ㅎㅏ2ㅅㅔ3ㅇㅛㅂㅜㅔㄹㄱㄹㄱㅗㅏ");
    }

    String joinChars(char[] chars) {
        StringJoiner joiner = new StringJoiner("");
        for (char c : chars) joiner.add(String.valueOf(c));
        return joiner.toString();
    }
}
