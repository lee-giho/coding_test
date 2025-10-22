import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(br.readLine()); // 자료구조의 개수

    int[] type = new int[N]; // 자료구조의 타입을 담을 배열 (0: 큐, 1: 스택)
    Deque<Integer> deque = new ArrayDeque<>();

    // 자료구조 타입 입력
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      type[i] = Integer.parseInt(st.nextToken());
    }

    // 초기 값 입력
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      int num = Integer.parseInt(st.nextToken());
      if (type[i] == 0) { // 큐일 경우에만
        deque.addLast(num); // 마지막에 값 넣기
      }
    }

    int M = Integer.parseInt(br.readLine()); // 추가로 넣을 원소의 개수
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < M; i++) {
      int num = Integer.parseInt(st.nextToken());
      deque.addFirst(num); // queuestack의 뒤쪽에 들어가는 효과
      sb.append(deque.pollLast()).append(' '); // 앞쪽 원소가 빠져 나가는 효과
    }

    System.out.println(sb.toString());
  }
}