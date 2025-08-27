# 📋 도비의 난독증 테스트
- Link<br>
https://www.acmicpc.net/problem/2204
- 풀이 날짜<br>
2025.08.27

## 🔎 문제 탐색하기

### 입력값
- 테스트 케이스의 첫째 줄<br>
n: 단어의 개수 (2 ≤ N ≤ 1,000)

- 테스트 케이스의 둘째 줄부터 n개의 줄<br>
word: 중복되지 않는 단어 (word ≤ 20)

### 출력값
- 각 테스트 케이스에서 사전상 가장 앞서는 단어 출력

### 생각해 본 방법
0이 나올 때까지 값을 입력받고 테스트 케이스를 진행한다.<br>
단어를 배열에 저장한 후 소문자로 바꿔 오름차순 정렬한다.

## 📝 코드 설계하기
0이 나올 때까지 1 ~ 4를 반복한다.
1. 단어의 개수 n을 입력한다. O(1)
2. 단어 n개를 배열에 입력한다. O(n)
3. 배열의 단어를 소문자로 변환한 후 오름차순 정렬한다. O(nlog(n))
4. 배열의 0번째 단어를 버퍼에 저장한다. O(1)
5. 모든 테스트 케이스가 끝나면 버퍼에 저장된 문자열을 출력한다. O(1)

총 시간 복잡도 = O(nlog(n))

## ✅ 정답 코드
```java
import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 한 줄 단위로 입력 받음
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    while(true) { // n이 0이 될 때까지 반복
      int n = Integer.parseInt(br.readLine()); // 단어의 개수 입력받기
      
      if (n == 0) { // 0이 될때, 남은 테스트 케이스가 없기 때문에 반복문 종료
        break;
      }

      String[] words = new String[n];
      for (int i = 0; i < n; i++) { // n개의 단어 입력받기
        words[i] = br.readLine();
      }

      Arrays.sort(words, (o1, o2) -> { // 단어를 소문자로 바꾼 뒤, 오름차순 정렬한다.
        String word1 = o1.toString().toLowerCase();
        String word2 = o2.toString().toLowerCase();
        return word1.compareTo(word2);
      });

      bw.write(words[0]); // 사전상 가장 앞서는 단어 출력
      bw.newLine(); // 줄바꿈
    }

    bw.flush(); // 버퍼에 저장되어 있는 문자열 출력
    bw.close(); // 스트림 종료
  }
}
```