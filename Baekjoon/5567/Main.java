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