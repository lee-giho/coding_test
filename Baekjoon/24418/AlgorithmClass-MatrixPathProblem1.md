# 📋 알고리즘 수업 - 행렬 경로 문제 1
- Link<br>
https://www.acmicpc.net/problem/24418
- 풀이 날짜<br>
2025.09.04

## 🔎 문제 탐색하기

### 입력값
- 첫째 줄<br>
n: 행렬의 크기(5 ≤ n ≤ 15)

- 둘째 줄부터 n개의 줄<br>
num: 공백으로 구분된 행렬의 각 행을 나타내는 n개의 정수 (1 ≤ num ≤ 100,000)

### 출력값
- 코드1 코드2 실행 횟수를 공백으로 구분해 출력

### 생각해 본 방법
- 코드1<br>
위또는 왼쪽으로만 가다가 경계에 만나면 return 한다.<br>
(n, n) -> (0, 0)는 위로 n번 왼쪽으로 n번이 1:1 대응하기 때문에 C(2n, n)이다.
- 코드2<br>
2중 for문이 (1, 1) ~ (n, n) 모든 칸을 한 번씩 갱신한다.<br>
따라서 n<sup>2</sup>이 된다.

## 📝 코드 설계하기
1. 행렬의 크기 n을 입력받는다. O(1)
2. n*n 크기 행렬의 값을 입력받는다. O(n<sup>2</sup>)
3. 코드1을 계산한다. O(n)
4. 코드2를 계산한다. O(1)
5. 각 코드의 실행 횟수를 공백으로 구분해 출력한다. O(1)

총 시간 복잡도 = O(n<sup>2</sup>)

## ✅ 정답 코드
```java
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    for (int i = 0; i < n; i++) { // 값을 사용하진 않고 받기만 함
      br.readLine();
    }

    long code1 = binom2nCn(n); // 코드1 실행 횟수
    long code2 = 1L * n * n; // 코드2 실행 횟수

    System.out.println(code1 + " " + code2);
  }

  private static long binom2nCn(int n) { // C(2n, n)
    long result = 1;
    for (int i = 1; i < n+1; i++) {
      result = result * (n+i) / i;
    }
    return result;
  }
}
```