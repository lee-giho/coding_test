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