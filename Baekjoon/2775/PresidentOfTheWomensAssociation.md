# 📋 부녀회장이 될테야
- Link<br>
https://www.acmicpc.net/problem/2775
- 풀이 날짜<br>
2025.08.20

## 🔎 문제 탐색하기

### 입력값
- 첫째 줄<br>
T: 몇 개의 Test case를 진행할 것인지
- 둘째 줄부터 T+1째 줄 / 2개의 줄이 T번만큼 반복<br>
k: 몇 층인지<br>
n: 몇 호인지<br>
(1 ≤ k, n < 14)

### 출력값
- 각각의 Test case에 대해 k층 n호에 거주하는 인원 수 출력<br>
줄 바꿈으로 Test case 구분

### 생각해 본 방법
테스트 케이스의 답을 구하는 코드를 만든 뒤 T번만큼 반복하여 각 테스트 케이스에 대한 답을 구한다.<br>
층과 호수가 늘어남에 따라 인원수가 정해지는 규칙을 찾고 반복문을 통해 k층 n호의 인원수를 구한다.<br>
numOfMember[][] 배열을 통해 인원수를 채우며 k층 n호의 인원수를 구한다.

k층 n호의 인원수 = (k-1)층 1호부터 n호까지의 인원수 합<br>
k층 (n-1)호의 인원수 = (k-1)층 1호부터 (n-1)호까지의 인원수 합

k층 n호의 인원수 = (k-1)층 1호부터 (n-1)호까지의 인원수 합 + (k-1)층 n호의 인원수<br>
k층 n호의 인원수 = k층 (n-1)호의 인원수 + (k-1)층 n호의 인원수

따라서, k층 n호의 인원수는 **이전 호의 인원수**와 바로 **아래층 인원수**의 **합**과 같다.<br>
numOfMember[k][n] = numOfMember[k][n-1] + numOfMember[k-1][n]<br>
단, 각 층의 1호는 이전 호수가 없기 때문에 인원수가 1로 고정이다.

## 📝 코드 설계하기
### 2차원 배열 사용
1. Test case의 수인 T를 입력받는다. O(n)
2. T번만큼 반복하며 아래의 과정을 수행한다.
3. 층수인 k와 호수인 n을 입력받는다. O(1)
4. 0층을 1호부터 n호까지 인원수를 1부터 n으로 저장한다. O(n)
5. 반복문을 통해 k층까지 numOfMember[k][n] = numOfMember[k][n-1] + numOfMember[k-1][n]으로 인원수를 저장한다. O(kn)<br>
1호는 1명으로 고정
6. 5번의 반복문이 끝나면 해당 Test case의 답을 출력한다. O(1)

총 시간 복잡도 = O(Tkn)

## ✅ 정답 코드
```java
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 한 줄 단위로 입력값 입력 받음

    int T = Integer.parseInt(br.readLine()); // Test case의 수 T를 입력받는다.

    for (int t = 0; t < T; t++) { // Test case의 수만큼 반복
      int floor = Integer.parseInt(br.readLine()); // 몇 층인지 입력받기
      int number = Integer.parseInt(br.readLine()); // 몇 호인지 입력받기

      int[][] numOfMember = new int[floor+1][number]; // 0층을 포함한 floor과 number에 맞는 배열 생성
      for (int n = 0; n < number; n++) { // 0층의 1호 ~ number호까지 인원수를 1 ~ number로 입력
        numOfMember[0][n] = n+1;
      }
      for (int f = 1; f < floor+1; f++) { // 1층부터 floor층까지 반복
        for (int n = 0; n < number; n++) { // 1호부터 number호까지 반복
          if (n == 0) { // 각 층의 1호는
            numOfMember[f][n] = 1; // 인원수가 1
          } else { // 1층 이상, 2호 이상은
            numOfMember[f][n] = numOfMember[f][n-1] + numOfMember[f-1][n]; // 인원수가 자신의 이전 호의 인원수와 바로 아래층 호의 인원수의 합과 같다
          }
        }
      }
      System.out.println(numOfMember[floor][number-1]); // floor와 number에 만족하는 인원수 출력
    }
  }
}
```