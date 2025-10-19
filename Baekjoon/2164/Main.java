import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine()); // 카드의 수 입력

    // 카드를 입력받아 큐에 저장
    Deque<Integer> queue = new ArrayDeque<>(N);
    for (int i = 1; i < N + 1; i++) {
      queue.addLast(i);
    }

    // 카드가 하나 남을 때까지 반복
    while (queue.size() > 1) {
      queue.pollFirst(); // 멘 위 카드 버리기
      queue.addLast(queue.pollFirst()); // 맨 위 카드 제일 아래로 옮기기
    }

    System.out.println(queue.pollFirst());
  }
}