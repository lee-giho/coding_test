# 📋 수 찾기
- Link<br>
https://www.acmicpc.net/problem/1920
- 풀이 날짜<br>
2025.09.09

## 🔎 문제 탐색하기

### 입력값
- 첫째 줄<br>
N: HashSet A에 들어갈 정수의 수 (1 ≤ N ≤ 100,000)
- 둘째 줄<br>
공백으로 구분된 HashSet A의 정수 원소 N개
- 셋째 줄<br>
M: 찾을 정수의 수 (1 ≤ M ≤ 100,000)
- 넷째 줄<br>
공백으로 구분된 찾을 정수 M개

### 출력값
- M개의 줄
각 숫자에 대해 존재하면 1, 아니면 0 출력

## 📝 코드 설계하기
1. HashSet A에 들어갈 정수의 수 N 입력받는다. O(1)
2. HashSet A에 정수 삽입한다. O(N)
3. 찾을 정수의 수 M 입력받는다. O(1)
4. M번 반복하며 HashSet A에 정수가 있는지 확인한다. O(M)
5. StringBuilder에 저장된 문자열 출력한다. O(M)

총 시간 복잡도 = O(N+M)

## ✅ 정답 코드
```java
import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(br.readLine()); // HashSet에 저장할 정수의 수 N 입력받기

    // 정수 N개를 입력받아 HashSet A에 저장
    StringTokenizer st = new StringTokenizer(br.readLine());
    HashSet<Integer> A = new HashSet<>();
    for (int i = 0; i < N; i++) {
      int num = Integer.parseInt(st.nextToken());
      A.add(num);
    }

    int M = Integer.parseInt(br.readLine()); // 찾을 정수의 수 M 입력받기

    // M개의 정수가 A에 존재하는지 확인
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < M; i++) {
      int n = Integer.parseInt(st.nextToken());
      if (A.contains(n)) {
        sb.append(1).append("\n"); // 존재하면 1
      } else {
        sb.append(0).append("\n"); // 존재하지 않으면 0
      }
    }

    System.out.println(sb.toString());
  }
}
```