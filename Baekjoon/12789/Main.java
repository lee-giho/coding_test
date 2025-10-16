import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine()); // 학생 수 N 입력
    StringTokenizer st = new StringTokenizer(br.readLine());

    // 줄에 서 있는 학생들의 번호 저장
    int[] waiting = new int[N];
    for (int i = 0; i < N; i++) {
      waiting[i] = Integer.parseInt(st.nextToken());
    }

    Stack<Integer> stack = new Stack<>(); // 임시 대기 공간
    int order = 1; // 받아야 하는 다음 학생 번호

    // 줄에 서 있는 순서대로
    for (int num : waiting) {
      if (num == order) { // 지금 서 있는 학생이 간식을 받을 차례면
        order++; // 간식 받고 다음 번호로
      } else { // 아니면 임시 대기 공간으로 이동
        stack.push(num);
      }

      // 임시 대기 공간의 top이 현재 차례면
      while (!stack.isEmpty() && stack.peek() == order) {
        stack.pop(); // 간식 받고
        order++; // 다음 번호로
      }
    }

    if (stack.isEmpty()) { // 모든 학생이 순서대로 간식을 받았다면
      System.out.println("Nice");
    } else { // 순서대로 간식을 받지 못해 모든 학생이 받지 못했다면
      System.out.println("Sad");
    }
  }
}