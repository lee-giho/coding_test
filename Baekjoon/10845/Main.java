import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(br.readLine()); // 명령의 개수 N 입력받기

    int[] queue = new int[N]; // 큐를 구현할 배열
    int front = 0; // 큐의 맨 앞 인덱스
    int back = -1; // 큐의 맨 뒤 인덱스

    // N개의 명령 처리
    for (int i = 0; i < N; i++) {
      String command = br.readLine(); // 한 줄의 명령 입력받기

      if (command.startsWith("push")) {
        // push x: x를 꺼내 큐의 맨 뒤에 삽입
        int x = Integer.parseInt(command.substring(5));
        queue[++back] = x;
      } else if (command.equals("pop")) {
        // pop: 큐가 비어 있으면 -1 아니면 front 값을 꺼내고 front +1
        if (back < front) {
          sb.append(-1).append("\n");
        } else {
          sb.append(queue[front++]).append("\n");
        }
      } else if (command.equals("size")) {
        // size: 현재 큐의 크기, back-front+1 또는 0
        sb.append((back < front) ? 0 : (back-front)+1).append("\n");
      } else if (command.equals("empty")) {
        // empty: 큐가 비어있으면 1, 아니면 0
        sb.append(back < front ? 1 : 0).append("\n");
      } else if (command.equals("front")) {
        // front: 큐의 맨 앞 값 출력, 비어있으면 -1 출력
        if (back < front) {
          sb.append(-1).append("\n");
        } else {
          sb.append(queue[front]).append("\n");
        }
      } else if (command.equals("back")) {
        // back: 큐의 맨 뒤 값 출력, 비어 있으면 -1 출력
        if (back < front) {
          sb.append(-1).append("\n");
        } else {
          sb.append(queue[back]).append("\n");
        }
      }
    }

    System.out.println(sb.toString());
  }
}