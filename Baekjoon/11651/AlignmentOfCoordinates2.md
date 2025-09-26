# 📋 좌표 정렬하기 2
- Link<br>
https://www.acmicpc.net/problem/11651
- 풀이 날짜<br>
2025.09.26

## 🔎 문제 탐색하기

### 입력값
- 첫째 줄<br>
N: 점의 개수 (1 ≤ N ≤ 100,000)<br>

- 둘째 줄부터 N개의 줄<br>
x<sub>i</sub> y<sub>i</sub>: i번 점의 위치 (-100,000 ≤ x<sub>i</sub>, y<sub>i</sub> ≤ 100,000)

### 출력값
- 첫째 줄부터 N개의 줄에 점을 정렬한 결과 출력<br>

## 📝 코드 설계하기
1. 점의 개수 N을 입력받는다. O(1)
2. N개의 점 (x, y)를 배열에 저장한다. O(N)
3. y, x 순으로 오름차순 정렬한다. O(N log N)
4. 정렬된 좌표를 순회하며 문자열을 만든다. O(N)
5. 문자열을 한 번에 출력한다. O(1)

총 시간 복잡도 = O(N log N)

## ✅ 정답 코드
```java
import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(br.readLine()); // 점의 개수 입력

    // 점들을 저장할 배열 선언 및 입력
    int[][] dots = new int[N][2];
    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      dots[i][0] = Integer.parseInt(st.nextToken());
      dots[i][1] = Integer.parseInt(st.nextToken());
    }

    // 배열 정렬: y좌표 오름차순, y좌표가 같다면 x좌표 오름차순
    Arrays.sort(dots, (a, b) -> {
      if (a[1] != b[1]) return Integer.compare(a[1], b[1]);
      return Integer.compare(a[0], b[0]);
    });

    // 정렬된 결과 출력 문자열에 저장
    for (int i = 0; i < N; i++) {
      sb.append(dots[i][0]).append(' ').append(dots[i][1]).append('\n');
    }
    
    System.out.println(sb.toString().toString());
  }
}
```