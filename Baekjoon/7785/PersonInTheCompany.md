# 📋 회사에 있는 사람
- Link<br>
https://www.acmicpc.net/problem/7785
- 풀이 날짜<br>
2025.10.02

## 🔎 문제 탐색하기

### 입력값
- 첫째 줄<br>
n: 로그에 기록된 출입 기록의 수 (2 ≤ n ≤ 10<sup>6</sup>)<br>

- 둘째 줄부터 n개의 줄<br>
공백으로 구분된 name과 command
  - name: 회사 직원의 이름
  - command: enter(출근) || leave(퇴근)

### 출력값
- 현재 회사에 있는 사람의 이름을 사전 순의 역순으로 출력<br>

## 📝 코드 설계하기
(k = 집합에 남은 사람의 수)
1. 로그에 기록된 출입 기록의 수 n을 입력받는다. O(1)
2. 로그 n개를 읽으며 아래의 내용을 수행한다. O(N)
  - enter -> 집합에 추가
  - leave -> 집합에서 제거
3. 집합에 남은 이름을 리스트로 옮기고 내림차순 정렬한다. O(k log k)
4. 줄바꿈을 통해 이름을 출력 버퍼에 저장한다. O(k)
5. 출력 버퍼에 저장된 문자열을 출력한다. O(1)

총 시간 복잡도 = O(N + k log k)

## ✅ 정답 코드
```java
import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int n = Integer.parseInt(br.readLine()); // 로그에 기록된 출입 기록의 수 n을 입력받는다.

    HashSet<String> inCompany = new HashSet<>(); // 현재 회사에 있는 사람을 관리할 집합

    // 한 줄씩 입력받으며 command에 따라 집합에 추가/삭제 한다.
    for (int i = 0; i < n; i++) {
      String line = br.readLine();
      int space = line.indexOf(' '); // 공백 위치 찾기
      String name = line.substring(0, space); // 이름
      String command = line.substring(space + 1); // 명령어: enter || leave

      if (command.equals("enter")) {
        inCompany.add(name);
      } else {
        inCompany.remove(name);
      }
    }

    // 집합에 남은 사람들을 리스트로 변환 후 내림차순 정렬
    ArrayList<String> list = new ArrayList<>(inCompany);
    list.sort(Collections.reverseOrder());

    // 정렬된 이름 출력 버퍼에 저장
    for (String name : list) {
      sb.append(name).append("\n");
    }

    System.out.println(sb.toString());
  }
}
```