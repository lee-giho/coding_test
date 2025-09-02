# 📋 파스칼 삼각형
- Link<br>
https://www.acmicpc.net/problem/15489
- 풀이 날짜<br>
2025.09.02

## 🔎 문제 탐색하기

### 입력값
- 첫째 줄<br>
공백으로 구분된 R과 C, W (2 ≤ R+W ≤ 30, 2 ≤ C+W ≤ 30, 1 ≤ W ≤ 29, C ≤ R)<br>
R: 몇 번째 줄에서<br>
C: 몇 번째 줄까지인지<br>
W: 한 변이 포함하는 수의 개수

### 출력값
- 정삼각형에 있는 숫자들의 합<br>

### 생각해 본 방법
파스칼 삼각형을 미리 만들고 아래로 내려가며 폭을 1씩 늘어나는 삼각형의 숫자 합을 구한다.

## 📝 코드 설계하기
1. 몇 번째 줄인지 나타내는 R과 C, 한 변이 포함하는 수의 개수인 W를 입력받는다. O(1)
2. 파스칼 삼각형의 수를 2차원 배열에 입력한다. O(1)
3. 반복문을 통해 R과 C, W에 해당하는 영역의 숫자를 더한다. O(W<sup>2</sup>)
4. 숫자의 합을 출력한다. O(1)

총 시간 복잡도 = O(W<sup>2</sup>)

## ✅ 정답 코드
```java
import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 한 줄 단위로 입력값 입력 받음
    StringTokenizer st = new StringTokenizer(br.readLine());

    int R = Integer.parseInt(st.nextToken()); // 시작 행 입력
    int C = Integer.parseInt(st.nextToken()); // 시작 열 입력
    int W = Integer.parseInt(st.nextToken()); // 삼각형 높이 입력

    int MAX = 30; // 최대 30행
    long[][] pascal = new long[MAX+1][MAX+1]; // 파스칼 삼각형을 저장할 배열

    // 파스칼 삼각형 생성
    for (int i = 1; i < MAX+1; i++) {
      pascal[i][1] = 1; // 각 행의 첫 번째 값은 1
      pascal[i][i] = 1; // 각 행의 마지막 값도 1
      for (int j = 2; j < i; j++) {
        pascal[i][j] = pascal[i-1][j-1] + pascal[i-1][j];
      }
    }

    // 삼각형 영역 합 구하기
    long sum = 0;
    for (int i = 0; i < W; i++) { // W행만큼 내려가며
      int row = R+i; // 현재 행 번호
      for (int j = 0; j < i+1; j++) { // 해당 행에서 C부터 C+1까지
        int col = C+j; // 현재 열 번호
        sum += pascal[row][col]; // 파스칼 값 더하기
      }
    }

    System.out.println(sum);
  }
}
```