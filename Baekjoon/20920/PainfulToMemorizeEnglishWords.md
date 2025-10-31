# 📋 영단어 암기는 괴로워
- Link<br>
https://www.acmicpc.net/problem/20920
- 풀이 날짜<br>
2025.10.31

## 🔎 문제 탐색하기

N개의 단어 중 길이가 M 이상인 단어만 아래의 우선순위로 외운다.

1. 자주 나오는 단어
2. 길이가 긴 단어
3. 사전순

### 입력값
- 첫째 줄<br>
공백으로 구분된 N과 M<br>
  - N: 단어의 개수 (1 ≤ N ≤ 100,000)<br>
  - M: 외울 단어의 길이 (1 ≤ N ≤ 10)

- 둘째 줄부터 N+1개의 줄<br>
word: 알파벳 소문자로 이루어진 영단어 (1 ≤ word.length ≤ 10)

### 출력값
외울 영단어를 줄바꿈을 통해 한 단어씩 출력

## 📝 코드 설계하기
(K = 외울 단어의 개수, K ≤ N)
1. 단어의 개수 N과 외울 단어의 길이 M을 입력받는다. O(1)
2. Map에 단어 저장 및 빈도 수를 계산한다. O(N)
3. Map을 리스트로 변환 후 우선순위에 따라 정렬한다. O(K log K)
4. 정렬된 단어를 한 줄에 하나씩 출력 버퍼에 저장한다. O(K)
5. 출력 버퍼에 저장된 문자열을 한 번에 출력한다. O(1)

총 시간 복잡도 = O(N log N)

## ✅ 정답 코드
```java
import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken()); // 단어의 개수
    int M = Integer.parseInt(st.nextToken()); // 외울 단어의 길이

    // 단어 저장 및 빈도 수 계산
    Map<String, Integer> freq = new HashMap<>();
    for (int i = 0; i < N; i++) {
      String word = br.readLine();
      if (word.length() < M) continue;
      freq.put(word, freq.getOrDefault(word, 0) + 1);
    }

    // 리스트로 변환 후 3가지 기준으로 정렬
    List<Map.Entry<String, Integer>> list = new ArrayList<>(freq.entrySet());
    list.sort((a, b) -> {
      // 빈도 내림차순
      int freqA = a.getValue();
      int freqB = b.getValue();
      if (freqA != freqB) return freqB - freqA;

      // 길이 내림차순
      int lenA = a.getKey().length();
      int lenB = b.getKey().length();
      if (lenB != lenA) return lenB - lenA;

      // 사전순 오름차순
      return a.getKey().compareTo(b.getKey());
    });

    // 정렬된 단어만 출력
    for (Map.Entry<String, Integer> e : list) {
      sb.append(e.getKey()).append("\n");
    }

    System.out.println(sb.toString());
  }
}
```