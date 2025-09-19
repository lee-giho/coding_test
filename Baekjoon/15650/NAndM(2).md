# 📋 N과 M (2)
- Link<br>
https://www.acmicpc.net/problem/15650
- 풀이 날짜<br>
2025.09.20

## 🔎 문제 탐색하기

### 입력값
- 첫째 줄<br>
공백으로 구분된 N과 M (1 ≤ M ≤ N ≤ 8)<br>
N: 몇까지 고를 건지<br>
M: 몇 개를 고를 건지

### 출력값
- 한 줄에 하나씩 공백으로 구분된 수열<br>
#### 조건<br>
- 중복 X<br>
- 사전 순으로 증가하는 순서

## 📝 코드 설계하기
1. N과 M을 입력 받는다. O(1)
2. pick 배열을 M의 크기로 초기화한다. O(1)
3. 재귀 DFS로 조합을 생성한다. O(C(N, M)M)
4. depth == M이면 수열을 출력한다. O(M)

총 시간 복잡도 = O(C(N, M)M)

## ✅ 정답 코드
```java
import java.io.*;
import java.util.*;

public class Main {

  static int N, M;
  static int[] pick; // 선택한 조합 저장할 배열
  static StringBuilder sb = new StringBuilder();

  // depth: 현재까지 뽑은 개수
  // start: 이번에 고를 수 있는 최소 숫자
  static void dfs(int depth, int start) {
    if (depth == M) { // M개를 모두 고르면 출력
      for (int i = 0; i < M; i++) {
        sb.append(pick[i]).append(' ');
      }
      sb.append('\n');
      return;
    }

    for (int num = start; num < N+1; num++) {
      pick[depth] = num;
      dfs(depth+1, num+1);
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken()); // 몇까지 고를 건지, N 입력받기
    M = Integer.parseInt(st.nextToken()); // 몇 개를 고를 건지, M 입력받기

    pick = new int[M];
    dfs(0, 1);
    System.out.println(sb.toString());
  }
}
```