# 📋 수 정렬하기
- Link<br>
https://www.acmicpc.net/problem/2750
- 풀이 날짜<br>
2025.09.27

## 🔎 문제 탐색하기

### 입력값
- 첫째 줄<br>
N: 수의 개수 (1 ≤ N ≤ 1,000)<br>

- 둘째 줄부터 N개의 줄<br>
num: 중복 없는 정수 (|num| ≤ 1,000)

### 출력값
- N개의 줄에 오름차순으로 정렬한 결과 출력<br>

## 📝 코드 설계하기
1. 수의 개수 N을 입력받는다. O(1)
2. N개의 정수를 배열에 저장한다. O(N)
3. 배열을 오름차순 정렬한다. O(N log N)
4. 정렬된 값을 한 줄에 하나씩 출력 버퍼에 담는다. O(N)
5. 버퍼에 저장된 값을 한 번에 출력한다. O(1)

총 시간 복잡도 = O(N log N)

## ✅ 정답 코드
```java
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine()); // 수의 개수 입력
        int[] nums = new int[N];

        // N개의 정수 배열에 입력
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(nums); // 오름차순 정렬
        
        // 한 줄에 하나씩 출력 문자열에 담기
        for (int x : nums) {
            sb.append(x).append('\n');
        }
        
        System.out.println(sb.toString());
    }
}
```