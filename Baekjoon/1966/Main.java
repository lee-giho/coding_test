import java.io.*;
import java.util.*;

public class Main {

  static class Doc { // 큐에 넣을 문서 객체
    int p, idx;
    Doc(int p, int idx) {
      this.p = p; // 중요도
      this.idx = idx; // 위치
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

    for (int t = 0; t < T; t++) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      int N = Integer.parseInt(st.nextToken()); // 문서의 개수
      int M = Integer.parseInt(st.nextToken()); // 추적할 문서의 초기 인덱스

      Deque<Doc> queue = new ArrayDeque<>();
      int[] cnt = new int[10]; // 중요도 1~9 개수 카운트

      // 공백으로 구분된 중요도 입력받기
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < N; i++) {
        int p = Integer.parseInt(st.nextToken());
        queue.addLast(new Doc(p, i));
        cnt[p]++;
      }

      // 현재 큐의 최대 중요도
      int currentMaxImportance = 9;
      while (currentMaxImportance > 0 && cnt[currentMaxImportance] == 0) {
        currentMaxImportance--;
      }

      int printed = 0;
      
      while (!queue.isEmpty()) {
        Doc d = queue.pollFirst();

        // 더 높은 중요도가 큐에 존재할 때
        if (d.p < currentMaxImportance) {
          queue.addLast(d); // 맨 뒤로 보냄
        } else { // 최대 중요도면
          printed++; // 인쇄
          cnt[d.p]--;

          // 최대 중요도 갱신
          while (currentMaxImportance > 0 && cnt[currentMaxImportance] == 0) {
            currentMaxImportance--;
          }

          // 문제에서 찾는 문서라면 인쇄할 수 출력
          if (d.idx == M) {
            sb.append(printed).append("\n");
            break;
          }
        }
      }
    }

    System.out.println(sb.toString());
  }
}