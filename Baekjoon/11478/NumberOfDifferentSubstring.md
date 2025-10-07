# 📋 서로 다른 부분 문자열의 개수
- Link<br>
https://www.acmicpc.net/problem/11478
- 풀이 날짜<br>
2025.10.07

## 🔎 문제 탐색하기

### 입력값
- 첫째 줄<br>
S: 부분 문자열의 개수를 구할 문자열 (1 ≤ S.length ≤ 1,000)

### 출력값
- S의 서로 다른 부분 문자열의 개수 출력

## 📝 코드 설계하기
1. 문자열 S를 입력받고 문자열의 길이 n을 구한다. O(1)
2. 이중 반복문으로 S.substring(i, j)의 값을 HashSet에 저장한다. O(n<sup>2</sup>)
3. 구한 부분 문자열의 개수를 출력한다. O(1)

총 시간 복잡도 = O(n<sup>2</sup>)

## ✅ 정답 코드
```java
import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String S = br.readLine(); // 문자열 입력
    int n = S.length(); // 문자열의 길이

    HashSet<String> set = new HashSet<>(); // 서로 다른 문자열을 담을 집합

    // 부분 문자열 집합에 추가
    for (int i = 0; i < n; i++) {
      for (int j = i+1; j < n+1; j++) {
        set.add(S.substring(i, j));
      }
    }

    System.out.println(set.size());
  }
}
```