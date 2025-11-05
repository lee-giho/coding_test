# 📋 칸토어 집합
- Link<br>
https://www.acmicpc.net/problem/4779
- 풀이 날짜<br>
2025.11.05

## 🔎 문제 탐색하기

### 입력값
- null이 나올 때까지<br>
N: 전체 길이를 나타내는 값의 지수인 정수 (0 ≤ N ≤ 12)<br>

### 출력값
줄바꿈을 통해 각 N에 대해 해당하는 칸토어 집합의 근사 출력

## 📝 코드 설계하기
(T = 입력 줄 수)
1. 정수 N을 null이 나올 때까지 입력받으며 아래를 반복한다. O(T)<br>
    1. 3<sup>N</sup>으로 전체 길이를 계산하고 배열에 "-"을 채운다. O(3<sup>N</sup>)
    2. 규칙에 맞게 문자열을 나누는 함수를 재귀로 호출한다. O(3<sup>N</sup>)
        - 길이가 1이면 더 나눌 수 없으므로 종료
        - 가운데 구간을 공백으로 바꾼다.
        - 왼쪽과 오른쪽 구간을 다시 재귀로 함수를 호출해 처리한다.
    3. 출력 버퍼에 규칙이 적용된 문자열을 저장한다. O(3<sup>N</sup>)
2. 출력 버퍼에 저장된 문자열을 한 번에 출력한다. O(1)

총 시간 복잡도 = O(3<sup>N</sup>)

## ✅ 정답 코드
```java
import java.io.*;
import java.util.*;

public class Main {

  static char[] arr;

  // 규칙에 맞게 문자열을 나누는 재귀 함수
  static void cantor(int start, int len) {
    if (len == 1) return; // 길이가 1이면 나눌 수 없으므로 종료

    int third = len / 3; // 3등분한 길이

    // 가운데 구간 공백 처리
    int midStart = start + third;
    int midEnd = start + third * 2;
    for (int i = midStart; i < midEnd; i++) {
      arr[i] = ' ';
    }

    cantor(start, third); // 왼쪽 구간
    cantor(start + third * 2, third); // 오른쪽 구간
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    String line;
    
    while((line = br.readLine()) != null && !line.isEmpty()) { // null이 나올 때까지 line을 받으며 반복
      int N = Integer.parseInt(line.trim());
      int len = (int) Math.pow(3, N); // 전체 길이

      arr = new char[len];
      Arrays.fill(arr, '-'); // 처음 상태는 전부 "-"

      cantor(0, len); // 전체 구간을 시작으로 재귀 함수를 통해 규칙 적용

      sb.append(arr).append("\n");
    }

    System.out.println(sb.toString());
  }
}
```