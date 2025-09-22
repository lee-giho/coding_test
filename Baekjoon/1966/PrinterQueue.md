# 📋 프린터 큐
- Link<br>
https://www.acmicpc.net/problem/1966
- 풀이 날짜<br>
2025.09.22

## 🔎 문제 탐색하기

### 입력값
- 첫째 줄<br>
T: 테스트 케이스의 개수

- 둘째 줄부터 2줄씩, T번<br>
1. 공백으로 구분된 N과 M<br>
N: 문서의 개수 (1 ≤ N ≤ 100)<br>
M: 추적할 문서의 초기 인덱스 (0 ≤ M ≤ N)<br>

2. 공백으로 구분된 N개의 문서에 대한 중요도<br>
p: 문서에 대한 중요도 (1 ≤ p ≤ 9)

### 출력값
- 각 테스트 케이스에 대해 문서가 몇 번째로 인쇄되는지 출력<br>

## 📝 코드 설계하기
1. 테스트 케이스 개수 T와 각 테스트 케이스의 문서 개수 N과 추적할 문서의 초기 인덱스 M, 문서들의 중요도 p를 입력받는다. O(N)
2. 큐 자료구조 선언 및 초기화를 한다. O(N)
3. 현재 최대 중요도롤 확인한다. O(1)
4. 큐가 빌 때까지 반복한다. O(N)<br>
- 맨 앞 문서를 확인해 큐에 더 높은 중요도가 있으면 맨 뒤로 보낸다.<br>
- 맨 앞 문서를 확인해 가장 큰 중요도면 인쇄하고 최대 중요도를 갱신한다.<br>
- 인쇄한 문서가 M이라면 인쇄한 개수를 출력하고 종료한다.
5. 각 테스트 케이스에 대한 정답을 출력한다. O(1)

총 시간 복잡도 = O(N)

## ✅ 정답 코드
```java
import java.io.*;
import java.util.*;

public class Main {

  static class Doc { // 큐에 넣을 문서 객체
    int p, idx;
    Doc(int p, int idx) {
      this.p = p; // 중요도
      this.idx = idx; // 위치
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

    for (int t = 0; t < T; t++) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      int N = Integer.parseInt(st.nextToken()); // 문서의 개수
      int M = Integer.parseInt(st.nextToken()); // 추적할 문서의 초기 인덱스

      Deque<Doc> queue = new ArrayDeque<>();
      int[] cnt = new int[10]; // 중요도 1~9 개수 카운트

      // 공백으로 구분된 중요도 입력받기
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < N; i++) {
        int p = Integer.parseInt(st.nextToken());
        queue.addLast(new Doc(p, i));
        cnt[p]++;
      }

      // 현재 큐의 최대 중요도
      int currentMaxImportance = 9;
      while (currentMaxImportance > 0 && cnt[currentMaxImportance] == 0) {
        currentMaxImportance--;
      }

      int printed = 0;
      
      while (!queue.isEmpty()) {
        Doc d = queue.pollFirst();

        // 더 높은 중요도가 큐에 존재할 때
        if (d.p < currentMaxImportance) {
          queue.addLast(d); // 맨 뒤로 보냄
        } else { // 최대 중요도면
          printed++; // 인쇄
          cnt[d.p]--;

          // 최대 중요도 갱신
          while (currentMaxImportance > 0 && cnt[currentMaxImportance] == 0) {
            currentMaxImportance--;
          }

          // 문제에서 찾는 문서라면 인쇄할 수 출력
          if (d.idx == M) {
            sb.append(printed).append("\n");
            break;
          }
        }
      }
    }

    System.out.println(sb.toString());
  }
}
```