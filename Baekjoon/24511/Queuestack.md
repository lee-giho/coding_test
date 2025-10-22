# 📋 queuestack
- Link<br>
https://www.acmicpc.net/problem/24511
- 풀이 날짜<br>
2025.10.22

## 🔎 문제 탐색하기

- 스택은 push 후 들어온 값을 바로 pop하기 때문에 결과에 영향을 주지 않아 무시해도 된다.
- 큐는 초기 값만 순서대로 보관하고 새 값이 들어올 때마다 앞에 push 후 뒤에서 pop을 한다.

### 입력값
- 첫째 줄<br>
N: 자료구조의 개수 (1 ≤ N ≤ 100,000)

- 둘째 줄<br>
수열: 길이가 N인 수열A
  - A<sub>i</sub> = 0: 큐
  - A<sub>i</sub> = 1: 스택

- 셋째 줄<br>
수열: 길이가 N인 수열B
  - B<sub>i</sub>: i번 자료구조에 들어 있는 원소 (1 ≤ B<sub>i</sub> ≤ 1,000,000,000)

- 넷째 줄<br>
M: 삽입할 수열의 길이 (1 ≤ M ≤ 100,000)

- 다섯째 줄<br>
수열: 삽입할 원소를 담고 있는 길이 M의 수열 C (1 ≤ C<sub>i</sub> ≤ 1,000,000,000)

### 출력값
- 수열 C의 원소를 차례대로 queuestack에 삽입했을 때 리턴값을 공백으로 구분해 출력

## 📝 코드 설계하기
1. 자료구조의 개수 N을 입력받는다. O(1)
2. 자료구조의 타입을 배열에 입력받는다. O(N)
3. 각 자료구조의 초기 값을 입력받는다. O(N)
    - 스택일 경우엔 push된 값이 그대로 pop되기 때문에 스킵
4. 추가로 넣을 원소의 개수 M을 입력받는다. O(1)
5. 새 원소를 받을 때마다 덱의 앞쪽에 넣고, 덱의 뒤쪽에서 하나 꺼내 출력 버퍼에 저장한다. O(M)
6. 출력 버퍼에 저장된 문자열을 한 번에 출력한다. O(1)

총 시간 복잡도 = O(N + M)

## ✅ 정답 코드
```java
import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(br.readLine()); // 자료구조의 개수

    int[] type = new int[N]; // 자료구조의 타입을 담을 배열 (0: 큐, 1: 스택)
    Deque<Integer> deque = new ArrayDeque<>();

    // 자료구조 타입 입력
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      type[i] = Integer.parseInt(st.nextToken());
    }

    // 초기 값 입력
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      int num = Integer.parseInt(st.nextToken());
      if (type[i] == 0) { // 큐일 경우에만
        deque.addLast(num); // 마지막에 값 넣기
      }
    }

    int M = Integer.parseInt(br.readLine()); // 추가로 넣을 원소의 개수
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < M; i++) {
      int num = Integer.parseInt(st.nextToken());
      deque.addFirst(num); // queuestack의 뒤쪽에 들어가는 효과
      sb.append(deque.pollLast()).append(' '); // 앞쪽 원소가 빠져 나가는 효과
    }

    System.out.println(sb.toString());
  }
}
```