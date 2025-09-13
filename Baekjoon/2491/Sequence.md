# 📋 수열
- Link<br>
https://www.acmicpc.net/problem/2491
- 풀이 날짜<br>
2025.09.14

## 🔎 문제 탐색하기

### 입력값
- 첫째 줄<br>
N: 수열의 길이 (1 ≤ N ≤ 100,000)
- 둘째 줄<br>
공백으로 구분된 N개의 숫자

### 출력값
- 가장 긴 길이 출력

## 📝 코드 설계하기
1. 수열의 길이 N을 입력받는다. O(1)
2. 수열의 원소를 입력받아 저장한다. O(N)
3. 배열의 원소를 확인하며 조건문을 통해 길이를 확인한다. O(N)<br>
arr[i] >= arr[i-1] -> upLen++, else upLen = 1<br>
arr[i] <= arr[i-1] -> downLen++, else downLen = 1<br>
answer = max(answer, upLen, downLen)
4. 가장 긴 길이를 출력한다. O(1)

총 시간 복잡도 = O(N)

## ✅ 정답 코드
```java
import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine()); // 수열의 길이 N 입력
    StringTokenizer st = new StringTokenizer(br.readLine());

    // 수열 원소 입력
    int[] arr = new int[N];
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    // N=1이면 가능한 연속 구간의 길이는 1
    if (N == 1) {
      System.out.println(1);
      return;
    }

    int upLen = 1; // 현재까지 arr[i] >= arr[i-1]이 연속으로 유지된 구간의 길이
    int downLen = 1; // 현재까지 arr[i] <= arr[i-1]이 연속으로 유지된 구간의 길이
    int answer = 1;

    for (int i = 1; i < N; i++) {
      if (arr[i] >= arr[i-1]) { // 오름차순 조건 검사
        upLen++;
      } else {
        upLen = 1; // 오름차순이 아니면 구간 길이 1로 초기화
      }

      if (arr[i] <= arr[i-1]) { // 내림차순 조건 검사
        downLen++;
      } else {
        downLen = 1; // 내림차순이 아니면 구간 길이 1로 초기화
      }

      // 가장 긴 길이 찾기
      answer = Math.max(answer, Math.max(upLen, downLen));
    }

    System.out.println(answer);
  }
}
```