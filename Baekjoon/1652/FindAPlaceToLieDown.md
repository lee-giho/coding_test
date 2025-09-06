# 📋 누울 자리를 찾아라
- Link<br>
https://www.acmicpc.net/problem/1652
- 풀이 날짜<br>
2025.09.06

## 🔎 문제 탐색하기

### 입력값
- 첫째 줄<br>
N: 방의 크기 (1 ≤ N ≤ 100)
- 둘째 줄부터 N개의 줄<br>
N개의 '.'과 'X'
'.': 아무것도 없는 곳
'X': 짐이 있는 곳

### 출력값
- 공백으로 구분해 가로와 세로로 누울 자리의 개수 출력

## 📝 코드 설계하기
1. 방의 크기 N과 구조를 입력받는다. O(1)
2. 가로로 누울 수 있는 자리의 개수를 구한다. O(N<sup>2</sup>)
3. 세로로 누울 수 있는 자리의 개수를 구한다. O(N<sup>2</sup>)
4. 공백으로 구분해 가로와 세로의 개수를 출력한다. O(1)

총 시간 복잡도 = O(N<sup>2</sup>)

## ✅ 정답 코드
```java
import java.io.*;

public class Main {
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine()); // 방의 크기 N 입력받기
    int row = 0; // 가로로 누울 수 있는 자리 수
    int column = 0; // 세로로 누울 수 있는 자리 수

    // 방 구조 저장할 2차원 배열 정의 후 값 입력
    String[][] room = new String[N][N];
    for (int i = 0; i < N; i++) {
      String[] line = br.readLine().split("");
      for (int j = 0; j < N; j++) {
        room[i][j] = line[j];
      }
    }

    // 가로 방향 확인
    for (int i = 0; i < N; i++) {
      int possible = 0; // 연속된 빈자리의 개수
      for (int j = 0; j < N; j++) {
        if (room[i][j].equals(".")) { // 빈자리면
          possible++; // 빈자리 개수 증가
          if (possible == 2) { // 길이가 2가 되면 가로로 누울 수 있는 자리
            row++;
          } 
        } else { // .이 아니면 연속된 빈자리의 개수 초기화
          possible = 0;
        }
      }
    }

    // 세로 방향 확인
    for (int i = 0; i < N; i++) {
      int possible = 0; // 연속된 빈자리의 개수
      for (int j = 0; j < N; j++) {
        if (room[j][i].equals(".")) { // 빈자리면
          possible++; // 빈자리 개수 증가
          if (possible == 2) { // 길이가 2가 되면 가로로 누울 수 있는 자리
            column++;
          } 
        } else { // .이 아니면 연속된 빈자리의 개수 초기화
          possible = 0;
        }
      }
    }

    System.out.println(row + " " + column);
  }
}
```