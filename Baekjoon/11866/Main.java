import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    Deque<Integer> queue = new ArrayDeque<>();
    for (int i = 1; i < N+1; i++) {
      queue.add(i);
    }

    StringBuilder sb = new StringBuilder();
    sb.append("<");

    while(!queue.isEmpty()) {
      for (int i = 0; i < K-1; i++) {
        queue.add(queue.poll());
      }
      int num = queue.poll();
      sb.append(num);
      if (!queue.isEmpty()) {
        sb.append(", ");
      }
    }

    sb.append(">");
    System.out.println(sb);
  }
}