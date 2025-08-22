# 📋 1로 만들기
- Link<br>
https://www.acmicpc.net/problem/1463
- 풀이 날짜<br>
2025.08.22

## 🔎 문제 탐색하기

- 정수 N에 대한 3가지 연산
    - 3으로 나누어 떨어지면, 3으로 나눈다.<br>
    if (N%3 == 0) return N/3
    - 2로 나누어 떨어지면, 2로 나눈다.<br>
    else if (N%2 == 0) return N/2
    - 1을 뺀다.<br>
    else return N-1

### 입력값
- 첫째 줄<br>
N: 연산의 최솟값을 구할 정수<br>
1 ≤ N ≤ 10^6

### 출력값
- 연산을 하는 횟수의 최솟값

### 생각해 본 방법
조건에 따라 세가지 연산을 골라서 하는 메서드를 만든 후 N이 1이 될 때까지 반복한다.

## 📝 코드 설계하기

1. Test case의 수 T를 입력받는다. O(1)
2. T번만큼 반복하며 아래 과정을 수행한다. O(T)
3. 각 Test case에서 N(서쪽 사이트)와 M(동쪽 사이트)을 입력받는다. O(1)
4. combination()을 호출해 C(M, N)을 계산한다. O(MN)
5. 반환된 값을 출력한다. O(1)

총 시간 복잡도 = O(TMN)

## ✅ 정답 코드
```java
import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 한 줄 단위로 입력값 입력 받음

    int N = Integer.parseInt(br.readLine()); // 정수 N을 입력받는다.

    int[] cnts = new int[N+1]; // 각 숫자가 갖는 연산의 최솟값을 저장할 배열 / 인덱스와 정수는 동일하다.
    cnts[1] = 0; // 1은 이미 1이므로 0으로 초기화

    for (int i = 2; i < N+1; i++) {
      // -1은 전부 할 수 있는 연산이기 때문에 기본으로 먼저 처리한다.
      // 조건에 맞게 2와 3으로 나누기를 진행하며 이전에 했던 연산과 최솟값 비교를 해 더 작은 수를 best에 저장한다.
      int best = cnts[i-1] + 1; // -1 연산
      if (i%2 == 0) best = Math.min(best, cnts[i/2] + 1); // 2로 나누기
      if (i%3 == 0) best = Math.min(best, cnts[i/3] + 1); // 3으로 나누기
      cnts[i] = best; // 최솟값을 해당 수의 인덱스에 저장
    }

    System.out.println(cnts[N]); // 정수 N이 가지는 연산의 최솟값을 출력한다.
  }
}
```

## 🔧 시도 회차 수정 사항
### 1회차 -> 2회차
- 조건문을 차례로 확인하며 먼저 만족하는 연산을 수행했다.<br>
→ 최솟값이 아니라 1이 되는 연산 중 하나를 출력한 것이다.<br>
```java
// 기존 코드
import java.io.*;

public class Main {

  static int cnt = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    calculation(N);

    System.out.println("cnt:" + cnt);
  }

  public static void calculation(int n) {
    System.out.println(n);
    if (n <= 1) {
      return;
    }

    if (n%3 == 0) {
      cnt++;
      calculation(n/3);
    } else if (n%2 == 0) {
      cnt++;
      calculation(n/2);
    } else {
      cnt++;
      calculation(n-1);
    }
  }
}
```
10을 예로 들었을 때, calculation의 조건문을 차례대로 확인하기 때문에<br>
5 4 2 1 ⇒ 총 4번의 연산을 한다.<br>
하지만 10의 최소 연산은 -1로 시작해<br>
9 3 1 ⇒ 총 3번의 연산이다.

- 각 숫자에서 세가지 조건을 확인하며 그중 최솟값이 되는 수를 저장하도록 수정했다.
```java
int[] cnts = new int[N+1]; // 각 숫자가 갖는 연산의 최솟값을 저장할 배열 / 인덱스와 정수는 동일하다.
cnts[1] = 0; // 1은 이미 1이므로 0으로 초기화

for (int i = 2; i < N+1; i++) {
  // -1은 전부 할 수 있는 연산이기 때문에 기본으로 먼저 처리한다.
  // 조건에 맞게 2와 3으로 나누기를 진행하며 이전에 했던 연산과 최솟값 비교를 해 더 작은 수를 best에 저장한다.
  int best = cnts[i-1] + 1; // -1 연산
  if (i%2 == 0) best = Math.min(best, cnts[i/2] + 1); // 2로 나누기
  if (i%3 == 0) best = Math.min(best, cnts[i/3] + 1); // 3으로 나누기
  cnts[i] = best; // 최솟값을 해당 수의 인덱스에 저장
}
```
10을 예로 들었을 때,<br>
-1 하고 9의 연산 최솟값에 +1을 해 10의 최솟값을 구한다.<br>
/2 하고 5의 연산 최솟값에 +1을 해 10의 최솟값을 구한다.<br>
(/3은 안 되기 때문에 제외)<br>
이 둘의 값을 비교해 더 작은 수를 best에 저장한다.<br>

2부터 시작하기 때문에 9와 5는 10 이전에 계산된 최솟값을 가지고 있다.<br>
9 → 2번<br>
2 → 3번<br>
따라서 10이 최솟값은 둘 중 더 작은 수인 2에 1을 더해 3이 된다.