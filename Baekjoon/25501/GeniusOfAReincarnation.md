# 📋 재귀의 귀재
- Link<br>
https://www.acmicpc.net/problem/25501
- 풀이 날짜<br>
2025.11.03

## 🔎 문제 탐색하기

### 입력값
- 첫째 줄<br>
T: 테스트 케이스의 개수 (1 ≤ T ≤ 1,000)

- 둘째 줄<br>
S: 알파벳 대문자로 구성된 문자열 (1 ≤ |S| ≤ 1,000)

### 출력값
- T개의 줄에 걸쳐 결과 출력<br>
공백으로 구분해 isPalindrome 함수의 반환값과 recursion 함수의 호출 횟수 출력

## 📝 코드 설계하기
1. 테스트 케이스 개수 T를 입력받는다. O(1)
2. 각 테스트 케이스마다 문자열 S를 입력받는다. O(T)
3. recursion 함수 호출로 팰린드롬 판별을 수행한다. O(N)<br>
  좌우 문자를 비교하며 내부로 이동
    - 다르면 0 반환
    - 같으면 재귀 호출
4. isPalindrome 함수의 반환값과 recursion 함수의 호출 횟수를 공백으로 구분해 출력한다. O(T)

총 시간 복잡도 = O(T*N)

## ✅ 정답 코드
```java
import java.io.*;

public class Main {
  static int count; // 재귀 함수 호출 횟수

  // 팰린드롬인지 판별
  public static int recursion(String s, int l, int r) {
    count++;
    if (l >= r) return 1; // 문자열의 중앙이면 팰린드롬 O
    else if (s.charAt(l) != s.charAt(r)) return 0; // 좌우가 다르면 X
    else return recursion(s, l + 1, r - 1); // 좌우가 같으면 안쪽으로 이동
  }

  // 팰린드롬 판별 함수
  public static int isPalindrome(String s) {
    count = 0;
    return recursion(s, 0, s.length() - 1);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수

    while(T-- > 0) {
      String S = br.readLine();
      int result = isPalindrome(S);
      sb.append(result).append(" ").append(count).append("\n");
    }

    System.out.println(sb.toString());
  }
}
```