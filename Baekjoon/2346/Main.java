import java.io.*;
import java.util.*;

public class Main {

  static class Balloon {
    int index; // 풍선의 번호
    int value; // 종이에 적힌 값

    Balloon(int index, int value) {
      this.index = index;
      this.value = value;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(br.readLine()); // 풍선의 개수 입력
    StringTokenizer st = new StringTokenizer(br.readLine());

    // 덱에 풍선의 번호와 종이에 적힌 값 입력
    ArrayDeque<Balloon> deque = new ArrayDeque<>();
    for (int i = 1; i < N + 1; i++) {
      int value = Integer.parseInt(st.nextToken());
      deque.addLast(new Balloon(i, value));
    }

    // 덱에 값이 없을 때까지 반복
    while (!deque.isEmpty()) {
      // 맨 앞 풍선 터뜨리고 번호 출력
      Balloon currentBalloon = deque.pollFirst();
      sb.append(currentBalloon.index).append(" ");

      if (deque.isEmpty()) {
        break;
      }

      // 현재 풍선의 값에 따라 덱 회전
      int next = currentBalloon.value;
      if (next > 0) { // 양수, 오른쪽으로 next-1 회전
        for (int i = 0; i < next - 1; i++) {
          deque.addLast(deque.pollFirst());
        }
      } else { // 음수, 왼쪽으로 -next 회전
        for (int i = 0; i < -next; i++) {
          deque.addFirst(deque.pollLast());
        }
      }
    }

    System.out.println(sb.toString());
  }
}