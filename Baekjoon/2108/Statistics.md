# 📋 통계학
- Link<br>
https://www.acmicpc.net/problem/2108
- 풀이 날짜<br>
2025.10.30

## 🔎 문제 탐색하기

### 입력값
- 첫째 줄<br>
N: 정수의 수 (1 ≤ N ≤ 4,000, 홀수)

- 둘째 줄부터 N개의 줄<br>
num: 정수 (|num| < 4,000)

### 출력값
- 첫째 줄<br>
산술평균 출력, 소수점 첫째 자리에서 반올림
- 둘째 줄<br>
중앙값 출력
- 셋째 줄<br>
최빈값 출력
- 넷째 줄<br>
범위 출력

## 📝 코드 설계하기
(K = 서로 다른 값의 개수)
1. 정수의 수 N을 입력받는다. O(1)
2. 정수를 배열에 저장한다. O(N)
3. 배열을 오름차순 정렬한다. O(N log N)
4. 산술평균을 계산한다. O(1)
5. 중앙값을 계산한다. O(1)
6. HashMap으로 빈도수 기록 후 최빈값을 계산한다. O(K log K)<br>
최빈값이 여러 개면 두 번째로 작은 값 선택
7. 범위를 계산한다. O(1)
8. 줄바꿈을 통해 계산된 값을 차례대로 출력한다. O(1)

총 시간 복잡도 = O(N log N)

## ✅ 정답 코드
```java
import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine()); // 정수의 개수
    int[] nums = new int[N]; // 정수 저장할 배열
    int sum = 0;

    for (int i = 0; i < N; i++) {
      nums[i] = Integer.parseInt(br.readLine());
      sum += nums[i];
    }

    Arrays.sort(nums);

    // 1. 산술평균
    int mean = (int) Math.round((double) sum / N);

    // 2. 중앙값
    int median = nums[N / 2];

    // 3. 최빈값
    Map<Integer, Integer> freq = new HashMap<>();
    for (int n : nums) {
      freq.put(n, freq.getOrDefault(n, 0) + 1);
    }

    // 빈도 내림차순, 값 오름차순 정렬
    List<Map.Entry<Integer, Integer>> list = new ArrayList<>(freq.entrySet());
    list.sort((a, b) -> {
      if (!a.getValue().equals(b.getValue())) {
        return b.getValue() - a.getValue(); // 빈도 내림차순
      } else {
        return a.getKey() - b.getKey(); // 값 오름차순
      }
    });

    int mode;
    if (list.size() > 1 && list.get(0).getValue().equals(list.get(1).getValue())) { // 원소가 2개 이상이고, 최빈값이 두 개 이상 존재할 때
      mode = list.get(1).getKey(); // 두 번째로 작은 값
    } else {
      mode = list.get(0).getKey(); // 유일한 최빈값
    }

    // 4. 범위
    int range = nums[N - 1] - nums[0];

    System.out.println(mean);
    System.out.println(median);
    System.out.println(mode);
    System.out.println(range);
  }
}
```