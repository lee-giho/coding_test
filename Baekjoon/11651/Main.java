import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(br.readLine()); // 점의 개수 입력

    // 점들을 저장할 배열 선언 및 입력
    int[][] dots = new int[N][2];
    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      dots[i][0] = Integer.parseInt(st.nextToken());
      dots[i][1] = Integer.parseInt(st.nextToken());
    }

    // 배열 정렬: y좌표 오름차순, y좌표가 같다면 x좌표 오름차순
    Arrays.sort(dots, (a, b) -> {
      if (a[1] != b[1]) return Integer.compare(a[1], b[1]);
      return Integer.compare(a[0], b[0]);
    });

    // 정렬된 결과 출력 문자열에 저장
    for (int i = 0; i < N; i++) {
      sb.append(dots[i][0]).append(' ').append(dots[i][1]).append('\n');
    }
    
    System.out.println(sb.toString());
  }
}