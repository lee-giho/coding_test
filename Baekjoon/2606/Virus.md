# 📋 바이러스
- Link<br>
https://www.acmicpc.net/problem/2606
- 풀이 날짜<br>
2025.09.16

## 🔎 문제 탐색하기

### 입력값
- 첫째 줄<br>
N: 컴퓨터의 수 (N ≤ 100)<br>

- 둘째 줄<br>
M: 연결되어 있는 컴퓨터 쌍의 수

- 셋째 줄부터 M개의 줄<br>
공백으로 구분된 두개의 컴퓨터 번호<br>
c1 c2

### 출력값
- 1번을 통해 감염된 컴퓨터의 수 출력

## 📝 코드 설계하기
1. 컴퓨터의 수 N과 연결되어 있는 컴퓨터 쌍의 수 M을 입력받는다. O(1)
2. 그래프 생성 및 초기화한다. O(N+M)
3. 방문 배열을 초기화한다. O(N)
4. DFS를 통해 감염된 컴퓨터를 찾는다. O(N+M)
5. 1번을 통해 감염된 컴퓨터의 수를 출력한다. O(1)

총 시간 복잡도 = O(N+M)

## ✅ 정답 코드
```java
import java.io.*;
import java.util.*;

public class Main {
  
  static List<Integer>[] graph; // 인접리스트로 그래프 표현
  static boolean[] visited; // 컴퓨터 방문 여부 확인
  static int infectedCount = 0;  // 1번을 통해 감염된 컴퓨터의 수

  // DFS 탐색 함수
  static void dfs(int u) {
    visited[u] = true; // 현재 컴퓨터 방문 처리
    for (int v : graph[u]) { // 현재 컴퓨터와 연결된 모든 컴퓨터 탐색
      if (!visited[v]) { // 감염되지 않은 컴퓨터라면
        infectedCount++;
        dfs(v);
      }
    }
  }
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine()); // 컴퓨터 수 (정점 개수)
    int M = Integer.parseInt(br.readLine()); // 연결 수 (간선 개수)

    // 그래프 초기화
    graph = new ArrayList[N+1];
    for (int i = 0; i < N+1; i++) {
      graph[i] = new ArrayList<>();
    }

    // 연결 관계 입력 (무방향)
    for (int i = 0; i < M; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int c1 = Integer.parseInt(st.nextToken());
      int c2 = Integer.parseInt(st.nextToken());
      graph[c1].add(c2);
      graph[c2].add(c1);
    }

    visited = new boolean[N+1]; // 방문 배열 초기화

    dfs(1); // 1번 컴퓨터부터 시작

    System.out.println(infectedCount);
  }
}
```