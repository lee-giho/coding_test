# 📋 인사성 밝은 곰곰이
- Link<br>
https://www.acmicpc.net/problem/25192
- 풀이 날짜<br>
2025.10.28

## 🔎 문제 탐색하기

- HashSet을 통해 방에 등장한 닉네임을 중복 없이 관리한다.
- "Enter"면 지금까지 저장한 닉네임의 수를 정답에 더하고 HashSet을 초기화한다.
  - "ENTER"가 나와야 이전 방을 더하는 구조이기 때문에 마지막에 한 번 더 저장한 닉네임의 수를 더한다.

### 입력값
- 첫째 줄<br>
N: 채팅방의 기록 수 (1 ≤ N ≤ 100,000)

- 둘째 줄부터 N개의 줄<br>
ENTER 또는 nickName (1 ≤ 문자열 길이 ≤ 20)<br>
첫 번째는 무조건 ENTER
    - ENTER: 새로운 사람의 입장을 의미
    - nickName: 채팅을 입력한 유저의 닉네임

### 출력값
- 채팅 기록 중 곰곰티콘이 사용된 횟수 출력

## 📝 코드 설계하기
1. 채팅방의 기록 수 N을 입력받는다. O(1)
2. N번 반복하며 문자열을 읽는다. O(N)
    - "Enter"면 닉네임의 수를 더하고 HashSet 초기화
    - 닉네임이면 HashSet에 추가
3. 반복 종료 후 닉네임의 수를 더해 마지막 방을 처리한다. O(1)
4. 곰곰티콘이 사용된 횟수를 출력한다. O(1)

총 시간 복잡도 = O(N)

## ✅ 정답 코드
```java
import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine()); // 채팅방의 기록 수

    Set<String> nickNames = new HashSet<>(); // 방에서 본 닉네임들
    long count = 0; // 전체 인사 횟수

    for (int i = 0; i < N; i++) {
      String s = br.readLine();

      if (s.equals("ENTER")) {
        // 이전 방의 인사 횟수를 더하고 새 방 시작
        count += nickNames.size();
        nickNames.clear();
      } else {
        // 현재 방에서 닉네임 기록
        nickNames.add(s);
      }
    }

    // 마지막 방의 닉네임 수도 더하기
    count += nickNames.size();

    System.out.println(count);
  }
}
```