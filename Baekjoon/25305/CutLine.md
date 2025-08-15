# 📋 커트라인
- Link<br>
https://www.acmicpc.net/problem/25305
- 풀이 날짜<br>
2025.08.15

## 🔎 문제 탐색하기

### 입력값
- 첫째 줄<br>
응시자의 수 N과 상을 받는 사람 수 k<br>
공백으로 구분<br>
(1 ≤ N ≤ 1,000)<br>
(1 ≤ k ≤ N)
- 둘째 줄<br>
각 학생의 점수 x<br>
공백으로 구분<br>
(0 ≤ x ≤ 10,000)


### 출력값
- 첫째 줄<br>
상을 받는 커트라인<br>
(상을 받는 사람들 중 가장 낮은 점수)

### 생각해 본 방법
- 학생의 점수를 배열에 저장 후 내림차순 정렬, k-1 번째 점수 출력

## 📝 코드 설계하기
1. 문제의 Input을 받습니다.
2. 첫째 줄의 공백으로 구분된 응시자 수 N와 상을 받는 사람의 수 k를 저장합니다.
3. 둘째 줄의 공백으로 구분된 각 학생의 점수 x를 배열에 저장합니다.
4. Arrays.sort를 통해 내림차순 정렬합니다.
5. k-1 번째 점수를 출력합니다.

## ✅ 정답 코드
```java
import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    Integer[] scores = new Integer[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      scores[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(scores, Collections.reverseOrder());

    System.out.println(scores[k-1]);
  }
}
```