# 📋 로프
- Link<br>
https://www.acmicpc.net/problem/2217
- 풀이 날짜<br>
2025.09.13

## 🔎 문제 탐색하기

### 입력값
- 첫째 줄<br>
N: 로프의 개수 (1 ≤ N ≤ 100,000)
- 둘째 줄부터 N개의 줄<br>
weight: 로프가 버틸 수 있는 최대 중량 (weight ≤ 10,000)

### 출력값
- 로프들을 이용해 들어올릴 수 있는 물체의 최대 중량 출력

## 📝 코드 설계하기
1. 로프의 개수 N을 입력받는다. O(1)
2. N개의 로프가 버틸 수 있는 중량을 배열에 저장한다. O(N)
3. 로프 배열을 오름차순으로 정렬한다. O(NlogN)
4. 최대 중량을 계산한다. O(N)
5. 최대 중량의 값을 출력한다. O(1)

총 시간 복잡도 = O(NlogN)

## ✅ 정답 코드
```java
import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine()); // 로프의 개수 N 입력

    // 각 로프가 버틸 수 있는 최대 중량을 저장할 배열
    int[] weight = new int[N];
    for (int i = 0; i < N; i++) {
      weight[i] = Integer.parseInt(br.readLine());
    }

    Arrays.sort(weight);

    long answer = 0;

    // i번째 로프부터 끝까지 사용했을 때, 들 수 있는 최대 무게
    for (int i = 0; i < N; i++) {
      long canLift = 1L * weight[i] * (N-i);
      if (canLift > answer) {
        answer = canLift;
      }
    }

    System.out.println(answer);
  }
}
```