# 📋 창문 닫기
- Link<br>
https://www.acmicpc.net/problem/13909
- 풀이 날짜<br>
2025.10.14

## 🔎 문제 탐색하기

i번째 사람이 i의 배수에 해당하는 창문을 닫거나 연다.
i번의 창문이 닫히거나 열리는 횟수는 i의 약수 개수와 같다.
대부분 수의 약수는 짝을 이루고 있어 닫히고 열리는 횟수가 짝수다.
완전제곱수는 짝을 이루지 않는 약수가 생겨 닫히고 열리는 횟수가 홀수다.

따라서, 마지막에 열려 있는 창문의 개수 = N 이하의 완전제곱수의 개수

### 입력값
- 첫째 줄<br>
창문의 개수와 사람의 수를 의미하는 N (1 ≤ N ≤ 2,100,000,000)

### 출력값
- 마지막에 열려 있는 창문의 개수 출력

## 📝 코드 설계하기
1. 창문의 개수와 사람이 수인 N을 입력받는다. O(1)
2. 정수 부분 제곱근을 계산한다. O(1)
3. 마지막에 열려 있는 창문의 개수를 출력한다. O(1)

총 시간 복잡도 = O(1)

## ✅ 정답 코드
```java
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    long N = Long.parseLong(br.readLine()); // 창문과 사람의 수 입력

    long count = (long)Math.sqrt(N); // N 이하의 제곱수 개수
    System.out.println(count);
  }
}
```