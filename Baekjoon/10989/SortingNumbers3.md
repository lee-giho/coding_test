# 📋 수 정렬하기 3
- Link<br>
https://www.acmicpc.net/problem/10989
- 풀이 날짜<br>
2025.09.28

## 🔎 문제 탐색하기

### 입력값
- 첫째 줄<br>
N: 수의 개수 (1 ≤ N ≤ 1,000,000)<br>

- 둘째 줄부터 N개의 줄<br>
num: 자연수 (1 ≤ num ≤ 10,000)

### 출력값
- N개의 줄에 오름차순으로 정렬한 결과 출력<br>

## 📝 코드 설계하기
1. 수의 개수 N을 입력받는다. O(1)
2. 크기가 10001인 배열을 초기화한다. O(1)
3. N개의 수를 입력받으며 해당 값의 인덱스의 수를 증가시킨다. O(N)
4. 1부터 10000까지 순회하며 각 인덱스의 값만큼 인덱스를 출력 버퍼에 추가한다. O(N)
5. 버퍼에 있는 문자열을 한 번에 출력한다. O(1)

총 시간 복잡도 = O(N)

## ✅ 정답 코드
```java
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(br.readLine());

    int[] count = new int[10001]; // 입력 값 범위: 1 ~ 10000

    // 숫자 등장 횟수 세기
    for (int i = 0; i < N; i++) {
      int num = Integer.parseInt(br.readLine());
      count[num]++;
    }

    // 작은 수부터 등장 횟수만큼 출력
    for (int i = 1; i < 10001; i++) {
      while (count[i]-- > 0) {
        sb.append(i).append("\n");
      }
    }

    System.out.println(sb.toString());
  }
}
```