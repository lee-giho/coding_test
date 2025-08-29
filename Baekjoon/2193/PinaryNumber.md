# 📋 숫자 게임
- Link<br>
https://www.acmicpc.net/problem/2193
- 풀이 날짜<br>
2025.08.30

## 🔎 문제 탐색하기

### 입력값
- 첫째 줄<br>
N: 이친수의 개수를 구할 정수 (1 ≤ N ≤ 90)

### 출력값
- N자리 이친수의 개수 출력

### 생각해 본 방법
N = 1, 1<br>
N = 2, 10<br>
N = 3, 100 | 101<br>
N = 4, 1000 | 1001 | 1010<br>
N = 5, 10000 | 10001 | 10010 | 10100| 10101

pnList[n] = pnList[n-1] + pnList[n-2]

위 식을 처음 계산하게 되는 1과 2를 1로 초기화한다.
3부터 N까지 차례대로 위 식을 통해 이친수의 개수를 구한다.

## 📝 코드 설계하기
1. 몇 자리 수의 이친수 개수를 구할 것인지 N을 입력받는다. O(1)
2. N+1 크기로 배열을 생성하고 1과 2를 1로 초기화한다. O(N)
3. 반복문을 통해 N이 3 이상일 때 pnList[n] = pnList[n-1] + pnList[n-2] 이 식을 통해 N까지 값을 구한다. O(N)
4. N자리 수의 이친수 개수를 출력한다. O(1)

총 시간 복잡도 = O(N)

## ✅ 정답 코드
```java
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 한 줄 단위로 입력값 입력 받음

    int N = Integer.parseInt(br.readLine()); // 몇 자리 수의 이친수 개수를 구할 것인지 입력

    long[] pnList = new long[N+1]; // 각 숫자에 대한 이친구 개수 저장할 배열

    // 1과 2를 1로 초기화
    pnList[1] = 1;
    if (N > 1) {
      pnList[2] = 1;
    }

    // 3부터 식을 통해 N자리 수의 이친수 개수를 구해간다.
    for (int i = 3; i < N+1; i++) {
      pnList[i] = pnList[i-1] + pnList[i-2];
    }

    System.out.println(pnList[N]);
  }
}
```