import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(br.readLine()); // 명령의 수 입력
    int[] stack = new int[N]; // 스택으로 사용할 배열
    int top = 0; // 스택의 원소 개수

    for (int i = 0; i < N; i++) {
      String line = br.readLine();
      char command = line.charAt(0); // 명령

      switch (command) {
        case '1': // push
          int num = Integer.parseInt(line.substring(2)); // 삽입할 정수
          stack[top++] = num;
          break;
        case '2': // pop
          if (top == 0) {
            sb.append(-1).append("\n");
          } else {
            sb.append(stack[--top]).append("\n");
          }
          break;
        case '3': // size
          sb.append(top).append("\n");
          break;
        case '4': // empty
          sb.append(top == 0 ? 1 : 0).append("\n");
          break;
        case '5': // top
          if (top == 0) {
            sb.append(-1).append("\n");
          } else {
            sb.append(stack[top - 1]).append("\n");
          }
          break;
      }
    }

    System.out.println(sb.toString());
  }
}