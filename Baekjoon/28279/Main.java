import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(br.readLine()); // 명령의 개수
    ArrayDeque<Integer> deque = new ArrayDeque<>(); // 덱 자료구조

    for (int i = 0; i < N; i++) {
      String line = br.readLine();

      char command = line.charAt(0); // 명령

      switch (command) {
        case '1': { // 덱의 앞에 정수 넣기
          int X = Integer.parseInt(line.substring(2)); // 입력할 정수
          deque.addFirst(X);
          break;
        }
        case '2': { // 덱의 뒤에 정수 넣기
          int X = Integer.parseInt(line.substring(2)); // 입력할 정수
          deque.addLast(X);
          break;
        }
        case '3': { // 덱에 정수가 있다면 맨 앞의 정수를 빼고 출력, 없으면 -1
          sb.append(deque.isEmpty() ? -1 : deque.pollFirst()).append("\n");
          break;
        }
        case '4': { // 덱에 정수가 있다면 맨 뒤의 정수를 빼고 출력, 없으면 -1
          sb.append(deque.isEmpty() ? -1 : deque.pollLast()).append("\n");
          break;
        }
        case '5': { // 덱에 들어있는 정수의 개수 출력
          sb.append(deque.size()).append("\n");
          break;
        }
        case '6': { // 덱이 비어있으면 1, 아니면 0
          sb.append(deque.isEmpty() ? 1 : 0).append("\n");
          break;
        }
        case '7': { // 덱에 정수가 있다면 맨 앞의 정수 출력, 없으면 -1
          sb.append(deque.isEmpty() ? -1 : deque.peekFirst()).append("\n");
          break;
        }
        case '8': { // 덱에 정수가 있다면 맨 뒤의 정수 출력, 없으면 -1
          sb.append(deque.isEmpty() ? -1 : deque.peekLast()).append("\n");
          break;
        }
      }
    }

    System.out.println(sb.toString());
  }
}