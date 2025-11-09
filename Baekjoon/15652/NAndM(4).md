# 📋 N과 M (4)
- Link<br>
https://www.acmicpc.net/problem/15652
- 풀이 날짜<br>
2025.11.10

## 🔎 문제 탐색하기

- 1부터 N까지 자연수 중에서 M개를 고른 수열<br>
- 한 수열 안에 같은 수 허용<br>
- 한 수열 안의 값은 오름차순

### 입력값
- 첫째 줄<br>
공백으로 구분된 자연수 N과 M (1 ≤ M ≤ N ≤ 7)<br>

### 출력값
- 첫째 줄부터 수열의 개수만큼<br>
1부터 N까지 자연수 중에서 M개를 고른 수열을 중복 없이 사전 순으로 출력<br>
수열의 값은 공백으로 구분해서 출력<br>
한 수열 안의 값은 오름차순

## 📝 코드 설계하기
1. 자연수 N과 M을 입력받는다. O(1)
2. 수열 저장할 배열을 초기화한다. O(1)
3. dfs(0, 1)을 호출해 0번째 자리수부터 최소값 1로 시작해 모든 수열을 만든다. O(N^M * M)
  - dfs 함수
    - depth == M<br>
      출력 버퍼에 수열 저장하고 종료
    - depth != M<br>
      num = start부터 N까지 반복하며 숫자를 depth 자리에 채우고 다음 자리로 이동하며 수열을 만든다.
4. 출력 버퍼에 저장된 문자열을 한 번에 출력한다. O(N^M * M)

총 시간 복잡도 = O(N^M * M)

## ✅ 정답 코드
```java
import java.io.*;
import java.util.*;

public class Main {

  static int N, M;
  static int[] arr; // 수열 저장
  static StringBuilder sb = new StringBuilder();

  // depth: 현재까지 채운 자리수 0 ~ M-1
  // start: 이번 자리에서 선택할 수 있는 최소 숫자
  static void dfs(int depth, int start) {
    // 길이 M짜리 수열을 완성한 경우
    if (depth == M) {
      for (int i = 0; i < M; i++) {
        sb.append(arr[i]).append(' ');
      }
      sb.append('\n');
      return;
    }

    // start ~ N까지 숫자를 depth 자리에 넣는다.
    for (int num = start; num < N+1; num++) {
      arr[depth] = num;
      dfs(depth+1, num); // 다음 자리 채우기
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    arr = new int[M];
    
    dfs(0, 1); // 0번째 자리부터 최소 1로 시작
    System.out.println(sb.toString());
  }
}
```