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