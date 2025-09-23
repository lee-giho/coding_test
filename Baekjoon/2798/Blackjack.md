# 📋 블랙잭
- Link<br>
https://www.acmicpc.net/problem/2798
- 풀이 날짜<br>
2025.09.23

## 🔎 문제 탐색하기

### 입력값
- 첫째 줄<br>
공백으로 구분된 N과 M<br>
N: 카드의 개수 (3 ≤ N ≤ 100)<br>
M: 목표값 (10 ≤ N ≤ 300,000)

- 둘째 줄<br>
공백으로 구분된 카드에 쓰여 있는 수 N개<br>
card: 카드에 쓰여 있는 수 (1 ≤ N ≤ 100,000)

### 출력값
- M을 넘지 않으면서 최대한 가까운 카드 3장의 합<br>

## 📝 코드 설계하기
1. 카드의 개수 N과 목표값 M을 입력받는다. O(1)
2. 카드 배열에 N개의 숫자를 저장한다. O(N)
3. 반복문을 통해 서로 다른 카드 3장을 선택한다. O(N<sup>3</sup>)
4. 값을 비교해 M을 넘지 않는 최대값을 갱신한다. O(1)
5. M을 넘지 않는 최대값을 출력한다. O(1)

총 시간 복잡도 = O(N<sup>3</sup>)

## ✅ 정답 코드
```java
import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken()); // 카드의 개수 N 입력
    int M = Integer.parseInt(st.nextToken()); // 목표값 M 입력

    // 카드 배열에 N개의 숫자 저장
    int[] cards = new int[N];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      cards[i] = Integer.parseInt(st.nextToken());
    }

    int answer = 0; // M을 넘지 않는 가장 큰 합

    // 카드 3장 선택
    for (int i = 0; i < N-2; i++) {
      for (int j = i+1; j < N-1; j++) {
        for (int k = j+1; k < N; k++) {
          int best = cards[i] + cards[j] + cards[k]; // 뽑은 카드의 합

          // 최대값 갱신
          if (best <= M && best > answer) {
            answer = best;
          }
        }
      }
    }

    System.out.println(answer);
  }
}
```