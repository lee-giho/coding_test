import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(br.readLine()); // 명령의 개수 N 입력받기

    int[] stack = new int[N]; // 스택을 구현할 배열
    int top = -1; // 스택의 맨 위 인덱스

    // N개의 명령 처리
    for (int i = 0; i < N; i++) {
      String command = br.readLine(); // 한 줄의 명령 입력받기

      if (command.startsWith("push")) {
        // push: number 값을 추출해 스택에 저장
        int number = Integer.parseInt(command.substring(5));
        stack[++top] = number; // top을 +1하고 값 저장
      } else if (command.equals("pop")) {
        // pop: 스택이 비어 있으면 -1, 아니면 top에 해당하는 값 출력
        if (top == -1) {
          sb.append(-1).append("\n");
        } else {
          sb.append(stack[top--]).append("\n"); // top에 대항다는 값 출력 및 top -1
        }
      } else if (command.equals("size")) {
        // size: 현재 스택 크기(top+1)
        sb.append(top+1).append("\n");
      } else if (command.equals("empty")) {
        // empty: 비어 있으면 1, 아니면 0
        sb.append(top == -1 ? 1 : 0).append("\n");
      } else if (command.equals("top")) {
        // top: 비어 있으면 -1, 아니면 stack[top]
        if (top == -1) {
          sb.append(-1).append("\n");
        } else {
          sb.append(stack[top]).append("\n");
        }
      }
    }

    System.out.println(sb.toString());
  }
}