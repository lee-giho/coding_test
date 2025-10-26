# 📋 약수
- Link<br>
https://www.acmicpc.net/problem/1037
- 풀이 날짜<br>
2025.10.27

## 🔎 문제 탐색하기

- 약수는 항상 짝을 이룬다.
  - ex) 12의 약수<br>
    (1, 12), (2, 6), (3, 4)

따라서, 주어진 진짜 약수들의 최솟값과 최댓값의 곱이 원래 수 N이다.<br>
N = 최솟값 x 최댓값

### 입력값
- 첫째 줄<br>
n: 진짜 약수의 개수 (1 ≤ n ≤ 50)

- 둘째 줄<br>
divisor: 공백으로 구분된 N개의 진짜 약수 (2 ≤ divisor ≤ 1,000,000)

### 출력값
- 진짜 약수에 해당하는 정수 N 출력

## 📝 코드 설계하기
1. 진짜 약수의 개수 n을 입력받는다. O(1)
2. n개의 약수를 배열에 저장한다. O(n)
3. 약수들이 저장된 배열을 오름차순 정렬해 최솟값과 최댓값을 구한다. O(n log n)
4. 최솟값 x 최댓값을 통해 원래 수 N을 구한다. O(1)
5. 구한 원래 수 N을 출력한다. O(1)

총 시간 복잡도 = O(n log n)

## ✅ 정답 코드
```java
import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine()); // 약수의 개수 입력
    int[] divisors = new int[n];

    // 약수들 배열에 입력
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      divisors[i] = Integer.parseInt(st.nextToken());
    }

    // 오름차순 정렬 (최소값과 최대값 구하기 위함)
    Arrays.sort(divisors);

    // N = 최소값 x 최대값
    int N = divisors[0] * divisors[n - 1];
    System.out.println(N);
  }
}
```