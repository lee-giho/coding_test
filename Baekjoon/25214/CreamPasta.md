# 📋 크림 파스타
- Link<br>
https://www.acmicpc.net/problem/25214
- 풀이 날짜<br>
2025.09.03

## 🔎 문제 탐색하기

### 입력값
- 첫째 줄<br>
N: 배열에 추가하려는 정수의 개수 (1 ≤ N ≤ 200,000)<br>
A<sub>i</sub> ~ A<sub>N</sub>: 공백으로 구분된 N개의 정수 (1 ≤ A<sub>i</sub> ≤ 10<sup>9</sup>)


### 출력값
- A<sub>i</sub>가 추가된 직후의 문제의 답 N개<br>
공백으로 구분해 출력

### 생각해 본 방법
지금까지 온 값들 중 최솟값을 알고 있으면 현재 값으로 만들 수 있는 최댓값 후보는 현재값 - 최솟값<br>
이전의 답을 알고 있으므로 현재 인덱스의 답은 이전의 답과 현재 얻을 수 있는 최댓값 후보 중 더 큰 수가 된다.

best[j] = max(best[j-1], A[j] - minValue)<br>
minValue = min(minValue, A[j])

## 📝 코드 설계하기
1. 정수 N을 입력받는다. O(1)
2. 반복문을 통해 아래의 과정을 반복한다. O(N)
3. best와 minValue 변수를 초기화한다. O(1)
첫 번째 원소에서 best=0, minValue=n으로 초기화한다.<br>
후보 값 계산하기<br>
최댓값 갱신하기<br>
최솟값 갱신하기<br>
StringBuilder에 현재 인덱스의 best를 추가한다.
3. StringBuilder에 저장된 결과를 출력한다. O(1)

총 시간 복잡도 = O(N)

## ✅ 정답 코드
```java
import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(br.readLine()); // 정수 N 입력받기

    StringTokenizer st = new StringTokenizer(br.readLine());

    long minValue = Long.MAX_VALUE; // 지금까지의 최솟값
    long best = 0; // 지금까지의 최대 (A[j] - A[i])

    for (int j = 1; j < N+1; j++) {
      long n = Long.parseLong(st.nextToken());

      if (j == 1) { // 첫 번째 원소에 대한 값 입력
        best = 0;
        minValue = n;
      } else {
        // 현재 인덱스에서 만들 수 있는 후보값 구하기
        long candidate = n - minValue;
        if (candidate > best) best = candidate;
        if (n < minValue) minValue = n;
      }

      sb.append(best);
      if (j < N) sb.append(" ");
    }

    System.out.println(sb);
  }
}
```