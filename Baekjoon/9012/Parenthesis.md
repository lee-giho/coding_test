# 📋 괄호
- Link<br>
https://www.acmicpc.net/problem/9012
- 풀이 날짜<br>
2025.09.12

## 🔎 문제 탐색하기

### 입력값
- 첫째 줄<br>
T: 테스트 데이터 개수 (1 ≤ T ≤ 100,000)
- 둘째 줄부터 T개의 줄<br>
line: 괄호 문자열 (2 ≤ line.length ≤ 50)

### 출력값
- T개의 줄에 거쳐 각 테스트 데이터에 대해 올바른 괄호 문자열인지 출력
YES && NO

## 📝 코드 설계하기
1. 테스트 케이스 수 T를 입력받는다. O(1)
2. T번 반복하며 문자열을 확인한다. O(T)
- 문자열의 각 문자를 확인한다. O(L) (L = 문자열의 길이)
'(': balance++
')': balance--
끝까지 확인한 뒤 balance가 0이면 YES 아니면 NO
3. 각 테스트 케이스에 대한 결과를 줄바꿈을 통해 출력한다. O(T)

총 시간 복잡도 = O(S) (S = 모든 입력 문자열 길이의 합)

## ✅ 정답 코드
```java
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
```