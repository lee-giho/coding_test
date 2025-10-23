# 📋 베라의 패션
- Link<br>
https://www.acmicpc.net/problem/15439
- 풀이 날짜<br>
2025.10.23

## 🔎 문제 탐색하기

- 모든 가능한 조합: 상의 N벌 x 하의 N벌 = N x N = N<sup>2</sup>

| N | 가능한 조합 (N<sup>2</sup>) | 같은 색 제외 (N) | 결과 |
| :---: | :---: | :---: | :---: |
| 1 | 1 | 1 | 0 |
| 2 | 4 | 2 | 2 |
| 5 | 25 | 5 | 20 |

### 입력값
- 첫째 줄<br>
N: 상의 또는 하의의 개수 (1 ≤ N ≤ 2017)

### 출력값
- 상의와 하의가 서로 다른 색상인 조합의 가짓수 출력

## 📝 코드 설계하기
1. 상의 또는 하의의 개수 N을 입력받는다. O(1)
2. N x N으로 전체 조합의 개수를 구하고 색이 같은 경우의 수를 제외한다. O(1)
3. 상의와 하의가 서로 다른 색상인 조합의 가짓수를 출력한다. O(1)

총 시간 복잡도 = O(1)

## ✅ 정답 코드
```java
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine()); // 상의 또는 하의의 개수 입력
    System.out.println(N * (N - 1));
  }
}
```