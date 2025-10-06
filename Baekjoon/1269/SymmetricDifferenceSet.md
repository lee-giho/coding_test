# 📋 대칭 차집합
- Link<br>
https://www.acmicpc.net/problem/1269
- 풀이 날짜<br>
2025.10.06

## 🔎 문제 탐색하기

### 입력값
- 첫째 줄<br>
공백으로 구분된 aSize와 bSize
  - aSize: 집합 A의 원소 개수 (1 ≤ aSize ≤ 200,000)<br>
  - bSize: 집합 B의 원소 개수 (1 ≤ bSize ≤ 200,000)

- 둘째 줄<br>
집합 A의 모든 원소 (1 ≤ 원소 ≤ 100,000,000)<br>
공백으로 구분된 자연수 aSize개

- 셋째 줄<br>
집합 B의 모든 원소 (1 ≤ 원소 ≤ 100,000,000)<br>
공백으로 구분된 자연수 bSize개

### 출력값
- 대칭 차집합의 원소 개수 출력

## 📝 코드 설계하기
1. 두 집합의 원소 개수 aSize와 bSize를 입력 받는다. O(1)
2. 집합 A의 원소 aSize개를 입력받아 HashSet에 저장한다. O(aSize)
3. 집합 B의 원소 bSize개를 입력받으며 A에 포함된 경우 교집합 수를 증가시킨다. O(bSize)
4. 대칭 차집합의 크기를 |AB| = aSize + bSize - 2intersection으로 계산한다. O(1)
5. 대칭 차집합의 크기를 출력한다. O(1)

총 시간 복잡도 = O(aSize + bSize)

## ✅ 정답 코드
```java
  import java.io.*;
  import java.util.*;

  public class Main {
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      StringTokenizer st = new StringTokenizer(br.readLine());
      int aSize = Integer.parseInt(st.nextToken()); // 집합 A의 원소 개수 입력
      int bSize = Integer.parseInt(st.nextToken()); // 집합 B의 원소 개수 입력

      // 집합 A 입력
      HashSet<Integer> setA = new HashSet<>();
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < aSize; i++) {
        setA.add(Integer.parseInt(st.nextToken()));
      }

      // 집합 B의 요소 입력 받으며 교집합 크기 구하기
      int intersection = 0; // 교집합 크기
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < bSize; i++) {
        int n = Integer.parseInt(st.nextToken());
        if (setA.contains(n)) {
          intersection++;
        }
      }

      int answer = aSize + bSize - 2 * intersection;
      System.out.println(answer);
    }
  }
```