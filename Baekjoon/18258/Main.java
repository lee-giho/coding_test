import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(br.readLine()); // 명령 개수 입력
    Deque<Integer> queue = new ArrayDeque<>(); // 큐

    // 명령을 입력받고 수행
    for (int i = 0; i < N; i++) {
      String command = br.readLine();

      if (command.startsWith("push")) {
        int value = Integer.parseInt(command.split(" ")[1]);
        queue.addLast(value);
      } else if (command.equals("pop")) {
        sb.append(queue.isEmpty() ? -1 : queue.pollFirst()).append("\n");
      } else if (command.equals("size")) {
        sb.append(queue.size()).append("\n");
      } else if (command.equals("empty")) {
        sb.append(queue.isEmpty() ? 1 : 0).append("\n");
      } else if (command.equals("front")) {
        sb.append(queue.isEmpty() ? -1 : queue.peekFirst()).append("\n");
      } else if (command.equals("back")) {
        sb.append(queue.isEmpty() ? -1 : queue.peekLast()).append("\n");
      }
    }

    System.out.println(sb);
  }
}