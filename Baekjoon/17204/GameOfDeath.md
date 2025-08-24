# 📋 죽음의 게임
- Link<br>
https://www.acmicpc.net/problem/17204
- 풀이 날짜<br>
2025.08.24

## 🔎 문제 탐색하기

### 입력값
- 첫째 줄<br>
공백으로 구분된 N과 K<br>
N: 게임에 참여하는 사람의 수 (3 ≤ N ≤ 150)<br>
K: 보성이의 번호 (1 ≤ K ≤ N-1)

- 둘째 줄부터 N개의 줄<br>
i번 사람이 지복하는 사람의 번호 a<sub>i</sub> (0 ≤ i, a<sub>i</sub> ≤ N-1)

### 출력값
- 보성이를 걸리게 하기 위해 영기가 말해야 하는 가장 작은 양의 정수 출력
- 보성이가 걸리지 않는다면 -1 출력

### 생각해 본 방법
사람을 지목하면 순열 사이클이 생기기 때문에 순서대로 보성이인지 확인을 하며 count를 증가시킨다.<br>
한 사이클을 돌았을 때 보성이가 없으면 보성이는 걸리지 않는 경우이기 때문에 반복문을 종료하고 -1을 출력한다.<br>
한 사이클을 돌 때 보성이가 있으면 반복문을 종료하고 증가시켰던 count를 출력한다.

## 📝 코드 설계하기
1. 첫째 줄의 공백으로 구분된 게임에 참여하는 사람의 수 N과 보성이의 번호 K를 저장한다. O(1)
2. 둘째 줄부터 N개의 줄에 입력되는 지목하는 사람의 번호를 배열에 저장한다. O(N)
3. 반복문을 통해 배열의 0번부터 시작해 돌아가며 보성이가 있는지 확인하고 count를 증가시킨다. O(N)
4. 한 사이클을 돌며 보성이가 있으면 증가시켰던 count를 출력한다. O(N)

총 시간 복잡도 = O(N)

## ✅ 정답 코드
```java
import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 한 줄 단위로 입력값 입력 받음
    StringTokenizer st = new StringTokenizer(br.readLine()); // 공백을 기준으로 잘라주는 st 생성

    int N = Integer.parseInt(st.nextToken()); // 게임에 참여하는 사람의 수 N 입력받기
    int bosung = Integer.parseInt(st.nextToken()); // 보성이의 번호 입력받기
    int count = 1; // 지목한 횟수
    int[] target = new int[N]; // 각 사람들이 지목한 사람의 번호 저장할 배열
    boolean[] visited = new boolean[N]; // 지모했던 사람인지 확인하는 배열

    for (int i = 0; i < N; i++) { // 사람들이 지목한 번호 저장
      target[i] = Integer.parseInt(br.readLine());
    }

    int next = target[0]; // 영기가 지목한 사람
    visited[0] = true;

    while (true) { // 한 사이클을 돌거나 보성이를 찾을 때까지 반복
      if (next == bosung) { // 보성이를 찾았을 경우
        break;
      }
      if (visited[next]) { // 한 사이클을 돌며 보성이를 찾지 못한 경우
        count = -1;
        break;
      }
      visited[next] = true; // 방문했다고 표시
      next = target[next]; // 다음으로 지목된 사람
      count++; // 지목한 횟수 +1
    }

    System.out.println(count);
  }
}
```

## 🔧 시도 회차 수정 사항
### 1회차 -> 2회차
```java
int next = target[0];
  while (true) {
    count++;
    next = target[next];
    if (next == bosung) {
      break;
    }
    if (next == target[0]) {
      count = -1;
      break;
    }
  }
```
- 이전의 코드에서는 영기한테 돌아가면 한 사이클이 돌았다고 조건문을 작성했다.<br>
영기부터 시작되는 거지 한 사이클에 무조건 영기가 포함되는 건 아니기 때문에 잘못된 조건문이었다.<br>
그로인해 무한 반복에 빠졌고, 시간 초과가 되었다.<br>
-> boolean[] 배열을 통해 확인했던 사람임을 표시하고, true인 사람을 다시 만났을 때 한 사이클이 끝났다는 것으로 수정했다.