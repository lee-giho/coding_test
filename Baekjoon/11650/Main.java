import java.io.*;
import java.util.*;

public class Main {

  static class Dot { // 점 위치를 담는 객체
    int x, y;
    Dot(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(br.readLine()); // 점의 개수
    Dot[] dots = new Dot[N]; // 점 담는 배열

    // 점에 좌표 입력
    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      dots[i] = new Dot(x, y);
    }

    // x, y 순서로 오름차순 정렬
    Arrays.sort(dots, (a, b) -> {
      if (a.x != b.x) return a.x - b.x;
      return a.y - b.y;
    });

    // 출력
    for (Dot d : dots) {
      sb.append(d.x).append(" ").append(d.y).append("\n");
    }
    System.out.println(sb.toString());
  }
}