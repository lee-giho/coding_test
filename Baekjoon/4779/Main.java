import java.io.*;
import java.util.*;

public class Main {

  static char[] arr;

  // 규칙에 맞게 문자열을 나누는 재귀 함수
  static void cantor(int start, int len) {
    if (len == 1) return; // 길이가 1이면 나눌 수 없으므로 종료

    int third = len / 3; // 3등분한 길이

    // 가운데 구간 공백 처리
    int midStart = start + third;
    int midEnd = start + third * 2;
    for (int i = midStart; i < midEnd; i++) {
      arr[i] = ' ';
    }

    cantor(start, third); // 왼쪽 구간
    cantor(start + third * 2, third); // 오른쪽 구간
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    String line;
    
    while((line = br.readLine()) != null && !line.isEmpty()) { // null이 나올 때까지 line을 받으며 반복
      int N = Integer.parseInt(line.trim());
      int len = (int) Math.pow(3, N); // 전체 길이

      arr = new char[len];
      Arrays.fill(arr, '-'); // 처음 상태는 전부 "-"

      cantor(0, len); // 전체 구간을 시작으로 재귀 함수를 통해 규칙 적용

      sb.append(arr).append("\n");
    }

    System.out.println(sb.toString());
  }
}