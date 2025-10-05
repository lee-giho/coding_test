# 📋 듣보잡
- Link<br>
https://www.acmicpc.net/problem/1764
- 풀이 날짜<br>
2025.10.05

## 🔎 문제 탐색하기

### 입력값
- 첫째 줄<br>
공백으로 구분된 N과 M
  - N: 듣도 못한 사람의 수 (1 ≤ N ≤ 500,000)<br>
  - M: 보도 못한 사람의 수 (1 ≤ N ≤ 500,000)

- 다음 N개의 줄<br>
name: 듣도 못한 사람의 이름 (중복X)

- 다음 M개의 줄<br>
name: 보도 못한 사람의 이름 (중복X)

### 출력값
- 듣보잡의 수와 그 이름을 사전순으로 출력

## 📝 코드 설계하기
(k = 듣보잡의 수)
1. 듣도 못한 사람의 수 N과 보도 못한 사람의 수 M을 입력받는다. O(1)
2. HashSet에 듣도 못한 사람을 저장한다. O(N)
3. 보도 못한 사람의 이름이 HashSet에 있는지 확인하고 있으면 리스트에 추가한다. O(M)
4. 듣보잡 배열을 오름차순으로 정렬한다. O(k log k)
5. 듣보잡의 수와 이름을 출력 버퍼에 저장한다. O(k)
6. 출력 버퍼에 저장된 문자열을 출력한다. O(1)

총 시간 복잡도 = O(N + M + k log k)

## ✅ 정답 코드
```java
import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken()); // 듣도 못한 사람 수 N 입력
    int M = Integer.parseInt(st.nextToken()); // 보도 못한 사람 수 M 입력

    HashSet<String> unheard = new HashSet<>(); // 듣도 못한 사람 저장할 HashSet
    ArrayList<String> result = new ArrayList<>(); // 듣보잡 사람 저장할 리스트

    // N명의 듣도 못한 사람 입력
    for (int i = 0; i < N; i++) {
      String name = br.readLine();
      unheard.add(name);
    }

    // M명의 보도 못한 사람 입력
    for (int i = 0; i < M; i++) {
      String name = br.readLine();
      if (unheard.contains(name)) { // 듣도 못한 사람에 포함되어 있느면
        result.add(name); // 듣보잡에 추가
      }
    }

    Collections.sort(result); // 오름차순 정렬

    sb.append(result.size()).append("\n");
    for (String name : result) {
      sb.append(name).append("\n");
    }

    System.out.println(sb.toString());
  }
}
```