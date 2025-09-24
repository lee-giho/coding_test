# 📋 분해합
- Link<br>
https://www.acmicpc.net/problem/2231
- 풀이 날짜<br>
2025.09.24

## 🔎 문제 탐색하기

### 입력값
- 첫째 줄<br>
N: 분해합을 구할 자연수 (1 ≤ N ≤ 1,000,000)<br>

### 출력값
- N의 가장 작은 생성자 출력<br>

## 📝 코드 설계하기
1. 자연수 N을 입력받는다. O(1)
2. 1부터 N-1까지 모든 수에 대해 반복한다. O(N)
- sum 초기화
- i의 각 자리수를 구해 sum에 더한다.
- sum == N이면 answer에 저장하고 반복 종료
3. 가장 작은 생성자 출력 O(1)

총 시간 복잡도 = O(N)

## ✅ 정답 코드
```java
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine()); // N 입력
    int answer = 0; // 생성자 저장

    // 1부터 N까지 반복
    for (int i = 1; i < N; i++) {
      int sum = i; // 각 자리수의 합 저장

      // 각 자리수의 합 구하기
      int num = i;
      while (num != 0) {
        sum += num % 10; // 각 자리수 더하기
        num /= 10; // 자리수 줄이기
      }

      // 생성자 찾기
      if (sum == N) {
        answer = i;
        break;
      }
    }

    System.out.println(answer);
  }
}
```