# 📋 대표값2
- Link<br>
https://www.acmicpc.net/problem/2587
- 풀이 날짜<br>
2025.09.27

## 🔎 문제 탐색하기

### 입력값
- 첫 번째 줄부터 다섯 번째 줄<br>
num: 10의 배수인 자연수 (1 ≤ N < 100)<br>

### 출력값
- 첫 번째 줄<br>
평균 출력

- 두 번째 줄<br>
중앙값 출력

## 📝 코드 설계하기
1. 정수 5개를 입력받아 배열과 합계에 저장 O(5)
2. 배열을 오름차순 정렬한다. O(5 log 5) -> O(1)
3. 평균과 중앙값을 계산한다. O(1)
4. 평균과 중앙값을 출력한다. O(1)

총 시간 복잡도 = O(5 log 5) -> O(1)

## ✅ 정답 코드
```java
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 자연수 5개를 배열에 입력하고, 합계에 저장.
        int[] nums = new int[5];
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            nums[i] = Integer.parseInt(br.readLine().trim());
            sum += nums[i];
        }
        
        Arrays.sort(nums); // 배열 오름차순 정렬

        int avg = sum / 5; // 평균 계산
        int median = nums[2]; // 중앙값
        
        System.out.println(avg);
        System.out.println(median);
    }
}
```