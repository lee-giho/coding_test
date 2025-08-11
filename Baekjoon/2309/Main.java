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