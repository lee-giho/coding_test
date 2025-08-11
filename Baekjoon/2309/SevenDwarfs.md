# 📋 일곱 난쟁이
- Link<br>
https://www.acmicpc.net/problem/2309
- 풀이 날짜<br>
2025.08.11

## 🔎 문제 탐색하기

### 입력값
- 줄바꿈을 통한 아홉 난쟁이들의 키
- 100을 넘지 않는 자연수
- 중복 X

### 출력값
- 찾은 일곱 난쟁이들의 키를 오름차순으로 출력
- 여러 가지 답이 나왔을 때는 아무거나 출력

### 생각해 본 방법
- 7개 숫자의 합이 100이 되는지 확인
- 9개의 숫자 합에서 2개의 숫자를 뺀 값이 100이 되는지 확인

해당 문제는 제외할 개수가 더 적어 두 번째 방법이 더 효율적이라고 생각했습니다.<br>
두 수를 찾기 위해 투 포인터 알고리즘을 사용했습니다.

## 📝 코드 설계하기
1. 문제의 Input을 받습니다.
2. Input을 오름차순으로 정렬합니다.
3. Input의 총 합을 구해 100을 빼서 제외할 두 수의 합을 구합니다.
4. 투 포인터를 사용해 두 수를 고르고, 이전 단계에서 계산한 두 수의 합과 같은지 비교합니다.
5. 찾은 두 수를 제외한 나머지 7개를 오름차순으로 출력합니다.

## 🔧 시도 회차 수정 사항
### 1회차
- 클래스명을 임의로 작성해서 오류가 발생했습니다.<br>
클래스명을 Main으로 수정했습니다.<br>
https://nahwasa.com/entry/%EC%9E%90%EB%B0%94%EB%A1%9C-%EB%B0%B1%EC%A4%80-%ED%92%80-%EB%95%8C%EC%9D%98-%ED%8C%81-%EB%B0%8F-%EC%A3%BC%EC%9D%98%EC%A0%90-boj-java

## ✅ 정답 코드
```java
import java.util.*;

public class Main{
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in); // 입력값 받기
    int[] heights = new int[9]; // 9명의 난쟁이들의 키가 담길 배열
    int sum = 0; // 9명의 난쟁이들 키의 합

    for (int i = 0; i < 9; i++) { // 배열에 난쟁이들의 키를 삽입하고, 키의 합 구하기
      heights[i] = scanner.nextInt();
      sum += heights[i];
    }

    Arrays.sort(heights); // 무작위로 입력받은 난쟁이들의 키를 오름차순으로 정렬
    int goal = sum - 100; // 제외할 2명의 난쟁이들 키의 합
    int left = 0, right = 8; // 배열의 첫 번째(left)와 마지막(right) 인덱스 값
    int rmLeft = -1, rmRight = -1; // 제외할 2명의 난쟁이들 키의 인덱스, 찾을 수 없는 경우는 없기 때문에 우선 -1로 초기화

    while(left < right) { // 투 포인터를 활용해 goal을 만족하는 인덱스 찾기
      int LRSum = heights[left] + heights[right]; // left와 right 인덱스 값의 합
      if (LRSum < goal) { // LRSum의 값이 커져야 하기 때문에 작은 수인 left를 증가시킴
        left++;
      } else if (LRSum > goal) { // LRSum의 값이 작아져야 하기 때문에 큰 수인 right를 감소시킴
        right--;
      } else { // 같을 경우 두 인덱스의 값을 제외한 나머지 값의 합이 100이므로 제외할 인덱스를 찾음
        rmLeft = left;
        rmRight = right;
        break;
      }
    }

    for (int i = 0; i < 9; i++) { // 위에서 찾은 제외할 인덱스의 값을 넘기고 나머지 인덱스의 값 출력
      if (i == rmLeft || i == rmRight) {
        continue;
      } else {
        System.out.println(heights[i]);
      }
    }
  }
}
```