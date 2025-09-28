# 📋 좌표 정렬하기
- Link<br>
https://www.acmicpc.net/problem/11650
- 풀이 날짜<br>
2025.09.29

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
2. N개의 점 Dot(x, y)을 배열에 저장한다. O(N)
3. x, y 순으로 오름차순 정렬한다. O(N log N)
4. 정렬된 좌표를 순회하며 출력 버퍼에 저장한다. O(N)
5. 출력 버퍼에 저장된 문자열을 한 번에 출력한다. O(1)

총 시간 복잡도 = O(N log N)

## ✅ 정답 코드
```java
import java.io.*;
import java.util.*;

public class Main {

  static class Dot { // 점 위치를 담는 객체
    int x, y;
    Dot(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(br.readLine()); // 점의 개수
    Dot[] dots = new Dot[N]; // 점 담는 배열

    // 점에 좌표 입력
    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      dots[i] = new Dot(x, y);
    }

    // x, y 순서로 오름차순 정렬
    Arrays.sort(dots, (a, b) -> {
      if (a.x != b.x) return a.x - b.x;
      return a.y - b.y;
    });

    // 출력
    for (Dot d : dots) {
      sb.append(d.x).append(" ").append(d.y).append("\n");
    }
    System.out.println(sb.toString());
  }
}
```