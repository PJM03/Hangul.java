# 한글 자음 모음 분리 자바 라이브러리
> 현재 기본적인 자모 분리 기능만 존재합니다. 추후 지속적인 업데이트를 통해 다시 합치는 기능 등 여러가지 기능을 추가할 예정입니다.

[e-](https://github.com/e-)님의 [Hangul.js](https://github.com/e-/Hangul.js/)와 같은 기능을 하는 라이브러리를 Java로 만들어보고자 시작했으며 비슷한 기능들을 추가 혹은 [Hangul.js](https://github.com/e-/Hangul.js/)에 있는 코드를 가져올 예정입니다.
---
## 예제
```java
import me.laum.hangul.Hangul;

public static void main(String[] args){
    String string = "안a녕1하2세3요뷁ㄺㅘ";
    //복잡한 중성, 종성은 분리하지 않음
    char[] array1 = Hangul.disassemble(string);
    System.out.println(array1);
    //result: ㅇㅏㄴaㄴㅕㅇ1ㅎㅏ2ㅅㅔ3ㅇㅛㅂㅞㄺㄺㅘ
    
    //복잡한 중성만 분리하고, 종성은 분리하지 않음    
    char[] array2 = Hangul.disassemble(string, true, false);
    System.out.println(array2);
    //result: ㅇㅏㄴaㄴㅕㅇ1ㅎㅏ2ㅅㅔ3ㅇㅛㅂㅜㅔㄺㄺㅗㅏ
    
    //복잡한 중성은 분리하지 않고, 종성만 분리함
    char[] array3 = Hangul.disassemble(string, false, true);
    System.out.println(array3);
    //result: ㅇㅏㄴaㄴㅕㅇ1ㅎㅏ2ㅅㅔ3ㅇㅛㅂㅞㄹㄱㄹㄱㅘ

    //복잡한 중성, 종성 모두 분리함
    char[] array4 = Hangul.disassemble(string, true, true);
    System.out.println(array4);
    //result: ㅇㅏㄴaㄴㅕㅇ1ㅎㅏ2ㅅㅔ3ㅇㅛㅂㅜㅔㄹㄱㄹㄱㅗㅏ
}
```
---
## 라이선스
#### MIT LICENSE
```text
Copyright (c) 2023 Jungmin Park

Permission is hereby granted, free of charge, to any person
obtaining a copy of this software and associated documentation
files (the "Software"), to deal in the Software without
restriction, including without limitation the rights to use,
copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the
Software is furnished to do so, subject to the following
conditions:

The above copyright notice and this permission notice shall be
included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
OTHER DEALINGS IN THE SOFTWARE.
```