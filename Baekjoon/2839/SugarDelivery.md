# 📋 설탕 배달
- Link<br>
https://www.acmicpc.net/problem/2839
- 풀이 날짜<br>
2025.09.01

## 🔎 문제 탐색하기

### 입력값
- 첫째 줄<br>
N: 설탕의 무게 (3 ≤ N ≤ 5,000)

### 출력값
- 봉지의 최소 개수 출력<br>
정확하게 만들어지지 않는다면 -1 출력

### 생각해 본 방법
최소 개수를 구해야 하기 때문에 5킬로그램 봉지가 많으면 많을 수록 좋다.<br>
5킬로그램 봉지의 개수를 먼저 구하고 3킬로그램 봉지의 개수를 구한다.<br>
이때 딱 떨어지지 않는다면 5킬로그램 봉지의 개수를 -1 하며 3킬로그램 봉지의 개수를 구한다.

## 📝 코드 설계하기
1. 배달할 설탕의 무게를 입력받는다. O(1)
2. 5킬로그램 봉지의 개수를 구한다. O(1)
3. 나머지 값이 3으로 나누어 떨어지거나 5의 개수가 0이 될 때까지 반복한다. O(N)<br>
5킬로그램 봉지의 개수만큼 뺀 나머지 무게가 3으로 나누어 떨어지면 총 개수를 구하고 반복문을 종료한다.<br>
만약 3으로 나누어 떨어지지 않으면 5의 개수를 -1하고 다시 확인한다.
4. 봉지의 최소 개수를 출력한다. O(1)

총 시간 복잡도 = O(N)

## ✅ 정답 코드
```java
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 한 줄 단위로 입력값 입력 받음

    int N = Integer.parseInt(br.readLine()); // 배달해야 할 설탕의 무게

    int answer = -1; // 기본값: 불가능할 경우 -1
    int canFive = N / 5; // 5kg 봉지를 사용할 수 있는 최대 개수

    // 5kg 봉지를 최대한 많이 쓰는 경우부터 하나씩 줄여가며 3kg 봉지로 채울 수 있는지 확인
    while (canFive >= 0) {
      int remainNum = N - (canFive * 5); // 5kg 봉지를 뺀 나머지 무게
      if (remainNum % 3 == 0) { // 나머지가 3으로 나누어 떨어지면
        answer = canFive + (remainNum / 3); // 총 봉지의 개수
        break;
      }
      canFive--;
    }

    System.out.println(answer);
  }
}
```