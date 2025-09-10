import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int K = Integer.parseInt(br.readLine()); // 입력받을 정수의 개수 K

    int sum = 0; // 최종 합계
    Deque<Integer> stack = new ArrayDeque<>(); // 입력값 관리를 위한 스택
    
    // K번 반복하며 정수 입력 처리
    for (int i = 0; i < K; i++) {
      int num = Integer.parseInt(br.readLine());

      if (num == 0) { // 0이 입력되면
        stack.pop(); // 최근 값 제거
      } else {
        stack.push(num);
      }
    }

    // 스택의 모든 값 더하기
    while (!stack.isEmpty()) {
      sum += stack.pop();
    }

    System.out.println(sum);
  }
}