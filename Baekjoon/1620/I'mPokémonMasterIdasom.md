# 📋 나는야 포켓몬 마스터 이다솜
- Link<br>
https://www.acmicpc.net/problem/1620
- 풀이 날짜<br>
2025.10.03

## 🔎 문제 탐색하기

### 입력값
- 첫째 줄<br>
공백으로 구분된 N과 M<br>
  - N: 포켓몬의 개수 (1 ≤ n ≤ 100,000)<br>
  - M: 맞춰야 하는 문제의 개수 (1 ≤ n ≤ 100,000)

- 다음 N개의 줄<br>
name: 나오는 순서가 번호인 포켓몬의 이름

- 다음 M개의 줄<br>
command: 문제, 포켓몬의 번호 or 포켓몬의 이름

### 출력값
- M개의 줄에 각각의 문제에 대한 답 출력<br>
  - 포켓몬 번호 -> 포켓몬 이름 출력
  - 포켓몬 이름 -> 포켓몬 번호 출력

## 📝 코드 설계하기
1. 포켓몬의 개수 N과 문제의 개수 M을 입력받는다. O(1)
2. 배열에 포켓몬 이름을 저장한다. O(N)
3. HashMap에 key: 이름, value: 번호로 저장한다. O(N)
4. 문제 처리 O(M)<br>
문제 line을 입력받는다.
    - 숫자면 이름을 출력 버퍼에 추가한다.
    - 문자열이면 번호를 출력 버퍼에 추가한다.
5. 출력 버퍼에 저장된 문자열을 출력한다. O(1)

총 시간 복잡도 = O(N + M)

## ✅ 정답 코드
```java
import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st = new StringTokenizer(br.readLine());
 
    int N = Integer.parseInt(st.nextToken()); // 포켓몬의 개수
    int M = Integer.parseInt(st.nextToken()); // M: 맞춰야 하는 문제의 개수

    
    String[] idToName = new String[N + 1]; // 번호 -> 이름
    Map<String, Integer> nameToId = new HashMap<>(); // 이름 -> 번호
    
    // 포켓몬 도감 입력
    for (int i = 1; i < N+1; i++) {
      String name = br.readLine();
      idToName[i] = name;
      nameToId.put(name, i);
    }

    // 문제 처리
    for (int i = 0; i < M; i++) {
      String line = br.readLine();
      if (Character.isDigit(line.charAt(0))) { // 숫자면
        int index = Integer.parseInt(line);
        sb.append(idToName[index]).append("\n"); // 이름 출력
      } else { // 문자열이면
        sb.append(nameToId.get(line)).append("\n"); // 번호 출력
      }
    }

    System.out.println(sb.toString());
  }
}
```