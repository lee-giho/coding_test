import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(br.readLine());

    int[] count = new int[10001]; // 입력 값 범위: 1 ~ 10000

    // 숫자 등장 횟수 세기
    for (int i = 0; i < N; i++) {
      int num = Integer.parseInt(br.readLine());
      count[num]++;
    }

    // 작은 수부터 등장 횟수만큼 출력
    for (int i = 1; i < 10001; i++) {
      while (count[i]-- > 0) {
        sb.append(i).append("\n");
      }
    }

    System.out.println(sb.toString());
  }
}