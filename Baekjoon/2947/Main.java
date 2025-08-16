import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 한 줄 단위로 입력값 입력 받음
    StringTokenizer st = new StringTokenizer(br.readLine()); // 공백을 기준으로 잘라주는 st 생성

    int n = st.countTokens(); // 나무 조각 수 n

    int[] nums = new int[n]; // 나무 조각 n개에 대한 배열
    for (int i = 0; i < n; i++) { // 나무 조각을 배열에 저장
      nums[i] = Integer.parseInt(st.nextToken());
    }

    bubbleSort(nums, n); // 버블 정렬 수행
  }

  public static void bubbleSort(int[] arr, int n) throws IOException { // 버블 정렬 메서드
    int temp = 0; // 임시로 값을 저장할 변수
    for (int i = 0; i < n-1; i++) { // 배열의 크기만큼 반복
      for (int j = 1; j < n-i; j++) { // 마지막 요소부터 큰 수로 바뀌기 때문에 n-i까지 반복
        if (arr[j-1] > arr[j]) { // 두 수 중 앞의 요소가 더 클 경우 자리 교환
          temp = arr[j];
          arr[j] = arr[j-1];
          arr[j-1] = temp;
          printWoodsNumber(arr, n); // 배열 출력
        }
      }
    }
  }

  public static void printWoodsNumber(int[] arr, int n) throws IOException { // n개의 나무 조각 숫자 전부 출력하는 메서드
    for (int i = 0; i < n; i++) { // 공백으로 구분해 한 줄로 출력
      System.out.print(arr[i] + " ");
    }
    System.out.println(); // 줄바꿈
  }
}