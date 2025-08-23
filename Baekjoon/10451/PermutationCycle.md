# 📋 순열 사이클
- Link<br>
https://www.acmicpc.net/problem/10451
- 풀이 날짜<br>
2025.08.23

## 🔎 문제 탐색하기

### 입력값
- 첫째 줄<br>
T: 몇 개의 Test case를 진행할 것인지
- 각 테스트 케이스의 첫째 줄<br>
N: 순열의 크기 (2 ≤ N < 1,000)
- 각 테스트 케이스의 둘째 줄<br>
순열, 공백으로 구분되어 있는 정수

### 출력값
- 입력으로 주어진 순열에 존재하는 순열 사이클의 개수<br>
줄바꿈으로 각 테스트에 대한 값 출력

### 생각해 본 방법
노드(입력받은 숫자들)를 저장하는 배열과 방문을 확인하는 배열을 통해 순열 사이클의 개수를 확인한다.<br>
반복문을 통해 노드에 방문할 때마다 표시하고 방문한 노드에 도착하면 순열 사이클이 만들어진 것이기 때문에 개수를 증가시키고 다음 노드로 이동한다.

## 📝 코드 설계하기
1. Test case의 수 T를 입력받는다. O(1)
2. T번만큼 반복하며 아래 과정을 수행한다. O(T)
3. 방문한 노드가 아니라면 아래의 과정을 수행한다. O(N)<br>
방문했다고 표시 후 다음 노드를 찾는다. O(1)<br>
다음 노드가 방문하지 않았던 곳이라면 다시 반복한다. O(N)<br>
다음 노드가 방문한 곳이라면 순열 사이클 개수 증가시키고 반복문을 종료한다. O(1)
4. 버퍼에 해당 테스트 케이스의 답을 저장한다. O(1)
5. 모든 테스트 케이스가 종료되면 버퍼에 저장되어 있는 값을 출력한다. O(1)

총 시간 복잡도 = O(TN)

## ✅ 정답 코드
```java
import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 한 줄 단위로 입력값 입력 받음
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int T = Integer.parseInt(br.readLine()); // Test case의 수 T를 입력받는다.

    for (int t = 0; t < T; t++) {
      int N = Integer.parseInt(br.readLine()); // 순열의 크기 N을 입력받는다.
      int arr[] = new int[N+1]; // 노드 값 배열에 저장
      boolean visited[] = new boolean[N+1]; // 방문한 노드인지 저장하는 배열
      int count = 0; // 몇 개의 순열 사이클이 있는지

      StringTokenizer st = new StringTokenizer(br.readLine()); // 공백을 기준으로 잘라주는 st 생성
      for (int i = 1; i < N+1; i++) {
        arr[i] = Integer.parseInt(st.nextToken()); // 노드 값 배열에 저장
      }

      for (int i = 1; i < N+1; i++) { // 순열 사이클 확인
        if (!visited[i]) { // 방문하지 않은 노드라면
          visited[i] = true; // 방문했다고 표시
          int next = arr[i]; // 다음으로 이동할 노드
          while (true) {
            if (visited[next]) { // 순열 사이클이 만들어졌다면
              count++; // 순열 사이클 개수 증가
              break;
            }
            visited[next] = true; // 방문했다고 표시
            next = arr[next]; // 다음으로 이동할 노드
          }
        }
      }

      bw.write(Integer.toString(count)); // 해당 테스트 케이스의 답
      bw.newLine(); // 줄바꿈
    }

    bw.flush(); // 버퍼에 저장되어 있는 문자열 출력
    bw.close(); // 스트림 종료
  }
}
```