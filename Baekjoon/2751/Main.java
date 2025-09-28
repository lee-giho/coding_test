import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(br.readLine()); // 수의 개수 N 입력받기

    int[] nums = new int[N]; // 정수를 저장할 배열

    // 배열에 정수 입력
    for (int i = 0; i < N; i++) {
      nums[i] = Integer.parseInt(br.readLine()); 
    }

    // 배열 오름차순 정렬
    Arrays.sort(nums);

    // 출력 버퍼에 담아서 한 번에 출력
    for (int n : nums) {
      sb.append(n).append("\n");
    }

    System.out.println(sb.toString());
  }
}