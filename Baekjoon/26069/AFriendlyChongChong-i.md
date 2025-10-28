# 📋 붙임성 좋은 총총이
- Link<br>
https://www.acmicpc.net/problem/26069
- 풀이 날짜<br>
2025.10.29

## 🔎 문제 탐색하기

- HashSet을 통해 춤추고 있는 사람을 만나는 경우에 두 사람 모두 추가한다.
- 마지막에 HashSet의 크기가 춤추고 있는 사람의 수가 된다.

### 입력값
- 첫째 줄<br>
N: 사람들이 만난 기록의 수 (1 ≤ N ≤ 1,000)

- 둘째 줄부터 N개의 줄<br>
공백으로 구분된 사람들의 이름 A B (1 ≤ 이름 ≤ 20)<br>
  - 사람들의 이름
    - 숫자와 영문 대소문자
    - 대소문자 구분

### 출력값
- 마지막 기록 이후 무지개 댄스를 추는 사람의 수 출력

## 📝 코드 설계하기
1. 사람들이 만난 기록의 수 N을 입력받는다. O(1)
2. 춤추는 사람들을 저장할 HashSet을 생성하고 "ChongChong"을 저장한다. O(1)
3. N번 반복하며 문자열을 읽고 아래의 과정을 처리한다. O(N)
    - A와 B 중 하나라도 HashSet에 있다면 모두 추가한다.
4. 무지개 댄스를 추는 사람의 수를 출력한다. O(1)

총 시간 복잡도 = O(N)

## ✅ 정답 코드
```java
import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine()); // 사람들이 만난 기록의 수 입력

    Set<String> dancers = new HashSet<>();
    dancers.add("ChongChong"); // 총총이는 처음부터 춤추는 상태

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      String A = st.nextToken();
      String B = st.nextToken();

      if (dancers.contains(A) || dancers.contains(B)) { // 한 사람이라도 춤을 추고 있다면 모두 추가
        dancers.add(A);
        dancers.add(B);
      }
    }

    System.out.println(dancers.size());
  }
}
```