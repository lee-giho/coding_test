# 📋 녹색거탑
- Link<br>
https://www.acmicpc.net/problem/24723
- 풀이 날짜<br>
2025.10.24

## 🔎 문제 탐색하기

- 각 층마다 이동할 수 있는 방향은 왼쪽과 오른쪽 2가지
- N번의 위치 결정을 통해 경우의 수를 구한다.
- 따라서, 2<sup>N</sup>개

| N | 결과 | 경우의 수 계산 |
| :---: | :---: | :---: |
| 1 | 2 | 2<sup>1</sup> |
| 2 | 4 | 2<sup>2</sup> |
| 3 | 8 | 2<sup>3</sup> |
| 4 | 16 | 2<sup>4</sup> |
| 5 | 32 | 2<sup>5</sup> |


### 입력값
- 첫째 줄<br>
N: 녹색거탑의 높이 (1 ≤ N ≤ 5)

### 출력값
- 녹색거탑의 정상에서 바닥으로 내려오는 경우의 수 출력

## 📝 코드 설계하기
1. 녹색거탑의 높이 N을 입력받는다. O(1)
2. 각 층마다 이동 방향 2가지, 전체 경우의 수인 2<sup>N</sup>으로 계산한다. O(1)
3. 계산된 내려오는 경우의 수를 출력한다. O(1)

총 시간 복잡도 = O(1)

## ✅ 정답 코드
```java
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine()); // 녹색거탑의 높이 N 입력

    int count = (int) Math.pow(2, N); // 2의 N제곱 계산
    System.out.println(count);
  }
}
```