# 📋 소트인사이드
- Link<br>
https://www.acmicpc.net/problem/1427
- 풀이 날짜<br>
2025.09.29

## 🔎 문제 탐색하기

### 입력값
- 첫째 줄<br>
N: 자연수 (1 ≤ N ≤ 1,000,000,000)<br>

### 출력값
- 자리수를 내림차순으로 정렬한 수 출력<br>

## 📝 코드 설계하기
(d = 자릿수, 최대 10)
1. 자연수 N을 문자열로 입력받는다. O(1)
2. 문자열을 문자 배열로 변환한다. O(d)
3. 배열을 오름차순 정렬한다. O(d log d)
4. 배열을 뒤집어서 출력 버퍼에 추가한다. O(d)
5. 버퍼에 있는 문자열을 한 번에 출력한다. O(1)

총 시간 복잡도 = O(d log d)

## ✅ 정답 코드
```java
import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String N = br.readLine(); // 숫자를 문자열로 입력
    char[] digits = N.toCharArray(); // 각 자릿수를 문자 배열로 변환

    Arrays.sort(digits); // 오름차순 정렬

    StringBuilder sb = new StringBuilder(new String(digits));
    System.out.println(sb.reverse().toString()); // 내림차순으로 출력
  }
}
```