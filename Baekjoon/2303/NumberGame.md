# 📋 숫자 게임
- Link<br>
https://www.acmicpc.net/problem/2303
- 풀이 날짜<br>
2025.08.29

## 🔎 문제 탐색하기

### 입력값
- 첫째 줄<br>
N: 전체 사람의 수 (2 ≤ N ≤ 1,000)

- 둘째 줄부터 N개의 줄<br>
number: 공백으로 구분된 5개의 숫자 (1 ≤ number ≤ 10)

### 출력값
- 게임에서 이긴 사람의 번호 출력<br>
이긴 사람이 두 명 이상일 경우 -> 번호가 가장 큰 사람의 번호 출력

### 생각해 본 방법
한 사람이 받는 카드 5장을 배열에 저장하고, 반복문을 통해 3개의 숫자를 더하며 가장 큰 1의 자리 숫자를 찾는다.<br>
각 사람이 갖는 가장 큰 일의 자리 숫자를 순서대로 배열에 저장한다.<br>
배열에서 가장 큰 수를 가진 인덱스에 +1을 해 사람의 번호를 출력한다.<br>
만약 같은 수를 가진 사람이 존재하면 배열에서 더 뒤에 위치한 인덱스 +1을 출력한다.

## 📝 코드 설계하기
1. 전체 사람의 수 N을 입력한다. O(1)
2. 사람의 수만큼 3번 ~ 4번까지 반복한다. O(N)
3. 받은 5개의 숫자를 배열에 입력한다. O(1)
4. 5개에서 3개씩 숫자를 뽑아 더한 수에서 일의 자리를 구하고 더 큰지 비교해 저장한다. O(1)
5. 각 사람이 갖는 가장 큰 수를 저장한 배열을 차례로 확인하며 가장 큰 수를 가진 사람을 찾는다. O(N)<br>
만약 같은 수를 가지면 배열에서 더 뒤에 위치한 사람의 번호를 찾는다.
6. 가장 큰 수를 가진 사람의 번호를 출력한다. O(1)

총 시간 복잡도 = O(N)

## ✅ 정답 코드
```java
import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 한 줄 단위로 입력값 입력 받음

    int N = Integer.parseInt(br.readLine()); // 전체 사람의 수 입력

    int[] number = new int[5]; // 한 사람이 받는 카드 5장
    int[] maxNum = new int[N]; // 각 사람의 가장 큰 일의 자리
    int maxNumber = 0; // 가장 큰 일의 자리 숫자
    int personNumber = 0; // 가장 큰 일의 자리 숫자를 가진 사람의 번호

    for (int p = 0; p < N; p++) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      for (int m = 0; m < 5; m++) { // 카드 다섯장 받기
        number[m] = Integer.parseInt(st.nextToken());
      }

      // 각 사람의 최대 숫자 구하기
      for (int i = 0; i < 5; i++) {
        for (int j = i+1; j < 5; j++) {
          for (int k = j+1; k < 5; k++) {
            int now = (number[i] + number[j] + number[k]) % 10; // 현재 가져온 세 숫자 합의 일의 자리
            if (now > maxNum[p]) { // 현재 구한 값이 더 크면
              maxNum[p] = now;
            }
          }
        }
      }
    }

    // 사람들 중 누가 더 큰 수를 가지고 있는지 확인하기
    for (int i = 0; i < N; i++) {
      if (maxNum[i] >= maxNumber) { // 같은 숫자일 경우 뒷 번호 사람을 출력해야 하기 때문에 등호도 넣음
        maxNumber = maxNum[i];
        personNumber = i + 1;
      }
    }

    System.out.println(personNumber);
  }
}
```