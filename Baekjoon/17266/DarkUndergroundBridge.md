# 📋 어두운 굴다리
- Link<br>
https://www.acmicpc.net/problem/17266
- 풀이 날짜<br>
2025.09.11

## 🔎 문제 탐색하기

### 입력값
- 첫째 줄<br>
N: 굴다리의 길이 (1 ≤ N ≤ 100,000)
- 둘째 줄<br>
M: 가로등의 개수 (1 ≤ M ≤ N)
- 셋째 줄<br>
x: 공백으로 구분된 가로등의 위치 (0 ≤ x ≤ N)

### 출력값
- 굴다리를 모두 비추기 위한 가로등의 최소 높이 출력

## 📝 코드 설계하기
1. 굴다리 길이 N과 가로등 개수 M을 입력받는다. O(1)
2. 가로등 위치 x들을 입력받는다. O(M)
3. 왼쪽 끝 길이를 구한다. O(1)
4. 중간에 위치한 두 가로등의 사이 길이를 구한다. O(M)
5. 오른쪽 끝 길이를 구한다. O(1)
6. 가로등의 최소 높이를 출력한다. O(1)

총 시간 복잡도 = O(M)

## ✅ 정답 코드
```java
import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine()); // 굴다리의 길이 N
    int M = Integer.parseInt(br.readLine()); // 가로등 개수 M

    // 가로등 위치 입력
    int[] lamps = new int[M];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < M; i++) {
      lamps[i] = Integer.parseInt(st.nextToken());
    }

    // 왼쪽 끝부터 첫 번째 가로등까지의 길이
    int need = lamps[0];

    // 가운데 가로등 사이의 거리
    for (int i = 0; i < M-1; i++) {
      int gap = lamps[i+1] - lamps[i];
      int half = (gap+1) / 2;
      if (half > need) {
        need = half;
      }
    }

    // 오른쪽 끝부터 마지막 가로등까지의 거리
    int right = N - lamps[M-1];
    if (right > need) {
      need = right;
    }

    System.out.println(need);
  }
}
```