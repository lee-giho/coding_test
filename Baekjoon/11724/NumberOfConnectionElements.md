# 📋 죽음의 게임
- Link<br>
https://www.acmicpc.net/problem/11724
- 풀이 날짜<br>
2025.08.25

## 🔎 문제 탐색하기

### 입력값
- 첫째 줄<br>
공백으로 구분된 N과 M<br>
N: 정점의 개수 (1 ≤ N ≤ 1,000)<br>
M: 간선의 개수 (0 ≤ M ≤ N(N-1)/2)

- 둘째 줄부터 M개의 줄<br>
공백으로 구분된 u와 v (u != v)<br>
같은 간선은 한 번만 주어짐<br>
u: 간선의 끝점 (1 ≤ u)<br>
v: 간선의 끝점 (v ≤ N)

### 출력값
- 연결 요소의 개수 출력

### 생각해 본 방법
리스트에 정점과 그와 연결된 정점을 저장한다.<br>
DFS를 통해 스택으로 해당 리스트에 있는 정점에 방문하며 방문함을 표시한다.<br>
더 이상 방문한 곳이 없으면 다음 정점으로 이동하며 방문하지 않은 곳이 있는지 확인한다.

## 📝 코드 설계하기
1. 공백으로 구분된 정점의 개수 N과 간선의 개수 M을 저장한다. O(1)
2. 그래프 저장할 리스트를 초기화한다. O(N)
3. 간선 입력을 처리한다. O(M)
4. 정점을 하나씩 확인하며 연결된 정점을 확인한다. O(N+M)
5. 연결 요소의 개수를 출력한다. O(1)

총 시간 복잡도 = O(n+M)

## ✅ 정답 코드
```java
import java.io.*;
import java.util.*;

public class Main {

  static int N, M; // N: 정점 개수, M: 간선 개수
  static boolean visited[]; // 방문 여부 체크 배열
  static List<List<Integer>> graph; // 그래프를 저장할 인접 리스트

  public static void dfs(int node) { // DFS
    Deque<Integer> stack = new ArrayDeque<>(); // 스택 자료구조 사용
    stack.push(node); // 노드를 스택에 넣기
    visited[node] = true; // 노드 방문 처리

    while (!stack.isEmpty()) { // 스택이 빌 때까지 반복
      int n = stack.pop(); // 현재 노드 가져오기
      for (int v : graph.get(n)) { // 현재 노드와 연결된 노드 확인
        if (!visited[v]) {
          visited[v] = true; // 노드 방문 처리
          stack.push(v); // 스택에 추가해 계속해서 탐색
        }
      }
    }
  }
  
  public static void main(String[] args) throws IOException {

    int count = 0; // 연결 요소의 개수

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 한 줄 단위로 입력값 입력 받음
    StringTokenizer st = new StringTokenizer(br.readLine()); // 공백을 기준으로 잘라주는 st 생성

    N = Integer.parseInt(st.nextToken()); // 정점의 개수
    M = Integer.parseInt(st.nextToken()); // 간선의 개수

    // 그래프 초기화
    graph = new ArrayList<>(N+1);
    for (int i = 0; i < N+1; i++) {
      graph.add(new ArrayList<>()); // 각 정점에 리스트 생성
    }
    visited = new boolean[N+1];

    // 간선 입력 받기
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int n1 = Integer.parseInt(st.nextToken()); // 간선의 한쪽 정점
      int n2 = Integer.parseInt(st.nextToken()); // 간선의 다른쪽 정점
      graph.get(n1).add(n2); // n1 -> n2 연결
      graph.get(n2).add(n1); // n2 -> n1 연결
    }

    for (int i = 1; i < N+1; i++) {
      if (!visited[i]) {
        dfs(i); // 정점과 연결된 모든 노드 확인
        count++;
      }
    }

    System.out.println(count);
  }
}
```