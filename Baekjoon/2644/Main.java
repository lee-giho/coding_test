import java.io.*;
import java.util.*;

public class Main {

  static int n; // 전체 사람 수 
  static int person1, person2; // 촌수를 구할 두 사람
  static int m; // 관계 개수
  static List<List<Integer>> relation; // 관계 그래프
  static boolean visited[]; // 방문 여부 배열
  static int answer = -1;

  public static void bfs(int start, int target) { // BFS
    Deque<int[]> queue = new ArrayDeque<>(); // [노드, 현재 촌수] 저장하는 큐
    queue.add(new int[]{start, 0}); // 시작값 초기화
    visited[start] = true;

    while (!queue.isEmpty()) {
      int[] current = queue.poll(); // 큐에서 값 꺼내기
      int n = current[0]; // 현재 노드
      int d = current[1]; // 현재까지 촌수

      if (n == target) { // 목표에 도달했을 경우
        answer = d;
        return;
      }

      for (int v : relation.get(n)) { // 인접 노드 확인
        if (!visited[v]) {
          visited[v] = true;
          queue.add(new int[]{v, d+1}); // 촌수 +1 하고 큐에 추가
        }
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 한 줄 단위로 입력값 입력 받음

    n = Integer.parseInt(br.readLine()); // 전체 사람 수 입력
    relation = new ArrayList<>(n+1);
    for (int i = 0; i < n+1; i++) {
      relation.add(new ArrayList<>()); // 각 정점에 리스트 생성
    }
    visited = new boolean[n+1];

    StringTokenizer st = new StringTokenizer(br.readLine()); // 공백을 기준으로 잘라주는 st 생성
    // 촌수 계산할 두 사람 입력
    person1 = Integer.parseInt(st.nextToken());
    person2 = Integer.parseInt(st.nextToken());

    m = Integer.parseInt(br.readLine()); // 관계 개수 입력

    for (int i = 0; i < m; i++) { // 관계 입력
      st = new StringTokenizer(br.readLine());
      int parent = Integer.parseInt(st.nextToken());
      int child = Integer.parseInt(st.nextToken());
      relation.get(parent).add(child);
      relation.get(child).add(parent);
    }

    bfs(person1, person2);

    System.out.println(answer);
  }
}