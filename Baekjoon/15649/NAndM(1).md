# 📋 N과 M (1)
- Link<br>
https://www.acmicpc.net/problem/15649
- 풀이 날짜<br>
2025.11.08

## 🔎 문제 탐색하기

1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열

### 입력값
- 첫째 줄<br>
공백으로 구분된 자연수 N과 M (1 ≤ M ≤ N ≤ 8)<br>

### 출력값
- 첫째 줄부터 수열의 개수만큼<br>
1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열을 사전 순으로 출력<br>
수열의 값은 공백으로 구분해서 출력

## 📝 코드 설계하기
1. 자연수 N과 M을 입력받는다. O(1)
2. 수열 저장할 배열과 방문 여부 확인할 배열을 초기화한다. O(1)
4. dfs(0)을 호출해 0번째 자리수부터 모든 수열을 만든다. O(P(N, M))
  - dfs 함수
    - depth == M<br>
      출력 버퍼에 수열 저장하고 종료
    - depth != M<br>
      num = 1부터 N까지 반복하며 방문하지 않은 숫자에 대해 방문 표시를 하고 다음 자리로 이동하며 수열을 만든다.
5. 출력 버퍼에 저장된 문자열을 한 번에 출력한다. O(출력 길이)

총 시간 복잡도 = O(P(N, M) * M)

## ✅ 정답 코드
```java
import java.io.*;
import java.util.*;

public class Main {
  
  static int N, M;
  static int[] selected; // 수열 저장
  static boolean[] visited; // 방문 여부
  static StringBuilder sb = new StringBuilder();

  // depth: 현재까지 채운 자리수 0 ~ M
  static void dfs(int depth) {
    // M까지 자리를 다 채웠으면 출력 후 종료
    if (depth == M) {
      for (int i = 0; i < M; i++) {
        sb.append(selected[i]).append(' ');
      }
      sb.append("\n");
      return;
    }

    // 1부터 N까지 숫자 중 하나 선택
    for (int num = 1; num < N+1; num++) {
      if (!visited[num]) {
        visited[num] = true; // 방문 표시
        selected[depth] = num; // 현재 자리에 배치
        dfs(depth + 1); // 다음 자리로 이동
        visited[num] = false; // 다시 되돌리기
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    selected = new int[M];
    visited = new boolean[N + 1];

    dfs(0); // 0번째 자리부터 시작

    System.out.println(sb.toString());

  }
}
```