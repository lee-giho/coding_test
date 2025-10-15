import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    while (true) {
      String line = br.readLine();
      if (line.equals(".")) { // 온점 하나가 나오면 입력 종료
        break;
      }

      Stack<Character> stack = new Stack<>();
      boolean balanced = true;

      for (char c : line.toCharArray()) {
        if (c == '(' || c == '[') { // 여는 괄호는 스택에 삽입
          stack.push(c);
        } else if (c == ')') { // 닫는 괄호일 때 여는 괄호가 짝을 이루는지 확인
          if (stack.isEmpty() || stack.peek() != '(') {
            balanced = false;
            break;
          }
          stack.pop();
        } else if (c == ']') { // 닫는 괄호일 때 여는 괄호가 짝을 이루는지 확인
          if (stack.isEmpty() || stack.peek() != '[') {
            balanced = false;
            break;
          }
          stack.pop();
        }
      }

      // balanced 값이 참이고 스택이 비어 있으면 균형잡힌 문자열("yes")
      if (balanced && stack.isEmpty()) {
        sb.append("yes\n");
      } else {
        sb.append("no\n");
      }
    }

    System.out.println(sb.toString());
  }
}