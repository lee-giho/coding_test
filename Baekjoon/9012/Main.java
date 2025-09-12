import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수 입력

    for (int i = 0; i < T; i++) {
      String line = br.readLine(); // 괄호 문자열 입력
      int balance = 0; // 괄호 개수  '()'는 +1, ')'는 -1
      boolean check = true; // 올바른 괄호 문자열인지

      // 문자열의 각 문자 확인
      for (int j = 0; j < line.length(); j++) {
        char c = line.charAt(j);
        
        if (c == '(') {
          balance++;
        } else {
          balance--;
        }

        if (balance < 0) { // 닫는 괄호가 먼저 나오면 확인할 필요 없이 break
          check = false;
          break;
        }
      }

      // 끝까지 확인한 후 열고 닫는 괄호의 개수가 같으면(balance == 0) YES 아니면 NO
      if (check && balance == 0) {
        sb.append("YES\n");
      } else {
        sb.append("NO\n");
      }
    }

    System.out.println(sb.toString());
  }
}