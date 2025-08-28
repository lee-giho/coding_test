# 📋 결혼식
- Link<br>
https://www.acmicpc.net/problem/5567
- 풀이 날짜<br>
2025.08.28

## 🔎 문제 탐색하기

### 입력값
- 첫째 줄<br>
n: 상근이의 동기의 수 (2 ≤ N ≤ 500)

- 둘째 줄<br>
m: 친구 관계 수 (1 ≤ N ≤ 10,000)

- 셋째 줄부터 m개의 줄<br>
공백으로 구분되어 친구 관계를 나타내는 두 번호<br>
a<sub>i</sub>, b<sub>i</sub> (1 ≤ a<sub>i</sub> < b<sub>i</sub> ≤ n)

### 출력값
- 상근이의 결혼식에 초대하는 동기의 수 출력

### 생각해 본 방법
이전에 풀었던 촌수 구하는 것과 비슷하게 하면 될 것 같다.<br>
촌수를 구할 때는 시작 노드와 끝 노드의 간선 개수를 구하면 됐었다.<br>
이번 결혼식 문제는 시작 노드에서부터 거리가 1 또는 2만큼 떨어진 노드의 수를 구하면 될 것 같다.

## 📝 코드 설계하기
1. 상근이의 동기의 수 n을 입력한다. O(1)
2. 친구 관계 수 m을 입력한다. O(1)
3. 친구 관계 리스트를 초기화한다. O(n)
4. 친구 관계를 입력한다. O(m)
5. BFS를 통해 거리가 1 또는 2인 노드를 탐색한다. O(n+m)
6. 결혼식에 초대하는 동기의 수를 출력한다. O(1)

총 시간 복잡도 = O(n+m)

## ✅ 정답 코드
```java
import java.io.*;
import java.util.*;

public class Main {

  static List<List<Integer>> relation; // 친구 관계 리스트
  static boolean visited[]; // 방문 여부 배열
  static int answer = 0;

  // BFS 함수 - 상근이(1번)에서 시작해 친구(거리 1)와 친구의 친구(거리 2)까지 탐색
  public static int bfs(int n) {
    Deque<Integer> queue = new ArrayDeque<>(); // BFS 탐색용 큐
    visited = new boolean[n+1]; // 방문 배열 초기화

    visited[1] = true; // 상근이 방문 처리
    queue.add(1); // 시작 노드

    int count = 0;

    // 거리 2까지만 탐색
    for (int i = 0; i < 2; i++) {
      int size = queue.size(); // 현재 레벨(같은 거리)의 노드 수
      while (size-- > 0) { 
        int u = queue.poll(); // 큐에서 현재 노드 꺼내기
        for (int v : relation.get(u)) { // 현재 노드의 모든 친구 확인
          if (!visited[v]) {
            visited[v] = true;
            count++;
            queue.add(v); // 다음 레벨(거리 +1)로 큐에 추가
          }
        }
      }
    }
    return count;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    int n = Integer.parseInt(br.readLine()); // 상근이의 동기의 수
    int m = Integer.parseInt(br.readLine()); // 친구 관계 수

    // 친구 관계 리스트 초기화
    relation = new ArrayList<>(n+1);
    for (int i = 0; i < n+1; i++) {
      relation.add(new ArrayList<>());
    }

    // 친구 관계 입력 - 무방향이므로 양쪽으로 추가
    for (int i = 0; i < m; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      relation.get(a).add(b);
      relation.get(b).add(a);
    }

    answer = bfs(n);

    System.out.println(answer);
  }
}
```